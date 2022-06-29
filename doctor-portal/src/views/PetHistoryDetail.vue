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
                        label="Chủ nuôi"
                        content="Nguyễn Văn A"
                    />
                    <DisplayInfo
                        label="Số điện thoại"
                        content="09123456789"
                    />
                    <DisplayInfo
                        label="Thời gian"
                        content="12-06-2022 09:00"
                    />
                </div>
                <div class="phd-right">
                    <DisplayInfo
                        label="Tên thú cưng"
                        content="Milu"
                    />
                    
                    <DisplayInfo
                        label="Loại thú cưng"
                        content="Chó"
                    />
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
                    text="Liên hệ Chủ nuôi"
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