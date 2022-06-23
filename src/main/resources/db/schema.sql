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
