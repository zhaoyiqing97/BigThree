import request from './service';

export const articleInfoPage = (params) => {
    return request({
        url: process.env.VUE_APP_API_CONTEXT + '/no-auth/article-info/page',
        params: params,
        method: 'get'
    });
};
