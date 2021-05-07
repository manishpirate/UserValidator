insert into USER_TBL(email_id, password, user_name) values ('abc@abc.com', '$2a$12$T40It.tMzC2WdEW.fQCrxOeiw2C9kVfM19hXGf1U5Hf/XU2yUo0tC','user');
insert into USER_TBL(email_id, password, user_name) values ('abc1@abc.com', '$2a$12$h8VgLLVMquTrqh4HOC.KvOyjeB1YJ1AZaWXzOcIdKfM.WcvNVcuny','user1');
insert into USER_TBL(email_id, password, user_name) values ('abc2@abc.com', '$2a$12$h8VgLLVMquTrqh4HOC.KvOyjeB1YJ1AZaWXzOcIdKfM.WcvNVcuny','user2');

insert into user_role (role_name, user_id) values ('ROLE_ADMIN', 1);
insert into user_role (role_name, user_id) values ('ROLE_USER', 1);
insert into user_role (role_name, user_id) values ('ROLE_USER', 2);
insert into user_role (role_name, user_id) values ('ROLE_USER', 2);