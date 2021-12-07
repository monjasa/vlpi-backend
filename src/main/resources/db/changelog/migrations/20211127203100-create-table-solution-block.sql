--liquibase formatted sql
--changeset monjasa:20211127203100-01

create table solution_block
(
    id               bigserial,
    text             varchar(1024),
    solution_order   int,
    task_id          bigint,
    created_by       varchar(255),
    created_at       timestamp,
    last_modified_by varchar(255),
    last_modified_at timestamp,
    constraint pk_solution_block primary key (id)
);

alter table solution_block
    add constraint fk_solution_block_task
        foreign key (task_id) references task (id);
