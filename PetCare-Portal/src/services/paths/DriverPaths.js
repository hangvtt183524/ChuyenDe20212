const VERSION = '/v1'

const SAVE = 'save'

const BASE = `${VERSION}`

const USERS = 'users'
const DOCTORS = 'doctors'
const SCHEDULES = 'schedules'


const BASE_USERS = `${BASE}/${USERS}`
const BASE_DOCTORS = `${BASE}/${DOCTORS}`
const BASE_SCHEDULES = `${BASE}/${SCHEDULES}`

function getSavePath(basePath, segment = SAVE) {
    return `${basePath}/${segment}`
}

export const PATHS = {
    USERS: {
        BASE: BASE_USERS,
        SAVE: getSavePath(BASE_USERS),
    },
    DOCTORS: {
        BASE: BASE_DOCTORS,
        SAVE: getSavePath(BASE_DOCTORS),
    },
    SCHEDULES: {
        BASE: BASE_DOCTORS,
        SAVE: getSavePath(BASE_SCHEDULES),
    }
}