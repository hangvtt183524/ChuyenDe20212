import InfotypeServices from "@/services/InfotypeServices"
import DriverServices from "@/services/DriverServices"

export default {
    namespaced: true,
    state: {
        configUser: {
            id: 1,
            mail: 'nanh.trang.140@gmail.com',
            password: '1234567890',
            birth_date: '14/04/2000',
            address: 'Ha Dong, Ha Noi',
            phone: '0987654321',
            username: 'VTTHang'
        },
        currentUser: {},
        petOfUser: [],
        allUsers: [],
        allDoctors: [],
        allServices: [],
        allExams: [],
        allPets: []
    },
    getters: {
        getConfigUser: state => state.configUser,
        getCurrentUser: state => state.currentUser,
        getPetOfUser: state => state.petOfUser,
        getAllUsers: state => state.allUsers,
        getAllDoctors: state => state.allDoctors,
        getAllServices: state => state.allServices,
        getAllExams: state => state.allExams,
        getAllPets: state => state.allPets
    },
    mutations: {
        setCurrentUser(state, currentUser) {
            state.currentUser = currentUser
        },
        setPetOfUser(state, listPet) {
            state.petOfUser = listPet
        },
        setAllUsers(state, listUser) {
            state.allUsers = listUser
        },
        setAllDoctors(state, listDoctor) {
            state.allDoctors = listDoctor
        },
        setAllServices(state, listService) {
            state.allServices = listService
        },
        setAllExams(state, listExam) {
            state.allExams = listExam
        },
        setAllPets(state, listPet) {
            state.allPets = listPet
        }
    },
    actions: {
        async getListPetOfUser({commit}, {user}) {
            const pets = await InfotypeServices.searchPetByUser(user)
            commit('setPetOfUser', pets)
        },
        async loginAndSetCurrentUser({commit}, {user}) {
            const loginUser = await InfotypeServices.login(user)
            commit('setCurrentUser', loginUser)
        },
        async getAllUsersByAdmin({commit}) {
            const allUsers = await InfotypeServices.searchUserAll()
            commit('setAllUsers', allUsers)
        },
        async getAllDoctorsByAdmin({commit}) {
            const allDoctors = await InfotypeServices.searchDoctorAll()
            commit('setAllDoctors', allDoctors)
        },
        async getAllServicesByAdmin({commit}) {
            const allServices = await DriverServices.getAllServices()
            commit('setAllServices', allServices)
        },
        async getAllExamsByAdmin({commit}) {
            const allExams = await InfotypeServices.searchScheduleAll()
            commit('setAllExams', allExams)
        },
        async getAllPetsByAdmin({commit}) {
            const allPets = await InfotypeServices.searchPetAll()
            commit('setAllPets', allPets)
        }
    }
}