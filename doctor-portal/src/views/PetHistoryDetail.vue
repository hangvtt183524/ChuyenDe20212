<template>
    <div class="black-bg">
        <div class="pet-history-detail">
            <div class="header phd-header">
                Chi tiết lịch sử khám bệnh
                <div class="exit" @click="hidePetHistoryDetail">
                    <i class="fa-solid fa-xmark"></i>
                </div>
            </div>
            <div class="phd-content">
                <div class="phd-left">
                    <DisplayInfo
                        label="Triệu chứng"
                        :content="petData.exam.firstDescription"
                    />
                    <DisplayInfo
                        label="Chủ nuôi"
                        :content="petData.user.username"
                    />
                    <DisplayInfo
                        label="Ngày"
                        :content="petData.exam.date"
                    />
                  <DisplayInfo
                      label="Thời gian"
                      :content="petData.exam.time"
                  />
                </div>
                <div class="phd-right">
                    <DisplayInfo
                        label="Tên thú cưng"
                        :content="petData.pet.name"
                    />
                    
                    <DisplayInfo
                        label="Loại thú cưng"
                        :content="petData.pet.species"
                    />
                  <Dropdown
                      label="Sử dụng dịch vụ"
                      :items="serviceList"
                      @select-text="chooseService($event)"
                  />
                  <InputItem
                      v-model="petData.exam.result"
                      :is-only-alpha="false"
                      :is-only-numeric="false"
                      :is-editing="true"
                  />
                </div>               
            </div>
            <div class="phd-buttons">
              <button
                  class="button is-normal is-blue"
                  style="margin-right: 15px;"
                  @click="saveExam"
              >Lưu</button>
            </div>
        </div>
        <ChatWindow
            v-if="showChatWindow"
            @hideChatWindow="hideChatWindow"
        />
    </div>
</template>
<script>
import DisplayInfo from './components/DisplayInfo.vue'
import ChatWindow from './components/ChatWindow.vue'
import Dropdown from "@/views/components/Dropdown";
import InputItem from "@/views/components/InputItem";
export default {
  props: {
    petData: {
      type: Object,
      default: null
    }
  },
    components: {
      InputItem,
        DisplayInfo, ChatWindow,
      Dropdown
    },
    data(){
        return{
            showChatWindow: false,
          serviceList: [],
          serviceIdList: [],
          choosenService: ''
        }
    },
    methods: {
        hidePetHistoryDetail(){
            this.$emit('exitDetail')
        },
        contactDrBtnOnClick(){
            this.showChatWindow = true
        },
        hideChatWindow(){
            this.showChatWindow = false
        },
      chooseService(val) {
          this.choosenService = val
      },
      saveExam() {
        this.$notify({
          group: 'default',
          type: 'success',
          title: 'Save success!',
          duration: 3000
        })
      }

    },
  mounted() {
    this.$store.state.config.allServices.forEach(service => {
      this.serviceList.push(service.description)
      this.serviceIdList.push(service.id)
    })
  }
}
</script>
<style scoped>
    @import url('../assets/styles/pethistorydetail.css');
</style>