<template>
    <div class="background">
        <p class="text Font_20">Không tìm thấy trang bạn yêu cầu</p>
    </div>
</template>

<script>
    export default {
        name: 'NotFound',
    }
</script>

<style lang="scss" scoped>
.background {
    position: relative;
    background-color: #a1d8ff7a;
    height: 600px;
    .text {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
}
</style>