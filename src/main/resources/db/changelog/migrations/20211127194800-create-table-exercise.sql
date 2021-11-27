--liquibase formatted sql
--changeset monjasa:20211127194800-01

create table exercise
(
    id               bigserial,
    name             varchar(255),
    description      varchar(1024),
    module_id        bigint,
    is_deleted       boolean,
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_exercise primary key (id)
);

alter table exercise
    add constraint fk_exercise_module
        foreign key (module_id) references module (id);
