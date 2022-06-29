<script>
export default {
  name: 'SignUp',
  data() {
    return {
      username: null,
      email: null,
      password: null,
    }
  },
  methods: {
    api() {
      console.log('auth');
    }
  },
}
</script>


<template>
  <div class="Card d-flex flex-column bg-white align-items-center">
    <p class="title text-capitalize">Đăng ký</p>

    <form @submit.prevent="api" class="d-flex flex-column align-items-center">
      <div class="input-wrap px-3 py-2 mb-3">
        <input v-model="username" placeholder="Username"/>
      </div>
      <div class="input-wrap px-3 py-2 mb-3">
        <input v-model="email" placeholder="Email"/>
      </div>
      <div class="input-wrap px-3 py-2 mb-3">
        <input v-model="password" placeholder="Mật khẩu"/>
      </div>
      <button class="blue-btn py-2 my-2">Đăng Ký</button>
    </form>

    <p class="sub_text">Bạn đã có tài khoản ?</p>
    <router-link to="/login">
      <button class="py-2 my-2">Đăng Nhập</button>
    </router-link>
  </div>
</template>


<style lang="scss" scoped>
.Card {
  width: 90%;
  border-radius: 18px;
  padding: 1.25rem 4rem;
}
.title {
  font-size: 25px;
  font-weight: 900;
  margin-bottom: 18px;
  color: #009fff;
}
form { width: 100%; }
.input-wrap {
  width: 100%;
  border: 1px solid #e4e4e4;
  border-radius: 3px;
}

input {
  border: 0;
  outline: none;
  font-weight: 600;
  font-size: 18px;
}
.blue-btn {
  background: #009fff;
}
.blue-btn:hover {
  background: #3183c8;
}
button, a, a button {
  width: 100%;
  font-size: 18px;
  color: white;
  border: none;
  border-radius: 4px;
  font-weight: 600;
}

.sub_text {
  font-weight: 600;
  font-size: 18px;
  color: #ccc;
}

::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
  color: #ccc;
  opacity: 1;/* Firefox */
  font-weight: 600;
  font-size: 18px;
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
  color: #ccc;
  font-weight: 600;
  font-size: 18px;
}

::-ms-input-placeholder { /* Microsoft Edge */
  color: #ccc;
  font-weight: 600;
  font-size: 18px;
}
</style>