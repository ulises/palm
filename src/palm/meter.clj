(ns palm.meter
  (:import (com.codahale.metrics Meter)))

(defn meter []
  (Meter.))

;; updating the meter
(defn mark!
  ([^Meter meter] (do (.mark meter) meter))
  ([^Meter meter ^long n] (do (.mark meter n) meter)))

;; total number of events
(defn value [^Meter meter] (.getCount meter))

;; rates
(defn mean-rate [^Meter m] (.getMeanRate m))

(defn get-1m-rate [^Meter meter] (.getOneMinuteRate meter))
(defn get-5m-rate [^Meter meter] (.getFiveMinuteRate meter))
(defn get-15m-rate [^Meter meter] (.getFifteenMinuteRate meter))
