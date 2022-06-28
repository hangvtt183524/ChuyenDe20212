<template lang="">
    <div class="display-info">
        <div class="label">{{this.label}}</div>
        <div class="info-content">{{this.content}}</div>
    </div>
</template>
<script>
export default {
    name: 'DisplayInfo',
    props: {
        label: null,
        content: null,
    }
}
</script>
<style scoped>
    @import url('../../assets/styles/common/displayinfo.css');
</style>