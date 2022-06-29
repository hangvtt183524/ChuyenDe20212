<template lang="">
    <div class="blue-bg">
        <div class="user-page scrollable" ref="userPage">
            <div class="header">Thông tin người dùng</div>
            <div class="user-info">
                <div class="avatar-holder">
                    <i class="fa-solid fa-user"></i>
                </div>
                <div class="info-content">
                    <div class="info-part">
                        <InputItem 
                            label = "Họ và tên"
                            :isEditing="true"
                        />
                        <InputItem 
                            label = "Số điện thoại"
                            :isEditing="true"
                        />
                    </div>
                    <div class="info-part">
                        <InputItem 
                            label = "Email"
                            :isEditing="true"
                        />
                        <InputItem 
                            label = "Địa chỉ"
                            :isEditing="true"
                        />
                    </div>
                </div>

            </div>
            <div class="pet-holder" v-for="(pet, index) in petList" :key="index">
                <div class="header">Thông tin thú cưng
                    <Button
                        text="Xóa"
                        color="red"
                        @click.native = "deletaPetBtnOnClick(index)"
                    />
                </div>
                <div class="pet-info">
                <div class="avatar-holder">
                    <i class="fa-solid fa-dog"></i>
                </div>
                <div class="info-content">
                    <div class="info-part">
                        <InputItem 
                            label = "Tên thú cưng"
                            :isEditing="true"
                        />
                        <InputItem 
                            label = "Loại thú cưng"
                            :isEditing="true"
                        />
                        <InputItem 
                            label = "Tuổi"
                            :isEditing="true"
                        />
                    </div>
                    <div class="info-part">
                        <Dropdown 
                            label = "Giới tính"
                            :items="genders"
                        />
                        <InputItem 
                            label = "Cân nặng"
                            :isEditing="true"
                            v-model="petList[index].weight"
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
                />     
            </div>
        </div>
    </div>
</template>
<script>
import InputItem from './components/InputItem.vue'
import Button from './components/Button.vue'
import Dropdown from './components/Dropdown.vue'
export default {
    name: 'User',
    components: {
        InputItem, Button, Dropdown
    },
    data(){
        return{
            petList: [
                {}
            ],
            genders: [
                {
                    text: "Giống đực"
                },
                {
                    text: "Giống cái"
                }
            ],
        }
    },
    methods: {
        addPetBtnOnClick(){
            this.petList.push({})
        },
        deletaPetBtnOnClick(index){
            console.log(this.petList)
            if(this.petList.length > 1){
                console.log(index)
                this.petList.splice(index, 1) 
                console.log(this.petList)             
            }
            
        }
    },
    watch:{
        // numberOfPets(){
        //     console.log(this.$refs.userPage.querySelectorAll('.pet-holder'))          
        // }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/user.css');
</style>