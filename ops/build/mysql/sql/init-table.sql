-- 创建表
USE big_three;

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for articleinfo
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info`
(
    `id`               BIGINT       NOT NULL COMMENT '主键',
    `title`            VARCHAR(200) NOT NULL COMMENT '文章标题',
    `author_id`        BIGINT       NOT NULL COMMENT '作者id,对应user_info中的id',
    `release_time`     DATETIME     NOT NULL DEFAULT NOW() COMMENT '发布时间',
    `type_id`          BIGINT       NOT NULL COMMENT '文章类型id,对应article_type中的id',
    `visit_num`        BIGINT       NOT NULL DEFAULT 0 COMMENT '文章浏览量',
    `comment_num`      INT          NOT NULL DEFAULT 0 COMMENT '文章评论量',
    `pay_kiss`         INT          NOT NULL DEFAULT 0 COMMENT '悬赏飞吻数',
    `cream`            INT(1)       NOT NULL DEFAULT 0 COMMENT '是否是精华帖,0代表不是,1代表是',
    `stick`            INT(1)       NOT NULL DEFAULT 0 COMMENT '是否是置顶帖,0代表不是,1代表是',
    `is_done`          INT(1)       NOT NULL DEFAULT 0 COMMENT '是否是否结帖,0代表不是,1代表是',
    `markdown_content` LONGTEXT COMMENT '文章内容',
    `html_content`     LONGTEXT COMMENT '文章内容',
    `state`            INT(1)       NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time`      DATETIME     NOT NULL,
    `create_user`      BIGINT       NOT NULL,
    `update_time`      DATETIME     NULL,
    `update_user`      BIGINT       NULL,
    PRIMARY KEY (`id`),
    -- 外键
    FOREIGN KEY (author_id) REFERENCES user_info (id),
    FOREIGN KEY (type_id) REFERENCES article_type (id)
) ENGINE = InnoDB;
-- 索引
CREATE INDEX `idx_article_info_author_id` ON `article_info` (`author_id`);

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type`
(
    `id`          BIGINT       NOT NULL COMMENT '主键',
    `typename`    VARCHAR(100) NOT NULL COMMENT '类型名',
    `power`       INT(1)       NOT NULL DEFAULT 0 COMMENT '0为普通用户可以获取权限,1为管理员独享权限',
    `state`       INT(1)       NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time` DATETIME     NOT NULL,
    `create_user` BIGINT       NOT NULL,
    `update_time` DATETIME     NULL,
    `update_user` BIGINT       NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- ----------------------------
-- Table structure for collection_info
-- ----------------------------
DROP TABLE IF EXISTS `collection_info`;
CREATE TABLE `collection_info`
(
    `id`              BIGINT   NOT NULL COMMENT '主键',
    `collection_id`   BIGINT   NOT NULL COMMENT 'user id',
    `article_id`      BIGINT   NOT NULL COMMENT '收藏文章id',
    `collection_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '收藏时间',
    `state`           INT(1)   NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time`     DATETIME NOT NULL,
    `create_user`     BIGINT   NOT NULL,
    `update_time`     DATETIME NULL,
    `update_user`     BIGINT   NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
-- 索引
CREATE INDEX `idx_collection_info_collection_id` ON `collection_info` (`collection_id`);

-- ----------------------------
-- Table structure for comment_info
-- ----------------------------
DROP TABLE IF EXISTS `comment_info`;
CREATE TABLE `comment_info`
(
    `id`            BIGINT   NOT NULL COMMENT '主键',
    `author_id`     BIGINT   NOT NULL COMMENT '评论者id,对应user_info中的id',
    `release_time`  DATETIME NOT NULL DEFAULT NOW() COMMENT '发布时间',
    `comm_content`  LONGTEXT COMMENT '文章内容',
    `article_id`    BIGINT   NOT NULL COMMENT '评论的文章id',
    `praise_points` INT(9)   NOT NULL DEFAULT 0 COMMENT '被点赞的数量',
    `is_accept`     INT(1)   NOT NULL DEFAULT 0 COMMENT '是否被采纳,0代表未被采纳,1代表已经被采纳',
    `state`         INT(1)   NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time`   DATETIME NOT NULL,
    `create_user`   BIGINT   NOT NULL,
    `update_time`   DATETIME NULL,
    `update_user`   BIGINT   NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info`
(
    `id`           BIGINT   NOT NULL,
    `message_type` INT(1)   NOT NULL COMMENT '0代表系统消息;1代表评论消息;2代表点赞消息;3代表采纳评论;4代表管理员公告通知',
    `userid_to`    BIGINT   NOT NULL COMMENT '接受消息的用户id',
    `userid_from`  BIGINT            DEFAULT NULL COMMENT '发出消息的用户id',
    `art_id`       INT(11)           DEFAULT NULL COMMENT '相关文章id',
    `comment_id`   INT(11)           DEFAULT NULL COMMENT '相关评论id',
    `read`         INT(1)   NOT NULL DEFAULT 0 COMMENT '0 未读,1 已读',
    `state`        INT(1)   NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time`  DATETIME NOT NULL,
    `create_user`  BIGINT   NOT NULL,
    `update_time`  DATETIME NULL,
    `update_user`  BIGINT   NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
-- 索引
CREATE INDEX `idx_message_info_userid_to` ON `message_info` (`userid_to`);

-- ----------------------------
-- Table structure for praise_info
-- ----------------------------
DROP TABLE IF EXISTS `praise_info`;
CREATE TABLE `praise_info`
(
    `id`          BIGINT   NOT NULL,
    `userid`      BIGINT   NOT NULL COMMENT '点赞者id',
    `comment_id`  BIGINT   NOT NULL COMMENT '评论id',
    `state`       INT(1)   NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time` DATETIME NOT NULL,
    `create_user` BIGINT   NOT NULL,
    `update_time` DATETIME NULL,
    `update_user` BIGINT   NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `email`       VARCHAR(100) NOT NULL COMMENT '邮箱地址',
    `nickname`    VARCHAR(50)  NOT NULL COMMENT '用户昵称',
    `password`    VARCHAR(200) NOT NULL COMMENT '用户密码',
    `head_url`    VARCHAR(500) NOT NULL DEFAULT 'default.png' COMMENT '头像地址',
    `city`        VARCHAR(50)  NOT NULL DEFAULT '火星' COMMENT '居住城市',
    `sex`         INT(1)       NOT NULL DEFAULT 0 COMMENT '性别0 男 1 女',
    `sign`        VARCHAR(200) NOT NULL DEFAULT '' COMMENT '个人签名',
    `kiss_num`    INT(9)       NOT NULL DEFAULT 0 COMMENT '飞吻数',
    `experience`  INT(9)       NOT NULL DEFAULT 0 COMMENT '经验值，发帖回帖涨经验值',
    `authority`   INT(1)       NOT NULL DEFAULT 0 COMMENT '用户权限 0 代表普通用户，1代表管理员',
    `active`      BIT(1)                DEFAULT b'0' COMMENT '0未激活,1为已经激活',
    `active_code` VARCHAR(200)          DEFAULT NULL,
    `last_sign`   DATE                  DEFAULT NULL COMMENT '上一次签到天数',
    `sign_days`   INT(11)      NOT NULL DEFAULT 0 COMMENT '连续签到天数',
    `reg_time`    DATETIME     NOT NULL DEFAULT NOW() COMMENT '注册时间',
    `state`       INT(1)       NOT NULL DEFAULT 0 COMMENT '0代表存在,1代表已经被删除',
    `create_time` DATETIME     NOT NULL,
    `create_user` BIGINT       NOT NULL,
    `update_time` DATETIME     NULL,
    `update_user` BIGINT       NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;