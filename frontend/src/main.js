import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import 'nes.css/css/nes.css';

import '@/index.css';
import '@/font.css';

Vue.use(ElementUI);
Vue.use(VueRouter)
Vue.config.productionTip = false

new Vue({
    router: router,
    render: h => h(App),
}).$mount('#app')
