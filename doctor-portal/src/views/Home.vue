<template lang="">
    <div class="home">
        <div class="img-zone">
            <div class='img-zone-part img img1'>
            </div>
            <div class='img-zone-part'>
              <div class='small-img-1 img img2'></div>
            </div>
            <div class='img-zone-part'>
              <div class='small-img-2 img img3'></div>
            </div>
            <div class='img-zone-part img img4'>
            </div>
        </div>
        <div class='home-slogan'>
          <p>Chăm sóc toàn diện <span>Cho thú cưng của bạn</span></p>
        </div>
    </div>
</template>
<script>
export default {
  name: 'HomeView',
  components: {
  },
  mounted() {
    this.$store.dispatch('config/getAllConfigs')
  }
}
</script>
<style scoped>
@import url('../assets/styles/home.css');
</style>