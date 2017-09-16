(ns vismod-reframe.views.main-menu
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))

(defn main-menu-visible []
  [re-com/v-box
    :size "200px"
    :children [
      [re-com/button
        :label "🗙"
        :on-click #(re-frame/dispatch [:set-open-main-menu false])]]])

(defn main-menu-hidden []
  [re-com/button 
    :label ">"
    :on-click #(re-frame/dispatch [:set-open-main-menu true])])

(defn main-menu []
  (let [open-main-menu (re-frame/subscribe [:open-main-menu])]
    (fn []
      (if @open-main-menu [main-menu-visible] [main-menu-hidden]))))