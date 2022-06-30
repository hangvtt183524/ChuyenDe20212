<template>
  <div class="container" align="center">
    <div id="booking-page flex" class="booking-page">
      <div class="booking-info">
        <div class="booking-info-wrapper content-panel">
          <div class="content-header">
            <span>Set a schedule</span>
          </div>
          <div class="booking-form content-body">
            <div class="booking-form-input">
              <div class="left-content">
                <div class="left-content-wrapper">
                  <InputItem
                      label="Your Pet"
                      :is-editing="true"
                  />
                  <InputItem
                      label="Date"
                      :is-editing="true"
                  />
                    <InputItem
                      label="Time"
                      :is-editing="true"
                  />
                </div>
              </div>
              <div class="right-content">
                <div class="right-content-wrapper">
                  <InputItem
                      label="Doctor"
                      :is-editing="true"
                  />
                  <InputItem
                      label="Situation"
                      :is-editing="true"
                  />
                </div>
              </div>
            </div>
            <div class="button-group">
              Button
            </div>
          </div>
        </div>
      </div>
      <div class="booking-history">
        <div class="booking-history-wrapper content-panel" v-if="!showHistory">
          <div
              class="content-header clickable"
              @click.stop="showHistory = !showHistory"
          >
            <span>History</span>
            <span class="svg-icon">
                <down class="is-fill-blue pull-right" />
              </span>
          </div>
        </div>
        <div class="booking-history-wrapper content-panel" v-if="showHistory">
          <div
              class="content-header clickable"
              @click.stop="showHistory = !showHistory"
          >
            <span>History</span>
            <span class="svg-icon">
                <up class="is-fill-blue pull-right" />
              </span>
          </div>
          <div class="history-detail">

          </div>
        </div>
        </div>
    </div>
  </div>
</template>
<script>
import InputItem from './components/InputItem.vue'

import Button from './components/Button.vue'
import PetHistoryDetail from './PetHistoryDetail.vue'
import {mapGetters} from "vuex";
import moment from "moment";
import InfotypeServices from "@/services/InfotypeServices";
export default {
  components: {
    InputItem, Button, PetHistoryDetail
  },
  data(){
    return{
      myPets: [],
      showPetHistoryDetail: false,
      choosenPet: 'Milu',
      choosenPetId: 1,
      chooseDate: null,
      chooseTime: null,
      chooseDescription: ''
    }
  },
   methods: {
    detailBtnOnClick(){
        this.showPetHistoryDetail = true
    },
    hidePetHistoryDetail(){
        this.showPetHistoryDetail = false
    },
     async saveExam() {
      let newExam = {
        ownerId: this.$store.state.config.currentUser.id,
        petId: this.choosenPetId,
        date: Number(moment(this.chooseDate, 'DD/MM/YYYY').format('DDMMYYYY')),
        time: this.chooseTime,
        firstDescription: this.chooseDescription
      }

      await InfotypeServices.saveSchedule(newExam)
       this.$notify({
         group: 'default',
         type: 'success',
         title: 'Save succcess!',
         duration: 3000
       })
     }
  },
  computed: {
    ...mapGetters({
      petsOfUser: 'config/getPetOfUser'
    })
  },
  mounted() {
    this.petsOfUser.forEach(pet => {
      this.myPets.push({
        id: pet.id,
        name: pet.name
      })
    })
  }
}
</script>

<style lang="scss">
.booking-page {
  padding: 20px;

  .booking-info {
    // max-width: 60%;
    // min-width: 60%;
    margin-bottom: 20px;
    .booking-info-wrapper {

      .booking-form {

        .booking-form-input {
          display: flex;
          .left-content {
            z-index: 19;
            max-width: 360px;
            .left-content-wrapper {
              max-width: 360px;
              min-width: 360px;
            }
          }

          .right-content {
            margin-left: 0px;
            z-index: 20;
            flex: auto;

            .right-content-wrapper {
              max-width: 360px;
              min-width: 360px;
            }
          }
        }
      }
    }
  }
  
  .booking-history {
    // max-width: 60%;
    // min-width: 60%;
  }
}
</style>