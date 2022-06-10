-- init
-- 数据库
CREATE DATABASE IF NOT EXISTS big_three
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_zh_0900_as_cs;
-- 用户
CREATE USER IF NOT EXISTS big_three IDENTIFIED BY 'big_three';
-- 权限
GRANT ALL ON big_three.* TO big_three;