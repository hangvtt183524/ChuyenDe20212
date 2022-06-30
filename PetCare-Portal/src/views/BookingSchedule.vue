<template lang="">
  <div class="blue-bg">
    <div class="booking-page">
      <div class="header">
        Đăng kí lịch khám
      </div>
      <div class="booking-content">
        <div class="booking-part">
          <Dropdown
            label = "Thú cưng"
            :items="this.myPets"
          />
          <InputItem
              label = "Ngày khám"
              :isEditing="true"
          />
        </div>
        <div class="booking-part">
          <InputItem
              label = "Giờ khám"
              :isEditing="true"
          />
          <InputItem
              label = "Ghi chú"
              :isEditing="true"
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
                        <td>Nguyễn Văn A</td>
                        <td class="align-center">09-12-2022</td>
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
import Dropdown from './components/Dropdown.vue'
import Button from './components/Button.vue'
import PetHistoryDetail from './PetHistoryDetail.vue'
export default {
  components: {
    InputItem, Dropdown, Button, PetHistoryDetail
  },
  data(){
    return{
      myPets:[],
      showPetHistoryDetail: false,
    }
  },
   methods: {
    detailBtnOnClick(){
        this.showPetHistoryDetail = true
    },
    hidePetHistoryDetail(){
        this.showPetHistoryDetail = false
    }
  }
}
</script>
<style scoped>
  @import url('../assets/styles/bookingschedule.css');
</style>