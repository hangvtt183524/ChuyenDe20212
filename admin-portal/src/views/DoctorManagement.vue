<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý tài khoản bác sĩ</p>
    </div>

    <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>
    <div v-else>

    <div class="table-wrapper">
      <table class="data-table">
        <thead class="header-row">
        <tr>
          <th style="width: 13em">Tên</th>
          <th style="width: 13em">Ngày sinh</th>
          <th style="width: 13em">Điện thoại</th>
          <th style="width: 20em">Email</th>
          <th style="width: 10em">Địa chỉ</th>
          <th style="width: 15em">Chuyên ngành</th>
          <th style="width: 11em">Password</th>
          <th style="width: 5em">Actions</th>
        </tr>
        </thead>
        <tbody class="body-row">
        <tr v-for="(doctor, index) in doctors" :key="index">
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.doctorName"
                :is-only-numeric="false"
                :is-only-alpha="false"
            />
          </td>
          <td>
            <InputItem
                :is-editing="doctor.isEditing"
                v-model="doctor.birthDate"
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
                v-model="doctor.mail"
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
  </div>
</template>

<script>
import editIcon from '@/assets/svg/edit.svg'
import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "./components/Pagination.vue"
import InfotypeServices from "@/services/InfotypeServices";
import {mapGetters} from "vuex";
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
      this.doctors = this.getAllDoctors
      this.len = this.doctors.length
      this.doctors.forEach(item => {
        item.isEditing = false
      })
      this.doctorsDataBackup = JSON.parse(JSON.stringify(this.doctors))
      this.totalPage = Math.ceil(this.doctors.length / this.numOfDoctorsPerPage)
      this.lastIndex = Math.min(this.numOfDoctorsPerPage - 1, this.len - 1)
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
      if (this.doctors != null) {
        return this.doctors.slice(first, last + 1);
      } else {
        return []
      }
    },
    editDoctor(doctor) {
      if (doctor.isEditing === false) {
        let doctorClone = JSON.parse(JSON.stringify(doctor))
        doctorClone.isEditing = true
        let doctorIndex = this.doctors.indexOf(doctor)
        this.doctors.splice(doctorIndex, 1)
        this.doctors.splice(doctorIndex, 0, doctorClone)
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
    async saveDoctor(doctor) {
      let doctorIndex = this.doctors.indexOf(doctor)
      await InfotypeServices.saveDoctor(doctor)
      let savedDoctor = JSON.parse(JSON.stringify(doctor))
      savedDoctor.isEditing = false
      this.doctors.splice(doctorIndex, 1)
      this.doctors.splice(doctorIndex, 0, savedDoctor)

      this.$notify({
        group: 'default',
        type: 'success',
        title: 'Save successfully!'
      })

      this.doctorsDataBackup = JSON.parse(JSON.stringify(this.doctors))
    },
    cancelEdit(doctor) {
      let doctorIndex = this.doctors.indexOf(doctor)
      this.doctors = JSON.parse(JSON.stringify(this.doctorsDataBackup))
      this.doctors[doctorIndex].isEditing = false
    }
  },
  computed: {
    ...mapGetters({
      getAllDoctors: 'config/getAllDoctors'
    })
  },
  mounted() {
    this.getData()
  },
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