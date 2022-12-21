import VueRouter from 'vue-router'
import index from '@/view'
import writeArticle from '@/view/write-article'
import articleInfo from '@/view/article-info'
import notFound from "@/components/not-found";
import login from "@/view/login";
import store from "@/store";
import Vue from "vue";
import {behaviorSend} from '@/directive/behavior';

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

function sendSkyWalking(to, userId) {
    behaviorSend(to, userId);
}

_router.beforeEach((to, from, next) => {
    const user = store.state.user;
    console.debug(`router.beforeEach token ${user}`, from, to, no_auth_router_arr);
    // 检查用户是否已登录
    if (user) {
        sendSkyWalking(to.path, user.id);
        next();
        return;
    }
    for (const it of no_auth_router_arr) {
        if (it.test(to.path)) {
            sendSkyWalking(to.path);
            next();
            return;
        }
    }
    // 将用户重定向到登录页面
    next({path: '/login'});
})
export default _router;
