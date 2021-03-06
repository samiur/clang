(defproject
  clang "0.1.0-SNAPSHOT"
  :description "ClojureScript on Angular"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [xnlogic/clobber "0.1.0-SNAPSHOT"]]
  :source-paths ["client"]
  :plugins [[lein-cljsbuild "0.3.2"]]

  ; To get the shegon server:
  ; CLASSPATH=./client:$CLASSPATH lein shegon
  ; -> http://localhost:19000/


  :cljsbuild {:repl-launch-commands {"firefox" ; lein cljsbuild trampoline repl-launch firefox path/to/html
                                       ["/Users/dw/Applications/Firefox.app/Contents/MacOS/firefox"
                                        "-jsconsole"
                                        :stdout ".repl-firefox-out"
                                        :stderr ".repl-firefox-err"]
                                     "ff"
                                       ["/Users/dw/Applications/Firefox.app/Contents/MacOS/firefox"
                                        "-jsconsole"
                                        "resources/public/index.html"
                                        :stdout ".repl-firefox-out"
                                        :stderr ".repl-firefox-err"]
                                     }
              :repl-listen-port 9000
              ;:notify-command ["growlnotify" "-m"]

              :builds
              {:dev
               {:source-paths ["client" "sample"]
                :compiler {:output-to "resources/public/js/clang_dbg.js"
                           :optimizations :whitespace
                           :pretty-print true}}

               :prod
               {:source-paths ["client" "sample"]
                :compiler {:output-to "resources/public/js/clang.js"
                           :pretty-print false
                           :optimizations :advanced}}

               :pre-prod
               {:source-paths ["client" "sample"]

                :compiler {:output-to "resources/public/js/clang_pre.js"
                           :optimizations :simple
                           :pretty-print false
                           }}}
              })


