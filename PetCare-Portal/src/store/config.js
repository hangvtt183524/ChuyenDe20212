import InfotypeServices from "@/services/InfotypeServices"

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
        currentPetIndex: 0
    },
    getters: {
        getConfigUser: state => state.configUser,
        getCurrentUser: state => state.currentUser,
        getPetOfUser: state => state.petOfUser,
        getCurrentPetIndex: state => state.currentPetIndex
    },
    mutations: {
        setCurrentUser(state, currentUser) {
            state.currentUser = currentUser
        },
        setPetOfUser(state, listPet) {
            state.petOfUser = listPet
        },
        setCurrentPetIndex(state, petIndex) {
            state.currentPetIndex = petIndex
        }
    },
    actions: {
        async getListPetOfUser({commit}, {user}) {
            const pets = await InfotypeServices.searchPetByUser(user)
            commit('setPetOfUser', pets)
        },
        async loginAndSetCurrentUser({commit}, {params}) {
            const loginUser = await InfotypeServices.login(params)
            commit('setCurrentUser', loginUser)
        },
        async choosePet({commit}, petIndex) {
            commit('choosePet', petIndex)
        }
    }
}