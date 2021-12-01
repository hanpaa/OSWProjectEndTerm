import Vue from 'vue'
import App from './App.vue'
import router from './router'
import {
  BootstrapVue,
  IconsPlugin
} from 'bootstrap-vue'


// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/main.css'
import vuetify from './plugins/vuetify'


Vue.config.productionTip = false


var getCookie = function(name) {
  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
  return value? value[2] : null;
};

if(getCookie("userId")){
  Vue.prototype.$userId = getCookie("userId");
}else{
  Vue.prototype.$userId = null;
}


new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
