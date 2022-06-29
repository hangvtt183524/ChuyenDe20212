<template>
  <div class="bg">
    <div class="login-card">
      <h1>Đăng nhập</h1>
      <div class="form">
        <InputItem
          :is-editing="true"
          placeholder="Email"
        />
        <InputItem
          :is-editing="true"
          placeholder="Password"
        />
        <div class="forget">
          <a href="/forget_password">Quên mật khẩu</a>
        </div>
        <div class="button-login">
        <Button
          text="Đăng nhập"
          color="blue"
          @click="login()"
        />
        </div>
        <div class="sign-up">
          Bạn chưa có tài khoản? <a href="/register">Đăng ký</a>
        </div>
      </div>
    </div>

  </div>
</template>


<script>
import Button from "./components/Button"
import InputItem from './components/InputItem'
export default {
  name: 'Login',
  data() {
    return {
      email: null,
      password: null,
    }
  },
  components: {
    Button,
    InputItem
  },
  methods: {
    api() {
      /* api login */
    },

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