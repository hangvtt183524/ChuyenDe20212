import { http, prepareParams } from "@/utils/utils";
import { PATHS } from "@/services/paths/InfotypePaths";

export default {
    async saveUser(user) {
        const response = await http.request({
            method: user.id ? 'PUT' : 'POST',
            url: user.id ? `${PATHS.USERS.UPDATE}` : `${PATHS.USERS.CREATE}`,
            data: user
        })
        return response.data
    },
    async saveDoctor(doctor) {
        const response = await http.request({
            method: doctor.id ? 'PUT' : 'POST',
            url: doctor.id ? `${PATHS.DOCTORS.UPDATE}` : `${PATHS.DOCTORS.CREATE}`,
            data: doctor
        })
        return response.data
    },
    async saveSchedule(schedule) {
        const response = await http.request({
            method: schedule.id ? 'PUT' : 'POST',
            url: schedule.id ? `${PATHS.SCHEDULES.UPDATE}` : `${PATHS.SCHEDULES.CREATE}`,
            data: schedule
        })
        return response.data
    },
    async savePet(pet) {
        let pathUrl = pet.id ? `${PATHS.PETS.UPDATE}` : `${PATHS.PETS.CREATE}`
        const response = await http.request({
            method: 'GET',
            url: pathUrl + '?' + prepareParams(pet)
        })
        return response.data
    },
    async searchUser(params) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.USERS.SEARCH}` + '?' + prepareParams(params)
        })
        return response.data
    },
    async searchDoctor(params) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.DOCTORS.SEARCH}`+ '?' + prepareParams(params)
        })
        return response.data
    },
    async searchSchedule(params) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.SCHEDULES.SEARCH}`+ '?' + prepareParams(params)
        })
        return response.data
    },
    async searchPetByUser(user) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.PETS.SEARCH_BY_USER}` + '?' + prepareParams({userId: user.id})
        })
        return response.data
    },
    async searchUserAll() {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.USERS.SEARCH_ALL}`
        })
        return response.data
    },
    async searchDoctorAll() {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.DOCTORS.SEARCH_ALL}`
        })
        return response.data
    },
    async searchScheduleAll() {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.SCHEDULES.SEARCH_ALL}`
        })
        return response.data
    },
    async login(params) {
        const response = await http.request({
            method: 'GET',
            url: `${PATHS.AUTHS.LOGIN}` + '?' + prepareParams(params)
        })
        return response.data
    }
}