--liquibase formatted sql

--changeset Ilay:create-demo-tweets-table
--comment create table demo.tweets
create table demo.tweets
(
    id                 serial primary key,
    message            varchar(180) not null,
    user_profile_id    integer      not null,
    created_timestamp  timestamp    not null
);
--rollback drop ta  ble twitter.tweets;

--changeset Ilay:add-twitter-user_profiles-table-constraints
--comment add constraints to demo.tweets table
alter table demo.tweets
    add constraint tweets__user_profiles__fk
        foreign key (user_profile_id) references twitter.user_profiles (id);

--rollback alter table demo.tweets drop constraint tweets__user_profiles__fk;


--changeset Ilay:add-demo-user_profiles-table-column-modified_timestamp
--comment add column modified_timestamp to demo.tweets table
alter table demo.tweets
    add column modified_timestamp timestamp;

update demo.tweets
set modified_timestamp = created_timestamp
where modified_timestamp is null;

alter table demo.tweets
    alter column modified_timestamp set not null;
--rollback alter table demo.tweets drop column modified_timestamp;
