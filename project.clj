(defproject audiogum/redis-embedded-clj "0.0.4"
  :description "Embedded redis for clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [integrant "0.11.0"]
                 [org.signal/embedded-redis "0.9.0"]
                 [org.clojure/tools.logging "1.3.0"]
                 [org.clojure/tools.namespace "1.5.0"]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "releases"]
                  ["change" "version" "leiningen.release/bump-version" "patch"]
                  ["vcs" "commit"]
                  ["vcs" "push" "origin" "main"]]

  :plugins [[s3-wagon-private "1.3.4"]]

  :repositories {"releases" {:url           "s3p://repo.bowerswilkins.net/releases/"
                             :no-auth       true
                             :sign-releases false}}

  :profiles {:dev {:dependencies [[com.taoensso/carmine "3.4.1"]]}})
