create database ruge_security;

-- auto-generated definition
create table sys_user
(
  user_id        int auto_increment
  comment '用户id'
    primary key,
  user_Name      varchar(255) null
  comment '用户名',
  pass_word      varchar(255) null
  comment '密码',
  user_Mobile    char(11)     null
  comment '手机号码',
  user_Status    char         null
  comment '状态  0：禁用   1：正常',
  user_Email     varchar(255) null
  comment '邮箱',
  create_User_Id varchar(255) null
  comment '创建人',
  create_Time    varchar(255) null
  comment '创建时间',
  constraint sys_user_user_id_uindex
  unique (user_id)
)
  comment '系统用户表';

