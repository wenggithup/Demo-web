"# Demo-web" 
# 创建表语句
    1、创建数据库
        create database bagevent_test;
        use bagevent_test
    2、创建User表
        CREATE TABLE `user` (
          `user_id` int(11) NOT NULL AUTO_INCREMENT,
          `user_name` varchar(255) NOT NULL,
          `email` varchar(255) DEFAULT NULL,
          `cellphone` bigint(20) DEFAULT NULL,
          `password` varchar(255) NOT NULL,
          `salt` varchar(255) DEFAULT NULL,
          `state` int(11) NOT NULL DEFAULT '1',
          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          PRIMARY KEY (`user_id`),
          UNIQUE KEY `username` (`user_name`)
        ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

    3、创建userloginlog表
        CREATE TABLE `userloginlog` (
          `login_id` int(11) NOT NULL AUTO_INCREMENT,
          `user_id` int(11) NOT NULL,
          `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          `login_ip` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`login_id`),
          KEY `UserLoginLog-User-fk` (`user_id`),
          CONSTRAINT `UserLoginLog-User-fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8