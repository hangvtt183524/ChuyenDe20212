<template lang="">
    <div class="blue-bg">
        <div class="user-page scrollable" ref="userPage">
            <div class="header">Thông tin người dùng</div>
            <div class="user-info">
                <div class="avatar-holder"></div>
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
            <div class="pet-holder" v-for="(pet, index) in numberOfPets" :key="index">
                <div class="header">Thông tin thú cưng
                    <Button
                        text="Xóa"
                        color="red"
                        @click.native = "deletaPetBtnOnClick"
                    />
                </div>
                <div class="pet-info">
                <div class="avatar-holder"></div>
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
                        <InputItem 
                            label = "Giới tính"
                            :isEditing="true"
                        />
                        <InputItem 
                            label = "Cân nặng"
                            :isEditing="true"
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
export default {
    name: 'User',
    components: {
        InputItem, Button
    },
    data(){
        return{
            numberOfPets: 1,
        }
    },
    methods: {
        addPetBtnOnClick(){
            this.numberOfPets += 1
        },
        deletaPetBtnOnClick(e){
            var currentPet = e.target.parentNode.parentNode
            if(this.numberOfPets > 1){
                this.$refs.userPage.removeChild(currentPet)
            }
            
        }
    },
    watch:{
        numberOfPets(){
            console.log(this.$refs.userPage.querySelectorAll('.pet-holder'))          
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/user.css');
</style>