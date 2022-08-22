/*!40101 SET NAMES utf8mb4 */;
USE big_three;
-- ----------------------------
-- Records of articletype
-- ----------------------------
INSERT INTO `article_type`
VALUES ('1', '提问', 0, 0, NOW(), 0, NULL, NULL);
INSERT INTO `article_type`
VALUES ('2', '活动', 0, 0, NOW(), 0, NULL, NULL);
INSERT INTO `article_type`
VALUES ('3', '分享', 0, 0, NOW(), 0, NULL, NULL);
INSERT INTO `article_type`
VALUES ('4', '公告', 1, 0, NOW(), 0, NULL, NULL);

-- default admin
INSERT INTO user_info (id, email, nickname, password, head_url, city, sex, sign, kiss_num, experience, authority, active, active_code, last_sign, sign_days, reg_time, state, create_time, create_user, update_time, update_user)
VALUES (1, 'admin@qq.com', 'admin', '$2a$10$yMK04sMIMDOHakmMq/dU6e8htvw3k4WQcEXeWfkL9.6aNvIRce/QS', 'default.png', '火星', 0, '', 0, 0, 1, FALSE, NULL, NULL, 0, '2022-08-16 09:40:11', 0, '2022-08-16 09:40:02', 1, NULL, NULL);

