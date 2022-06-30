<template>
  <div class="blue-bg">
    <div class="booking-page">
      <div class="header">
        Đăng kí lịch khám
      </div>
      <div class="booking-content">
        <div class="booking-part">
          <InputItem
              label = "Thú cưng"
              :isEditing="true"
              v-model="choosenPet"
              :placeholder="choosenPet"
          />
          <InputItem
              label = "Ngày khám"
              :isEditing="true"
              v-model="chooseDate"
          />
          <Button
              text="Đặt lịch"
              color="blue"
              @click.native="saveExam"
          />
        </div>
        <div class="booking-part">
          <InputItem
              label = "Giờ khám"
              :isEditing="true"
              v-model="chooseTime"
          />
          <InputItem
              label = "Ghi chú"
              :isEditing="true"
              v-model="chooseDescription"
              :is-only-numeric="false"
              :is-only-alpha="false"
          />
        </div>
      </div>
      <div class="header">
        Lịch sử khám bệnh
      </div>
        <div class="pet-history-table scrollable">
            <table class="table" ref="table">
                <thead>
                    <tr>
                        <th class="align-center">STT</th>
                        <th>Tên Bệnh</th>
                        <th>Bác sĩ</th>
                        <th class="align-center">Thời gian</th>
                        <th>Kết luận</th>
                        <th>Chức năng</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>  
                        <td class="align-center">1</td>
                        <td>Rụng lông</td>
                        <td>VTTHANG</td>
                        <td class="align-center">12-04-2022</td>
                        <td>Đã chữa khỏi</td>
                        <td>
                            <Button
                                text="Chi tiết"
                                color="blue"
                                @click.native="detailBtnOnClick"
                            />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <PetHistoryDetail
      v-if="showPetHistoryDetail"
      @exitDetail="hidePetHistoryDetail"
    />
  </div>
</template>
<script>
import InputItem from './components/InputItem.vue'

import Button from './components/Button.vue'
import PetHistoryDetail from './PetHistoryDetail.vue'
import {mapGetters} from "vuex";
import moment from "moment";
import InfotypeServices from "@/services/InfotypeServices";
export default {
  components: {
    InputItem, Button, PetHistoryDetail
  },
  data(){
    return{
      myPets: [],
      showPetHistoryDetail: false,
      choosenPet: 'Milu',
      choosenPetId: 1,
      chooseDate: null,
      chooseTime: null,
      chooseDescription: ''
    }
  },
   methods: {
    detailBtnOnClick(){
        this.showPetHistoryDetail = true
    },
    hidePetHistoryDetail(){
        this.showPetHistoryDetail = false
    },
     async saveExam() {
      let newExam = {
        ownerId: this.$store.state.config.currentUser.id,
        petId: this.choosenPetId,
        date: Number(moment(this.chooseDate, 'DD/MM/YYYY').format('DDMMYYYY')),
        time: this.chooseTime,
        firstDescription: this.chooseDescription
      }

      await InfotypeServices.saveSchedule(newExam)
       this.$notify({
         group: 'default',
         type: 'success',
         title: 'Save succcess!',
         duration: 3000
       })
     }
  },
  computed: {
    ...mapGetters({
      petsOfUser: 'config/getPetOfUser'
    })
  },
  mounted() {
    this.petsOfUser.forEach(pet => {
      this.myPets.push({
        id: pet.id,
        name: pet.name
      })
    })
  }
}
</script>
<style scoped>
  @import url('../assets/styles/bookingschedule.css');
</style>