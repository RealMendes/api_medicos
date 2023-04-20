alter table medicos add inativo boolean;
update medicos set inativo = false;
alter table medicos modify inativo boolean not null;