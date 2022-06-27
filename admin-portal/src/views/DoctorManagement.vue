<template>
    <div class="doctor-management-page">
      <div class="page-title">
        <p>Quản lý tài khoản bác sĩ</p>
      </div>

      <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>

  
      <div v-else class="table-wrapper">
        <table class="doctor-table">
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
            <tr v-for="doctor in renderDoctors" :key="doctor.id">
              <td>
                <input type="text" v-model="doctor.name" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <input type="text" v-model="doctor.dob" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <input type="text" v-model="doctor.phone" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <input type="text" v-model="doctor.email" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <input type="text" v-model="doctor.address" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <input type="text" v-model="doctor.major" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              <td>
                <input type="text" v-model="doctor.password" :disabled="!doctor.isEditing" :class="{view: !doctor.isEditing}">
              </td>
              <td>
                <button
                    @click="doctor.isEditing = true; isEditing = true"
                    v-if="!doctor.isEditing && !isEditing">
                  Sửa
                </button>
                <button
                    @click="deleteHandle(doctor)"
                    v-if="!isEditing">
                  Xoá
                </button>
                <button @click="saveHandle(doctor)" v-else-if="doctor.isEditing">Lưu</button>
                <button v-if="doctor.isEditing" @click="cancelHandle(doctor)">Huỷ</button>
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
  
    import Pagination from "./components/Pagination.vue"
    export default {
      name: 'DoctorManagement',
      props: {
        numOfDoctorsPerPage: {
          type: Number,
          default: 2,
        }
      },
      components: {
        pagination: Pagination
      },
      data() {
        const doctors = this.getData().doctors;
        const renderDoctors = doctors.slice(0, Math.min(this.numOfDoctorsPerPage, this.getData().doctors.length))
        renderDoctors.forEach(doctor => {
          doctor.isEditing = false;
        })

        return {
          doctors,
          renderDoctors,
          len: doctors.length,
          totalPage: Math.ceil(doctors.length / this.numOfDoctorsPerPage),
          currentPage: 1,
          firstIndex: 0,
          lastIndex: Math.min(this.numOfDoctorsPerPage - 1, doctors.length - 1),
          isEditing: false,
          cachedDoctors: []
        }
      },
      mounted() {
        this.cachedDoctors = Object.assign({}, this.renderDoctors);
        console.log(this.doctors)
      },
      methods: {
        getData() {
          const doctors = [
            {
              id: "001",
              name: "Bùi Việt Anh",
              dob: "24/1/2000",
              address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
              email: 'anh@gmail.com',
              password: '',
              major: '',
            },
            {
              id: "002",
              name: "Bùi Việt Anh",
              dob: "24/1/2000",
              address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
              email: 'anh@gmail.com',
              password: '',
              major: '',
            },
          ]
          return {
            doctors
          }
        },
  
        onPageChange(page) {
          this.currentPage = page;
          this.firstIndex = (page - 1) * this.numOfDoctorsPerPage;
          if (page === this.totalPage)
            this.lastIndex = this.len - 1
          else this.lastIndex = page * this.numOfDoctorsPerPage - 1;

          const renderDoctors = []
          for (let i = this.firstIndex; i <= this.lastIndex; i++) {
            renderDoctors.push(this.doctors[i])
          }


          renderDoctors.forEach(doctor => {
            doctor.isEditing = false;
          })
          console.log(renderDoctors)
          this.renderDoctors = renderDoctors
        },

        saveHandle(doctor) {
          console.log(this.cachedDoctors)
          this.cachedDoctors = Object.assign({}, this.renderDoctors);
          doctor.isEditing = false;
          this.isEditing = false;
          console.log(this.renderDoctors)
        },

        cancelHandle(doctor) {
          console.log(this.cachedDoctors)
          this.renderDoctors = Object.assign({}, this.cachedDoctors);
          doctor.isEditing = false;
          this.isEditing = false;
          console.log(this.renderDoctors)
        },

        deleteHandle(doctor) {
          console.log(this.doctors.indexOf(doctor))
          console.log(this.doctors)
          this.doctors.splice(this.doctors.indexOf(doctor), 1)
          console.log(this.doctors)
          this.len = this.doctors.length
          this.totalPage = Math.ceil(this.len / this.numOfDoctorsPerPage)
          this.isEditing = false
          this.lastIndex = Math.min(this.lastIndex, this.doctors.length - 1)
        }
      }
    }
  
  </script>
  
  <style lang="scss">
  
  @import "../assets/scss/main.scss";
  
  .doctor-management-page{
    padding: 30px;
    background-color: $colorPrimary100;
  
    .page-title {
      padding-left: 100px;
      font-size: 40px;
      color: $colorPrimary900;
    }

    .noti {
      padding-left: 100px;
    }

    .table-wrapper {
      padding-left: 100px;
      padding-right: 100px;
  
      .doctor-table {
        border: 1px solid #ddd;
        border-collapse: collapse;
        width: 100%;

        .header-row {
          margin: 50px;
          background-color: #63a2d8;
  
          th {
            border: 1px solid #ddd;
            padding-top: 10px;
            padding-bottom: 10px;
          }
        }
  
        .body-row {

          tr:nth-child(even) {
            background-color: $colorPrimary300;
          }
  
          tr:hover {
            background-color: $colorPrimary300;
          }
  
          td {
            border: 1px solid #ddd;
            padding-left: 10px;
            padding-top: 10px;
            padding-bottom: 10px;
          }

          .view {
            border-color: transparent;
            background-color: initial;
            color: initial
          }
        }
  
      }
    }




  }
  
  </style>
  