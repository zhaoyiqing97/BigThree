import request from './service';
import store from "@/store";

export const doLogin = async (username, password) => {
    const res = await _login(username, password);
    store.commit('setUser', res.data);
}
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
