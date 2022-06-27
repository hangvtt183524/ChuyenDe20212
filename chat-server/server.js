const app = require("express")();
const http = require("http").Server(app);
const io = require("socket.io")(http);
// const mongoose = require("mongoose");
let users = [];
let messages = [];

io.on("connection", socket => {
    socket.on('msg', msg => {
        console.log(msg)
        io.emit('msg', msg);
    });

    // Disconnect
    socket.on("disconnect", () => {
        console.log(`${socket.username} has left the party.`);
        io.emit("userLeft", socket.username);
        users.splice(users.indexOf(socket), 1);
    });
});

http.listen(process.env.PORT || 3000, () => {
    console.log("Listening on port %s", process.env.PORT || 3000);
});