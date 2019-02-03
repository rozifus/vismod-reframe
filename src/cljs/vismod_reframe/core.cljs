(ns vismod-reframe.core
  (:require [cljsjs.material-ui]
            [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [vismod-reframe.events]
            [vismod-reframe.subs]
            [vismod-reframe.routes :as routes]
            [vismod-reframe.views :as views]
            [vismod-reframe.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))

(init)
