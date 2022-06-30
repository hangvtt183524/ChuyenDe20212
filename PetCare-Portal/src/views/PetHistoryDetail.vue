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
                        label="Tên bệnh"
                        :content="examInfo.firstDescription"
                    />
                    <DisplayInfo
                        label="Bác sĩ"
                        :content="examInfo.doctorName"
                    />
                    <DisplayInfo
                        label="Thời gian"
                        :content="examInfo.date"
                    />
                </div>
                <div class="phd-right">
                    <DisplayInfo
                        label="Ghi chú"
                        :content="examInfo.result"
                    />
                    <DisplayInfo
                        label="Dịch vụ sử dụng"
                        content="Tiêm vacxin HPV"
                    />
                </div>               
            </div>
            <div class="phd-buttons">
<!--                <Button-->
<!--                    text="In hóa đơn"-->
<!--                    color="orange"   -->
<!--                />-->
                <Button
                    text="Liên hệ bác sĩ"
                    color="blue"  
                    @click.native="contactDrBtnOnClick" 
                />
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
import Button from './components/Button.vue'
import ChatWindow from './components/ChatWindow.vue'
export default {
    components: {
        DisplayInfo, Button, ChatWindow
    },
  props: {
      examInfo: {
        type: Object,
        default: null
      }
  },
    data(){
        return{
            showChatWindow: false,
        }
    },
    methods: {
        hidePetHistoryDetail(){
            this.$emit('exitDetail')
        },
        contactDrBtnOnClick(){
            this.showChatWindow = true
            console.log(1)
        },
        hideChatWindow(){
            this.showChatWindow = false
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/pethistorydetail.css');
</style>