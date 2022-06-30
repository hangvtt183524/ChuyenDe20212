<template>
    <div class="navigation" ref="menu">
        <div class="navigation-tittle">Pet Care</div>
        <div class="menu">
            <router-link :to="page.path" class="choice" v-on:click.native="highLight(index)" v-for="(page, index) in pages" :key="index">
                <div class="page-link">{{page.name}}</div>
                <div class="underline"></div>
            </router-link>
             <div class="choice" v-on:click="showNavMenu" v-if="Object.keys(currentUser).length > 0">
                <div class="page-link">Thú cưng của tôi</div>
                <div class="underline" ref="thirdUnderline"></div>
                <div class="navMenu" ref="navMenu">
                    <router-link class="navItem" v-for="(pet, index) in this.$store.state.config.petOfUser" :key="index" :to="{path: `/my-pet/${pet.id}/info`}">
                        <div class="navIcon">
                            <i class="fa-solid fa-paw"></i>
                        </div>
                        <div class="navText">{{pet.name}}</div>
                    </router-link>
                </div>
            </div>
          <router-link to="/not-found" class="choice" v-on:click.native="showNavMenu" v-else>
            <div class="page-link">Thú cưng của tôi</div>
            <div class="underline" ref="thirdUnderline"></div>
          </router-link>
          
        </div>
        <div class="account">
<!--            <div class="choice">-->
<!--                Đăng xuất-->
<!--                <div class="underline"></div>-->
<!--            </div>-->
          <router-link to="/user" class="choice" v-on:click.native="highLight(4)" v-if="Object.keys(currentUser).length > 0">
            <div class="page-link">{{this.$store.state.config.currentUser.username}}</div>
            <div class="underline"></div>
          </router-link>
          <router-link to="/login" class="choice" v-on:click.native="highLight(5)" v-if="Object.keys(currentUser).length <= 0">
            <div class="page-link">Đăng nhập</div>
            <div class="underline"></div>
          </router-link>
          <router-link to="/" class="choice" v-on:click.native="highLight(5)" v-if="Object.keys(currentUser).length > 0">
            <div class="page-link">Đăng xuất</div>
            <div class="underline"></div>
          </router-link>
        </div>
    </div>
</template>
<script>
import {mapGetters} from "vuex";
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
    var element = this.$refs.menu
    element.childNodes[1].childNodes[0].childNodes[1].classList.add('visible')
    // console.log(element.childNodes[1].childNodes[0].childNodes[1])
  },
  methods: {
    highLight(index){
        var underlines = this.$refs.menu.querySelectorAll('.underline')
        underlines.forEach(u => {
            u.classList.remove('visible')
        });
        underlines[index].classList.add('visible')
        if( this.$refs.navMenu){
            this.$refs.navMenu.classList.remove('nm-activate')
        }       
    },
    showNavMenu(){
        var underlines = this.$refs.menu.querySelectorAll('.underline')
        underlines.forEach(u => {
            u.classList.remove('visible')
        });
        if(this.$refs.navMenu){
            this.$refs.navMenu.classList.toggle('nm-activate')
        }
        this.$refs.thirdUnderline.classList.add('visible')
        // console.log(this.$refs.thirdUnderline)
        // console.log("ahihi")
        // console.log(window.location.pathname)
    }
},
  computed: {
    ...mapGetters({
      configUser: 'config/getConfigUser',
      currentUser: 'config/getCurrentUser'
    })
  }
}
</script>
<style scoped>
@import url('../../assets/styles/layout/navigation.css');
</style>