/*
 Navicat Premium Data Transfer

 Source Server         : tencent_mysql57
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-8ya7frpq.bj.tencentcdb.com:10017
 Source Schema         : HomeDecoration

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 25/06/2019 23:18:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_reserveDecoration
-- ----------------------------
DROP TABLE IF EXISTS `t_reserveDecoration`;
CREATE TABLE `t_reserveDecoration`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_realname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `r_tel` bigint(12) NOT NULL,
  `r_isDone` tinyint(1) NOT NULL DEFAULT 0,
  `r_userId` int(11) NOT NULL,
  `r_reserveDate` date NOT NULL,
  PRIMARY KEY (`r_id`) USING BTREE,
  INDEX `r_userId`(`r_userId`) USING BTREE,
  CONSTRAINT `t_reserveDecoration_ibfk_1` FOREIGN KEY (`r_userId`) REFERENCES `t_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约装修' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_reserveDecoration
-- ----------------------------
INSERT INTO `t_reserveDecoration` VALUES (4, '郑先生', 13259499373, 1, 1, '2019-05-23');
INSERT INTO `t_reserveDecoration` VALUES (5, '封女士', 13259499372, 1, 1, '2019-05-24');
INSERT INTO `t_reserveDecoration` VALUES (6, 'ceshi', 13259493375, 0, 1, '2019-05-24');
INSERT INTO `t_reserveDecoration` VALUES (7, '井先生', 13859499375, 0, 1, '2019-05-29');
INSERT INTO `t_reserveDecoration` VALUES (8, '贾女士', 13259499314, 0, 1, '2019-06-10');
INSERT INTO `t_reserveDecoration` VALUES (9, '哈老师', 13259499475, 1, 1, '2019-06-12');

SET FOREIGN_KEY_CHECKS = 1;
