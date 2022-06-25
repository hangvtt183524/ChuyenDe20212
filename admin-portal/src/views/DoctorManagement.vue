<template>
    <div class="user-management-page">
      <div class="page-title">
        <p>Quản lý tài khoản</p>
      </div>
  
      <div class="table-wrapper">
        <table class="user-table">
          <thead class="header-row">
            <tr>
              <th>Tên</th>
              <th>Ngày sinh</th>
              <th>Điện thoại</th>
              <th>Email</th>
              <th>Địa chỉ</th>
              <th>Chuyên ngành</th>
              <th>Password</th>
            </tr>
          </thead>
          <tbody class="body-row">
            <tr v-for="doctor in getRenderUsers(firstIndex, lastIndex)" :key="doctor.id">
              <td>{{doctor.name}}</td>
              <td>{{doctor.dob}}</td>
              <td>{{doctor.phone}}</td>
              <td>{{doctor.email}}</td>
              <td>{{doctor.address}}</td>
              <td>{{doctor.major}}</td>
              <td>{{doctor.password}}</td>
            </tr>
          </tbody>
        </table>
  
  
        <pagination
            :total-pages="totalPage"
            :total="len"
            :per-page="numOfUsersPerPage"
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
        numOfUsersPerPage: {
          type: Number,
          default: 1,
        }
      },
      components: {
        pagination: Pagination
      },
      data() {
        return {
          users: this.getData().users,
          // renderUsers: this.fetchData().users.slice(0, this.numOfUsersPerPage),
          len: this.getData().users.length,
          totalPage: Math.ceil(this.getData().users.length / this.numOfUsersPerPage),
          currentPage: 1,
          firstIndex: 0,
          lastIndex: this.numOfUsersPerPage - 1
        }
      },
      methods: {
        getData() {
          return {
            users: [
              {
                id: "001",
                name: "Bùi Việt Anh",
                dob: "24/1/2000",
                address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
                email: 'anh@gmail.com',
                password: '',
                major: '',
              },
            ]
          }
        },
  
        onPageChange(page) {
          this.currentPage = page;
          this.firstIndex = (page - 1) * this.numOfUsersPerPage;
          if (page == this.totalPage)
            this.lastIndex = this.len - 1
          else this.lastIndex = page * this.numOfUsersPerPage - 1;
        },
  
        getRenderUsers(first, last) {
          const renderUsers = []
          for (let i = first; i <= last; i++) {
            renderUsers.push(this.users[i])
          }

          return renderUsers;
        }
      }
    }
  
  </script>
  
  <style lang="scss">
  
  @import "../assets/scss/main.scss";
  
  .user-management-page{
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
  
      .user-table {
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
        }
  
      }
    }
  
  
  
  }
  
  </style>
  