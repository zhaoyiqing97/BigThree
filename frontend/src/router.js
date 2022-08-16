import VueRouter from 'vue-router'
import index from '@/components/index.vue'
import writeArticle from '@/components/write-article'
import login from "@/components/login";
import Cookies from "js-cookie";

const _ = require('lodash');

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
        }
    ]
})
const no_auth_router_arr = [
    '/login',
    '/index'
]
_router.beforeEach((to, from, next) => {
    const token = Cookies.get('big_three_token')
    console.debug(`router.beforeEach token ${token}`, from, to, _.includes(no_auth_router_arr, to.path));
    // 检查用户是否已登录
    if (token) {
        next();
        return;
    }
    if (_.includes(no_auth_router_arr, to.path)) {
        next();
        return;
    }
    // 将用户重定向到登录页面
    next({path: '/login'});
})
export default _router;
