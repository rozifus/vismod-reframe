(ns vismod-reframe.solvers.multiplicative-order
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))



;; point-ring

(defn scale-point-ring [factor points]
  (map 
    (fn [[x y]] [(* x factor) (* y factor)])
    points))

(defn unit-point-ring [point-count]
  (let [step (/ (* 2 Math/PI) point-count)
        half-pi (/ Math/PI 2)]
    (for [i (range point-count)
          :let [angle (- (* i step) half-pi)]]
      [(Math/cos angle) (Math/sin angle)])))

(defn point-ring
  ([point-count] (unit-point-ring point-count))
  ([point-count radius]
    (scale-point-ring radius (unit-point-ring point-count))))

;; svg

(defn svg-panel [props & children]
  [:svg {
    :width "100%"
    :height "100%"
    :id "canvas"
    :style {:outline "2px solid black"
            :background-color "red"}}
    (into children)])

;; solver 

(defn step-panel []
  [re-com/v-box
    :size "1"
    :style {:background-color "blue"}
    :children [[:div]]])

(defn section [{keys [points data]} & children]
  (let [path-string "M10,10 L0,0"]
    [:path {
      :d path-string
      :stroke-width "0.5"
      :fill "none"
      :stroke "green"}]))

(defn layer [{:keys [points data]} & children]
  [:g
    (into children)])

(defn graph-panel []
  [re-com/box
    :size "2"
    :child [svg-panel {} [:g]]])

(defn solver-panel []
  (fn []
    [re-com/h-box
      :size "1"
      :height "100%"
      :children [[step-panel] [graph-panel]]]))
