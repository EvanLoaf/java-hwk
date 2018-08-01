create table if not exists users(
  id bigint(19) auto_increment not null,
  email varchar(20) not null,
  password varchar(20) not null,
  first_name varchar(20) not null,
  last_name varchar(20) not null,
  primary key(id)
);