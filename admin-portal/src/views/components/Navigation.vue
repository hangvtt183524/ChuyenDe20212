<template lang="">
    <div class="navigation">
        <div class="navigation-tittle">Pet Care</div>
        <div class="menu">
            <div class="choice">
                <router-link class="page-link" to="/">Trang chủ</router-link>
                <div class="underline"></div>
            </div>
            <div class="choice">
                <router-link class="page-link" to="/">Quản lý khách hàng</router-link>
                <div class="underline"></div>
            </div>
            <div class="choice">
                <router-link class="page-link" to="/">Quản lý bác sĩ</router-link>
                <div class="underline"></div>
            </div>
        </div>
        <div class="account">
            <div class="choice">
                Đăng xuất
                <div class="underline"></div>
                </div>
        </div>
    </div>
</template>
<script>
export default {
  name: 'TheNavigation',
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>