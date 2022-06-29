<template>
    <div class="dropdown" ref='dropdown'>
        <div class="label">{{this.label}}</div>

      <div v-if="isEditing">
        <div class="dropdown-content">
            <div class="select-list" ref="selectList">
                <div class="select-item"
                     v-for="(item, index) in items" :key="index"
                     @click="selectItemOnclick(index, $event)"
                     :id="item.id"
                >
                    <i class="fa-solid fa-check"></i>
                    <div class="dd-item-text">{{item.text}}</div>
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
      <div v-else>
        <div v-if="valueInput">
          {{valueInput}}
        </div>
        <div v-else>
          Chưa có
        </div>
      </div>
    </div>
</template>
<script>
// import Vue from 'vue'
export default {
    name: "MDropdown",
    props: {
      displaySelectedText: null,
      items: {
          type: Array,
          default: null
      },
      isEditing: {
        type: Boolean,
        default: false
      },
      value: {
        type: String,
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
      if (this.isEditing)
        this.setSelectedItem()
    },
    methods: {
        setSelectedItem() {
          // Vue.nextTick(() => {
            this.items.forEach((item, index) => {
              var itemList = this.$refs.selectList.querySelectorAll('.select-item')
              console.log(itemList)
              console.log(item)
              // this.value = item
              if (this.valueInput == item) {
                itemList[index].click()
              }
            });
          // })
        },
        ddSelectOnclick(){
            this.$refs.selectList.classList.toggle("dd-activate")
            var ddProp = this.$refs.dropdown.getBoundingClientRect()
            
            this.$refs.selectList.style.setProperty('width', ddProp.width +'px', 'important');
            this.$refs.selectList.style.setProperty('top', ddProp.bottom +'px', 'important');
            this.$refs.selectList.style.setProperty('left', ddProp.left+'px', 'important');
        },
        selectItemOnclick(index, e){
            if(Array.from(e.currentTarget.classList).includes('selected-item')){
                e.currentTarget.classList.remove('selected-item')

                this.selectedText = this.originSelectedText
            }
            // console.log(Array.from(e.currentTarget.classList))
            else{
                var itemList = this.$refs.selectList.querySelectorAll(".select-item")
                Array.from(itemList).forEach(element => {
                    element.classList.remove('selected-item')
                });
                e.currentTarget.classList.add('selected-item')
                this.selectedText = e.target.innerText
            }
            
            // if(this.displaySelectedText){
            //     this.selectedText = e.currentTarget.children.item(1).innerHTML
            // }
            this.$refs.selectList.classList.remove('dd-activate')
            
            this.$emit('setValue', this.selectedText)
        }
      }

}
</script>
<style scoped>
    @import url('../../assets/styles/common/dropdown.css');
</style>