<script>
export default {
    name: 'AppHeader',
    data() {
        return {
        }
    },
}
</script>

<template lang="">
    <div class="container AppHeader">
        <div class="row align-items-center">
            <div class="col-3 py-3">
                <p class="AppLogo">Pet Care</p>
            </div>
            <div class="col-6">
                <div class="d-flex flex-row justify-content-start">
                    <a href="/home"><p class="AppHeader_Link Font_20 mx-4" >Trang chủ</p></a>
                    <a href=""><p class="AppHeader_Link Font_20 mx-4">Sức khỏe thú cưng</p></a>
                    <a href=""><p class="AppHeader_Link Font_20 mx-4">Forum</p></a>
                </div>
            </div>
            <div class="col-3">

            </div>
        </div>
        
    </div>
</template>


<style lang="scss" scoped>
    @import url('./index.scss');
</style>