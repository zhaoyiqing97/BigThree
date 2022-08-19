import request from './service';

export const articlePage = (params) => {
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
export const articlePush = (data) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + '/publishArticle',
        method: 'post',
        data
    });
}
export const articleSearch = (search) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + `/no-auth/article-info/search?search=${search}`,
        method: 'get'
    });
}
export const articleGet = (id) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + `/no-auth/article-info/${id}`,
        method: 'get'
    });
}
