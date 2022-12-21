import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ClientMonitor from 'skywalking-client-js';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import 'nes.css/css/nes.css';

import '@/index.css';
import '@/font.css';
import '@/filter';
import '@/directive';


Vue.use(ElementUI);
Vue.config.productionTip = false;

// Vue
ClientMonitor.register({
    collector: process.env.VUE_APP_SKY_BASE + process.env.VUE_APP_SKY_CONTEXT,
    service: 'big_three::frontend',
    pagePath: 'index.html',
    serviceVersion: '2.0.0',
    vue: Vue,
    useFmp: true,
    enableSPA: true
});

new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')
