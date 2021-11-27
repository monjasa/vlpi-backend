--liquibase formatted sql
--changeset monjasa:20211127195400-01

create table task
(
    id               bigserial,
    question         varchar(4096),
    score            int,
    exercise_id      bigint,
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_task primary key (id)
);

alter table task
    add constraint fk_task_exercise
        foreign key (exercise_id) references exercise (id);
