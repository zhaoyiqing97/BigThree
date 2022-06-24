import VueRouter from 'vue-router'
import index from '@/components/index.vue'
import writeArticle from '@/components/write-article'

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
        {
            path: '/write/:id',
            component: writeArticle,
            props: true
        },
    ]
})
