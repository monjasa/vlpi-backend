--liquibase formatted sql
--changeset monjasa:20211204231300-01

insert into role (name, created_by, created_at, last_modified_by, last_modified_at)
values ('ROLE_ADMINISTRATOR', 'system', now(), 'system', now()),
       ('ROLE_STUDENT', 'system', now(), 'system', now());
