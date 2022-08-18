import request from './service';

export const articleInfoPage = (params) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + '/no-auth/article-info/page',
        params: params,
        method: 'get'
    });
};
export const articleType = () => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + '/no-auth/article-type/list',
        method: 'get'
    });
}
export const pushArticle = (data) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + '/publishArticle',
        method: 'post',
        data
    });
}
