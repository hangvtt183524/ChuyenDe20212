import InfotypeServices from "@/services/InfotypeServices";
import DriverServices from "@/services/DriverServices"

export default {
    namespaced: true,
    state: {
        configDoctor: {
            id: 1,
            mail: 'nanh.trang.140@gmail.com',
            password: '1234567890',
            birth_date: '14/04/2000',
            address: 'Ha Dong, Ha Noi',
            phone: '0987654321',
            doctorName: 'Mr. John'
        },
        currentDoctor: {
            id: 1,
            mail: 'nanh.trang.140@gmail.com',
            password: '1234567890',
            birth_date: '14/04/2000',
            address: 'Ha Dong, Ha Noi',
            phone: '0987654321',
            doctorName: 'Mr. John'
        },
        allServices: [],
        allUsers: [],
        allExams: [],
        allPets: []
    },
    getters: {
        getConfigDoctor: state => state.configDoctor,
        getCurrentDoctor: state => state.currentDoctor,
        getAllUsers: state => state.allUsers,
        getAllServices: state => state.allServices,
        getAllExams: state => state.allExams,
        getAllPets: state => state.allPets
    },
    mutations: {
        setAllUsers(state, listUser) {
            state.allUsers = listUser
        },
        setAllExams(state, listExam) {
            state.allExams = listExam
        },
        setAllServices(state, listService) {
            state.allServices = listService
        },
        setAllPets(state, listPet) {
            state.allPets = listPet
        }
    },
    actions: {
        async getAllConfigs({commit}) {
            const users = await InfotypeServices.searchUserAll()
            const exams = await InfotypeServices.searchScheduleAll()
            const services = await DriverServices.getAllServices()
            const pets = await InfotypeServices.searchPetAll()

            commit('setAllUsers', users)
            commit('setAllExams', exams)
            commit('setAllServices', services)
            commit('setAllPets', pets)
        }
    }
}