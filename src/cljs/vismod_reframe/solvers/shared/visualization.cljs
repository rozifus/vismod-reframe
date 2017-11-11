(ns vismod-reframe.solvers.shared
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))



;; visualization 

(defn visualization [{:keys [graph]} & children]
  [:div 
    {:width "60%" 
     :height "100%"}
    [graph]
    children])

