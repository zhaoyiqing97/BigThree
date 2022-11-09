import VueRouter from 'vue-router'
import index from '@/components/index.vue'
import writeArticle from '@/components/write-article'
import articleInfo from '@/components/article-info'
import notFound from "@/components/not-found";
import login from "@/components/login";
import store from "@/store";
import Vue from "vue";
import ClientMonitor from 'skywalking-client-js';

Vue.use(VueRouter)

const _router = new VueRouter({
    mode: 'history', // require service support
    routes: [
        {
            path: '',
            redirect: '/index'
        },
        {
            path: '/index',
            component: index,
        },
        {
            path: '/write/:id',
            component: writeArticle,
            props: true
        },
        {
            path: '/write',
            component: writeArticle
        },
        {
            path: '/login',
            component: login
        },
        {
            path: '/article-info/:id',
            component: articleInfo,
            props: true
        },
        {path: '*', component: notFound}
    ]
})
const no_auth_router_arr = [
    /\/login/,
    /\/index/,
    /^\/article-info\/\d+$/
]

function sendSkyWalking(to) {
    ClientMonitor.setPerformance({
        collector: process.env.VUE_APP_SKY_BASE + process.env.VUE_APP_SKY_CONTEXT,
        service: 'big_three::frontend',
        serviceVersion: '2.0.0',
        pagePath: to,
        useFmp: true
    });
}

_router.beforeEach((to, from, next) => {
    const user = store.state.user;
    console.debug(`router.beforeEach token ${user}`, from, to, no_auth_router_arr);
    // 检查用户是否已登录
    if (user) {
        sendSkyWalking(to);
        next();
        return;
    }
    for (const it of no_auth_router_arr) {
        if (it.test(to.path)) {
            sendSkyWalking(to);
            next();
            return;
        }
    }
    // 将用户重定向到登录页面
    next({path: '/login'});
})
export default _router;
