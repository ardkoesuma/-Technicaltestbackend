DROP TABLE IF EXISTS "user";
 CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL
);


DROP TABLE IF EXISTS "employee";
 CREATE TABLE "employee" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    position VARCHAR(100) NOT NULL,
    image_base64 TEXT
);