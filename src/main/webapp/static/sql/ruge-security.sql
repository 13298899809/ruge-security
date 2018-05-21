create database ruge_security;

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
  user_Birthday  varchar(255) null
  comment '用户生日',
  real_Name      varchar(255) null
  comment '真实姓名',
  user_Sex       char         null
  comment '用户性别',
  user_Motto     varchar(255) null
  comment '座右铭',
  constraint sys_user_user_id_uindex
  unique (user_id)
)
  comment '系统用户表';

  CREATE TABLE ruge_dictionary
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dic_code varchar(255) COMMENT '字典码',
    dic_value varchar(255) COMMENT '字典值',
    dic_type varchar(255) COMMENT '字典类别',
    dic_sort int COMMENT '字典排序',
    dic_pid int COMMENT '字典的父id',
    dic_des varchar(255) COMMENT '字典描述'
);
CREATE UNIQUE INDEX ruge_dictionary_id_uindex ON ruge_dictionary (id);
ALTER TABLE ruge_dictionary COMMENT = '字典表';

