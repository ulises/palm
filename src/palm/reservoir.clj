(ns palm.reservoir
  (:import (com.codahale.metrics ExponentiallyDecayingReservoir)))

(defn exponentially-decaying-reservoir
  ([] (ExponentiallyDecayingReservoir.))
  ([{:keys [size alpha]}]
     {:pre [size alpha]}
     (ExponentiallyDecayingReservoir. size alpha)))
