CREATE TABLE IF NOT EXISTS `user`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(20) NOT NULL UNIQUE COMMENT '用户名',
    `password`    varchar(50) NOT NULL COMMENT '密码',
    `age`         int(2)      NOT NULL COMMENT '年龄',
    `gender`      varchar(10) NOT NULL COMMENT '性别',
    `creater`     varchar(20)          DEFAULT NULL COMMENT '创建人',
    `modifier`    varchar(20)          DEFAULT NULL COMMENT '更新人',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime    NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `index_gender` (`gender`) USING BTREE COMMENT '性别'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;