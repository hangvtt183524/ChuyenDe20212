<template lang="">
    <div>
        <div class="pet-info">
            <div class="pet-content-title">Thông tin chung</div>
            <div class="pet-info-left">
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
                <Dropdown
                    label = "Giới tính"
                    :items="this.genders"
                />
            </div>
            <div class="pet-info-right">
                <InputItem 
                    label = "Cân nặng"
                    :isEditing="true"
                />
                <InputItem 
                    label = "Tình trạng sức khỏe"
                    :isEditing="true"
                />
                <InputItem 
                    label = "Sở thích"
                    :isEditing="true"
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
            genders: [
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
<style lang="">
    
</style>