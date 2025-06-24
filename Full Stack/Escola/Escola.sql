create database EscolaDB COLLATE=utf8_general_ci;

use EscolaDB;

create table cursos ( id int not null primary key AUTO_INCREMENT,
                      nome varchar(50) );

create table classes ( id int not null primary key AUTO_INCREMENT,
                       nome varchar(80),
                       curso_id int );
                       
alter table classes add constraint fk_cursos foreign key (curso_id) references cursos (id);


insert into cursos (nome) values ("Analise e Desenvolvimento de Sistemas" );
insert into cursos (nome) values ("Pedagogia" );
insert into cursos (nome) values ("Engenharia Elétrica" );
insert into cursos (nome) values ("Nutrição" );

insert into classes (nome, curso_id) values ("1º sem. TADS", 1);
insert into classes (nome, curso_id) values ("3º sem. TADS", 1);
insert into classes (nome, curso_id) values ("1º sem. Pedagogia", 2);
insert into classes (nome, curso_id) values ("3º sem. Pedagogia", 2);
insert into classes (nome, curso_id) values ("1º sem. Eletrica", 3);
insert into classes (nome, curso_id) values ("3º sem. Eletrica", 3);
insert into classes (nome, curso_id) values ("5º sem. Eletrica", 3);
insert into classes (nome, curso_id) values ("1º sem. Nutrição", 4);
insert into classes (nome, curso_id) values ("3º sem. Nutrição", 4);
