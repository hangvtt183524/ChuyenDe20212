import { http } from "@/utils/Infotype";
import { PATHS } from "@/services/paths/InfotypePaths";

export default {
    async saveUser(user) {
        const response = await http.request({
            method: user.id ? 'PUT' : 'POST',
            url: `${PATHS.USERS.BASE}`,
            data: user
        })
        return response.data
    },
    async saveDoctor(doctor) {
        const response = await http.request({
            method: doctor.id ? 'PUT' : 'POST',
            url: `${PATHS.DOCTORS.BASE}`,
            data: doctor
        })
        return response.data
    },
    async saveSchedule(schedule) {
        const response = await http.request({
            method: schedule.id ? 'PUT' : 'POST',
            url: `${PATHS.SCHEDULES.BASE}`,
            data: schedule
        })
        return response.data
    },
    async searchUser(user, param) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.USERS.SEARCH}`,
            data: user
        })
        return response.data
    },
    async searchDoctor(doctor, param) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.DOCTORS.SEARCH}`,
            data: doctor
        })
        return response.data
    },
    async searchSchedule(schedule, param) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.SCHEDULES.SEARCH}`,
            data: schedule
        })
        return response.data
    },
    async searchUserAll() {

    },
    async searchDoctorAll() {

    },
    async searchScheduleAll() {

    }
}