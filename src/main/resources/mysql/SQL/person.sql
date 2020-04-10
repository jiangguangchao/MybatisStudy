drop table if exists person;

create table person(
    ID int(11) not null primary key auto_increment comment "身份证号",
    last_name varchar(60) comment "姓名",
    gender int(1) comment "性别 0：男    1：女",
    addr varchar(255) comment "地址"
);

--下面这两条sql修改字段会报错。
--alter table person modify column ID comment "编号";
--alter table person modify column ID int(11) not null primary key auto_increment comment "编号";

--下面这条修改是正确的
alter table person modify column
    ID int(11) not null auto_increment comment "编号";


insert into person(
    last_name, gender, addr
) values(
    "郭靖", 0, "桃花岛"
) ;

insert into person(
    last_name, gender, addr
) values(
    "黄蓉", 1, "桃花岛"
) ;
