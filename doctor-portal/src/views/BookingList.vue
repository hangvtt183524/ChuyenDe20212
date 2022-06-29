<template lang="">
    <div class="booking-list-bg blue-bg">
        <div class="booking-list">
            <div class="header booking-list-header">
                Quản lý danh sách lịch khám
                <div class="dropdowns">
                    <div class="dropdown-holder">
                        <Dropdown
                            label="Tìm kiếm theo tháng"
                            :items="this.months"
                        />
                    </div>
                    <div class="dropdown-holder">
                        <Dropdown
                            label="Tìm kiếm theo ngày"
                            :items="this.dates"
                        />
                    </div>
                </div>
            </div>
            <div class="booking-table scrollable">
                <table class="table" ref="table">
                    <thead>
                        <tr>
                            <th class="align-center">STT</th>
                            <th>Tên Bệnh</th>
                            <th>Chủ nuôi</th>
                            <th>Tên thú cưng</th>
                            <th>Loại thú cưng</th>
                            <th class="align-center">Thời gian</th>
                            <th>Kết luận</th>
                            <th>Chức năng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>  
                            <td class="align-center">1</td>
                            <td>Rụng lông</td>
                            <td>Nguyễn Văn A</td>
                            <td>Milu</td>
                            <td>Chó</td>
                            <td class="align-center">09-12-2022</td>
                            <td>Đã chữa khỏi</td>
                            <td>
                                <Button
                                    text="Chi tiết"
                                    color="blue"
                                    @click.native="detailBtnOnClick"
                                />
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
            <div class="paging">
                <Button
                    text="Trước"
                    color="orange"
                />
                <Button
                    text="Sau"
                    color="orange"
                />
            </div>
        </div>
        <PetHistoryDetail
            v-if="showDetail"
            @exitDetail="exitDetail" 
        />
    </div>
</template>
<script>
import Button from './components/Button.vue'
import Dropdown from './components/Dropdown.vue' 
import PetHistoryDetail from './PetHistoryDetail.vue'
export default {
    components:{
        Button, Dropdown, PetHistoryDetail
    },
    data(){
        return{
            months: Array.from(Array(13).keys()).splice(1, 12),
            dates: Array.from(Array(32).keys()).splice(1, 31),
            showDetail: false,
        }
    },
    created(){
        console.log(this.months)
    },
    methods: {
        detailBtnOnClick(){
            this.showDetail = true
        },
        exitDetail(){
            this.showDetail = false
        }
    }
}
</script>
<style scoped>
    @import url('../assets/styles/bookinglist.css');
</style>