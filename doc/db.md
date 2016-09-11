###数据库建表语句
```
CREATE TABLE `subscribe_user_info` (
  `uid` bigint(20) NOT NULL COMMENT '用户UID',
  `idol_uid` bigint(20) NOT NULL COMMENT '关注UID',
  `add_time` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`uid`,`idol_uid`),
  KEY `idx_idol_uid` (`idol_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

```
###初始数据 SQL
```
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('1','7626c20e-2173-4bc2-be7d-dea7c6ee6c7b','JosonLiu','华南师范','25');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('2','9c49884c-a360-4e7d-b9d2-5d8a8203db46','JosonLiu','华南师范','25');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('3','774d7f83-38cc-4131-8788-6a3e8e8a2125','record1','中山大学','26');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('4','2f770361-ba5a-428d-8af2-06098a920bad','record2','中山大学','26');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('5','ecc4eaea-98c2-4e24-b2ba-3ae49f1c8841','JosonLiu','华南师范','25');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('6','cdb432d1-8304-4695-a831-5ae1c787c75a','record1','中山大学','26');
insert into `user` (`id`, `user_id`, `user_name`, `user_school`, `user_age`) values('7','70982f76-2547-4e29-b74f-7cece2fddf4d','record2','中山大学','26')

```