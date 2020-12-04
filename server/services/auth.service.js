/**** Node Modules ***/
const bcrypt = require('bcrypt')

/****  Models ***/
const AuthModel = require('../models/auth.model.js')

const SALTROUNDS = 14

class AuthService {

  static async register(username, password) {
    //create hash
    const hashedPass = await bcrypt.hash(password, SALTROUNDS)

    // Validation
    if (username.length > 32) {
      throw `Username must be between 0-32 characters`
    }
    try {
      return await AuthModel.createUser(username, hashedPass)
    }

    // errors handling for inserting row
    catch (err) {
      if (err.code == '23505') {
        throw `Username ${username} already in use`
      }
      else {
        console.error(err)
        throw `Error creating user`
      }
    }
  }


  static async login(username, password) {
    const user = await AuthModel.retrieveUser(username)
    try {
      const match = await bcrypt.compare(password, user[0].password)
      if (!match) throw "Invalid Login"


    } catch (err) {
      //console.error(err)
      throw "Invalid Login"
    }
    return await user[0]
  }

}









module.exports = AuthService
