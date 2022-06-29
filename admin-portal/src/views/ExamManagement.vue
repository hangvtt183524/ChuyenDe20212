<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý lịch khám bệnh</p>
    </div>

    <p v-if="len === 0" class="noti">Không có dữ liệu hiển thị</p>

    <div class="table-wrapper">
      <table class="data-table">
        <thead class="header-row">
        <tr>
          <th>Tên chủ</th>
          <th>Tên thú cưng</th>
          <th>Bác sĩ</th>
          <th>Ngày khám</th>
          <th>Ghi chú</th>
          <th>Kết quả</th>
          <th>Tình trạng</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody class="body-row">
        <tr v-for="exam in examItems" :key="exam.id">
          <td>
            <InputItem
                :is-editing="exam.isEditing"
                v-model="exam.owner"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="exam.isEditing"
                v-model="exam.pet"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <div>
                <Dropdown
                  :is-editting="exam.isEditing"
                  :items="doctors"
                  :value="exam.doctor"
                />
            </div>
          </td>
          <td>
            <InputItem
                :is-editing="exam.isEditing"
                v-model="exam.date"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="exam.isEditing"
                v-model="exam.description"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="exam.isEditing"
                v-model="exam.result"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <div class="flex">
              <div class="svg-icon" v-if="exam.isEditing === false">
                <div v-if="exam.status">
                  <done-icon class="is-fill-green"/>
                </div>
                <div v-else>
                  <done-icon class="is-fill-gray"/>
                </div>
              </div>
              <div v-else class="svg-icon clickable">
                <div v-if="exam.status">
                  <done-icon class="is-fill-green" @click="exam.status=!exam.status"/>
                </div>
                <div v-else>
                  <done-icon class="is-fill-gray" @click="exam.status=!exam.status"/>
                </div>
              </div>
            </div>
          </td>
          <td class="flex">
            <div class="svg-icon clickable" v-if="exam.isEditing === false">
              <edit-icon class="is-fill-blue" @click="editExam(exam)" />
<!--              <delete-icon class="is-fill-blue" @click="deleteUser(exam)" />-->
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
</template>

<script>
import editIcon from '@/assets/svg/edit.svg'
// import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import doneIcon from '@/assets/svg/success.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "@/views/components/Pagination.vue"
import Dropdown from "@/views/components/Dropdown";
export default {
  name: 'ExamManagement',
  props: {
    numOfExamsPerPage: {
      type: Number,
      default: 15,
    }
  },
  components: {
    pagination: Pagination,
    editIcon,
    // deleteIcon,
    saveIcon,
    crossIcon,
    doneIcon,
    InputItem,
    Dropdown
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
    }
  },
  methods: {
    getData() {
      return [
        {
          id: "001",
          owner: "Bùi Việt Anh",
          pet: "Corgi",
          doctor: "Hằng",
          date: '2/4/2022',
          description: '',
          result: '',
          status: true,
          isEditing: false,
        },
        {
          id: "002",
          owner: "Việt Anh",
          pet: "Shiba",
          doctor: '',
          date: '2/4/2022',
          description: '',
          result: '',
          status: false,
          isEditing: false,
        }
      ]
    },
    getDoctor() {
      return [
        {text: 'Hằng'},
        {text: 'Thu'}
      ]
    },
    onPageChange(page) {
      // console.log(page)
      this.currentPage = page;
      this.firstIndex = (page - 1) * this.numOfExamsPerPage;
      if (page === this.totalPage)
        this.lastIndex = this.len - 1
      else this.lastIndex = page * this.numOfExamsPerPage - 1;
    },
    getRenderExams() {
      let first = this.firstIndex
      let last = this.lastIndex
      const renderExams = []
      for (let i = first; i <= last; i++) {
        renderExams.push(this.exams[i])
      }
      return renderExams;
    },
    editExam(exam) {
      if (exam.isEditing === false) {
        exam.isEditing = !exam.isEditing
      }
    },
    // deleteExam(exam) {
    //   exam.isEditing = false
    //   /*
    //   call api delete exam
    //   */
    //   let examIndex = this.exams.indexOf(exam)
    //   this.exams.splice(examIndex, 1)
    //   this.examsDataBackup.splice(examIndex, 1)
    //   this.len = this.exams.length
    //   this.lastIndex = Math.min(this.lastIndex, this.len - 1)
    //   this.totalPage = Math.ceil(this.exams.length / this.numOfExamsPerPage)
    // },
    saveExam(exam) {
      console.log(exam)
      /*
      call api save exam
      */
      exam.isEditing = false
      this.examsDataBackup = JSON.parse(JSON.stringify(this.exams))
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
    console.log(this.exams)
    this.len = this.exams.length
    this.totalPage = Math.ceil(this.exams.length / this.numOfExamsPerPage)
    this.lastIndex = Math.min(this.numOfExamsPerPage - 1, this.len - 1)
    this.examsDataBackup = JSON.parse(JSON.stringify(this.exams))
  }
}
</script>

<style lang="scss">
@import "../assets/scss/main.scss";
.management-page{
  padding: 30px;
  background-color: $colorPrimary100;
  .page-title {
    padding-left: 100px;
    font-size: 40px;
    color: $colorPrimary900;
  }
  .table-wrapper {
    padding-left: 100px;
    padding-right: 100px;
    .data-table {
      border: 1px solid #ddd;
      border-collapse: collapse;
      width: 100%;
      .header-row {
        margin: 50px;
        background-color: $colorPrimary900;
        position: sticky;
        z-index: 100;
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
}
</style>