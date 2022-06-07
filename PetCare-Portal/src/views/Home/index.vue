<script>
import AppPoster from '../../general/AppPoster';
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
    <div class="home">
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
    </div>
</template>


<style scoped>
  .home{
    background-color: #a1d8ff7a;
  }

  p{
    display: block;
    font-size: 40px;
    line-height: 45px;
    font-weight: 900;
    color: #009fff;
  }
</style>
