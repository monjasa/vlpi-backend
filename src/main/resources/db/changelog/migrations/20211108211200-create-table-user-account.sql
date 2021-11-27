--liquibase formatted sql
--changeset monjasa:20211108211200-01

create table user_account
(
    id               bigserial,
    email            varchar(255),
    password         varchar(255),
    enabled          boolean,
    first_name       varchar(255),
    last_name        varchar(255),
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_user_account primary key (id)
);
