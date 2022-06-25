<template lang="">
    <div class = "button" v-bind:class="[color]">
        {{text}}
    </div>
</template>
<script>
export default {
    name: 'Button',
    props: {
        text: {
            type: String,
            default: ''
        },
        color:{
            type: String,
            default: ''
        }
    },
}
</script>
<style scoped>
    @import url('../../assets/styles/common/button.css');
</style>