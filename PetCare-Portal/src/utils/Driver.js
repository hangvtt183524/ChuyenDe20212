import axios from 'axios'
import Vue from 'vue'

const http = axios.create({
    baseURL: process.env.VUE_APP_DRIVER_BASE_URL,
    timeout: 30000
})

http.defaults.timeout = 30000

http.interceptors.request.use(
    async config => {
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

http.interceptors.response.use(
    res => res,
    error => {
        let msg = 'API request failed'
        if (error && error.response && error.response.data) {
            msg = error.response.data.message || error.response.data
        }

        Vue.notify({
            group: 'default',
            type: 'error',
            title: 'Error',
            text: msg
        })
        return Promise.reject(error)
    }
)

export {
    http
}