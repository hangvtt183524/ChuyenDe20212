<template lang="">
    <div class="navigation">
        <div class="navigation-tittle">Pet Care</div>
        <div class="menu">
            <div class="choice">
                <router-link class="page-link" to="/">Trang chủ</router-link>
                <div class="underline"></div>
            </div>
            <div class="choice">
                <router-link class="page-link" to="/booking-schedule">Dịch vụ</router-link>
                <div class="underline"></div>
            </div>
            <div class="choice">
                Sản phẩm
                <div class="underline"></div>
            </div>
            <div class="choice">
                Hỏi đáp
                <div class="underline"></div>
            </div>
            <div class="choice">
                <router-link class="page-link" to="/pet-information">Thú cưng của tôi</router-link>
                <div class="underline"></div>
            </div>
        </div>
        <div class="account">
            <div class="choice">
                Đăng xuất
                <div class="underline"></div>
                </div>
            <div class="choice">
                Đăng Nhập
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