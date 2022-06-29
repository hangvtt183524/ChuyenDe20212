<template lang="">
    <div class="blue-bg">
        <div class="msgs-screen">
            <div class="user-list scrollable">
                <div class="user" v-for="(user, index) in userList" :key="index" @click="userOnClick">
                    <div class="avatar"></div>
                    <div class="username">{{user.userName}}</div>
                    <div class="latest-msg">Đây là bệnh gì ạ ?</div>
                </div>
            </div>
            <div class="msg-side">
                    <p>
                        <i class="fa-solid fa-envelopes-bulk"></i>
                        <span>Chọn 1 mục để xem tin nhắn </span>
                    </p>
                <div class="chat-window" v-if="showChatWindow">
                    <div class="header chat-window-header">
                        ABC
                        <div class="exit" @click="exitBtnOnClick">
                            <i class="fa-solid fa-xmark"></i>
                        </div>
                    </div>
                    <div class="msgs scrollable" ref="msgs">
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
            </div>
        </div>
    </div>
</template>
<script>
import Vue from 'vue'
export default {
    name: 'MessagesScreen',
    data(){
        return{
            showChatWindow: false,
            userList: [
                {
                    userName: 'ABC'
                },
                {
                    userName: 'DEF'
                },
                {
                    userName: 'GHI'
                },
                {
                    userName: 'ABC'
                },
                {
                    userName: 'ABC'
                },
                {
                    userName: 'ABC'
                },
                {
                    userName: 'DEF'
                },
                {
                    userName: 'GHI'
                },
                {
                    userName: 'ABC'
                },
                {
                    userName: 'ABC'
                },
            ],
            myId: '1',
            msgs: [],
            msgsData: [],
        }
    },
    created(){
        this.msgsData=[
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
    },
    methods: {
        getClass(msg){
            return {
                'float-right' : msg.senderId == this.myId
            }
        },
        autoScroll(){
            var element = this.$refs.msgs
            if(element){
                element.scrollTop = element.scrollHeight;
            }
        },
        userOnClick(){
            this.showChatWindow = true
            this.msgs = this.msgsData      
        },
         exitBtnOnClick(){
            this.showChatWindow = false
            this.msgs = []
        },
    }, 
    watch:{
        msgs(){
            Vue.nextTick(()=>{
                this.autoScroll()
            })
            
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/messagesscreen.css');
</style>