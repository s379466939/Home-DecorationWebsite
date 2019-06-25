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

 Date: 25/06/2019 23:18:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_contract
-- ----------------------------
DROP TABLE IF EXISTS `t_contract`;
CREATE TABLE `t_contract`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_userId` int(11) DEFAULT NULL,
  `c_userName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_merchant` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_contractContent` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_houseLocation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_houseDescription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_constructionTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_contractState` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `c_userId`(`c_userId`) USING BTREE,
  CONSTRAINT `t_contract_ibfk_1` FOREIGN KEY (`c_userId`) REFERENCES `t_user` (`u_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修合同' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_contract
-- ----------------------------
INSERT INTO `t_contract` VALUES (1, 1, '郑先生', '逸馨家装公司', '室内装修', '西安市春天花园校区1栋101', '三室一厅', '2019-5-25 至 2019-10-25', 0);
INSERT INTO `t_contract` VALUES (2, 1, '封女士', '逸馨家装公司', '室内装修', '西安市春天花园校区1栋102', '三室一厅', '2019-5-25 至 2019-10-25', 1);

SET FOREIGN_KEY_CHECKS = 1;
