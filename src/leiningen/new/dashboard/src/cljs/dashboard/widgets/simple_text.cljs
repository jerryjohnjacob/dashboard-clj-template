(ns {{ns-name}}.widgets.simple-text
  (:require [reagent.core :as r :refer [atom]]
            [dashboard-clj.widgets.core :as widget-common]))


(widget-common/register-widget
 :simple-text
 (fn [data options]
   [:div {:class "simple-text-widget"}
    [:h3 {:class "title"} (get-in data [:data :title])]
    [:div {:class "data"}
     [:p
      (get-in data [:data :text])]]
    ]))
