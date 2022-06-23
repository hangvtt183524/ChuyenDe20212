<template lang="">
    <div class="navigation">
        <div class="navigation-tittle">Pet Care</div>
        <div class="menu" ref="menu">
            <div class="choice" v-on:click="highLight" v-for="(page, index) in pages" :key="index">
                <router-link class="page-link" :to="page.path">{{page.name}}</router-link>
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
  data(){
    return {
        pages: [
            {
                path: '/',
                name: 'Trang chủ'
            },
            {
                path: '/booking-schedule',
                name: 'Dịch vụ'
            },
            {
                path: '/',
                name: 'Hỏi đáp'
            },
            {
                path: '/pet-information',
                name: 'Thú cưng của tôi'
            },      
        ]
    }
  },
  methods: {
    highLight(e){
        var underlines = this.$refs.menu.querySelectorAll('.underline')
        underlines.forEach(u => {
            u.classList.remove('visible')
        });
        e.path[1].childNodes[1].classList.add('visible')
    }
},
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>