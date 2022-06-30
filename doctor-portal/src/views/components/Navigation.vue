<template>
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
                {{$store.state.config.currentDoctor.doctorName}}
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
                path: '/booking-list',
                name: 'Quản lý lịch khám'
            },
            {
                path: '/messages-screen',
                name: 'Tin nhắn'
            },    
        ],
        pets: [
            {
                id: '1',
                name: 'Milu'
            },
            {
                id: '2',
                name: 'Ki'
            }
        ]
    }
  },
  mounted(){
  },
  methods: {
    highLight(index){
        var underlines = this.$refs.menu.querySelectorAll('.underline')
        underlines.forEach(u => {
            u.classList.remove('visible')
        });
        underlines[index].classList.add('visible')
        console.log(index)
    },
},
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>