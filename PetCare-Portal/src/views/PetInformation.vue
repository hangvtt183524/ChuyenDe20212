<template>
    <div class="pet-info-background">
        <div class="pet-card">
            <div class="pet-avatar-holder">
                <div class="pet-avatar">
                    <div class="pet-avatar-cover"></div>
                    <div class="">Milu</div>
                </div>    
                                       
            </div>
            <div class="pet-info-holder">
              <div class="pet-tab">
                <span @click="showGeneralInfo = true; showHistoryExam = false">Thông tin chung</span>
                <span @click="showGeneralInfo = false; showHistoryExam = true">Theo dõi sức khỏe</span>
                <div class="pet-name-underline"></div>
              </div>
              <div v-if="showGeneralInfo">
                <div class="pet-content">
                  <div class="pet-content-left">
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
                    <InputItem
                        label = "Giới tính"
                        :isEditing="true"
                    />
                  </div>
                  <div class="pet-content-right">
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
              <div v-if="showHistoryExam">
                <div class="pet-content">
                  <perfect-scrollbar>
                    <div v-for="exam in historyExamList"
                         :key="exam.id"
                    >
                      <InputItem
                          label = "Doctor"
                          :isEditing="false"
                          :value="exam.doctor"
                      />
                      <InputItem
                          label = "Date"
                          :isEditing="false"
                          :value="exam.date"
                      />
                      <InputItem
                          label = "Time"
                          :isEditing="false"
                          :value="exam.time"
                      />
                      <InputItem
                          label = "Description"
                          :isEditing="true"
                          :value="exam.description"
                      />
                      <InputItem
                          label = "Result"
                          :isEditing="true"
                          :value="exam.result"
                          v-if="exam.status != 0"
                      />
                      <InputItem
                          label = "Status"
                          :isEditing="false"
                          :value="exam.status"
                      />
                      <div class="">
                        <Button
                            text="Cancel"
                            color="white"
                            v-if="exam.status === 0"
                        />
                        <Button
                            text="Download Bill"
                            color="blue"
                        />
                      </div>
                    </div>
                  </perfect-scrollbar>
                </div>
              </div>
            </div>
        </div>
    </div>
</template>
<script>
import InputItem from './components/InputItem.vue'
import Button from './components/Button.vue'
import { PerfectScrollbar } from 'vue2-perfect-scrollbar'
export default {
    components: {
        InputItem, Button,
      PerfectScrollbar
    },
  data() {
      return {
        showGeneralInfo: true,
        showHistoryExam: false,
        historyExamList: [
          {
            doctor: "Mr.John",
            date: "12/04/2022",
            time: "08:12:54",
            description: "",
            result: "",
            status: 1
          },
        ]
      }
  }
}
</script>
<style scoped>
    @import url('../assets/styles/pet-information.css');
</style>