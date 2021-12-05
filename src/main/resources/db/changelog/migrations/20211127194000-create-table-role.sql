--liquibase formatted sql
--changeset monjasa:20211127194000-01

create table role
(
    id               bigserial,
    name             varchar(255),
    constraint pk_role primary key (id)
);
