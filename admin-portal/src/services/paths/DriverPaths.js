const PREFIX = 'driverservice'
const VERSION = 'v1'

const CONSTANTS = 'constant'
const MAILS = 'mail'

const BASE = `${PREFIX}/${VERSION}`

const BASE_CONSTANTS = `${BASE}/${CONSTANTS}`
const BASE_MAILS = `${BASE}/${MAILS}`

function getServicePath(basePath, segment = CONSTANTS) {
    return `${basePath}/${segment}`
}

export const PATHS = {
    CONSTANTS: {
        ALL_SERVICES: getServicePath(BASE_CONSTANTS, "getAllServices"),
    },
    MAILS: {
        SEND_MAIL: getServicePath(BASE_MAILS, 'confirm-mail')
    }
}