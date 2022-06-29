<template>
    <div class="blue-bg">
        <div class="user-page scrollable" ref="userPage">
            <div class="header">Thông tin người dùng</div>
            <div class="user-info">
                <div class="avatar-holder"></div>
                <div class="info-content">
                    <div class="info-part">
                        <InputItem 
                            label = "Username"
                            :isEditing="true"
                            v-model="userInfo.username"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                        <InputItem 
                            label = "Số điện thoại"
                            :isEditing="true"
                            v-model="userInfo.phone"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                    </div>
                    <div class="info-part">
                        <InputItem 
                            label = "Email"
                            :isEditing="true"
                            v-model="userInfo.mail"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                        <InputItem 
                            label = "Địa chỉ"
                            :isEditing="true"
                            v-model="userInfo.address"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                    </div>
                </div>

            </div>
            <div class="pet-holder" v-for="(pet, index) in petsInfo" :key="index">
                <div class="header">Thông tin thú cưng
                    <Button
                        text="Xóa"
                        color="red"
                        @click.native = "deletaPetBtnOnClick(index)"
                    />
                </div>
                <div class="pet-info">
                <div class="avatar-holder"></div>
                <div class="info-content">
                    <div class="info-part">
                        <InputItem 
                            label = "Tên thú cưng"
                            :isEditing="true"
                            v-model="pet.name"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                        <InputItem 
                            label = "Loại thú cưng"
                            :isEditing="true"
                            v-model="pet.species"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                        <InputItem 
                            label = "Tuổi"
                            :isEditing="true"
                            v-model="pet.age"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                    </div>
                    <div class="info-part">
                        <InputItem 
                            label = "Giới tính"
                            :isEditing="true"
                            v-model="pet.gender"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                        <InputItem 
                            label = "Cân nặng"
                            :isEditing="true"
                            v-model="pet.weight"
                            :is-only-alpha="false"
                            :is-only-numeric="false"
                        />
                    </div>
                </div>
            </div>
            </div>
            <div class="buttons-holder">      
                <Button
                    text="Hủy"
                    color="white"
                />
                <Button 
                    text="Thêm thú cưng"
                    color="orange"
                    @click.native="addPetBtnOnClick"
                />
                <Button
                    text="Lưu"
                    color="blue"
                    @click.native="saveInfo"
                />
            </div>
        </div>
    </div>
</template>
<script>
import InputItem from './components/InputItem.vue'
import Button from './components/Button.vue'
import InfotypeServices from "@/services/InfotypeServices"
import {mapGetters} from "vuex"

export default {
    name: 'User',
    components: {
        InputItem, Button
    },
    data(){
        return{
          userInfo: null,
          petsInfo: []
        }
    },
    methods: {
        addPetBtnOnClick(){
            this.petsInfo.push({
              id: null,
              name: null,
              gender: null,
              age: null,
              species: null,
              weight: null
            })
        },
        deletaPetBtnOnClick(index){
            console.log(this.petList)
            if(this.petList.length > 1){
                console.log(index)
                this.petList.splice(index, 1) 
                console.log(this.petList)             
            }
            
        },
      async saveInfo() {
        await InfotypeServices.saveUser(this.userInfo)
        this.$store.commit('config/setCurrentUser', this.userInfo)
        this.$notify({
          group: 'default',
          type: 'success',
          title: 'Save successfully!'
        })
      }
    },
    watch:{
        numberOfPets(){
            // console.log(this.$refs.userPage.querySelectorAll('.pet-holder'))
        }
    },
  created() {
      this.userInfo = this.currentUser
    this.petsInfo = this.petOfUser
  },
  computed: {
    ...mapGetters({
      currentUser: 'config/getCurrentUser',
      petOfUser: 'config/getPetOfUser'
    })
  }
}
</script>
<style scoped>
    @import url('../assets/styles/user.css');
</style>