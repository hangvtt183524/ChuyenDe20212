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
        <div class="col-md-6 col-0 mt-5">
          <AppPoster/>
        </div>
        <div class="col-md-6 mt-5 d-flex flex-column justify-content-center align-items-center">
            <router-view v-slot="{ Component }">
                <component :is="Component" view-prop="value" />
            </router-view>
        </div>
      </div>
    </div>
</template>


<style lang="scss" scoped>

</style>