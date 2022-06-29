<template>
  <div class="bg">
    <div class="login-card">
      <h1>Đăng nhập</h1>
      <div class="form">
        <InputItem
          :is-editing="true"
          placeholder="Email"
          v-model="email"
          :is-only-alpha="false"
          :is-only-numeric="false"
        />
        <InputItem
          :is-editing="true"
          placeholder="Password"
          v-model="password"
          :is-only-alpha="false"
          :is-only-numeric="false"
      />
        <div class="forget">
          <a href="/forget_password">Quên mật khẩu</a>
        </div>
        <div class="button-login">
          <button
              class="button is-normal is-blue"
              @click="handleLogin"
          >
            Đăng nhập
          </button>
        </div>
        <div class="sign-up">
          Bạn chưa có tài khoản? <a href="/register">Đăng ký</a>
        </div>
      </div>
    </div>

  </div>
</template>


<script>
// import Button from "./components/Button"
import InputItem from './components/InputItem'
import InfotypeServices from "@/services/InfotypeServices"
export default {
  name: 'Login',
  data() {
    return {
      email: null,
      password: null,
    }
  },
  components: {
    // Button,
    InputItem
  },
  methods: {
    async handleLogin() {
      if (this.email && this.password) {
        const loginResult = await InfotypeServices.login({mail: this.email, password: this.password})
        if (loginResult === 'Login success!') {
          this.$notify({
            group: 'default',
            type: 'success',
            title: loginResult,
            duration: 3000
          })
          const currentUser = await InfotypeServices.searchUser({mail: this.email})
          this.$store.commit('config/setCurrentUser', currentUser[0])
          const petList = await InfotypeServices.searchPetByUser(currentUser[0])
          this.$store.commit('config/setPetOfUser', petList)
          await this.$router.push({ path: '/' })
        } else {
          this.$notify({
            group: 'default',
            type: 'error',
            title: loginResult,
            duration: 5000
          })
        }
      } else {
        this.$notify({
          group: 'default',
          type: 'error',
          title: 'Hãy điền thông tin email và mật khẩu hợp lệ',
          duration: 5000
        })
      }
    }
  },
}
</script>


<style lang="scss" scoped>
@import "../assets/scss/main";
.bg {
  background-color: #a1d8ff7a;
  height: calc(100vh - 70px);
  position: relative;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  .login-card {
    position: absolute;
    top: 80px;
    bottom: 80px;
    left: 35%;
    right: 35%;
    padding: 20px;
    background-color: #fff;
    box-sizing: border-box;
    align-content: center;
    h1 {
      text-align: center;
      color: $colorPrimary600;
    }
    .form {
      width: 100%;
      height: 225px;
      background-size: cover;
      background-position: center;
      .message {
        color: red;
      }
      .button-login {
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 30px;

      }
      .forget {
        text-align: right;
        padding-right: 5px;
      }
      .forget a {
        text-decoration: none;
        color: #9c9c9c;
        font-size: 0.9rem;
      }

      .sign-up {
        text-align: center;
      }
      .sign-up a {
        text-decoration: none;
        color: $colorPrimary500;
        font-weight: 600;
      }
      .sign-up span {
        font-weight: 600;
        color: $colorPrimary500;
      }
    }
  }
}
</style>