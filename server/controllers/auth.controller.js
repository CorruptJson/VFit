
/**** Node Modules ***/
const router = require("express").Router()


/*** Services ***/
const authService = require('../services/auth.service.js')



/*** Routes ***/
router.post('/register', register)
router.post('/login', login)
router.post('/logout', logout)
router.post('/check-cookie', checkCookie)



async function register(req, res) {
  try {
    const userId = await authService.register(req.body.username, req.body.password)
    req.session.user = userId
    res.status(200).json({ success: true })
  }
  catch (err) {
    console.error(err)
    res.status(400).json({ error: err })
  }
}


async function login(req, res) {
  try {
    const user = await authService.login(req.body.username, req.body.password)
    req.session.user = user.id
    res.status(200).json({ success: true })
  }
  catch (err) {
    console.error(err)
    res.status(401).json({ error: err })
  }
}


async function logout(req, res) {
  try {
    req.session.reset()
    res.status(200).json({ success: true })
  }
  catch (err) {
    res.status(500).json({ error: err })
  }

}


async function checkCookie(req, res) {
  try {
    if (req.session.user == null) {
      throw "No valid token"
    }
    res.status(200).json({ id: req.session.user })
  }
  catch (err) {
    res.status(401).json({ error: err })
  }

}




module.exports = router
