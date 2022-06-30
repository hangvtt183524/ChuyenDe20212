import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home.vue";
import Auth from "../views/Auth.vue";
  import Login from "../views/Login.vue";
  import SignUp from "../views/SignUp.vue";
import BookingSchedule from "../views/BookingSchedule";
import MyPet from "../views/MyPet.vue";
import PetInfo from "../views/PetInfo.vue"
import PetHistory from "../views/PetHistory.vue"
import NotFound from "../views/NotFound.vue"
import Login from "../views/Login"

import NotFound from "../views/NotFound";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: '/home',
  },
  {
    path: "/home",
    component: Home,
  },
  {
    path: '',
    children: [{
        path: '/login',
        component: Login,
      }, {
        path: '/sign-up',
        component: SignUp
      },
    ],
    component: Auth,
  }, {
    path: "/booking-schedule",
    name: "BookingSchedule",
    component: BookingSchedule,
  },


  { path: '/:pathMatch(.*)*', component: NotFound },
];


const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
