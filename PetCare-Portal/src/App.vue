<script>
import AppLayout from './general/AppLayout';

export default {
  name: "App",
  components: {
    AppLayout,
  },
};
</script>


<template>
  <div id="app">
    <div class="d-flex flex-column flex-root">
      <div class="page d-flex flex-column flex-fluid">
        <div class="wrapper d-flex flex-row flex-fluid">
          <AppLayout>
            <div class="bg-blue">
              <router-view v-slot="{ Component }">
                <component :is="Component" view-prop="value" />
              </router-view>
            </div>
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

#app{
  display: flex;
  height: 100vh;
  overflow-x:hidden;
  overflow-y:auto;
}

.flex-root {
  flex: 1 1 0;
}

.flex-fluid {
  flex: 1 0 0;
}

.bg-blue {
  background-color: #a1d8ff7a;
}
</style>
