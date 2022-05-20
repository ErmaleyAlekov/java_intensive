DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS Chat;
CREATE TABLE IF NOT EXISTS Chat.Users (
    id SERIAL PRIMARY KEY,
    login text UNIQUE NOT NULL,
    password text NOT NULL,
    createdrooms text NOT NULL,
    allrooms text NOT NULL
);
CREATE TABLE IF NOT EXISTS Chat.Rooms (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    owner INTEGER REFERENCES Chat.Users(id) NOT NULL
);
CREATE TABLE IF NOT EXISTS Chat.Messages (
    id SERIAL PRIMARY KEY,
    author INTEGER REFERENCES Chat.Users(id) NOT NULL,
    room INTEGER REFERENCES Chat.Rooms(id) NOT NULL,
    text TEXT NOT NULL,
    timestamp TIMESTAMP NULL
);