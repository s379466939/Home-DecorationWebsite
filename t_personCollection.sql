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

 Date: 25/06/2019 23:18:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_personCollection
-- ----------------------------
DROP TABLE IF EXISTS `t_personCollection`;
CREATE TABLE `t_personCollection`  (
  `galleryDesignId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  INDEX `galleryDesignId`(`galleryDesignId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `t_personCollection_ibfk_1` FOREIGN KEY (`galleryDesignId`) REFERENCES `t_galleryDesign` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_personCollection_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
