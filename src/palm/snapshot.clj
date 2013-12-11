(ns palm.snapshot
  (:import (com.codahale.metrics Snapshot)))

(defn value
  [^Snapshot s ^double quantile]
  (.getValue s quantile))

(defn mean
  [^Snapshot s]
  (.getMean s))

(defn median
  [^Snapshot s]
  (.getMedian s))
