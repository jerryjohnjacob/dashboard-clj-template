(ns {{ns-name}}.server
  (:require [dashboard-clj.core :as dash]
            [environ.core :refer [env]]
            [{{ns-name}}.fetcher])
  (:gen-class))

(def datasources [
                  {
                   :name :welcome-message
                   :read-fn :{{ns-name}}.fetcher/fetch}])

(defn start-dashboard[]
  (dash/start datasources {:port (Integer. (or (env :port) 5000))}))

(defn -main [& [port]]
  (start-dashboard))
