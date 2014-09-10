(defproject bunia "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-json "0.2.0"]
                 [org.clojure/tools.logging "0.3.0"]
                 [org.clojure/data.json "0.2.5"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler bunia.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
