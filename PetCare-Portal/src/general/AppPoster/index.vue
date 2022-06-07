<script>
import dog1 from '../../assets/images/dog1.jpg';
import dog2 from '../../assets/images/dog2.jpg';
import cat1 from '../../assets/images/cat1.jpg';
import cat2 from '../../assets/images/cat2.jpg';

export default {
    name: 'AppPoster',
    data() {
        return {
            dog1: dog1,
            dog2: dog2,
            cat1: cat1,
            cat2: cat2,
        }
    },
}
</script>


<template>
    <div class="AppPoster row">
        <div class="col-6 image large slot1">
            <img :src="dog1" class="p-3" />
        </div>
        <div class="col-6 image small slot2">
            <img :src="cat2" class="p-3" />
        </div>
        <div class="col-6 image small slot3">
            <img :src="dog2" class="p-3" />
        </div>
        <div class="col-6 image large slot4">
            <img :src="cat1" class="p-3" />
        </div>
    </div>
</template>


<style lang="scss" scoped>
.image {
    position: relative;
    height: 220px;
    img {
        position: absolute;
        border-radius: 40px;
    }
    &.large img{
        width: 220px;
        height: 220px;
    }
    &.small img{
        width: 180px;
        height: 180px;
    }
    &.slot1 img{ right:0; bottom:0; }
    &.slot2 img{ left:0; bottom:0; }
    &.slot3 img{ right:0; top:0; }
    &.slot4 img{ left:0; top:0; }
}
</style>