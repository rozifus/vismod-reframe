(ns vismod-reframe.views.solver
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [vismod-reframe.solvers.multiplicative-order :as multiplicative-order]))

;; solver 

(defn euclidean-solver []
  [re-com/title
    :label "euclidean solver!"
    :level :level1])

(defn- solver-panels [solver-name]
  (case solver-name
    :euclidean [euclidean-solver]
    :multorder [multiplicative-order/solver-panel]
    [:div]))

(defn solver []
  (let [active-solver (re-frame/subscribe [:active-solver])]
    [re-com/box
      :size "1"
      :child [solver-panels @active-solver]]))
