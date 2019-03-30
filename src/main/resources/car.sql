/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 30/03/2019 19:01:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bicycle
-- ----------------------------
DROP TABLE IF EXISTS `bicycle`;
CREATE TABLE `bicycle`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `number` bigint(20) NOT NULL DEFAULT 0,
  `price` bigint(20) NOT NULL COMMENT '单车的租赁价格 元/小时',
  `type` tinyint(4) NOT NULL DEFAULT 0,
  `status` tinyint(4) NOT NULL,
  `deflag` tinyint(4) NOT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `bicycle_id` bigint(20) NOT NULL COMMENT '单车id',
  `start_time` datetime(0) NOT NULL COMMENT '单车开始租用的时间',
  `end_time` datetime(0) NOT NULL COMMENT '单车租用结束的时间',
  `total_price` bigint(10) NOT NULL DEFAULT 0 COMMENT '整个订单的总价格',
  `status` int(4) NOT NULL COMMENT '状态',
  `dflag` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url描述',
  `pid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES (1, '/index', '主页', 0);
INSERT INTO `u_permission` VALUES (2, '/rent', '租赁', 0);
INSERT INTO `u_permission` VALUES (3, '/return', '归还', 0);
INSERT INTO `u_permission` VALUES (4, '/order', '订单', 0);
INSERT INTO `u_permission` VALUES (5, '/bicycleManagement', '单车信息管理', 0);
INSERT INTO `u_permission` VALUES (6, '/userManagement', '用户信息管理', 0);
INSERT INTO `u_permission` VALUES (7, '/rentManagement', '租金管理', 0);
INSERT INTO `u_permission` VALUES (8, '/adminManagement', '管理员管理', 0);
INSERT INTO `u_permission` VALUES (9, '/infoManagement', '信息管理', 0);
INSERT INTO `u_permission` VALUES (10, '/show', '主页', 0);
INSERT INTO `u_permission` VALUES (11, '/userInfo', '个人信息', 0);

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES (1, '管理员', 'admin');
INSERT INTO `u_role` VALUES (2, '用户', 'user');

-- ----------------------------
-- Table structure for u_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission`  (
  `rid` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES (1, 1);
INSERT INTO `u_role_permission` VALUES (1, 2);
INSERT INTO `u_role_permission` VALUES (1, 10);
INSERT INTO `u_role_permission` VALUES (2, 2);
INSERT INTO `u_role_permission` VALUES (2, 3);
INSERT INTO `u_role_permission` VALUES (2, 4);
INSERT INTO `u_role_permission` VALUES (2, 11);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '1:有效，0:禁止登录',
  `balance` bigint(20) NULL DEFAULT NULL COMMENT '余额',
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `dflag` tinyint(1) NULL DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, 'qgy', '', '248248', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (2, 'qgy', '', '123456', NULL, NULL, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for u_user_role
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role`  (
  `uid` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) NULL DEFAULT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES (1, 1);
INSERT INTO `u_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
