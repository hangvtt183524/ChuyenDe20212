<template>
  <div class="management-page">
    <div class="page-title">
      <p>Quản lý tài khoản khách hàng</p>
    </div>

    <p v-if="len == 0" class="noti">Không có dữ liệu hiển thị</p>
    <div v-else>

    <div class="table-wrapper">
      <table class="data-table">
        <thead class="header-row">
          <tr>
            <th>STT</th>
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
          <tr v-for="(user, index) in users" :key="index">
            <td>
              <InputItem
                  :is-editing="false"
                  v-model="user.id"
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
                  v-model="user.birthDate"
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
                  v-model="user.mail"
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
  </div>
</template>

<script>
import editIcon from '@/assets/svg/edit.svg'
import deleteIcon from '@/assets/svg/delete.svg'
import saveIcon from '@/assets/svg/save.svg'
import crossIcon from '@/assets/svg/close.svg'
import InputItem from "@/views/components/InputItem";
import Pagination from "./components/Pagination.vue"
import {mapGetters} from "vuex";
import InfotypeServices from "@/services/InfotypeServices"
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
    async getData() {
      this.users = this.getAllUsers
      this.len = this.users.length
      this.users.forEach(item => {
        item.isEditing = false
      })
      this.usersDataBackup = JSON.parse(JSON.stringify(this.users))
      this.totalPage = Math.ceil(this.users.length / this.numOfUsersPerPage)
      this.lastIndex = Math.min(this.numOfUsersPerPage - 1, this.len - 1)
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
      if (this.users != null) {
        return this.users.slice(first, last + 1);
      } else {
        return []
      }
    },
    editUser(user) {
      if (user.isEditing === false) {
        let userClone = JSON.parse(JSON.stringify(user))
        userClone.isEditing = true
        let userIndex = this.users.indexOf(user)
        this.users.splice(userIndex, 1)
        this.users.splice(userIndex, 0, userClone)
      }
    },
    async deleteUser(user) {
      user.isEditing = false

      let userIndex = this.users.indexOf(user)
      this.users.splice(userIndex, 1)
      this.usersDataBackup.splice(userIndex, 1)
      this.len = this.users.length
      this.lastIndex = Math.min(this.lastIndex, this.len - 1)
      this.totalPage = Math.ceil(this.users.length / this.numOfUsersPerPage)
    },
    async saveUser(user) {
      let userIndex = this.users.indexOf(user)
      await InfotypeServices.saveUser(user)
      let savedUser = JSON.parse(JSON.stringify(user))
      savedUser.isEditing = false
      this.users.splice(userIndex, 1)
      this.users.splice(userIndex, 0, savedUser)

      this.$notify({
        group: 'default',
        type: 'success',
        title: 'Save successfully!'
      })
      this.usersDataBackup = JSON.parse(JSON.stringify(this.users))
    },
    cancelEdit(user) {
      let userIndex = this.users.indexOf(user)
      this.users = JSON.parse(JSON.stringify(this.usersDataBackup))
      this.users[userIndex].isEditing = false
    }
  },
  computed: {
    ...mapGetters({
      getAllUsers: 'config/getAllUsers'
    })
  },
  mounted() {
    this.$store.dispatch('config/getAllUsersByAdmin')
    this.getData()
  },
}
</script>

<style lang="scss">
@import "../assets/scss/main.scss";
.management-page{
  padding: 30px;
  background-color: $colorPrimary100;
  .noti {
    padding-left: 100px;
  }
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