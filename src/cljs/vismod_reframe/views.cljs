(ns vismod-reframe.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))


;; home

(defn home-title []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [re-com/title
       :label (str "Hello from " @name ". This is the Home Page.")
       :level :level1])))

(defn link-to-about-page []
  [re-com/hyperlink-href
   :label "go to About Page"
   :href "#/about"])

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[home-title] [link-to-about-page]]])


;; about

(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title] [link-to-home-page]]])

(defn euclidean-solver []
  [re-com/title
    :label "euclidean solver!"
    :level :level1])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn- solver-panels [solver-name]
  (case solver-name
    :euclidean [euclidean-solver]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn solver-menu []
  (let [open-solver-menu (re-frame/subscribe [:open-solver-menu])]
    (fn []
      [re-com/v-box
       :size "200px"
       :children []
      ])))

(defn solver []
  (let [active-solver (re-frame/subscribe [:active-solver])]
    (fn []
      [re-com/v-box
       :size "1"
       :children [[solver-panels @active-solver]]
      ])))

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [re-com/h-box
       :width "100%"
       :height "100%"
       :children [[solver-menu] [solver]]
      ])))

