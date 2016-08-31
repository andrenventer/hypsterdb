(ns hypsterdb.test.db.core
  (:require [hypsterdb.db.core :refer [*db*] :as db]
            [luminus-migrations.core :as migrations]
            [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [hypsterdb.config :refer [env]]
            [conman.core :refer [with-transaction]]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
      #'hypsterdb.config/env
      #'hypsterdb.db.core/*db*)
    (migrations/migrate ["migrate"](:database-url env))
    (f)))

(deftest test-message
  (jdbc/with-db-transaction [t-conn *db*]
    (jdbc/db-set-rollback-only! t-conn)
    (let [message {:name "test"
                   :message "test"
                   :timestamp (java.util.Date.)}]
      (is (= 1 (db/save-message! t-conn message)))
      (let [result (db/get-messages t-conn {})]
        (is (= 1 (count result)))
        (is (= message (dissoc (first result) :id))))))
  (is (empty? (db/get-messages))))
