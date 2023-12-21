--liquibase formatted sql

--changeset Ilay:create-demo-subscriptions-table
--comment create table demo.subscriptions
create table demo.subscriptions
(
    id                 serial primary key,
    follower_id        integer   not null,
    followed_id        integer   not null,
    created_timestamp  timestamp not null
);
--rollback drop table demo.subscriptions;

--changeset Ilay:add-demo-subscriptions-table-constraints
--comment add constraints to demo.subscriptions table
alter table demo.subscriptions
    add constraint follower__user_profiles__fk
        foreign key (follower_id) references demo.user_profiles (id);

alter table demo.subscriptions
    add constraint followed__user_profiles__fk
        foreign key (followed_id) references demo.user_profiles (id);

alter table demo.subscriptions
    add constraint subscriptions__relationship__unique
        unique (follower_id, followed_id);
--rollback alter table demo.subscriptions drop constraint follower__user_profiles__fk;
--rollback alter table demo.subscriptions drop constraint followed__user_profiles__fk;
--rollback alter table demo.subscriptions drop constraint subscriptions__relationship__unique;
