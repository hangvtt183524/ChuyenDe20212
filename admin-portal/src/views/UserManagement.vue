<template>
  <div class="user-management-page">
    <div class="page-title">
      <p>Quản lý tài khoản người dùng</p>
    </div>

    <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>

    <div v-else class="table-wrapper">
      <table class="user-table">
        <thead class="header-row">
          <tr>
            <th>Tên</th>
            <th>Username</th>
            <th>Ngày sinh</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Password</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody class="body-row">
        <tr v-for="user in renderUsers" :key="user.id">
          <td>
            <input type="text" v-model="user.name" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <input type="text" v-model="user.username" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <input type="text" v-model="user.dob" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <input type="text" v-model="user.phone" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <input type="text" v-model="user.email" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <input type="text" v-model="user.address" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          <td>
            <input type="text" v-model="user.password" :disabled="!user.isEditing" :class="{view: !user.isEditing}">
          </td>
          <td>
            <button
                @click="editHandle(user)"
                v-if="!user.isEditing && !isEditing">
              Sửa
            </button>
            <button
                @click="deleteHandle(user)"
                v-if="!isEditing">
              Xoá
            </button>
            <button @click="saveHandle(user)" v-else-if="user.isEditing">Lưu</button>
            <button v-if="user.isEditing" @click="cancelHandle(user)">Huỷ</button>
          </td>


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
    name: 'UserManagement',
    props: {
      numOfUsersPerPage: {
        type: Number,
        default: 3,
      }
    },
    components: {
      pagination: Pagination
    },
    mounted() {
      this.cachedUsers = Object.assign({}, this.renderUsers);
    },
    data() {
      const users = this.getData().users;
      const renderUsers = users.slice(0, Math.min(this.numOfUsersPerPage, this.getData().users.length))
      renderUsers.forEach(user => {
        user.isEditing = false;
      })

      console.log(renderUsers)

      return {
        users,
        renderUsers,
        len: users.length,
        totalPage: Math.ceil(users.length / this.numOfUsersPerPage),
        currentPage: 1,
        firstIndex: 0,
        lastIndex: Math.min(this.numOfUsersPerPage - 1, users.length - 1),
        isEditing: false,
        cachedUsers: []
      }
    },
    methods: {
      getData() {
        return {
          users: [
            {
              id: "001",
              username: "bva001",
              name: "Bùi Việt Anh",
              dob: "24/1/2000",
              address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
              email: 'anh@gmail.com',
              password: "",
              phone: "0933244323"
            },
            {
              id: "002",
              username: "bva002",
              name: "Bùi Việt Anh",
              dob: "24/1/2000",
              address: "4 Bạch Mai, Hai Bà Trưng, TP Hà Nội",
              email: 'anh@gmail.com',
              password: "",
              phone: "0933244323"
            },
          ]
        }
      },

      onPageChange(page) {
        this.currentPage = page;
        this.firstIndex = (page - 1) * this.numOfUsersPerPage;
        if (page === this.totalPage)
          this.lastIndex = this.len - 1
        else this.lastIndex = page * this.numOfUsersPerPage - 1;

        const renderUsers = []
        for (let i = this.firstIndex; i <= this.lastIndex; i++) {
          renderUsers.push(this.users[i])
        }

        renderUsers.forEach(user => {
          user.isEditing = false;
        })
        this.renderUsers = renderUsers
      },

      editHandle(user) {
        user.isEditing = true;
        this.isEditing = true;
      },

      saveHandle(user) {
        console.log(this.cachedUsers)
        this.cachedUsers = Object.assign({}, this.renderUsers);
        user.isEditing = false;
        this.isEditing = false;
        console.log(this.renderUsers)
      },

      cancelHandle(user) {
        user.isEditing = false;
      },

      deleteHandle(user) {
        this.isEditing = false
        user.isEditing = false;
      },


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

  .noti {
    padding-left: 100px;
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
