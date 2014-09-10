(ns bunia.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [ring.util.response :refer [response]]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" [] (response [{:name "widget 1"} {:name "widget 2"}]))
  (POST "/" {body :body} 
  	(log/info (json/write-str body))
  	(response {:message "OK" :body body}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
	(-> 
		(handler/api app-routes)
		(middleware/wrap-json-body)
		(middleware/wrap-json-response)))
