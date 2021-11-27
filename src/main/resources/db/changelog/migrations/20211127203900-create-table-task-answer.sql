--liquibase formatted sql
--changeset monjasa:20211127203900-01

create table task_answer
(
    id                 bigserial,
    score              int,
    task_id            bigint,
    exercise_answer_id bigint,
    created_by         varchar(255),
    created_at         timestamp,
    last_modified_by   varchar(255),
    last_modified_at   timestamp,
    constraint pk_task_answer primary key (id)
);

alter table task_answer
    add constraint fk_task_answer_task
        foreign key (task_id) references task (id);

alter table task_answer
    add constraint fk_task_answer_exercise_answer
        foreign key (exercise_answer_id) references exercise_answer (id);
