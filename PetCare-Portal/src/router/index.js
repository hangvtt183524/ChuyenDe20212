import Vue from "vue";
import VueRouter from "vue-router";

import Home from '../views/Home';
import Auth from '../views/Auth';
  import Login from '../views/Auth/Login';
  import SignUp from '../views/Auth/SignUp';

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
  },


  { path: '/:pathMatch(.*)*', component: NotFound },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
