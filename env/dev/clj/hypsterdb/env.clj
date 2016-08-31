(ns hypsterdb.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [hypsterdb.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[hypsterdb started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[hypsterdb has shut down successfully]=-"))
   :middleware wrap-dev})
