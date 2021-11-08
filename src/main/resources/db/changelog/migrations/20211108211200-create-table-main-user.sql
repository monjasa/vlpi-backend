--liquibase formatted sql
--changeset monjasa:20211108211200-01

create table main_user(
    id serial primary key,
    email varchar(255),
    password varchar(255),
    enabled boolean,
    first_name varchar(255),
    last_name varchar(255)
);
