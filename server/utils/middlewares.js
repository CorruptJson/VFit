
require('dotenv').config()

const express = require('express')
const session = require('client-sessions')
const bodyParser = require('body-parser')

const app = express()

const SESSION_SECRET = process.env.SESSION_SECRET
const SESSION_DURATION =  24 * 60 * 60 * 1000


/*** Middlewares ***/

/* Bodyparser Middlewares */
app.use(bodyParser.urlencoded({
  extended: true
}))
app.use(bodyParser.json())


/* Session Middleware */
app.use(session({
  cookieName: 'session',
  secret: SESSION_SECRET,
  duration: SESSION_DURATION
}))



module.exports = {app}
