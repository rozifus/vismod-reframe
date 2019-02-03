(ns vismod-reframe.views
  (:require [material-ui]
            [material-ui-icons]
            [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [reagent.core :as r]
            [vismod-reframe.views.main-menu :as main-menu]
            [vismod-reframe.views.solver :as solver]
            [id.nadiar.cljs-mui.core :as mui]
            [id.nadiar.cljs-mui.icons :as icon]
            [id.nadiar.cljs-mui.style :refer [theme] :as style]
            [goog.object :as gobj]))


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

;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(comment
  (defn main-panel []
    (let [active-panel (re-frame/subscribe [:active-panel])]
      (fn []
        [re-com/h-box
        :width "100%"
        :height "100%"
        :children [[main-menu/main-menu] [solver/solver]]
        ]))))

(def custom-style
  {:button {:margin (gobj/getValueByKeys theme "spacing" "uint")}})

(def with-my-styles (style/with-style custom-style))

(defn my-button [{:keys [classes] :as props}]
  [mui/button {:variant "contained"}
   "Hellow Worldie!"])

(defn main-grid [{keys [classes children] :as props}]
  [mui/grid {:container true
             :direction "column"}])

(defn main-panel []
  [:> (r/reactify-component main-grid)])

