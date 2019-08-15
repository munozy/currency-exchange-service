--liquibase formatted sql

--changeset munozy:1
create sequence currency_exchange_service.seq_exchange start 1000 increment 1;
create table currency_exchange_service.exchange (
    id int8 not null,
    source char(3) not null,
    target char(3) not null,
    conversion numeric not null
);
ALTER TABLE currency_exchange_service.exchange ADD CONSTRAINT constraint_unique_exchange_source_target UNIQUE (source, target);
insert into currency_exchange_service.exchange (id, source, target, conversion) values (1000, 'USD', 'EUR', 2);
--rollback DROP SEQUENCE currency_exchange_service.seq_exchange;
--rollback DROP TABLE currency_exchange_service.exchange;