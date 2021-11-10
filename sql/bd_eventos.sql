CREATE DATABASE bd_eventos CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_general_ci'; 

USE bd_eventos;
/*
 Navicat Premium Data Transfer

 Source Server         : VPS_MTORREZ
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : bd_eventos

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/11/2021 12:50:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for seminarios
-- ----------------------------
DROP TABLE IF EXISTS `seminarios`;
CREATE TABLE `seminarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expositor` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fecha` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hora` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cupo` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seminarios
-- ----------------------------
INSERT INTO `seminarios` VALUES (1, 'APLICACIONES MACHINE LEARNING', 'Antonio Flores', '2021-12-01', '08:00 - 10:00', 50);
INSERT INTO `seminarios` VALUES (2, 'FIREBASE CON KOTLIN', 'Carlos Paco', '2021-12-01', '10:00 - 12:00', 40);
INSERT INTO `seminarios` VALUES (3, 'REDES NEURONALES CON MATLAB', 'Peter Olivares', '2021-12-01', '14:00 - 16:00', 30);

SET FOREIGN_KEY_CHECKS = 1;
