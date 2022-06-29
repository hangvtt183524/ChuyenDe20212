import {http} from "@/utils/utils";
import { PATHS } from "@/services/paths/DriverPaths";

export default {
    async getAllServices() {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.CONSTANTS.ALL_SERVICES}`
        })
        return response.data
    }
}
