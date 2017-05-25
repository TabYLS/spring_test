/*
Navicat MySQL Data Transfer

Source Server         : YLS
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : springjdbc

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-05-25 20:53:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jdbcgroup
-- ----------------------------
DROP TABLE IF EXISTS `jdbcgroup`;
CREATE TABLE `jdbcgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of jdbcgroup
-- ----------------------------
INSERT INTO `jdbcgroup` VALUES ('1', '管理员组');
INSERT INTO `jdbcgroup` VALUES ('3', '文章发布员');
INSERT INTO `jdbcgroup` VALUES ('4', '文章发布员');
INSERT INTO `jdbcgroup` VALUES ('5', '文章发布员');
INSERT INTO `jdbcgroup` VALUES ('6', '文章发布员');
INSERT INTO `jdbcgroup` VALUES ('7', '执法者');
INSERT INTO `jdbcgroup` VALUES ('8', '执法者');
INSERT INTO `jdbcgroup` VALUES ('9', '执法者');

-- ----------------------------
-- Table structure for jdbcuser
-- ----------------------------
DROP TABLE IF EXISTS `jdbcuser`;
CREATE TABLE `jdbcuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(2) NOT NULL,
  `descn` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gid` int(11) DEFAULT NULL COMMENT '分组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of jdbcuser
-- ----------------------------
INSERT INTO `jdbcuser` VALUES ('4', 'yls1', 'yls1', '1', '特级管理员', null);
INSERT INTO `jdbcuser` VALUES ('6', 'yls', 'yls', '1', '特级管理员', null);
INSERT INTO `jdbcuser` VALUES ('7', 'yls', 'yls', '1', '特级管理员', null);
INSERT INTO `jdbcuser` VALUES ('8', 'yls', 'yls', '1', '特级管理员', null);
INSERT INTO `jdbcuser` VALUES ('9', '悟空', '123456', '1', '特技员', '6');
INSERT INTO `jdbcuser` VALUES ('10', '悟空', '123456', '1', '特技员', '7');
INSERT INTO `jdbcuser` VALUES ('11', '悟空', '123456', '1', '特技员', '8');
INSERT INTO `jdbcuser` VALUES ('12', '悟空', '123456', '1', '特技员', '9');
