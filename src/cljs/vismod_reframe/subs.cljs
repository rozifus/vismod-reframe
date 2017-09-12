(ns vismod-reframe.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))

(re-frame/reg-sub
 :open-solver-menu
 (fn [db _]
   (:open-solver-menu db)))

(re-frame/reg-sub
 :active-solver
 (fn [db _]
   (:active-solver db)))
