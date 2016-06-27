(ns {{ns-name}}.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout-responsive :as grid]
            [{{ns-name}}.widgets.simple-text]
            [re-frame.core :as rf]))

(def widgets [{
               :type        :simple-text
               :name        :sample-widget
               :data-source :welcome-message
               :options     {}}])

(def widget-layout {
                    :sample-widget {:layout-opts {:position {:lg {:x 0 :y 0 :w 2 :h 2}
                                                             :md {:x 0 :y 0 :w 2 :h 2}
                                                             :sm {:x 0 :y 0 :w 2 :h 2 :static true}}}}})

(def dashboard {
                :layout  :responsive-grid-layout
                :options {:layout-opts {:cols {:lg 6 :md 4 :sm 2 :xs 1 :xxs 1}}}
                :widgets (mapv #(merge % (get widget-layout (:name %))) widgets)
                })

(d/start-dashboard dashboard "app")
