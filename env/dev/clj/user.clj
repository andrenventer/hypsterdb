(ns user
  (:require [mount.core :as mount]
            hypsterdb.core))

(defn start []
  (mount/start-without #'hypsterdb.core/repl-server))

(defn stop []
  (mount/stop-except #'hypsterdb.core/repl-server))

(defn restart []
  (stop)
  (start))


