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
