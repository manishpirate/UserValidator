
create table USER_TBL (id bigint AUTO_INCREMENT PRIMARY KEY, email_id varchar(255), password varchar(255), user_name varchar(255));
create table user_role (id bigint AUTO_INCREMENT PRIMARY KEY, role_name varchar(255), user_id bigint);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references USER_TBL;