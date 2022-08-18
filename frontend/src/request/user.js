import request from './service';

export const _login = (username, password) => {
    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);
    return request({
        url: process.env.VUE_APP_API_CONTEXT + 'login',
        params,
        method: 'post'
    });
};
