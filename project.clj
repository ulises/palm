(defproject palm "0.1.2-SNAPSHOT"
  :description "A thin wrapper around codahale's metrics."

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.codahale.metrics/metrics-core "3.0.1"]]

  :repositories {"repo.codahale.com" "http://repo.codahale.com"}

  :global-vars {*warn-on-reflection* true}

  :deploy-branches ["master"]
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :creds :gpg}]
                 ["snapshots" {:url "https://clojars.org/repo"
                               :creds :gpg}]])
