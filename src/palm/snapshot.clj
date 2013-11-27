(ns palm.snapshot
  (:import (com.codahale.metrics Snapshot)))

(defn value
  [^Snapshot s ^double quantile]
  (.getValue s quantile))

(defn median
  [^Snapshot s]
  (.getMedian s))
