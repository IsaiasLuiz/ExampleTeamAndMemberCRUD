create table team(id_team integer, name varchar(255),  created_at Date, updated_at date, primary key(id_team));

create table member(id_member integer not null, name varchar(255), created_at date, updated_at date, id_team integer, primary key(id_member), foreign key(id_team) references team(id_team));