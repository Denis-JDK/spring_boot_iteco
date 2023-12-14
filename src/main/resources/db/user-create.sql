create schema ad;

create sequence ad.users_id_seq;

create table ad.users (
 id integer unique not null default nextval('ad.users_id_seq'),
 names varchar not null,
 email varchar
);