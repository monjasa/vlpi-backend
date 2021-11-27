--liquibase formatted sql
--changeset monjasa:20211127194000-01

create table role
(
    id               bigserial,
    name             varchar(255),
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_role primary key (id)
);
