const db = require('../utils/database.js')

test('Test', () => {
  expect(1).toBe(1)
})


describe("Check Tables Exist", () => {
  test("User Table", () => {
    return expect(db.runQuery("SELECT * FROM users;")).resolves.toBeTruthy()
  })

  test("Invalid Table", () => {
    return expect(db.runQuery("SELECT * FROM faketable")).rejects.toThrow()
  })
})



afterAll(() => db.pool.end())
