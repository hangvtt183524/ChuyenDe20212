const PREFIX = 'driverservice'
const VERSION = 'v1'

const CONSTANTS = 'constant'

const BASE = `${PREFIX}/${VERSION}`

const BASE_CONSTANTS = `${BASE}/${CONSTANTS}`

function getServicePath(basePath, segment = CONSTANTS) {
    return `${basePath}/${segment}`
}

export const PATHS = {
    CONSTANTS: {
        ALL_SERVICES: getServicePath(BASE_CONSTANTS, "getAllServices"),
    }
}