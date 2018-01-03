/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : suyu

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-12-11 10:03:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `content` text,
  `lid` tinyint(3) unsigned DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `readcount` int(11) DEFAULT NULL,
  `comment` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='博客';

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'java基础', 'java jdk', 'xxxxxx', '1', '2017-12-07 10:53:43', '2017-12-07 10:53:45', '666', '6');
INSERT INTO `blog` VALUES ('2', 'git基础', 'git status git add git commit', 'xxxxx', '2', '2017-12-07 10:54:04', '2017-12-07 10:54:06', '8888', '8');
INSERT INTO `blog` VALUES ('3', 'maven', 'mvn clean install', 'mavne报错解决', '3', '2017-12-07 10:54:29', '2017-12-07 10:54:32', '9999', '77');
INSERT INTO `blog` VALUES ('4', 'vue.js入门', 'vue init webpack', 'xxxxxxx', '4', '2017-12-07 10:54:53', '2017-12-07 10:54:56', '6666', '88');
INSERT INTO `blog` VALUES ('5', 'js  document', 'document.getelementbyid(1)', 'xxxxx', '5', '2017-12-07 10:55:21', '2017-12-07 10:55:23', '66666', '99');
INSERT INTO `blog` VALUES ('6', 'java进阶', 'java  edk', 'xxxx', '1', '2017-12-07 11:20:10', '2017-12-07 11:20:12', '8888', '9');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) unsigned DEFAULT NULL COMMENT '评论用户编号',
  `bid` bigint(20) unsigned DEFAULT NULL COMMENT '博客编号',
  `content` text COMMENT '内容',
  `commentTime` datetime DEFAULT NULL COMMENT '评论时间',
  `state` tinyint(3) unsigned DEFAULT '0' COMMENT '状态：0.通过 1.不通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `labelName` varchar(45) DEFAULT NULL COMMENT '标签名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `state` tinyint(3) unsigned DEFAULT '0' COMMENT '标签状态 0. 使用 1.未使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', 'java', '2017-12-07 10:20:36', '2017-12-07 10:20:39', '0');
INSERT INTO `label` VALUES ('2', 'git', '2017-12-07 10:20:57', '2017-12-07 10:21:01', '0');
INSERT INTO `label` VALUES ('3', 'maven', '2017-12-07 10:21:13', '2017-12-07 10:21:17', '0');
INSERT INTO `label` VALUES ('4', 'vue', '2017-12-07 10:21:47', '2017-12-07 10:21:50', '0');
INSERT INTO `label` VALUES ('5', 'js', '2017-12-07 10:22:00', '2017-12-07 10:22:02', '0');

-- ----------------------------
-- Table structure for `reply_comments`
-- ----------------------------
DROP TABLE IF EXISTS `reply_comments`;
CREATE TABLE `reply_comments` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) unsigned DEFAULT NULL COMMENT '回复用户编号',
  `cid` bigint(20) unsigned DEFAULT NULL COMMENT '评论编号',
  `content` text COMMENT '内容',
  `replyTime` datetime DEFAULT NULL COMMENT '回复时间',
  `state` tinyint(3) unsigned DEFAULT '0' COMMENT '状态 ：0.通过 1.未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复评论表';

-- ----------------------------
-- Records of reply_comments
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` tinyint(3) unsigned DEFAULT NULL COMMENT '用户状态:0.正常1.冻结',
  `headImage` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `wechart` varchar(45) DEFAULT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '苏雨丶', '123456', '1', 'http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com/person/img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20171208103122.jpg', '2017-11-07 20:27:40', '2017-11-07 20:27:44', '2017-11-07 20:27:46', 'nzlsgg@163.com', '15900610143', 'nzl9595');
INSERT INTO `user` VALUES ('2', '11', '123456', '1', 'http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com/person/img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20171208103122.jpg', '2017-12-08 14:37:01', '2017-12-08 14:37:04', '2017-12-08 14:37:06', '111', '18720535212', '1234');
INSERT INTO `user` VALUES ('3', '22', '123456', '1', 'http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com/person/img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20171208103122.jpg', '2017-12-08 14:37:36', '2017-12-08 14:37:39', '2017-12-08 14:37:41', '222', '18720535202', '45698');

-- ----------------------------
-- Table structure for `user_blog`
-- ----------------------------
DROP TABLE IF EXISTS `user_blog`;
CREATE TABLE `user_blog` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `bid` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '博客编号',
  `isTop` tinyint(3) unsigned DEFAULT NULL COMMENT '是否置顶 0.否 1.指顶',
  `type` tinyint(1) DEFAULT NULL COMMENT '0 新\r\n1.热',
  PRIMARY KEY (`uid`,`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户博客中间表';

-- ----------------------------
-- Records of user_blog
-- ----------------------------
INSERT INTO `user_blog` VALUES ('1', '1', '0', '0');
INSERT INTO `user_blog` VALUES ('1', '2', '0', '1');
INSERT INTO `user_blog` VALUES ('1', '3', '0', '0');
INSERT INTO `user_blog` VALUES ('1', '4', '0', '1');
INSERT INTO `user_blog` VALUES ('1', '5', '0', '1');
INSERT INTO `user_blog` VALUES ('1', '6', '0', '0');

-- ----------------------------
-- Table structure for `user_browse`
-- ----------------------------
DROP TABLE IF EXISTS `user_browse`;
CREATE TABLE `user_browse` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) unsigned DEFAULT NULL COMMENT '用户编号',
  `bid` bigint(20) unsigned DEFAULT NULL COMMENT '博客编号',
  `viewTime` varchar(45) DEFAULT NULL COMMENT '浏览时间',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `duringTime` int(10) unsigned DEFAULT NULL COMMENT '浏览时间长',
  `count` int(10) unsigned DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户浏览表';

-- ----------------------------
-- Records of user_browse
-- ----------------------------
INSERT INTO `user_browse` VALUES ('1', '2', '1', '22', '127.0.0.1', '22', '2');
INSERT INTO `user_browse` VALUES ('2', '2', '2', '22', '127.0.0.1', '23', '1');
INSERT INTO `user_browse` VALUES ('3', '3', '1', '33', '127.0.0.1', '12', '2');
INSERT INTO `user_browse` VALUES ('4', '2', '3', '10', '127.0.0.1', '31', '2');
INSERT INTO `user_browse` VALUES ('5', '3', '4', '20', '127.0.0.1', '222', '4');
INSERT INTO `user_browse` VALUES ('6', '3', '5', '54', '127.0.0.1', '22', '3');
