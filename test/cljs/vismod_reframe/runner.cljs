(ns vismod-reframe.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [vismod-reframe.core-test]))

(doo-tests 'vismod-reframe.core-test)
