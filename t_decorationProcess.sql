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

 Date: 25/06/2019 23:18:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_decorationProcess
-- ----------------------------
DROP TABLE IF EXISTS `t_decorationProcess`;
CREATE TABLE `t_decorationProcess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `constructionTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `constructionContent` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `constructionPicUrls` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contract_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `contract_id`(`contract_id`) USING BTREE,
  CONSTRAINT `t_decorationProcess_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `t_contract` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修施工进度' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_decorationProcess
-- ----------------------------
INSERT INTO `t_decorationProcess` VALUES (5, '2019-5-25 下午', '一次主材', 'http://10.54.10.57:8080/home-decorationPic/1558803818211.jpg http://10.54.10.57:8080/home-decorationPic/1558803818223.jpg http://10.54.10.57:8080/home-decorationPic/1558803818228.jpg http://10.54.10.57:8080/home-decorationPic/1558803818236.jpg http://10.54.10.57:8080/home-decorationPic/1558803818239.jpg http://10.54.10.57:8080/home-decorationPic/1558803818242.jpg http://10.54.10.57:8080/home-decorationPic/1558803818246.jpg', '正常施工', 1);
INSERT INTO `t_decorationProcess` VALUES (6, '2019-5-25 下午', '一次主材', 'http://10.54.10.57:8080/home-decorationPic/1558803862762.jpg http://10.54.10.57:8080/home-decorationPic/1558803862769.jpg http://10.54.10.57:8080/home-decorationPic/1558803862776.jpg http://10.54.10.57:8080/home-decorationPic/1558803862780.jpg http://10.54.10.57:8080/home-decorationPic/1558803862784.jpg http://10.54.10.57:8080/home-decorationPic/1558803862787.jpg http://10.54.10.57:8080/home-decorationPic/1558803862793.jpg', '正常施工', 2);
INSERT INTO `t_decorationProcess` VALUES (7, '2019-5-26 下午', '水电路改造工程', 'http://10.54.10.57:8080/home-decorationPic/1558803977326.jpg http://10.54.10.57:8080/home-decorationPic/1558803977335.jpg http://10.54.10.57:8080/home-decorationPic/1558803977339.jpg http://10.54.10.57:8080/home-decorationPic/1558803977342.jpg http://10.54.10.57:8080/home-decorationPic/1558803977347.jpg http://10.54.10.57:8080/home-decorationPic/1558803977352.jpg http://10.54.10.57:8080/home-decorationPic/1558803977355.jpg http://10.54.10.57:8080/home-decorationPic/1558803977359.jpg', '正常施工', 1);
INSERT INTO `t_decorationProcess` VALUES (8, '2019-5-26 下午', '水电路改造工程', 'http://10.54.10.57:8080/home-decorationPic/1558804008900.jpg http://10.54.10.57:8080/home-decorationPic/1558804008905.jpg http://10.54.10.57:8080/home-decorationPic/1558804008914.jpg http://10.54.10.57:8080/home-decorationPic/1558804008919.jpg http://10.54.10.57:8080/home-decorationPic/1558804008927.jpg http://10.54.10.57:8080/home-decorationPic/1558804008932.jpg http://10.54.10.57:8080/home-decorationPic/1558804008935.jpg http://10.54.10.57:8080/home-decorationPic/1558804008938.jpg', '正常施工', 2);

SET FOREIGN_KEY_CHECKS = 1;
