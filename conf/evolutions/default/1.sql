# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table creation (
  id                        varchar(255) not null,
  name                      varchar(255),
  desc                      varchar(255),
  constraint pk_creation primary key (id))
;

create table creation_set (
  id                        varchar(255) not null,
  name                      varchar(255),
  desc                      varchar(255),
  constraint pk_creation_set primary key (id))
;

create table image (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_image primary key (id))
;

create table task (
  id                        varchar(255) not null,
  contents                  varchar(255),
  constraint pk_task primary key (id))
;

create sequence creation_seq;

create sequence creation_set_seq;

create sequence image_seq;

create sequence task_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists creation;

drop table if exists creation_set;

drop table if exists image;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists creation_seq;

drop sequence if exists creation_set_seq;

drop sequence if exists image_seq;

drop sequence if exists task_seq;

