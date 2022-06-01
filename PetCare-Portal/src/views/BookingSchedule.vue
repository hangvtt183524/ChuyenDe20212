<template>
  <div id="booking-page" class="booking-page">
    <div class="booking-info">
      <div class="booking-info-wrapper">
        <div class="label-wrapper">
          <label>Set a schedule</label>
        </div>
        <div class="booking-form">
          <div class="booking-form-input">
            <div class="left-content">
              <div class="left-content-wrapper">
                <InputItem
                    label="Your Pet"
                    is-editing="true"
                />
                <InputItem
                    label="Date"
                    is-editing="true"
                />
              </div>
            </div>
            <div class="right-content">
              <div class="right-content-wrapper">
                <InputItem
                    label="Situation"
                    is-editing="true"
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

    </div>
  </div>
</template>

<script>
import InputItem from "@/components/InputItem";

export default {
  name: "BookingSchedule",
  components: {
    InputItem
  }
}
</script>

<style lang="scss">
.booking-page {
  display: flex;
  padding: 20px;

  label {
    color: #3366ff;
    font-size: 24px;
    font-weight: bold;
    line-height: 16px;
  }

  .booking-info {

    .booking-info-wrapper {
      display: flex;
      flex-direction: column;

      .booking-form {
        display: flex;
        flex-direction: column;

        border-bottom-left-radius: 14px;
        border-bottom-right-radius: 14px;
        border: #a1d8ff7a solid 2px;

        .booking-form-input {
          display: flex;
          .left-content {
            z-index: 19;
            max-width: 430px;
            .left-content-wrapper {
              max-width: 430px;
              min-width: 430px;
            }
          }

          .right-content {
            margin-left: 0px;
            z-index: 20;
            flex: auto;

            .right-content-wrapper {
              max-width: 430px;
              min-width: 430px;
            }
          }
        }
      }
    }
  }


}
</style>