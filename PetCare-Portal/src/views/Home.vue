<script>
import AppPoster from './components/AppPoster.vue';
export default {
    name: 'Home',
    components: {
      AppPoster,
    },
    data() {
      return {
      }
    }
}
</script>

<template>
    <div class="container pb-5">
      <div class="row">
        <div class="col-md-6 col-0 mt-5">
          <AppPoster></AppPoster>
        </div>
        <div class="col-md-6 mt-5 d-flex flex-column justify-content-center align-items-center">
          <div>
            <p>Chăm sóc toàn diện</p>
            <p>cho thú cưng của bạn</p>
          </div>
        </div>
      </div>
    </div>
</template>


<style scoped>
  p{
    display: block;
    font-size: 40px;
    line-height: 45px;
    font-weight: 900;
    color: #009fff;
  }
</style>