/**** Node Modules ***/


/****  Project scripts ***/
const middlewares = require('./utils/middlewares.js')
const auth = require('./controllers/auth.controller.js')



/**** Constants ***/

const app = middlewares.app

const port = process.env.PORT || 8080





/****  Routing ***/
app.use("/auth", auth)






app.get("/", (req, res) => {
  res.send("V-Fit Server is Online!")
})


app.listen(port, console.log(`Server is up on the port ${port}, with PID: ${process.pid}`))
