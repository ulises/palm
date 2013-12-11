(ns palm.histogram
  (:require
   [palm.reservoir :refer [exponentially-decaying-reservoir]]
   [palm.snapshot :as snapshot])
  (:import (com.codahale.metrics Histogram))
  (:refer-clojure :exclude [count]))

(defn histogram
  ([] (histogram (exponentially-decaying-reservoir)))
  ([reservoir] (Histogram. reservoir)))

(defn update!
  [^Histogram h ^long v]
  (.update h v)
  h)

(defn count
  [^Histogram h]
  (.getCount h))

(defn snapshot
  [^Histogram h]
  (.getSnapshot h))

(defn mean
  [^Histogram h]
  (let [s (snapshot h)]
    (snapshot/mean s)))

(defn median
  [^Histogram h]
  (let [s (snapshot h)]
    (snapshot/median s)))

(defn quantile
  [^Histogram h q]
  (let [s (snapshot h)]
    (snapshot/value s q)))
