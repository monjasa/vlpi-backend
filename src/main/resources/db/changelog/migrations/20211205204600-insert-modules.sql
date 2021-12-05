--liquibase formatted sql
--changeset monjasa:20211205204600-01

insert into module (name, description, created_by, created_at, last_modified_by, last_modified_at)
values ('Requirement Analysis', 'Practice capturing system requirements and process of requirements verification', 'system', now(), 'system', now()),
       ('System Design', 'Gain experience with drafting and building software system architecture', 'system', now(), 'system', now()),
       ('System Modelling', 'Work with using models to conceptualize and construct systems', 'system', now(), 'system', now()),
       ('Implementation', 'Enhance your skills on the development, proving, and integration of software', 'system', now(), 'system', now()),
       ('Quality Assurance', 'Acquire practical knowledge on working with software testing and verification', 'system', now(), 'system', now());
