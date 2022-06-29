<script>
import AppPoster from '../../general/AppPoster';

export default {
  name: 'Auth',
  components:{
    AppPoster,
  },
}
</script>


<template>
  <div class="container pb-5">
    <div class="row">
      <div class="col-lg-6 col-0 mt-5 poster">
        <AppPoster/>
      </div>
      <div class="col-lg-6 col-12 mt-5 d-flex flex-column justify-content-center align-items-center">
        <router-view v-slot="{ Component }">
          <component :is="Component" view-prop="value" />
        </router-view>
      </div>
    </div>
  </div>
</template>


<style lang="scss" scoped>
@media (max-width: 992px) {
  .poster {
    display: none;
  }
}
</style>