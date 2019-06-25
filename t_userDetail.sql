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

 Date: 25/06/2019 23:19:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_userDetail
-- ----------------------------
DROP TABLE IF EXISTS `t_userDetail`;
CREATE TABLE `t_userDetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `headImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `t_userDetail_userId_uindex`(`userId`) USING BTREE,
  CONSTRAINT `t_userDetail_t_user_u_id_fk` FOREIGN KEY (`userId`) REFERENCES `t_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_userDetail
-- ----------------------------
INSERT INTO `t_userDetail` VALUES (2, NULL, NULL, 'http://192.168.43.87:8080/home-decorationPic/1560174463018.jpg', 1, NULL);
INSERT INTO `t_userDetail` VALUES (3, NULL, NULL, 'http://192.168.43.87:8080/home-decorationPic/1560308358495.jpg', 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
