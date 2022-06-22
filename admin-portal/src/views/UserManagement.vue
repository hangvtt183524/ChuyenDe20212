<template>
    <div class="container pb-5">
        <div class="container pt-5">
            <h1>Quản lý tài khoản</h1>
        </div>

        <div class="container pt-5">
            <table class="table table-striped table-bordered table-light">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" :key="user.id">
                        <td class="">{{user.name}}</td>
                        <td>{{user.email}}</td>
                        <td>{{user.role}}</td>
                    </tr>
                </tbody>
            </table>

            <nav class="d-flex flex-row-reverse">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>

        </div>

        

    </div>
</template>

<script>
    export default {
        name: 'UserManagement',
        compenents: {

        },
        data() {
            return {
                users: [
                    { name: "Viet Anh", email: 'anh@gmail.com', role: 'User' },
                    { name: "Hang", email: 'hang@gmail.com', role: 'Doctor' },
                    { name: "Thu", email: 'thuh@gmail.com', role: 'User' },
                    { name: "Viet Anh", email: 'anh@gmail.com', role: 'User' },
                    { name: "Hang", email: 'hang@gmail.com', role: 'Doctor' },
                    { name: "Thu", email: 'thuh@gmail.com', role: 'User' },
                    { name: "Viet Anh", email: 'anh@gmail.com', role: 'User' },
                    { name: "Hang", email: 'hang@gmail.com', role: 'Doctor' },
                    { name: "Thu", email: 'thuh@gmail.com', role: 'User' },
                ]
            };
    }
    }

</script>

<style lang="scss">

    
</style>
