<template lang="">
    <div class="navigation">
        <div class="navigation-tittle">Pet Care</div>
        <div class="menu" ref="menu">
            <router-link :to="page.path" class="choice" v-on:click.native="highLight(index)" v-for="(page, index) in pages" :key="index">
                <div class="page-link">{{page.name}}</div>
                <div class="underline"></div>
            </router-link>
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
                path: '/my-pet/info',
                name: 'Thú cưng của tôi'
            },      
        ]
    }
  },
  mounted(){
    console.log(this.$refs.menu.childNodes[0].childNodes[1].classList.add('visible'))
  },
  methods: {
    highLight(index){
        var underlines = this.$refs.menu.querySelectorAll('.underline')
        underlines.forEach(u => {
            u.classList.remove('visible')
        });
        underlines[index].classList.add('visible')
    }
},
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>