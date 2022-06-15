import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BookingSchedule from "../views/BookingSchedule";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/booking-schedule",
    name: "BookingSchedule",
    component: BookingSchedule,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
