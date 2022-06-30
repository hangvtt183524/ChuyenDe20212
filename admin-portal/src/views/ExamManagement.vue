<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý lịch khám bệnh</p>
    </div>

    <div class="filter-card">
      <Dropdown
          :is-editing="true"
          label="Lọc theo bác sĩ"
          :items="filterChoice"
          valueInput="Tất cả"
          @setValue="setDoctor"
      />
    </div>

    <p v-if="renderExamLen === 0" class="noti">Không có dữ liệu hiển thị</p>

    <div v-else>
      <div class="table-wrapper">
        <table class="data-table">
          <thead class="header-row">
          <tr>
<<<<<<< HEAD
            <th style="width: 13em">Tên chủ</th>
            <th style="width: 7em">Tên thú cưng</th>
            <th style="width: 15em">Bác sĩ</th>
            <th style="width: 15em">Ngày khám</th>
            <th style="width: 10em">Ghi chú</th>
            <th style="width: 10em">Kết quả</th>
            <th style="width: 25em">Tình trạng</th>
            <th style="width: 5em">Actions</th>
=======
            <th>Owner</th>
            <th>Pet</th>
            <th>Bác sĩ</th>
            <th>Ngày khám</th>
            <th>Kết quả</th>
            <th>Tình trạng</th>
            <th>Actions</th>
>>>>>>> main
          </tr>
          </thead>
          <tbody class="body-row">
          <tr v-for="exam in examItems" :key="exam.id">
            <td>
              <InputItem
                  :is-editing="false"
                  v-model="exam.owner.username"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="false"
                  v-model="exam.pet.name"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <div>
                <Dropdown
                    :is-editing="exam.isEditing"
                    :items="doctors"
                    :valueInput="exam.doctor"
                    @setValue="setDoctor"
                />
              </div>
            </td>
            <td>
              <InputItem
                  :is-editing="false"
                  v-model="exam.date"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="false"
                  v-model="exam.result"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <Dropdown
                  :is-editing="exam.isEditing"
                  :items="examStatusText"
                  :valueInput="examStatus[exam.status]"
                  @setValue="setStatus"
              />
<<<<<<< HEAD
              <!--            <div class="flex">-->
              <!--              <div class="svg-icon" v-if="exam.isEditing === false">-->
              <!--                <div v-if="exam.status">-->
              <!--                  <done-icon class="is-fill-green"/>-->
              <!--                </div>-->
              <!--                <div v-else>-->
              <!--                  <done-icon class="is-fill-gray"/>-->
              <!--                </div>-->
              <!--              </div>-->
              <!--              <div v-else class="svg-icon clickable">-->
              <!--                <div v-if="exam.status">-->
              <!--                  <done-icon class="is-fill-green" @click="exam.status=!exam.status"/>-->
              <!--                </div>-->
              <!--                <div v-else>-->
              <!--                  <done-icon class="is-fill-gray" @click="exam.status=!exam.status"/>-->
              <!--                </div>-->
              <!--              </div>-->
              <!--            </div>-->
=======
>>>>>>> main
            </td>
            <td class="flex">
              <div class="svg-icon clickable" v-if="exam.isEditing === false">
                <edit-icon class="is-fill-blue" @click="editExam(exam)" />
                <delete-icon class="is-fill-blue" @click="deleteExam(exam)" />
              </div>
              <div class="svg-icon clickable" v-if="exam.isEditing === true">
                <save-icon class="is-fill-blue" @click="saveExam(exam)" />
              </div>
              <div class="svg-icon clickable" v-if="exam.isEditing === true">
                <cross-icon class="is-fill-red" @click="cancelEdit(exam)" />
              </div>
            </td>
          </tr>
          </tbody>
        </table>


        <pagination
            :total-pages="totalPage"
            :total="len"
            :per-page="numOfExamsPerPage"
            :current-page="currentPage"
            @pagechanged="onPageChange"
        />

      </div>
    </div>
<<<<<<< HEAD
=======
    </div>
<<<<<<< HEAD
>>>>>>> 2ab1fc80de5dc0b7e05be98759d5b808d3f85988
  </div>

=======
>>>>>>> main
</template>

<script>
import editIcon from '@/assets/svg/edit.svg'
import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import moment from 'moment'
// import doneIcon from '@/assets/svg/success.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "@/views/components/Pagination.vue"
import Dropdown from "@/views/components/Dropdown";
import InfotypeServices from "@/services/InfotypeServices"
import DriverServices from "@/services/DriverServices"
// import Button from "@/views/components/Button";
export default {
  name: 'ExamManagement',
  props: {
    numOfExamsPerPage: {
      type: Number,
      default: 8,
    }
  },
  components: {
    pagination: Pagination,
    editIcon,
    deleteIcon,
    saveIcon,
    crossIcon,
    // doneIcon,
    InputItem,
    Dropdown,
    // Button
  },
  data() {
    return {
      exams: null,
      doctors: null,
      len: 0,
      totalPage: 0,
      currentPage: 1,
      firstIndex: 0,
      lastIndex: 0,
      examsDataBackup: null,
      selectedDoctor: null,
      selectedStatus: null,
      isEditing: false,
      filterChoice: null,
      renderExamLen: 0,
      examStatus: {
        0: 'Chưa gửi mail xác nhận',
        1: 'Đã gửi mail xác nhận',
        2: 'Bị huỷ',
        3: 'Đã hoàn thành'
      },
      examStatusText: [
        {text: 'Chưa gửi mail xác nhận'},
        {text: 'Đã gửi mail xác nhận'},
        {text: 'Bị huỷ'},
        {text: 'Đã hoàn thành'}
      ]
    }
  },
  methods: {
    getData() {
      let allExams = this.$store.state.config.allExams
      allExams.forEach(exam => {
        let owner = this.$store.state.config.allUsers.filter(user => Number(user.id) === Number(exam.ownerId))[0]
        let pet = this.$store.state.config.allPets.filter(pet => Number(pet.id) === Number(exam.petId) && Number(pet.ownerId) === Number(exam.ownerId))[0]
        exam.isEditing = false
        exam.date = moment(exam.date, 'DDMMYYYY').format('DD-MM-YYYY')
        exam.owner = owner
        exam.pet = pet
      })
      allExams = allExams.filter(exam => exam.owner && exam.pet)
      return allExams
    },
    getDoctor() {
      let doctorDropDown = []
      this.$store.state.config.allDoctors.forEach(doctor => {
        doctorDropDown.push(doctor.doctorName)
      })
      return doctorDropDown
    },
    setDoctor(doctor) {
      if (doctor === 'Tất cả') {
        this.selectedDoctor = null;
      }
      else this.selectedDoctor = doctor;
    },
    setStatus(status) {
      this.selectedStatus = Object.keys(this.examStatus).find(key => this.examStatus[key] === status);
    },
    onPageChange(page) {
      this.currentPage = page;
      this.firstIndex = (page - 1) * this.numOfExamsPerPage;
      if (page === this.totalPage)
        this.lastIndex = this.len - 1
      else this.lastIndex = page * this.numOfExamsPerPage - 1;
    },
    getRenderExams() {
      const renderExams = []
      if (this.selectedDoctor && !this.isEditing) {
        this.exams.forEach(exam => {
          if (exam.doctor == this.selectedDoctor)
            renderExams.push(exam);
        })
        console.log("day"+renderExams)
      }
      else {
        let first = this.firstIndex
        let last = this.lastIndex
        for (let i = first; i <= last; i++) {
          renderExams.push(this.exams[i])
        }
      }
      this.renderExamLen = renderExams.length;
      return renderExams;
    },
    editExam(exam) {
      if (exam.isEditing === false) {
        exam.isEditing = !exam.isEditing
        this.selectedDoctor = exam.doctor;
        this.selectedStatus = exam.status;
        this.isEditing = true;
      }
    },
    deleteExam(exam) {
      exam.isEditing = false
      /*
      call api delete exam
      */
      let examIndex = this.exams.indexOf(exam)
      this.exams.splice(examIndex, 1)
      this.examsDataBackup.splice(examIndex, 1)
      this.len = this.exams.length
      this.lastIndex = Math.min(this.lastIndex, this.len - 1)
      this.totalPage = Math.ceil(this.exams.length / this.numOfExamsPerPage)
    },
<<<<<<< HEAD
    saveExam(exam) {
=======
    async saveExam(exam) {
      let examIndex = this.exams.indexOf(exam)
>>>>>>> main
      exam.doctor = this.selectedDoctor;
      exam.status = this.selectedStatus;
      this.selectedDoctor = null;
      this.selectedStatus = null;
      /*
      call api save exam
      */
      let saveExam = {
        id: exam.id,
        ownerId: exam.ownerId,
        petId: exam.petId,
        doctorId: 1,
        date: Number(moment(exam.date, 'DD-MM-YYYY').format('DDMMYYYY')),
        time: exam.time,
        firstDescription: exam.firstDescription,
        result: exam.result
      }
      await InfotypeServices.saveSchedule(saveExam)
      this.$notify({
        group: 'default',
        type: 'success',
        title: "Save success!",
        duration: 3000
      })
      let savedExam = JSON.parse(JSON.stringify(exam))
      savedExam.isEditing = false
      this.exams.splice(examIndex, 1)
      this.exams.splice(examIndex, 0, savedExam)
      this.isEditing = false
      this.examsDataBackup = JSON.parse(JSON.stringify(this.exams))
      await DriverServices.sendConfirmMail({
        mail: exam.owner.mail,
        date: exam.date,
        time: exam.time
      })
    },
    cancelEdit(exam) {
      let examIndex = this.exams.indexOf(exam)
      this.exams = JSON.parse(JSON.stringify(this.examsDataBackup))
      this.exams[examIndex].isEditing = false
    }
  },
  computed: {
    examItems() {
      return this.getRenderExams()
    }
  },
  created() {
    this.exams = this.getData()
    this.doctors = this.getDoctor()
    const choices = this.getDoctor();
    choices.push({text: 'Tất cả'});
    this.filterChoice = choices;
    this.len = this.exams.length
    this.totalPage = Math.ceil(this.exams.length / this.numOfExamsPerPage)
    this.lastIndex = Math.min(this.numOfExamsPerPage - 1, this.len - 1)
    this.examsDataBackup = JSON.parse(JSON.stringify(this.exams))
    this.renderExamLen = this.exams.len;
  }
}
</script>

<style lang="scss">
@import "../assets/scss/main.scss";
.management-page{
  padding: 2%;
  background-color: $colorPrimary100;
  .noti {
    padding-left: 100px;
  }
  .page-title {
    padding-left: 5%;
    font-size: 40px;
    color: $colorPrimary900;
  }
  .table-wrapper {
    padding-left: 5%;
    padding-right: 5%;
    table.fixed
    {
      table-layout:fixed;
      width:90px;
    }
    .data-table {
      border: 1px solid #ddd;
      border-collapse: collapse;
      width: 100%;
      .header-row {
        margin: 50px;
        background-color: $colorPrimary900;
        position: sticky;
        z-index: 2;
        top: 0;
        th {
          color: white;
          border: 1px solid #ddd;
          padding-top: 20px;
          padding-bottom: 20px;
        }
      }
      .body-row {
        tr:nth-child(even) {
          background-color: $colorPrimary300;
        }
        tr:hover {
          background-color: $colorPrimary400;
        }
        td {
          padding-left: 10px;
          padding-top: 10px;
          padding-bottom: 10px;
        }
      }
    }

  }
  .filter-card {
    padding-left: 5%;
    padding-right: 80%;
    z-index: 3;
  }
}
</style>