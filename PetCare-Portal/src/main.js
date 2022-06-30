import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store/index";
import Vue2Editor from "vue2-editor";
import VueNotification from "vue-notification";
import { BootstrapVue, IconsPlugin, BootstrapVueIcons } from 'bootstrap-vue';

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import './assets/scss/main.scss';

Vue.use(Vue2Editor);

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(BootstrapVueIcons);
Vue.use(VueNotification);

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");