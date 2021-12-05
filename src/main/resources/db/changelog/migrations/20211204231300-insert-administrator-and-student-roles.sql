--liquibase formatted sql
--changeset monjasa:20211204231300-01

insert into role (name)
values ('ROLE_ADMINISTRATOR'),
       ('ROLE_STUDENT');