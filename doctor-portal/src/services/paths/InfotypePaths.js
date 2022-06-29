const PREFIX = 'infotypeservice'
const VERSION = 'v1'

const SEARCH = 'search'
const SEARCH_ALL = 'searchAll'
const UPDATE = 'update'
const DELETE = 'delete'
const CREATE = 'create'
const SEARCH_BY_ID = 'searchById'

const BASE = `${PREFIX}/${VERSION}`

const USERS = 'user'
const DOCTORS = 'doctor'
const SCHEDULES = 'schedule'
const PETS = 'pet'
const AUTHS = 'auth'


const BASE_USERS = `${BASE}/${USERS}`
const BASE_DOCTORS = `${BASE}/${DOCTORS}`
const BASE_SCHEDULES = `${BASE}/${SCHEDULES}`
const BASE_PETS = `${BASE}/${PETS}`
const BASE_AUTHS = `${BASE}/${AUTHS}`

function getSearchPath(basePath, segment = SEARCH) {
    return `${basePath}/${segment}`
}

export const PATHS = {
    USERS: {
        BASE: BASE_USERS,
        SEARCH: getSearchPath(BASE_USERS),
        SEARCH_ALL: getSearchPath(BASE_USERS, SEARCH_ALL),
        UPDATE: getSearchPath(BASE_USERS, UPDATE),
        CREATE: getSearchPath(BASE_USERS, CREATE),
        DELETE: getSearchPath(BASE_USERS, DELETE),
        SEARCH_BY_ID: getSearchPath(BASE_USERS, SEARCH_BY_ID)
    },
    DOCTORS: {
        BASE: BASE_DOCTORS,
        SEARCH: getSearchPath(BASE_DOCTORS),
        SEARCH_ALL: getSearchPath(BASE_DOCTORS, SEARCH_ALL),
        UPDATE: getSearchPath(BASE_DOCTORS, UPDATE),
        CREATE: getSearchPath(BASE_DOCTORS, CREATE),
        DELETE: getSearchPath(BASE_DOCTORS, DELETE),
        SEARCH_BY_ID: getSearchPath(BASE_DOCTORS, SEARCH_BY_ID)
    },
    SCHEDULES: {
        BASE: BASE_SCHEDULES,
        SEARCH: getSearchPath(BASE_SCHEDULES),
        SEARCH_ALL: getSearchPath(BASE_SCHEDULES, SEARCH_ALL),
        UPDATE: getSearchPath(BASE_SCHEDULES, UPDATE),
        CREATE: getSearchPath(BASE_SCHEDULES, CREATE),
        DELETE: getSearchPath(BASE_SCHEDULES, DELETE),
        SEARCH_BY_ID: getSearchPath(BASE_SCHEDULES, SEARCH_BY_ID)
    },
    PETS: {
        BASE: BASE_PETS,
        SEARCH: getSearchPath(BASE_PETS),
        SEARCH_ALL: getSearchPath(BASE_PETS, SEARCH_ALL),
        UPDATE: getSearchPath(BASE_PETS, UPDATE),
        CREATE: getSearchPath(BASE_PETS, CREATE),
        DELETE: getSearchPath(BASE_PETS, DELETE),
        SEARCH_BY_ID: getSearchPath(BASE_PETS, SEARCH_BY_ID),
        SEARCH_BY_USER: getSearchPath(BASE_PETS, 'searchByUser')
    },
    AUTHS: {
        LOGIN: getSearchPath(BASE_AUTHS, 'login')
    }
}

