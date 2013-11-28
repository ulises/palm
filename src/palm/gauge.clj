(ns palm.gauge
  (:import (com.codahale.metrics Gauge)))

(defn gauge [f]
  (proxy [Gauge] []
      (getValue [] (f))))

(defn value
  [^Gauge g]
  (.getValue g))
