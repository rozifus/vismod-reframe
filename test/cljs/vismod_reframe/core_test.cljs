(ns vismod-reframe.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [vismod-reframe.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
