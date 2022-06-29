import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BookingSchedule from "../views/BookingSchedule";
import MyPet from "../views/MyPet.vue";
import PetInfo from "../views/PetInfo.vue"
import PetHistory from "../views/PetHistory.vue"
import NotFound from "../views/NotFound.vue"
import Login from "../views/Login"
import User from "../views/User.vue"

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
        path: "/not-found",
        name: "NotFound",
        component: NotFound
    },
    {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/my-pet/:petId",
    name: "MyPet",
    component: MyPet,
    children: [
      {
        path: "info",
        component: PetInfo
      },
      {
        path: "history",
        component: PetHistory
      }
    ]
  },
  {
    path: '/user',
    component: User
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
