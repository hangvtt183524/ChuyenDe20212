<template lang="">
    <div class="container AppHeader">
        <div class="row align-items-center">
            <div class="col-3 py-3">
                <router-link to="/home">
                    <p class="AppLogo">Pet Care</p>
                </router-link>
            </div>

            <div class="col-6">
                <div class="d-flex flex-row justify-content-start">
                    <router-link v-for="tab in tabs" :to="tab.path" :key="tab.id" class="mx-4">
                        <p class="AppHeader_Link Font_20" :class="{active : curPath === tab.path}">
                            {{tab.text}}
                        </p>
                    </router-link>
                </div>
            </div>

            <div class="col-3">
                <div class="d-flex flex-row justify-content-end">
                    <router-link to="/sign-up" class="mx-2">
                        <p class="Font_20 text-capitalize" :class="{active: curPath === '/sign-up'}">
                            Đăng ký
                        </p>
                    </router-link>
                    <router-link to="/login" class="mx-2">
                        <p class="Font_20 text-capitalize" :class="{active: curPath === '/login'}">
                            Đăng nhập
                        </p>
                    </router-link>
                </div>
            </div>
        </div>
        
    </div>
</template>

<script>
export default {
  name: 'TheNavigation',
      data() {
        return {
            tabs: [
                {
                    id: 'home',
                    text: 'Trang chủ',
                    path: '/home',
                },
                {
                    id: 'sktc',
                    text: 'Sức khỏe thú cưng',
                    path: '',
                },
                {
                    id: 'forum',
                    text: 'Forum',
                    path: '',
                }
            ]
        }
    },
    computed: {
        curPath() {
            return this.$route.path;
        }
    }
}
</script>

<style scoped>
@import url('../../assets/styles/layout/navigation.scss');
</style>