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
        petOfUser: []
    },
    getters: {
        getConfigUser: state => state.configUser,
        getCurrentUser: state => state.currentUser,
        getPetOfUser: state => state.petOfUser
    },
    mutations: {
        setCurrentUser(state, currentUser) {
            state.currentUser = currentUser
        },
        setPetOfUser(state, listPet) {
            state.petOfUser = listPet
        }
    },
    actions: {
        getListPetOfUser({state, commit}, {user}) {

        }
    }
}