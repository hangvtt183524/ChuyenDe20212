<template>
  <div className="app-wrapper">
    <div className="app">
      <TheNavigation/>
      <router-view/>
      <notifications
          group="default"
          :closeOnClick="true"
          position="bottom right"
          :duration="-1"
          :ignoreDuplicates="true"
      />
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
  methods: {
   
  },
  watch: {},
};
</script>

<style lang="scss">
// @import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");
// * {
//   margin: 0;
//   padding: 0;
//   box-sizing: border-box;
//   font-family: "Quicksand", sans-serif;
// }
// .app {
//   display: flex;
//   flex-direction: column;
//   min-height: 100vh;
// }
// .container {
//   max-width: 1440px;
//   margin: 0 auto;
// }
// .link {
//   cursor: pointer;
//   text-decoration: none;
//   text-transform: uppercase;
//   color: black;
// }
// .link-light {
//   color: #fff;
// }
@import url('./assets/styles/main.css');
.vue-notification {
  padding: 10px;
  margin: 0 5px 5px;

  font-size: 12px;

  color: #ffffff;
  background: #44a4fc;
  border-left: 5px solid #187fe7;

  &.warn {
    background: #ffb648;
    border-left-color: #f48a06;
    position: relative;

    &::before {
      content: '\00D7';
      position: absolute;
      right: 5px;
      top: 0;
    }
  }

  &.error {
    background: #e54d42;
    border-left-color: #b82e24;
    position: relative;
  }

  &.success {
    background: #68cd86;
    border-left-color: #42a85f;
    position: relative;

    &::before {
      content: '\00D7';
      position: absolute;
      right: 5px;
      top: 0;
    }
  }
}
</style>