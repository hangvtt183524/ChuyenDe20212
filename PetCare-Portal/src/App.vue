<script>
import AppLayout from './general/AppLayout';

export default {
  name: "App",
  components: {
    AppLayout,
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


<template>
  <div id="root">
    <div class="d-flex flex-column flex-root">
      <div class="page d-flex flex-column flex-fluid">
        <div class="wrapper d-flex flex-row flex-fluid">
          <AppLayout>
            <router-view />
          </AppLayout>
        </div>
      </div>
    </div>
  </div>
</template>


<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");

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
