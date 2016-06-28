(ns leiningen.new.dashboard
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "dashboard"))

(defn dashboard
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/dashboard/core.cljs" data)]
             ["src/cljs/{{sanitized}}/widgets/simple_text.cljs" (render "src/cljs/dashboard/widgets/simple_text.cljs" data)]
             ["project.clj" (render "project.clj" data)]
             ["test/clj/{{sanitized}}/example_test.clj" (render "test/clj/dashboard/example_test.clj" data)]
             ["src/clj/{{sanitized}}/server.clj" (render "src/clj/dashboard/server.clj" data)]
             ["dev/user.clj" (render "dev/user.clj" data)]
             ["src/clj/{{sanitized}}/fetcher.clj" (render "src/clj/dashboard/fetcher.clj" data)]
             ["resources/public/index.html" (render "resources/index.html")]
             ["resources/public/images/github_logo.png" (render "resources/images/github_logo.png")]
             ["resources/public/images/github_mark.png" (render "resources/images/github_mark.png")]
             ["resources/log4j.properties" (render "resources/log4j.properties")]
             ["resources/public/css/style.css" (render "resources/css/style.css")]
             ["resources/public/images/grey_wash_wall.png" (render "resources/images/grey_wash_wall.png")]
             )))
