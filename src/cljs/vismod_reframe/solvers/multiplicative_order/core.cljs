(ns vismod-reframe.solvers.multiplicative-order
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))


;; solver 


(defn point-ring [point-count size]
  (let [step (/ (2 * Math/PI) point-count)
        half-pi (/ Math/PI 2)]
    (for [i (range point-count)
          :let [angle (- (* i step) half-pi)]]
      [(* size (Math/cos angle)) (* size (Math/sin angle))]))))

(defn svg-panel []
  [:svg {
    :width "100%"
    :height "100%"
    :id "canvas"
    :style {:outline "2px solid black"
            :background-color "red"}}])

(defn step-panel []
  [re-com/v-box
    :size "1"
    :style {:background-color "blue"}
    :children [[:div]]])

(defn graph-panel []
  [re-com/box
    :size "2"
    :child [svg-panel]])

(defn solver-panel []
  (fn []
    [re-com/h-box
      :size "1"
      :height "100%"
      :children [[step-panel] [graph-panel]]]))
