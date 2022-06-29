<template>
    <div class="booking-list-bg blue-bg">
        <div class="booking-list">
            <div class="header booking-list-header">
                Quản lý danh sách lịch khám
                <div class="dropdowns">
                    <div class="dropdown-holder">
                        <Dropdown
                            label="Tìm kiếm theo tháng"
                            :items="this.months"
                        />
                    </div>
                    <div class="dropdown-holder">
                        <Dropdown
                            label="Tìm kiếm theo ngày"
                            :items="this.dates"
                        />
                    </div>
                </div>
            </div>
            <div class="booking-table scrollable">
                <table class="table" ref="table">
                    <thead>
                        <tr>
                            <th class="align-center">STT</th>
                            <th>Triệu chứng</th>
                            <th>Chủ nuôi</th>
                            <th>Tên thú cưng</th>
                            <th>Loại thú cưng</th>
                            <th class="align-center">Thời gian</th>
                            <th>Kết luận</th>
                            <th>Chức năng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(exam, index) in examinations" :key="index">
                            <td class="align-center">{{ index + 1}}</td>
                            <td>{{exam.exam.firstDescription}}</td>
                            <td>{{exam.user.username}}</td>
                            <td>{{exam.pet.name}}</td>
                            <td>{{exam.pet.species}}</td>
                            <td class="align-center">{{exam.exam.date}}</td>
                            <td>{{exam.exam.result}}</td>
                            <td>
                                <button
                                    class="button is-normal is-blue"
                                    @click="detailBtnOnClick(exam)"
                                >Chi tiết</button>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
            <div class="paging">
                <button
                    class="button is-normal"
                    style="background-color: #ffc021; margin-right: 15px;"
                >Trước</button>
                <button
                    class="button is-normal"
                    style="background-color: #ffc021"
                >Sau</button>
            </div>
        </div>
        <PetHistoryDetail
            v-if="showDetail"
            @exitDetail="exitDetail"
            :pet-data="historyPet"
        />
    </div>
</template>
<script>
import Dropdown from './components/Dropdown.vue' 
import PetHistoryDetail from './PetHistoryDetail.vue'
import {mapGetters} from "vuex"
import moment from 'moment'
export default {
    components:{
        Dropdown, PetHistoryDetail
    },
    data(){
        return{
            months: Array.from(Array(13).keys()).splice(1, 12),
            dates: Array.from(Array(32).keys()).splice(1, 31),
            showDetail: false,
          examinations: [],
          historyPet: null
        }
    },
    created(){
    },
    methods: {
        detailBtnOnClick(exam){
            this.showDetail = true
          this.historyPet = exam
        },
        exitDetail(){
            this.showDetail = false
        }
    },
  computed: {
    ...mapGetters({
      allUsers: 'config/getAllUsers',
      allExams: 'config/getAllExams',
      allServices: 'config/getAllServices',
      allPets: 'config/getAllPets'
    }),
  },
  mounted() {
      let examsOfDoctor = this.allExams.filter(exam => Number(exam.doctorId) === Number(this.$store.state.config.currentDoctor.id))
      examsOfDoctor.forEach(exam => {
      exam.date = moment(exam.date, 'DDMMYYYY').format('DD-MM-YYYY')
      this.examinations.push({
        exam: exam,
        user: this.allUsers.filter(user => Number(user.id) === Number(exam.ownerId))[0],
        pet: this.allPets.filter(pet => Number(pet.id) === Number(exam.petId) && Number(pet.ownerId) === Number(exam.ownerId))[0]
      })
    })
    this.examinations = this.examinations.filter(exam => exam.pet)
  }
}
</script>
<style scoped>
    @import url('../assets/styles/bookinglist.css');
</style>