create table if not exists accidenttypes
(
    id   serial primary key,
    name varchar(255)
);

create table if not exists rules
(
    id   serial primary key,
    name varchar(255)
);

create table if not exists accidents
(
    id      serial primary key,
    address varchar(255),
    name    varchar(255),
    text    varchar(255),
    type_id INTEGER REFERENCES accidenttypes (id)
);

create table if not exists accidents_rules
(
    accident_id INTEGER REFERENCES accidenttypes (id),
    rules_id    INTEGER REFERENCES rules (id)
);

CREATE TABLE if not exists users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  boolean default true,
    PRIMARY KEY (username)
);

CREATE TABLE if not exists authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);
