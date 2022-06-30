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
  methods: {
    disappearElement(){
      var element = document.querySelector('.navMenu')
      if(element){
        document.querySelector('.navMenu').classList.remove('nm-activate')
      }
    }
  },
  watch: {},
};
</script>

<style lang="scss">
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