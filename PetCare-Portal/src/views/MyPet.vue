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
import Vue from 'vue'

export default {
    components: {
    
    },
    data(){
        return{
            petId: this.$route.path.split('/')[2],
            menuItems: [
                {
                    icon: 'fa-solid fa-circle-info',
                    text: 'Thông tin chung',
                    path: ''
                },
                 {
                    icon: 'fa-solid fa-file',
                    text: 'Lịch sử khám bệnh',
                    path: ''
                },
                 {
                    icon: 'fa-solid fa-stethoscope',
                    text: 'Đăng ký khám bệnh',
                    path: '/booking-schedule'
                }
            ],
            test: [
                {
                    name: this.petId
                }
            ]
        }
    },
    created(){
        // this.petId = this.$route.path.split('/')[2]
        // console.log(this.petId)
        this.setUpPetMenuPath()
    },

    mounted(){
        this.petMenuItemOnClick(0)
    },
    methods: {
        petMenuItemOnClick(index){
            // console.log(this.$refs.info.classList)
            var items = this.$refs.petMenu.childNodes
            items.forEach(item => {
                item.classList.remove('selected-item')
            });
            items[index].classList.add('selected-item')
        },
        setUpPetMenuPath(){
            this.menuItems.forEach((item, index) => {
            if(index == 0){
                item.path = `/my-pet/${this.petId}/info`
            }
            if(index == 1){
                item.path = `/my-pet/${this.petId}/history`
            }
        });
        },
        reload(){
            this.petMenuItemOnClick(0)
        }
    },
    watch:{
        $route: function(){
            this.petId = this.$route.path.split('/')[2]
            Vue.nextTick(()=>{
                this.reload()
            })
            // console.log(this.petId)
        },
        petId: function(){
            this.setUpPetMenuPath()
            //reload lại page
            Vue.nextTick(()=>{
                this.reload()
            })
            
        }

    }
}
</script>
<style scoped>
    @import url('../assets/styles/mypet.css');
</style>