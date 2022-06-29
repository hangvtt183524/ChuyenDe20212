<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý tài khoản khách hàng</p>
    </div>

    <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>

    <div class="table-wrapper">
      <table class="data-table">
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
          <tr v-for="user in userItems" :key="user.id">
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.name"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.username"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.dob"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.phone"
                  :is-only-numeric="true"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.email"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.address"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td>
              <InputItem
                  :is-editing="user.isEditing"
                  v-model="user.password"
                  :is-only-numeric="false"
                  :is-only-alpha="false"
              />
            </td>
            <td class="flex">
<!--              <div class="svg-icon clickable" v-if="user.isEditing === false">-->
<!--                <edit-icon class="is-fill-blue" @click="editUser(user)" />-->
<!--              </div>-->
              <div class="svg-icon clickable" v-if="user.isEditing === true">
                <save-icon class="is-fill-blue" @click="saveUser(user)" />
              </div>
              <div class="svg-icon clickable" v-if="user.isEditing === true">
                <cross-icon class="is-fill-red" @click="cancelEdit(user)" />
              </div>
              <div class="svg-icon clickable" v-else>
                <edit-icon class="is-fill-blue" @click="editUser(user)" />
                <delete-icon class="is-fill-blue" @click="deleteUser(user)" />
              </div>
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
import editIcon from '@/assets/svg/edit.svg'
import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "./components/Pagination.vue"
export default {
  name: 'UserManagement',
  props: {
    numOfUsersPerPage: {
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
      users: null,
      len: 0,
      totalPage: 0,
      currentPage: 1,
      firstIndex: 0,
      lastIndex: 0,
      usersDataBackup: null
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
          phone: '',
          username: '',
          isEditing: false
        },
        {id: "002", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "003", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "004", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "005", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "006", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "007", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "008", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "009", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "010", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "011", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "012", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "013", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "014", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "016", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
        {id: "015", name: "Việt Anh", dob: "24/1/2000", address: "4 Bạch Mai", email: 'anh@gmail.com', isEditing: false, password: '', phone: '', username: '',},
      ]
    },
    onPageChange(page) {
      // console.log(page)
      this.currentPage = page;
      this.firstIndex = (page - 1) * this.numOfUsersPerPage;
      if (page == this.totalPage)
        this.lastIndex = this.len - 1
      else this.lastIndex = page * this.numOfUsersPerPage - 1;
    },
    getRenderUsers() {
      let first = this.firstIndex
      let last = this.lastIndex
      const renderUsers = []
      for (let i = first; i <= last; i++) {
        renderUsers.push(this.users[i])
      }
      return renderUsers;
    },
    editUser(user) {
      if (user.isEditing === false) {
        user.isEditing = !user.isEditing
      }
    },
    deleteUser(user) {
      user.isEditing = false
      /*
      call api delete user
      */
      let userIndex = this.users.indexOf(user)
      this.users.splice(userIndex, 1)
      this.usersDataBackup.splice(userIndex, 1)
      this.len = this.users.length
      this.lastIndex = Math.min(this.lastIndex, this.len - 1)
      this.totalPage = Math.ceil(this.users.length / this.numOfUsersPerPage)
    },
    saveUser(user) {
      console.log(user)
      /*
      call api save user
      */
      user.isEditing = false
      this.usersDataBackup = JSON.parse(JSON.stringify(this.users))
    },
    cancelEdit(user) {
      let userIndex = this.users.indexOf(user)
      this.users = JSON.parse(JSON.stringify(this.usersDataBackup))
      this.users[userIndex].isEditing = false
    }
  },
  computed: {
    userItems() {
      return this.getRenderUsers()
    }
  },
  created() {
    this.users = this.getData()
    this.len = this.users.length
    this.totalPage = Math.ceil(this.users.length / this.numOfUsersPerPage)
    this.lastIndex = Math.min(this.numOfUsersPerPage - 1, this.len - 1)
    this.usersDataBackup = JSON.parse(JSON.stringify(this.users))
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