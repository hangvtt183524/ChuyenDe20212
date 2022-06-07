import Vue from "vue";
import VueRouter from "vue-router";
import Home from '../views/Home';
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

  { path: '/:pathMatch(.*)*', component: NotFound },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
