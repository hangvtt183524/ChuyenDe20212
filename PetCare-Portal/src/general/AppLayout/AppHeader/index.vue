<script>
export default {
    name: 'AppHeader',
    data() {
        return {
            activeTab: this.$route.path,
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
}

</script>

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
                        <p class="AppHeader_Link Font_20" :class="{active : activeTab == tab.path}">
                            {{tab.text}}
                        </p>
                    </router-link>
                </div>
            </div>

            <div class="col-3">
                <div class="d-flex flex-row justify-content-end">
                    <router-link to="/home" class="mx-2">
                        <p class="Font_20 text-capitalize">Đăng ký</p>
                    </router-link>
                    <router-link to="/home" class="mx-2">
                        <p class="Font_20 text-capitalize">Đăng nhập</p>
                    </router-link>
                </div>
            </div>
        </div>
        
    </div>
</template>


<style lang="scss" scoped>
    .AppLogo {
    font-size: 3rem;
    font-weight: 700;
    color: #009fff;
    line-height: 3rem;
    }

    .AppHeader_Link:hover, .active {
        border-bottom: 2px solid #009fff;
    }
</style>
