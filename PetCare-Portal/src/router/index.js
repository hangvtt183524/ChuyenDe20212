import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BookingSchedule from "../views/BookingSchedule";
import PetInformation from "../views/PetInformation.vue";

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
  {
    path: "/pet-information",
    name: "PetInformation",
    component: PetInformation,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
