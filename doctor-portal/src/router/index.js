import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BookingList from "../views/BookingList.vue"
import MessagesScreen from '../views/MessagesScreen.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/booking-list",
    name: "BookingList",
    component: BookingList,
  },
  {
    path: "/messages-screen",
    name: "MessagesScreen",
    component: MessagesScreen,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
