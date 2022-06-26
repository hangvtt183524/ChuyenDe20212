<template lang="">
    <div class="pet-history">
        <div class="pet-history-title">Lịch sử khám bệnh</div> 
        <div class="pet-history-table scrollable">
            <table class="table" ref="table">
                <thead>
                    <tr>
                        <th class="align-center">STT</th>
                        <th>Tên Bệnh</th>
                        <th>Bác sĩ</th>
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
                        <td class="align-center">09-12-2022</td>
                        <td>Đã chữa khỏi</td>
                        <td>
                            <Button
                                text="Chi tiết"
                                color="blue"
                            />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import Button from './components/Button.vue'
export default {
    components:{
        Button, 
    }
}
</script>
<style lang="">
    
</style>