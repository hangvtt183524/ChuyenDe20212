<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý tài khoản bác sĩ</p>
    </div>

    <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>

    <div class="table-wrapper">
      <table class="data-table">
        <thead class="header-row">
        <tr>
          <th>Tên</th>
          <th>Ngày sinh</th>
          <th>Điện thoại</th>
          <th>Email</th>
          <th>Địa chỉ</th>
          <th>Chuyên ngành</th>
          <th>Password</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody class="body-row">
        <tr v-for="doctor in doctorItems" :key="doctor.id">
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.name"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.dob"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.phone"
                :is-only-numeric="true"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.email"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.address"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.major"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.password"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td class="flex">
            <div class="svg-icon clickable" v-if="doctor.isEditing === false">
              <edit-icon class="is-fill-blue" @click="editDoctor(doctor)" />
            </div>
            <div class="svg-icon clickable" v-if="doctor.isEditing === true">
              <save-icon class="is-fill-blue" @click="saveDoctor(doctor)" />
            </div>
            <div class="svg-icon clickable" v-if="doctor.isEditing === true">
              <cross-icon class="is-fill-red" @click="cancelEdit(doctor)" />
            </div>
            <div class="svg-icon clickable" v-else>
              <delete-icon class="is-fill-blue" @click="deleteDoctor(doctor)" />
            </div>
          </td>
        </tr>
        </tbody>
      </table>


      <pagination
          :total-pages="totalPage"
          :total="len"
          :per-page="numOfDoctorsPerPage"
          :current-page="currentPage"
          @pagechanged="onPageChange"
      />

    </div>

  </div>
</template>

<script>
import editIcon from '@/assets/svg/edit.svg'
import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "./components/Pagination.vue"
export default {
  name: 'DoctorManagement',
  props: {
    numOfDoctorsPerPage: {
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
    InputItem
  },
  data() {
    return {
      doctors: null,
      len: 0,
      totalPage: 0,
      currentPage: 1,
      firstIndex: 0,
      lastIndex: 0,
      doctorsDataBackup: null
    }
  },
  methods: {
    getData() {
      return [
        {
          id: "001",
          name: "Bùi Việt Anh",
          dob: "24/1/2000",
          address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
          email: 'anh@gmail.com',
          password: '',
          major: '',
          isEditing: false
        },
        {
          id: "002",
          name: "Bùi Việt Anh",
          dob: "24/1/2000",
          address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
          email: 'anh@gmail.com',
          password: '',
          major: '',
          isEditing: false
        }
        ]
    },
    onPageChange(page) {
      // console.log(page)
      this.currentPage = page;
      this.firstIndex = (page - 1) * this.numOfDoctorsPerPage;
      if (page == this.totalPage)
        this.lastIndex = this.len - 1
      else this.lastIndex = page * this.numOfDoctorsPerPage - 1;
    },
    getRenderDoctors() {
      let first = this.firstIndex
      let last = this.lastIndex
      const renderDoctors = []
      for (let i = first; i <= last; i++) {
        renderDoctors.push(this.doctors[i])
      }
      return renderDoctors;
    },
    editDoctor(doctor) {
      if (doctor.isEditing === false) {
        doctor.isEditing = !doctor.isEditing
      }
    },
    deleteDoctor(doctor) {
      doctor.isEditing = false
      /*
      call api delete doctor
      */
      let doctorIndex = this.doctors.indexOf(doctor)
      this.doctors.splice(doctorIndex, 1)
      this.doctorsDataBackup.splice(doctorIndex, 1)
      this.len = this.doctors.length
      this.lastIndex = Math.min(this.lastIndex, this.len - 1)
      this.totalPage = Math.ceil(this.doctors.length / this.numOfDoctorsPerPage)
    },
    saveDoctor(doctor) {
      console.log(doctor)
      /*
      call api save doctor
      */
      doctor.isEditing = false
      this.doctorsDataBackup = JSON.parse(JSON.stringify(this.doctors))
    },
    cancelEdit(doctor) {
      let doctorIndex = this.doctors.indexOf(doctor)
      this.doctors = JSON.parse(JSON.stringify(this.doctorsDataBackup))
      this.doctors[doctorIndex].isEditing = false
    }
  },
  computed: {
    doctorItems() {
      return this.getRenderDoctors()
    }
  },
  created() {
    this.doctors = this.getData()
    this.len = this.doctors.length
    this.totalPage = Math.ceil(this.doctors.length / this.numOfDoctorsPerPage)
    this.lastIndex = Math.min(this.numOfDoctorsPerPage - 1, this.len - 1)
    this.doctorsDataBackup = JSON.parse(JSON.stringify(this.doctors))
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