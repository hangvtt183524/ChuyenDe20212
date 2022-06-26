<template>
    <div class="pet-info-background">
        <div class="pet-card">
            <div class="pet-avatar-holder">
                <div class="pet-avatar">
                    <div class="pet-avatar-cover">
                        <i class="fa-solid fa-camera"></i>
                    </div>
                </div> 
                <div class="menu" ref="petMenu">                
                    <router-link class="item" :to="item.path" @click.native="petMenuItemOnClick(index)" v-for="(item, index) in menuItems" :key="index">
                        <div class="item-icon">
                            <i :class="item.icon"></i>
                        </div>
                        <div class="item-text">{{item.text}}</div>
                    </router-link>
                </div>                    
            </div>
            <div class="pet-content-holder">
                <div class="pet-name">Milu
                    <div class="pet-name-underline"></div>
                </div>
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<script>

export default {
    components: {
    
    },
    data(){
        return{
            menuItems: [
                {
                    icon: 'fa-solid fa-circle-info',
                    text: 'Thông tin chung',
                    path: '/my-pet/info'
                },
                 {
                    icon: 'fa-solid fa-file',
                    text: 'Lịch sử khám bệnh',
                    path: '/my-pet/history'
                },
                 {
                    icon: 'fa-solid fa-stethoscope',
                    text: 'Đăng ký khám bệnh',
                    path: '/booking-schedule'
                }
            ]
        }
    },
    mounted(){
        this.$refs.petMenu.childNodes[0].classList.add('selected-item')
    },
    methods: {
        petMenuItemOnClick(index){
            // console.log(this.$refs.info.classList)
            var items = this.$refs.petMenu.childNodes
            Array.from(items).forEach(item => {
                item.classList.remove('selected-item')
            });
            items[index].classList.add('selected-item')
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/mypet.css');
</style>