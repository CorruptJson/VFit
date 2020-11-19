/**** Node Modules ***/
const express = require('express')
const session = require('client-sessions')



/****  Project scripts ***/
const middlewares = require('./utils/middlewares.js')
const auth = require('./controllers/auth.controller.js')




/**** Constants ***/

const app = middlewares.app

const port = process.env.PORT || 8080
const sessionSecret = process.env.SESSION_SECRET





/****  Routing ***/
app.use("/auth", auth)









app.listen(port, console.log(`Server is up on the port ${port}, with PID: ${process.pid}`))
