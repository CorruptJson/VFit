/**** Node Modules ***/
const express = require('express')
const bodyParser = require('body-parser')
const session = require('client-sessions')



/****  Project scripts ***/
const auth = require('./services/auth.js')



/**** Constants ***/

const app = express()

const port = process.env.PORT || 8080
const sessionSecret = process.env.SESSION_SECRET












app.listen(port, console.log(`Server is up on the port ${port}, with PID: ${process.pid}`))