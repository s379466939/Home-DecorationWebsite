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

 Date: 25/06/2019 23:18:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_galleryDesign
-- ----------------------------
DROP TABLE IF EXISTS `t_galleryDesign`;
CREATE TABLE `t_galleryDesign`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `g_community` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `g_picUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `g_houseType` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `g_area` float NOT NULL,
  `g_cost` float NOT NULL,
  `g_style` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类案例图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_galleryDesign
-- ----------------------------
INSERT INTO `t_galleryDesign` VALUES (30, '枫林意树', 'http://192.168.43.87:8080/home-decorationPic/1560235835050.jpg', '二居室', 150, 8, '欧式');
INSERT INTO `t_galleryDesign` VALUES (31, '紫薇田园都市', 'http://192.168.43.87:8080/home-decorationPic/1560236093413.jpg', '二居室', 110, 8, '简约');
INSERT INTO `t_galleryDesign` VALUES (32, '开元第一城', 'http://192.168.43.87:8080/home-decorationPic/1560236358562.jpg', '一居室', 110, 8, '欧式');
INSERT INTO `t_galleryDesign` VALUES (33, '缤纷南郡', 'http://192.168.43.87:8080/home-decorationPic/1560236625775.jpg', '三居室', 120, 8, '意大利');
INSERT INTO `t_galleryDesign` VALUES (34, '紫薇田园都市', 'http://192.168.43.87:8080/home-decorationPic/1560237271918.jpg', '二居室', 120, 8, '简约');
INSERT INTO `t_galleryDesign` VALUES (35, '万科金域曲江', 'http://192.168.43.87:8080/home-decorationPic/1560237360607.jpg', '四居室', 180, 8, '简约');
INSERT INTO `t_galleryDesign` VALUES (36, '紫薇曲江意境', 'http://192.168.43.87:8080/home-decorationPic/1560237430574.jpg', '二居室', 158, 8, '欧式');
INSERT INTO `t_galleryDesign` VALUES (37, '中海凯旋门', 'http://192.168.43.87:8080/home-decorationPic/1560237519106.jpg', '三居室', 118, 8, '美式');
INSERT INTO `t_galleryDesign` VALUES (38, '紫薇·花园洲', 'http://192.168.43.87:8080/home-decorationPic/1560237596111.jpg', '二居室', 88, 7.5, '简约');
INSERT INTO `t_galleryDesign` VALUES (39, '嘉园蓝湖九郡', 'http://192.168.43.87:8080/home-decorationPic/1560237696730.jpg', '三居室', 110, 8, '中式');
INSERT INTO `t_galleryDesign` VALUES (40, '天朗蓝湖树', 'http://192.168.43.87:8080/home-decorationPic/1560237803789.JPG', '三居室', 107, 8, '田园');
INSERT INTO `t_galleryDesign` VALUES (41, '林奥嘉园', 'http://192.168.43.87:8080/home-decorationPic/1560237951288.JPG', '二居室', 103, 8, '地中海');
INSERT INTO `t_galleryDesign` VALUES (42, '公园大道', 'http://192.168.43.87:8080/home-decorationPic/1560238077104.jpg', '二居室', 105, 8, '北欧');
INSERT INTO `t_galleryDesign` VALUES (43, '当代万国城', 'http://192.168.43.87:8080/home-decorationPic/1560238168453.jpg', '二居室', 140, 10, '简欧');
INSERT INTO `t_galleryDesign` VALUES (44, '观承别墅', 'http://192.168.43.87:8080/home-decorationPic/1560238238285.jpg', '二居室', 155, 8, '日式');
INSERT INTO `t_galleryDesign` VALUES (45, '金隅七零九零', 'http://192.168.43.87:8080/home-decorationPic/1560238302620.jpg', '二居室', 110, 8, '日式');
INSERT INTO `t_galleryDesign` VALUES (46, '海亮艺术华府', 'http://192.168.43.87:8080/home-decorationPic/1560238396600.jpg', '三居室', 120, 9, '现代');
INSERT INTO `t_galleryDesign` VALUES (47, '泓景花园', 'http://192.168.43.87:8080/home-decorationPic/1560238840004.jpg', '二居室', 145, 8, '美式');
INSERT INTO `t_galleryDesign` VALUES (48, '保利心语花园', 'http://192.168.43.87:8080/home-decorationPic/1560238914230.jpg', '三居室', 188, 10, '美式');
INSERT INTO `t_galleryDesign` VALUES (49, '22222', 'http://192.168.43.87:8080/home-decorationPic/1560308054808.jpg', '二居室', 114, 10, '简约');
INSERT INTO `t_galleryDesign` VALUES (50, '3333', 'http://192.168.43.87:8080/home-decorationPic/1560308094384.jpg', '二居室', 110, 10, '简约');

SET FOREIGN_KEY_CHECKS = 1;
