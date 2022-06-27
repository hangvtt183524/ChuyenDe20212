<template lang="">
    <div class="chat-window">
        <div class="header chat-window-header">
            Bs. Nguyễn Văn A
            <div class="exit" @click="exitBtnOnClick">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="msgs scrollable">
            <div class="wrap-msg" v-for="(msg, index) in msgs" :key="index" :class="getClass(msg)">
                <div class="msg">
                    {{msg.content}}
                </div>
            </div>
        </div>
        <div class="send-msg">
            <input>
            <i class="fa-solid fa-paper-plane"></i>
        </div>
    </div>
</template>
<script>

export default {
    name: 'ChatWindow',
    data(){
        return{
            myId: '1',
            msgs:[
                {
                    senderId: '2',
                    receiverId: '1',
                    content: 'Do you know BTS ?'
                },
                {
                    senderId: '1',
                    receiverId: '2',
                    content: 'International playboys'
                },
                {
                    senderId: '2',
                    receiverId: '1',
                    content: 'Do you know BTS ?'
                },
                {
                    senderId: '1',
                    receiverId: '2',
                    content: 'International playboys'
                },
                 {
                    senderId: '1',
                    receiverId: '2',
                    content: 'International playboys djfk akfj alfjk alfj alfkjd djf '
                },
                
                
            ]
        }
    },
    methods: {
        getClass(msg){
            return {
                'float-right' : msg.senderId == this.myId
            }
        },
        exitBtnOnClick(){
            this.$emit('hideChatWindow')
        }
    }
}
</script>
<style scoped>
    @import url('../../assets/styles/common/chatwindow.css');
</style>