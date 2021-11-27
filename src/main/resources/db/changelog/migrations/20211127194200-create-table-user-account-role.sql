--liquibase formatted sql
--changeset monjasa:20211127194200-01

create table user_account_role
(
    user_account_id bigint,
    role_id         bigint,
    constraint pk_user_account_role primary key (user_account_id, role_id)
);

alter table user_account_role
    add constraint fk_user_account_role_user_account
        foreign key (user_account_id) references user_account (id);

alter table user_account_role
    add constraint fk_user_account_role_role
        foreign key (role_id) references role (id);
