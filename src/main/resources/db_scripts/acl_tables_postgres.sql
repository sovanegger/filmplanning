create table tb_filmprojects(
id bigint NOT NULL,
title character varying(255) NOT NULL,
screenplay text,
CONSTRAINT tb_filmprojects_pkey PRIMARY KEY (id));

CREATE TABLE tb_authorities
(

id bigint NOT NULL,

authority character varying(255) NOT NULL,

description text,

CONSTRAINT tb_authorities_pkey PRIMARY KEY (id)
);

create table acl_sid(
id bigserial not null primary key,
principal boolean not null,
sid varchar(100) not null,
constraint unique_uk_1 unique(sid,principal));

create table acl_class(
id bigserial not null primary key,
class varchar(100) not null,
constraint unique_uk_2 unique(class));

create table acl_object_identity(
id bigserial primary key,
object_id_class bigint not null,
object_id_identity bigint not null,
parent_object bigint,
owner_sid bigint,
entries_inheriting boolean not null,
constraint unique_uk_3 unique(object_id_class,object_id_identity),
constraint foreign_fk_1 foreign key(parent_object) references acl_object_identity(id),
constraint foreign_fk_2 foreign key(object_id_class) references acl_class(id),
constraint foreign_fk_3 foreign key(owner_sid) references acl_sid(id));

create table acl_entry(
id bigserial primary key,
acl_object_identity bigint not null,
ace_order int not null,
sid bigint not null,
mask integer not null,
granting boolean not null,
audit_success boolean not null,
audit_failure boolean not null,
constraint unique_uk_4 unique(acl_object_identity,ace_order),
constraint foreign_fk_4 foreign key(acl_object_identity)
references acl_object_identity(id),
constraint foreign_fk_5 foreign key(sid) references acl_sid(id));

create table acl_class_entry(
id bigserial primary key,
class bigint not null,
sid bigint not null,
filmproject_id bigint not null,
permission integer not null,
constraint foreign_fk_6 foreign key(class) references acl_class(id),
constraint foreign_fk_7 foreign key(sid) references acl_sid(id),
constraint foreign_fk_8 foreign key(filmproject_id) references tb_filmprojects(id));

INSERT INTO tb_authorities(id, authority, description)
    VALUES (1, 'ROLE_ADMIN', '');
INSERT INTO tb_authorities(id, authority, description)
    VALUES (2, 'ROLE_USER', '');