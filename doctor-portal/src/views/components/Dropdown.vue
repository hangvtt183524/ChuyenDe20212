<template lang="">
    <div class="dropdown" ref='dropdown'>
        <div class="label">{{this.label}}</div>    
        <div class="dropdown-content">                   
            <div class="select-list scrollable" ref="selectList">
                <div class="select-item" v-for="(item, index) in items" :key="index" @click="selectItemOnclick(index, $event)" :id="item.id">
                    <i class="fa-solid fa-check"></i>
                    <div class="dd-item-text" v-if="!item.text">{{item.text}}</div>
                    <div class="dd-item-text" v-if="item">{{item}}</div>
                </div>
            </div>
            
            <div class="select" @click="ddSelectOnclick" ref="select">
                <div class="select-content">
                    <div class="dd-item-text">{{this.selectedText}}</div>
                </div>
                <i class="fas fa-angle-down"></i>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: "MDropdown",
    props: {
        displaySelectedText: null,
        items: {
            type: Array,
            default: null
        },
        valueInput: null,
        label: null,
    },
    data(){
        return{
            selectedIcon: null,
            selectedText: null,
            originSelectedText: this.selectedText,
        }
    },
    mounted() {
        // this.setSelectedItem()
    },
    methods: {
        setSelectedItem(){
            this.items.forEach((item, index) => {
                var itemList = this.$refs.selectList.querySelectorAll('.select-item')
                console.log(itemList)
                console.log(item)
                if(this.valueInput == item.id){
                    itemList[index].click()
                }
            });
        },
        ddSelectOnclick(){
            this.$refs.selectList.classList.toggle("dd-activate")
            var ddProp = this.$refs.dropdown.getBoundingClientRect()
            console.log(ddProp)
            
            this.$refs.selectList.style.setProperty('width', ddProp.width +'px', 'important');
            this.$refs.selectList.style.setProperty('top', ddProp.bottom +'px', 'important');
            this.$refs.selectList.style.setProperty('left', ddProp.left+'px', 'important');
        },
        selectItemOnclick(index, e){
            if(Array.from(e.currentTarget.classList).includes('selected-item')){
                e.currentTarget.classList.remove('selected-item')
                
                console.log('first')
                this.selectedText = this.originSelectedText
            }
            // console.log(Array.from(e.currentTarget.classList))
            else{
                console.log('second')
                var itemList = this.$refs.selectList.querySelectorAll(".select-item")
                Array.from(itemList).forEach(element => {
                    element.classList.remove('selected-item')
                });
                e.currentTarget.classList.add('selected-item')
                console.log(e.target.innerText)
                this.selectedText = e.target.innerText
            }
            
            // if(this.displaySelectedText){
            //     this.selectedText = e.currentTarget.children.item(1).innerHTML
            // }
            this.$refs.selectList.classList.remove('dd-activate')
            
            // this.$emit('setValue', this.items[index].id)
        }
    }
}
</script>
<style scoped>
    @import url('../../assets/styles/common/dropdown.css');
</style>