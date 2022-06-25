<template>
    <div class="pet-info-background">
        <div class="pet-card">
            <div class="pet-avatar-holder">
                <div class="pet-avatar">
                    <div class="pet-avatar-cover"></div>
                </div>                     
            </div>
            <div class="pet-info-holder">
                <div class="pet-name">Milu
                    <div class="pet-name-underline"></div>
                </div>
                <div class="pet-content">
                    <div class="pet-content-title">Thông tin chung</div>
                    <div class="pet-content-left">
                       <InputItem 
                            label = "Tên thú cưng"
                            isEditing="true"
                        />
                        <InputItem 
                            label = "Loại thú cưng"
                            isEditing="true"
                        />
                        <InputItem 
                            label = "Tuổi"
                            isEditing="true"
                        />
                        <Dropdown
                            label = "Giới tính"
                            :items="this.gender"
                        />
                    </div>
                    <div class="pet-content-right">
                        <InputItem 
                            label = "Cân nặng"
                            isEditing="true"
                        />
                        <InputItem 
                            label = "Tình trạng sức khỏe"
                            isEditing="true"
                        />
                        <InputItem 
                            label = "Sở thích"
                            isEditing="true"
                        />
                    </div>
                </div>
                <div class="pet-buttons-holder">
                      
                    <Button
                        text="Hủy"
                        color="white"
                    />
                    <Button 
                        text="Lưu"
                        color="blue"
                    />     
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import InputItem from './components/InputItem.vue'
import Button from './components/Button.vue'
import Dropdown from './components/Dropdown.vue'
export default {
    components: {
        InputItem, Button, Dropdown
    },
    data(){
        return{
            gender: [
                {
                    text: "Giống đực"
                },
                {
                    text: "Giống cái"
                }
            ]
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/pet-information.css');
</style>