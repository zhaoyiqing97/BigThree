module.exports = {
    devServer: {
        host: '127.0.0.1', /* 设置为0.0.0.0则所有的地址均能访问 */
        port: 7001, /* 设置端口 */
        open: true, /* 自动打开浏览器 */
        https: false,
        hot: true,  /* 热部署 */
        /* 使用代理 */
        proxy: {
            '^/backend/': {
                target: 'http://127.0.0.1:18080',//后台服务器地址
                changeOrigin: true, /* 允许跨域 */
            }
        },
    },
}
