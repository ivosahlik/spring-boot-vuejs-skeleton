import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import {routes} from './routes'
import VueResource from 'vue-resource'
import Vuetify from 'vuetify'

import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.use(VueRouter)
Vue.use(VueResource)
Vue.use(Vuetify)

const router = new VueRouter({
  routes: routes,
  mode: 'history'
})

new Vue({
  el: '#app',
  router: router,
  render: h => h(App)
})
