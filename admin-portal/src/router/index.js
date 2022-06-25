import Vue from "vue";
import VueRouter from "vue-router";
import UserManagement from "../views/UserManagement.vue";
import DoctorManagement from "../views/DoctorManagement";

Vue.use(VueRouter);

const routes = [
  {
    path: "/user-management",
    name: "UserManagement",
    component: UserManagement,
  },
  {
    path: "/doctor-management",
    name: "DoctorManagement",
    component: DoctorManagement,
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;