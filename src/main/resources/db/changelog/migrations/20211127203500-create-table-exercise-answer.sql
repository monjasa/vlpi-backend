--liquibase formatted sql
--changeset monjasa:20211127203500-01

create table exercise_answer
(
    id               bigserial,
    text             varchar(1024),
    user_account_id  bigint,
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_exercise_answer primary key (id)
);

alter table exercise_answer
    add constraint fk_exercise_answer_user_account
        foreign key (user_account_id) references user_account (id);
