<template>
  <div class="navigation">
    <div class="navigation-tittle">Pet Care</div>
    <div class="menu">
      <div class="choice">
        <router-link class="page-link" to="/user-management">Quản lý khách hàng</router-link>
        <div class="underline"></div>
      </div>
      <div class="choice">
        <router-link class="page-link" to="/doctor-management">Quản lý bác sĩ</router-link>
        <div class="underline"></div>
      </div>
      <div class="choice">
        <router-link class="page-link" to="/exam-management">Quản lý lịch khám</router-link>
        <div class="underline"></div>
      </div>
    </div>
    <div class="account">
      <div class="choice">
        ADMIN
        <div class="underline"></div>
      </div>
    </div>
  </div>
</template>
<script>
import {mapGetters} from "vuex"
export default {
  name: 'TheNavigation',
  mounted() {
    console.log(this.configUser)
  },
  computed: {
    ...mapGetters({
      configUser: 'config/getConfigUser'
    })
  }
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>