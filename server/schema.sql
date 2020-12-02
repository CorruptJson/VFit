/* Table Definitions for PostgreSQL database */

CREATE TABLE IF NOT EXISTS "users"
(
    "id" serial PRIMARY KEY,
    "username" varchar(32) UNIQUE NOT NULL,
    "password" char(60) NOT NULL
);