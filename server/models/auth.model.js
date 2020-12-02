const { runQuery, pool } = require('../utils/database.js')



const createUser = async (username, password) => {
  const query = `INSERT INTO users (username, password) VALUES ($1, $2) RETURNING id`
  return await (await runQuery(query, [username, password])).rows[0].id
}

const retrieveUser = async (username) => {
  const query = `SELECT * FROM users WHERE username = $1`
  return (await runQuery(query, [username])).rows
}



module.exports = {
  createUser,
  retrieveUser
}
