import axios from 'axios';
import {Message} from "element-ui";
import router from "@/router";

// create an axios instance
const service = axios.create({
    baseURL: process.env.VUE_APP_API_BASE, // request timeout
    timeout: 150 * 1000
    // withCredentials: true,
    // headers: {
    //     'Cache-Control': 'no-cache',
    //     'Pragma': 'no-cache'
    // }
});

// request interceptor
service.interceptors.request.use((config) => {
    // set Authorization token with request header
    // config.headers['Authorization'] = Cookies.get('big_three_token');
    console.debug('[Service] <Request> --> {fulfilled} ---> config', config);
    return config;
}, (error) => {
    //request error
    console.error('[Service] <Request> --> {rejected} ---> error', error);
    return Promise.reject(error);
});

// response interceptor
service.interceptors.response.use((response) => {
    console.debug('[Service] <Response> --> {fulfilled} ---> response', response);
    return response.data;
}, (error) => {
    console.debug('[Service] <Response> --> {rejected} ---> error', error);
    if (error && error.response) {
        // TODO Reservation processing error response
        switch (error.response.status) {
            case 400:
                break;
            case 401:
                router.push('/login');
                break;
            case 403:
                break;
            case 404:
                break;
            case 405:
                break;
            case 409:
                break;
            case 422:
                break;
            case 500:
                break;
            default:
                break;
        }
        Message({
            message: error.response.data.msg,
            type: 'error'
        });
    }
    return Promise.reject(error);
});

export default service;
