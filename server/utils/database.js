require('dotenv').config()


const { Pool } = require('pg')

const pool = new Pool({
  connectionString: process.env.DATABASE_URL,
  ssl: { rejectUnauthorized: false }
})


const runQuery = async (query, param) => {
  const client = await pool.connect()
  try {
    const res = await client.query(query, param)
    return res
  } finally {
    client.release()
  }
}

module.exports = {
  pool,
  runQuery
}

