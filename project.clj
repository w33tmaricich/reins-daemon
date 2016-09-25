(defproject w33tmaricich/reins-daemon "0.1.0-SNAPSHOT"
  :description "A mobile agent execution environment."
  :url "http://github.com/w33tmaricich/reins-daemon"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot reins-daemon.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
