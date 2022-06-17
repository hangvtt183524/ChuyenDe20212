<template>
  <div id="root">
    <div class="d-flex flex-column flex-root">
      <div class="page d-flex flex-column flex-fluid">
        <div class="wrapper d-flex flex-row flex-fluid">
          <div class="App flex-column flex-fluid">
            <TheNavigation />
            <div class="bg-blue">
              <router-view v-slot="{ Component }">
                <component :is="Component" view-prop="value" />
              </router-view>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TheNavigation from "@/views/components/Navigation";

export default {
  name: "app",
  components: {
    TheNavigation,
  },
  data() {
    return {};
  },
  created() {
  },
  mounted() {
  },
  methods: {},
  watch: {},
};
</script>

<style lang="scss">
@import url('./assets/styles/main.css');
</style>