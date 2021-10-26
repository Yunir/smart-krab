create table "krab_user" (
id bigserial not null primary key,
login varchar,
password varchar,
enabled boolean,
role varchar
);

create table "extra_coins" (
id bigserial not null primary key,
value integer,
added_at timestamp
);

create table "order_info" (
id bigserial not null primary key,
position varchar,
value integer,
status varchar,
added_at timestamp
);

create table "tool" (
id bigserial not null primary key,
name varchar,
status integer
);

INSERT into extra_coins (value, added_at) values (5, current_timestamp);
INSERT into extra_coins (value, added_at) values (1, current_timestamp);
INSERT into extra_coins (value, added_at) values (7, current_timestamp);
INSERT into extra_coins (value, added_at) values (2, current_timestamp);

insert into order_info (position, value, status, added_at) values ('Kraby Pattie', 5, 'registered', current_timestamp);

insert into krab_user (login, password, enabled, role)
VALUES ('krusty', '$2a$10$x8pNO8z3H584w4T9K4.g8eOM5vHn5dhPUbRdW3xpl45XWR4ejYD5S', true, 'ROLE_OWNER'); -- krab
insert into krab_user (login, password, enabled, role)
VALUES ('squid', '$2a$10$irUhcMVzLeIME.z9RGIfSO1.3CpbgQPuGANLjb7Wd0Cp0k/5fRoge', true, 'ROLE_CASHIER'); -- test
insert into krab_user (login, password, enabled, role)
VALUES ('bob', '$2a$10$uj0Xz2wG10k1NuKN6Z6Xs.ZFaoDuNrX6tFSg5Bs6q/jbOeIf3uLju', true, 'ROLE_CHEF'); -- chef
