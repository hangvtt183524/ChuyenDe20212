import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import Vue2Editor from "vue2-editor";
import { BootstrapVue, IconsPlugin, BootstrapVueIcons } from 'bootstrap-vue';

import './assets/scss/main.scss';

Vue.use(Vue2Editor);

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(BootstrapVueIcons);

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");