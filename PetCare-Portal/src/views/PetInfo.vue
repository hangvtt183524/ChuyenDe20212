<template>
    <div>
        <div class="pet-info">
            <div class="pet-content-title">Thông tin chung</div>
            <div class="pet-info-left">
                <InputItem 
                    label = "Tên thú cưng"
                    :isEditing="true"
                    v-model="petData.name"
                    :is-only-numeric="false"
                    :is-only-alpha="false"
                />
                <InputItem 
                    label = "Loại thú cưng"
                    :isEditing="true"
                    v-model="petData.species"
                    :is-only-numeric="false"
                    :is-only-alpha="false"
                />
                <InputItem 
                    label = "Tuổi"
                    :isEditing="true"
                    v-model="petData.age"
                    :is-only-numeric="false"
                    :is-only-alpha="false"
                />
            </div>
            <div class="pet-info-right">
                <InputItem 
                    label = "Cân nặng"
                    :isEditing="true"
                    v-model="petData.weight"
                    :is-only-numeric="false"
                    :is-only-alpha="false"
                />
              <Dropdown
                  label = "Giới tính"
                  :items="this.genders"
              />
            </div>
        </div>
        <div class="pet-buttons-holder">      
            <button class="button is-normal">Hủy</button>
            <button
                class="button is-normal is-blue"
                @click="savePet"
            >Lưu</button>
        </div>
    </div>
</template>
<script>
import InputItem from './components/InputItem.vue'
import Dropdown from './components/Dropdown.vue'
import InfotypeServices from "@/services/InfotypeServices"
export default {
     components: {
        InputItem, Dropdown
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
            ],
          petData: {}
        }
    },
  mounted() {
       this.petData = this.$store.state.config.petOfUser.filter(pet => pet.id === this.$store.state.config.currentPetIndex)[0]
  },
  methods: {
       async savePet() {
         const savedPet = await InfotypeServices.savePet(this.petData)
         const petIndex = this.$store.state.config.petOfUser.indexOf(
             this.$store.state.config.petOfUser.filter(pet => pet.id === this.$store.state.config.currentPetIndex)[0]
         )

         let newPetList = this.$store.state.config.petOfUser.splice(petIndex, 1)
         newPetList.splice(petIndex, 0, savedPet)
         this.$store.commit('config/setPetOfUser', newPetList)
       }
  }
}
</script>
<style lang="">
    
</style>