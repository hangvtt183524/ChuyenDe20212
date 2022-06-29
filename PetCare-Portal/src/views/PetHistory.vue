<template>
    <div class="pet-history">
        <div class="pet-history-title">Lịch sử khám bệnh</div> 
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
                    <tr v-for="(exam, index) in petExams" :key="index">
                        <td class="align-center">{{index + 1}}</td>
                        <td>{{exam.firstDescription}}</td>
                        <td>{{exam.doctorName}}</td>
                        <td class="align-center">{{exam.date}}</td>
                        <td>{{exam.result}}</td>
                        <td>
                            <Button
                                text="Chi tiết"
                                color="blue"
                                @click.native="detailBtnOnClick(exam)"
                            />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <PetHistoryDetail
            v-if="showPetHistoryDetail"
            @exitDetail="hidePetHistoryDetail"
            :exam-info="detailExam"
        />
    </div>
</template>
<script>
import Button from './components/Button.vue'
import PetHistoryDetail from './PetHistoryDetail.vue'
import {mapGetters} from "vuex"
import moment from 'moment'
export default {
    components:{
        Button, PetHistoryDetail
    },
    data(){
        return{
            showPetHistoryDetail: false,
          petExams: [],
          detailExam: null
        }
    },
    methods: {
        detailBtnOnClick(exam){
            this.showPetHistoryDetail = true
          this.detailExam = exam
        },
        hidePetHistoryDetail(){
            this.showPetHistoryDetail = false
        }
    },
  computed: {
    ...mapGetters({
      allExams: 'config/getAllExams',
      allDoctors: 'config/getAllDoctors'
    })
  },
  created() {
      this.petExams = this.allExams.filter(exam => Number(exam.ownerId) === Number(this.$store.state.config.currentUser.id)
          && Number(exam.petId) === Number(this.$store.state.config.currentPetIndex))
    this.petExams.forEach(exam => {
      let doctor = this.allDoctors.filter(doctor => Number(doctor.id) === Number(exam.doctorId))[0]
      exam.doctorName = doctor.doctorName
      exam.date = moment(exam.date, 'DDMMYYYY').format('DD-MM-YYYY')
    })
  }
}
</script>
<style lang="">
    
</style>