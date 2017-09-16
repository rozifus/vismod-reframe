(ns vismod-reframe.events
  (:require [re-frame.core :as re-frame]
            [vismod-reframe.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :set-open-main-menu
 (fn [db [_ open?]]
   (assoc db :open-main-menu open?)))

(re-frame/reg-event-db
 :set-active-solver
 (fn [db [_ active-solver]]
   (assoc db :open-solver active-solver)))
