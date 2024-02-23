CREATE DATABASE webloader CHARACTER SET utf8 COLLATE utf8_general_ci;
use webloader;
CREATE TABLE user
(
    id   int(11) NOT NULL AUTO_INCREMENT,
    name varchar(20),
    age  int(11),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用户表';


CREATE TABLE book
(
    id      int(11) NOT NULL AUTO_INCREMENT,
    user_id int(11)     DEFAULT NULL,
    name    varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='书籍表';



alter table user
    add uuid varchar(255) default '' not null;

create unique index user_uuid_uindex
    on user (uuid);


alter table book
    add uuid varchar(255) default '' not null;

create unique index book_uuid_uindex
    on book (uuid);

alter table `user`
    convert to character set gbk collate gbk_chinese_ci;
alter table `book`
    convert to character set gbk collate gbk_chinese_ci;
