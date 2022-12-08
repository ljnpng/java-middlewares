insert into clue (clue_title, clue_code, clue_status, create_time, create_user)
values ('测试1', 'CODE-1', 1, now(), 1);
insert into clue (clue_title, clue_code, clue_status, create_time, create_user)
values ('测试1', 'CODE-2', 2, now(), 1);
insert into clue (clue_title, clue_code, clue_status, create_time, create_user)
values ('测试1', 'CODE-3', 3, now(), 1);
insert into clue (clue_title, clue_code, clue_status, create_time, create_user)
values ('测试1', 'CODE-4', 4, now(), 1);

insert into accept_user (user_id, status, create_time, clue_id)
values (12, 1, now(), 1);
insert into accept_user (user_id, status, create_time, clue_id)
values (13, 1, now(), 1);
insert into accept_user (user_id, status, create_time, clue_id)
values (14, 1, now(), 1);
insert into accept_user (user_id, status, create_time, clue_id)
values (15, 1, now(), 1);
insert into accept_user (user_id, status, create_time, clue_id)
values (16, 1, now(), 1);
insert into accept_user (user_id, status, create_time, clue_id)
values (17, 1, now(), 1);


select *
from accept_user;