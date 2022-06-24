const PREFIX = 'infotypeservice'
const VERSION = '/v1'

const SEARCH = 'search'

const BASE = `${PREFIX}/${VERSION}`

const USERS = 'users'
const DOCTORS = 'doctors'
const SCHEDULES = 'schedules'


const BASE_USERS = `${BASE}/${USERS}`
const BASE_DOCTORS = `${BASE}/${DOCTORS}`
const BASE_SCHEDULES = `${BASE}/${SCHEDULES}`

function getSearchPath(basePath, segment = SEARCH) {
    return `${basePath}/${segment}`
}

export const PATHS = {
    USERS: {
        BASE: BASE_USERS,
        SEARCH: getSearchPath(BASE_USERS),
    },
    DOCTORS: {
        BASE: BASE_DOCTORS,
        SEARCH: getSearchPath(BASE_DOCTORS),
    },
    SCHEDULES: {
        BASE: BASE_DOCTORS,
        SEARCH: getSearchPath(BASE_SCHEDULES),
    }
}

