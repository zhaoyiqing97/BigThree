import VueRouter from 'vue-router'
import index from '@/components/index.vue'

export default new VueRouter({
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
    ]
})
