--liquibase formatted sql

--changeset Ilay:create-demo-user_profiles-table
--comment create table demo.user_profiles
create table demo.user_profiles
(
    id         integer primary key,
    nickname   varchar(32)  not null,
    image_link varchar(128) not null
);
--rollback drop table twitter.user_profiles;

--changeset Ilay:add-demo-user_profiles-table-constraints
--comment add constraints to demo.user_profiles table
alter table demo.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table demo.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table demo.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table demo.user_profiles drop constraint user_profiles__nickname__unique;