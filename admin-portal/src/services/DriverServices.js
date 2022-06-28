import { http } from "@/utils/utils";
import { PATHS } from "@/services/paths/DriverPaths";

export default {
    async bookSchedule(schedule) {
        const response = await http.request({
            method: schedule.id ? 'PUT' : 'POST',
            url: `${PATHS.SCHEDULES.BASE}`,
            data: schedule
        })
        return response.data
    }
}
