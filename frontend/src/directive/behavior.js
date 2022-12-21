import ClientMonitor from 'skywalking-client-js';
import store from "@/store";

const behavior = {
    inserted: function (_el, _binding) {
        _el.onclick = () => {
            let type = _binding.value['type'];
            let resource = _binding.value['resource'];
            const user = store.state.user;
            behaviorSend(`${type}:${resource}`, user.id);
        }
    },
}
const behaviorSend = (resource, userId) => {
    let userStr = ''
    if (userId) {
        userStr = ":" + userId
    }
    ClientMonitor.setPerformance({
        collector: process.env.VUE_APP_SKY_BASE + process.env.VUE_APP_SKY_CONTEXT,
        service: `big_three::frontend`,
        serviceVersion: '2.0.0',
        pagePath: `${resource}${userStr}`,
    });
}

export {behavior, behaviorSend};
