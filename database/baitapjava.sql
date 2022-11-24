/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL_LOCAL
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : baitapjava

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 24/11/2022 22:17:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_comment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status` int NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `author_id` bigint NULL DEFAULT NULL,
  `post_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_r8da6wd8yr5rhgny3b437pk34`(`author_id` ASC) USING BTREE,
  INDEX `FK_f7qubxc5gi177f47o4f8ja0uf`(`post_id` ASC) USING BTREE,
  CONSTRAINT `FK_f7qubxc5gi177f47o4f8ja0uf` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_r8da6wd8yr5rhgny3b437pk34` FOREIGN KEY (`author_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_comment
-- ----------------------------
INSERT INTO `tbl_comment` VALUES (1, NULL, NULL, 'hay qua', NULL, 1, NULL, 1, 5);
INSERT INTO `tbl_comment` VALUES (2, NULL, NULL, 'hay qua ban', NULL, 0, NULL, 1, 5);
INSERT INTO `tbl_comment` VALUES (3, NULL, NULL, 'hay qua ban', NULL, 1, NULL, 1, 5);
INSERT INTO `tbl_comment` VALUES (4, NULL, NULL, 'hay qua ban', NULL, 1, NULL, 1, 5);
INSERT INTO `tbl_comment` VALUES (5, NULL, NULL, 'Dinh vay ba', NULL, 0, NULL, 1, 5);

-- ----------------------------
-- Table structure for tbl_lookup
-- ----------------------------
DROP TABLE IF EXISTS `tbl_lookup`;
CREATE TABLE `tbl_lookup`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `code` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `position` int NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_lookup
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_post
-- ----------------------------
DROP TABLE IF EXISTS `tbl_post`;
CREATE TABLE `tbl_post`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `status` int NOT NULL,
  `tags` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `author_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_gv0xlwy6muf7qj6pas021478`(`author_id` ASC) USING BTREE,
  CONSTRAINT `FK_gv0xlwy6muf7qj6pas021478` FOREIGN KEY (`author_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_post
-- ----------------------------
INSERT INTO `tbl_post` VALUES (5, '2022-11-24 20:07:35', 0x323032322D31312D32342032303A35323A35392E3437, '																												Mình sẽ mở đầu bài viết với một câu châm ngôn của bác Martin Fowler mà mình nghĩ ai là Software Engineer cũng đều nên nhớ,\r\n“Any fool can write code that a computer can understand.\r\nGood programmers write code that humans can understand.”\r\nTạm dịch là,\r\n“Bất cứ thằng ngu nào cũng có thể viết code cho máy tính có thể hiểu.\r\nLập trình viên giỏi là người viết code để cho người khác có thể hiểu.”\r\n							\r\n							\r\n							\r\n							', 1, 'Cong Nghe', 'Senior hay không-Senior?', 1);

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES (1, NULL, NULL, 'ROLE_ADMIN');
INSERT INTO `tbl_role` VALUES (2, NULL, NULL, 'ROLE_USER');

-- ----------------------------
-- Table structure for tbl_tags
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tags`;
CREATE TABLE `tbl_tags`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `frequency` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tags
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT NULL,
  `updated_time` tinyblob NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `profile` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `role_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_gbdgihevc2inxejmwd2r45sw7`(`role_id` ASC) USING BTREE,
  CONSTRAINT `FK_gbdgihevc2inxejmwd2r45sw7` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, NULL, NULL, 'thanhthien@gmail.com', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'admin', 1);
INSERT INTO `tbl_user` VALUES (2, NULL, NULL, 'thuhien@gmail.com', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'thuhien', 2);

SET FOREIGN_KEY_CHECKS = 1;
