<template>
  <div class="user-management-page">
    <div class="page-title">
      <p>Quản lý tài khoản</p>
    </div>

    <div class="table-wrapper">
      <table class="user-table">
        <thead class="header-row">
          <tr>
            <th class="col-table">ID</th>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody class="body-row">
          <tr v-for="user in users" :key="user.id">
            <td class="">{{user.id}}</td>
            <td class="">{{user.name}}</td>
            <td>{{user.dob}}</td>
            <td>{{user.address}}</td>
            <td>{{user.email}}</td>
          </tr>
        </tbody>
      </table>
      <Pagination/>



    </div>



  </div>
</template>

<script>

  import Pagination from "./components/Pagination.vue"
  export default {
    name: 'UserManagement',
    compenents: {
      Pagination
    },
    data() {
      return {
        users: [
          {
            id: "001",
            name: "Bùi Việt Anh",
            dob: "24/1/2000",
            address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
            email: 'anh@gmail.com'
          },
          {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},{id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},{id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},
          // {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com'},


        ]
      };
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
