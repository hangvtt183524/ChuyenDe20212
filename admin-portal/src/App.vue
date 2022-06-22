<template>
  <div className="app-wrapper">
    <div className="app">
      <TheNavigation/>
      <router-view/>
    </div>
  </div>
</template>

<script>
import TheNavigation from './views/components/Navigation'
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
/* @import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Quicksand", sans-serif;
  }
  .app {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }
  .container {
    max-width: 1440px;
    margin: 0 auto;
  }
  .link {
    cursor: pointer;
    text-decoration: none;
    text-transform: uppercase;
    color: black;
  }
  .link-light {
    color: #fff;
  } */
@import url('./assets/styles/main.css');
</style>