import { http, prepareParams } from "@/utils/utils";
import { PATHS } from "@/services/paths/InfotypePaths";

export default {
    async saveUser(user) {
        let urlPath = user.id ? `${PATHS.USERS.UPDATE}` : `${PATHS.USERS.CREATE}`
        const response = await http.request({
            method: 'GET',
            url: urlPath + '?' + prepareParams(user)
        })
        return response.data
    },
    async saveDoctor(doctor) {
        let urlPath = doctor.id ? `${PATHS.DOCTORS.UPDATE}` : `${PATHS.DOCTORS.CREATE}`
        const response = await http.request({
            method: 'GET',
            url: urlPath + '?' + prepareParams(doctor)
        })
        return response.data
    },
    async saveSchedule(schedule) {
        let urlPath = schedule.id ? `${PATHS.SCHEDULES.UPDATE}` : `${PATHS.SCHEDULES.CREATE}`
        const response = await http.request({
            method: 'GET',
            url: urlPath + '?' + prepareParams(schedule)
        })
        return response.data
    },
    async savePet(pet) {
        let urlPath = pet.id ? `${PATHS.PETS.UPDATE}` : `${PATHS.PETS.CREATE}`
        const response = await http.request({
            method: 'GET',
            url: urlPath + '?' + prepareParams(pet)
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
            url: `${PATHS.PETS.SEARCH_BY_ID}` + '?' + prepareParams(user.id)
        })
        return response.data
    },
    async searchUserAll() {
        prepareParams(null)
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
    async login(user) {
        console.log(user)
        const response = null
        return response.data
    }
}