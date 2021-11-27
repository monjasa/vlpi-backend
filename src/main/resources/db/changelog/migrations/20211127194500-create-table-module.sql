--liquibase formatted sql
--changeset monjasa:20211127194500-01

create table module
(
    id               bigserial,
    name             varchar(255),
    description      varchar(1024),
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_module primary key (id)
);
