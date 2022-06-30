import {http, prepareParams} from "@/utils/utils";
import { PATHS } from "@/services/paths/DriverPaths";

export default {
    async getAllServices() {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.CONSTANTS.ALL_SERVICES}`
        })
        return response.data
    },
    async sendConfirmMail(params) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.MAILS.SEND_MAIL}` + '?' + prepareParams(params)
        })
        return response.data
    }
}
