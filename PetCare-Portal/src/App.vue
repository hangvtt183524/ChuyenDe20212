<template>
  <div id="root">
    <div class="d-flex flex-column flex-root">
      <div class="page d-flex flex-column flex-fluid">
        <div class="wrapper d-flex flex-row flex-fluid">
            <div class="App">
              <TheNavigation/>
              <router-view />
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TheNavigation from '../src/components/Navigation.vue'
export default {
  name: "app",
  components: {
    TheNavigation,
  },
  data() {
    return {};
  },
  created() {},
  mounted() {},
  methods: {},
  watch: {},
};
</script>

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");
@import url('./styles/main.css');
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Quicksand", sans-serif;
}

#root{
  display: flex;
  height: 100vh;
}

.flex-root {
  flex: 1 1 0;
}

.flex-fluid {
  flex: 1 0 0;
}
</style>
