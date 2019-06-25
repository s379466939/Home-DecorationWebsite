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

 Date: 25/06/2019 23:19:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `t_user_u_account_uindex`(`u_account`) USING BTREE,
  INDEX `u_role`(`u_role`) USING BTREE,
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`u_role`) REFERENCES `t_role` (`r_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'devin', '123456', 'devin', 1);
INSERT INTO `t_user` VALUES (2, 'danfeng', '123456', 'danfeng', 2);
INSERT INTO `t_user` VALUES (3, '111111', '111111', '11111', 2);
INSERT INTO `t_user` VALUES (4, 'abcdef', '123456', 'abcdef', 1);

SET FOREIGN_KEY_CHECKS = 1;
