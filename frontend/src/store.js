import Vuex from "vuex";
import Vue from "vue";

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        user: JSON.parse(sessionStorage.getItem("big-three"))
    },
    mutations: {
        setUser(state, newUser) {
            state.user = newUser;
            sessionStorage.setItem("big-three", JSON.stringify(newUser));
        },
        clearUser(state) {
            sessionStorage.clear();
            state.user = null;
            console.log(state.user, 'clearUser');
        }
    }
})
export default store;
