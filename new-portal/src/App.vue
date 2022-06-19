<template>
  <div className="app-wrapper">
    <div className="app">
      <TheNavigation/>
      <router-view/>
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