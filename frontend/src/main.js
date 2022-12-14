import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ClientMonitor from 'skywalking-client-js';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import 'nes.css/css/nes.css';

import '@/index.css';
import '@/font.css';
import '@/filters';

Vue.use(ElementUI);
Vue.config.productionTip = false

// Vue
Vue.config.errorHandler = (error) => {
    ClientMonitor.reportFrameErrors({
        collector: process.env.VUE_APP_SKY_BASE + process.env.VUE_APP_SKY_CONTEXT,
        service: 'big_three::frontend',
        pagePath: '/error',
        serviceVersion: '2.0.0',
    }, error);
}

new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')
