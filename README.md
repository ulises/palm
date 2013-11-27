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
    how2pls> (doseq [n (range 10)] (update h n))
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
