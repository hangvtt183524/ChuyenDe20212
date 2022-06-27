<template lang="">
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
                        content="Rụng lông"
                    />
                    <DisplayInfo
                        label="Bác sĩ"
                        content="Nguyễn Văn A"
                    />
                    <DisplayInfo
                        label="Thời gian"
                        content="12-06-2022"
                    />
                </div>
                <div class="phd-right">
                    <DisplayInfo
                        label="Ghi chú"
                        content="Cần khám định kỳ"
                    />
                    <DisplayInfo
                        label="Dịch vụ sử dụng"
                        content="Thăm khám, kê thuốc"
                    />
                    <DisplayInfo
                        label="Kết luận"
                        content="Đã chữa khỏi"
                    />
                </div>               
            </div>
            <div class="phd-buttons">
                <Button
                    text="In hóa đơn"
                    color="orange"   
                />
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
        <!-- <div class="chat-window">
            <div class="header chat-window-header">
                Bs. Nguyễn Văn A
                <div class="exit">
                    <i class="fa-solid fa-xmark"></i>
                </div>
            </div>
            <div class="msgs">

            </div>
            <div class="send-msg">
                <input>
                <i class="fa-solid fa-paper-plane"></i>
            </div>
        </div> -->
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
    data(){
        return{
            showChatWindow: false
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
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/pethistorydetail.css');
</style>