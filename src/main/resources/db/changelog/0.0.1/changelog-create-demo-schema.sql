--liquibase formatted sql

--changeset Ilay:create-demo-schema
--comment create new schema
create schema demo;
--rollback drop schema demo;
