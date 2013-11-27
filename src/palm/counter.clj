(ns palm.counter
  (:import (com.codahale.metrics Counter)))

(defn counter []
  (Counter.))

(defn value
  [^Counter c]
  (.getCount c))

(defn inc!
  ([^Counter c] (inc! c 1))
  ([^Counter c v]
     (.inc c v)
     c))

(defn dec!
  ([^Counter c] (dec! c 1))
  ([^Counter c v]
     (.dec c v)
     c))
