const { runQuery, pool } = require('../utils/database.js')



const createUser = async (username, password) => {
  const query = `INSERT INTO users (username, password) VALUES ($1, $2)`
  return await runQuery(query, [username, password])
}

const retrieveLogin = async (username) => {
  const query = `SELECT id, username, password FROM users WHERE username = $1`
  return (await runQuery(query, [username])).rows
}



module.exports = {
  createUser,
  retrieveLogin
}
