# palm

A thin wrapper around codahale's excellent metrics.

## Usage

A simple histogram, using an exponentially decaying reservoir with
size=1028 and alpha=0.015:

````
    how2pls> (require '[palm.histogram :refer [histogram median update quantile]])
    nil
    how2pls> (def h (histogram))
    #'how2pls/h
    how2pls> (doseq [n (range 10)] (update! h n))
    nil
    how2pls> (median h)
    4.5
    how2pls> (quantile h 0.99)
    9.0
    how2pls> (quantile h 0.9)
    8.9
    how2pls>
````

If you want to specify size and alpha for the reservoir:

````
    how2pls> (require '[palm.reservoir :refer [exponentially-decaying-reservoir]])
    nil
    how2pls> (def r (exponentially-decaying-reservoir {:size 512
    :alpha 0.3))
    #'how2pls/r
    how2pls> (def h-custom (histogram r))
    #'how2pls/h-custom
````

Counters are included too:
````
    how2pls> (require '[palm.counter :as c])
    nil
    how2pls> (def cnt (c/counter))
    #'how2pls/cnt
    how2pls> cnt
    #<Counter com.codahale.metrics.Counter@418ff373>
    how2pls> (c/value cnt)
    0
    how2pls> (c/inc! cnt)
    #<Counter com.codahale.metrics.Counter@418ff373>
    how2pls> (c/inc! cnt)
    #<Counter com.codahale.metrics.Counter@418ff373>
    how2pls> (c/value cnt)
    2
    how2pls> (c/dec! cnt)
    #<Counter com.codahale.metrics.Counter@418ff373>
    how2pls> (c/value cnt)
    1
    how2pls>
````

and gauges as well:

````
    how2pls> (require '[palm.gauge :as g])
    nil
    how2pls> (def ga (g/gauge rand))
    #'how2pls/ga
    how2pls> (g/value ga)
    0.13707259327461085
    how2pls> (g/value ga)
    0.43762169261290373
    how2pls> (g/value ga)
    0.8287572825813778
    how2pls>
````
