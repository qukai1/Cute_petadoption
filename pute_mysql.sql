/*
 Navicat Premium Data Transfer

 Source Server         : CateDate
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : pute_mysql

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 19/05/2023 17:27:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lingyangbiao
-- ----------------------------
DROP TABLE IF EXISTS `lingyangbiao`;
CREATE TABLE `lingyangbiao`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '领养请求表id',
  `lingyangrenid` int(11) NULL DEFAULT NULL COMMENT '领养人id',
  `suoshurenid` int(11) NULL DEFAULT NULL COMMENT '所属人id',
  `suoshubiao` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '宠物所在表',
  `biaoid` int(11) NULL DEFAULT NULL COMMENT '所在表id',
  `lingyang_ski` int(11) NULL DEFAULT NULL COMMENT '领养是否完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lingyangbiao
-- ----------------------------
INSERT INTO `lingyangbiao` VALUES (28, 2, 4, 'pute_pet', 11, 1);
INSERT INTO `lingyangbiao` VALUES (32, 2, 2, 'team_pute', 3, 1);
INSERT INTO `lingyangbiao` VALUES (33, 4, 3, 'pute_pet', 47, 1);
INSERT INTO `lingyangbiao` VALUES (34, 3, 1, 'pute_pet', 58, 1);

-- ----------------------------
-- Table structure for pute_pet
-- ----------------------------
DROP TABLE IF EXISTS `pute_pet`;
CREATE TABLE `pute_pet`  (
  `pute_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '宠物id',
  `pute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人转养宠物信息表',
  `pute_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pute_age` int(255) NULL DEFAULT NULL,
  `pute_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pute_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pute_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宠物所在地区',
  `pute_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(255) NULL DEFAULT NULL COMMENT '所属用户',
  `pute_ski` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领养状态',
  `pute_date` datetime(0) NULL DEFAULT NULL COMMENT '领养时间',
  `pute_iux` int(11) NULL DEFAULT NULL COMMENT '是否有人领养',
  PRIMARY KEY (`pute_id`) USING BTREE,
  INDEX `userid`(`user_id`) USING BTREE,
  CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pute_pet
-- ----------------------------
INSERT INTO `pute_pet` VALUES (1, '小黑', '公', 2, '宠物狗类', 'sfere', '湖南-永州', '016.jpg', 1, '0', '2023-03-21 11:35:32', 0);
INSERT INTO `pute_pet` VALUES (2, '小五', '母', 4, '宠物猫类', '身份热舞', '湖南-长沙', '1.jpg', 3, '0', '2023-03-14 11:35:35', 0);
INSERT INTO `pute_pet` VALUES (7, '母狗s强', '公', 5, '宠物猫类', '牛逼', '湖南-耒阳', '06.jpg', 2, '0', '2023-03-21 11:59:47', 0);
INSERT INTO `pute_pet` VALUES (8, '是11', '公', 72, '宠物狗类', '粉1', '湖南-湘西', '2.jpg', 2, '1', '2023-03-21 11:59:47', 0);
INSERT INTO `pute_pet` VALUES (11, '李文强', '母', 2, '宠物猫类', '非常强壮', '湖南-永州', '10.jpg', 2, '0', '2023-03-20 16:37:37', 0);
INSERT INTO `pute_pet` VALUES (12, '狗强', '母', 2, '宠物猫类', '很牛逼啊', '湖南-益阳', '09.jpg', 1, '0', '2023-03-22 18:07:09', 0);
INSERT INTO `pute_pet` VALUES (41, '小强', '母', 18, '宠物猫类', '小强很厉害', '湖南-永州', 'fe37c1d9-43fa-400f-9c58-2ba425e53c25.jpg', 3, '1', '2023-03-26 10:03:41', 0);
INSERT INTO `pute_pet` VALUES (46, 'Userlist', '公', 2, '宠物狗类', '这只狗狗很聪明', '湖南-益阳', 'bd258ce3-5a65-480e-a250-49ebc6dba80a.jpg', 1, '0', '2023-03-26 13:36:38', 0);
INSERT INTO `pute_pet` VALUES (47, '大胃王', '母', 2, '宠物猫类', '这只小狗很厉害', '湖南-长沙', '6.jpg', 4, '0', '2023-03-21 17:49:08', 0);
INSERT INTO `pute_pet` VALUES (48, '红烧肉3', '公', 2, '宠物狗类', '小猫很爱吃', '湖南-永州', '133c21b6-abc5-43b9-b429-73e80b4d887d.jpg', 4, '0', '2023-03-21 18:09:38', 0);
INSERT INTO `pute_pet` VALUES (50, '小黄q', '公', 2, '宠物狗类', '小黄爱吃', '湖南-永州', '013.jpg', 3, '1', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (51, '小黄w', '公', 1, '宠物狗类', '小黄爱吃', '湖南-永州', '10.jpg', 1, '0', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (52, '小黄e', '公', 3, '宠物狗类', '小黄爱吃', '湖南-永州', '09.jpg', 1, '0', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (53, '小黄r', '母', 3, '宠物狗类', '小黄爱吃', '湖南-永州', '011.jpg', 2, '1', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (54, '小黄t', '公', 1, '宠物狗类', '小黄爱吃', '湖南-永州', '015.jpg', 2, '1', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (55, '小黄a', '公', 1, '宠物狗类', '小黄爱吃', '湖南-永州', '013.jpg', 1, '0', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (56, '小黄s', '公', 3, '宠物狗类', '小黄爱吃', '湖南-永州', '013.jpg', 3, '1', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (57, '小黄d', '公', 4, '宠物狗类', '小黄爱吃', '湖南-永州', '12.jpg', 4, '1', '2023-03-14 18:35:11', 0);
INSERT INTO `pute_pet` VALUES (58, '小黑f', '公', 2, '宠物狗类', 'sfere', '湖南-永州', '12.jpg', 3, '0', '2023-03-21 11:35:32', 0);
INSERT INTO `pute_pet` VALUES (59, '狗狗里', '母', 3, '宠物猫类', '身份热舞', '湖南-衡阳', '12.jpg', 2, '1', '2023-03-24 12:08:27', 0);
INSERT INTO `pute_pet` VALUES (60, '旺财', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '12.jpg', 3, '0', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (64, '丢丢', '母', 4, '宠物猫类', '可爱宠物', '湖南-长沙', '014.jpg', 2, '0', '2023-03-28 15:15:21', 0);
INSERT INTO `pute_pet` VALUES (65, '旺财1', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '10.jpg', 3, '0', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (66, '旺财2', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '09.jpg', 3, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (67, '旺财3', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', 'fe37c1d9-43fa-400f-9c58-2ba425e53c25.jpg', 1, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (68, '旺财4', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', 'bd258ce3-5a65-480e-a250-49ebc6dba80a.jpg', 1, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (69, '旺财5', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '3.jpg', 3, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (70, '旺财6', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '6.jpg', 1, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (71, '旺财7', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '85594584-b839-4b17-9a18-4a883cd28294.png', 3, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (72, '旺财8', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '013.jpg', 4, '0', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (73, '旺财9', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '10.jpg', 2, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (74, '旺财q', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '09.jpg', 3, '1', '2023-03-14 12:09:23', 0);
INSERT INTO `pute_pet` VALUES (75, '旺财w', '公', 2, '宠物狗类', '很厉害', '湖南-耒阳', '011.jpg', 4, '0', '2023-03-14 12:09:23', 0);

-- ----------------------------
-- Table structure for pute_team
-- ----------------------------
DROP TABLE IF EXISTS `pute_team`;
CREATE TABLE `pute_team`  (
  `pute_team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队信息表',
  `pute_team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `pute_team_date` date NULL DEFAULT NULL,
  `pute_team_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `pute_team_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '团队所属地区',
  `pute_team_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pute_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `userid` int(11) NULL DEFAULT NULL COMMENT '团队所属人',
  `team_num` int(11) NULL DEFAULT NULL COMMENT '团队人数',
  `pute_num` int(11) NULL DEFAULT NULL COMMENT '所有宠物数量',
  PRIMARY KEY (`pute_team_id`) USING BTREE,
  INDEX `p-u`(`userid`) USING BTREE,
  CONSTRAINT `p-u` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pute_team
-- ----------------------------
INSERT INTO `pute_team` VALUES (1, '华中院校团队1', '2021-02-17', 'team_1.jpg', '湖北华大', '致力于宠物管理1', '155746625332', 1, 5, 11);
INSERT INTO `pute_team` VALUES (2, '永职院校团队', '2019-02-14', '01.jpg', '湖南永州', '欢迎加入我们', '16699633352', 4, 5, 6);

-- ----------------------------
-- Table structure for pute_team_huodong
-- ----------------------------
DROP TABLE IF EXISTS `pute_team_huodong`;
CREATE TABLE `pute_team_huodong`  (
  `huodong_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队活动信息表',
  `huodong_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `huodong_state` date NULL DEFAULT NULL,
  `huodong_eng` date NULL DEFAULT NULL,
  `huodong_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `huodong_baifen` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `pute_team_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`huodong_id`) USING BTREE,
  INDEX `pute_team_id`(`pute_team_id`) USING BTREE,
  CONSTRAINT `pute_team_id` FOREIGN KEY (`pute_team_id`) REFERENCES `pute_team` (`pute_team_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pute_team_huodong
-- ----------------------------
INSERT INTO `pute_team_huodong` VALUES (1, '周末公益行', '2023-02-08', '2025-07-23', '进行中', '50%', 1);
INSERT INTO `pute_team_huodong` VALUES (2, '动物保护年', '2023-05-02', '2026-10-15', '进行中', '60%', 2);

-- ----------------------------
-- Table structure for team_pute
-- ----------------------------
DROP TABLE IF EXISTS `team_pute`;
CREATE TABLE `team_pute`  (
  `teamid` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队宠物id',
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_age` int(11) NULL DEFAULT NULL,
  `team_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `team_id` int(11) NULL DEFAULT NULL COMMENT '所属团队id',
  `team_ski` int(11) NULL DEFAULT NULL COMMENT '领养状态id',
  `team_date` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '管理员id',
  `team_iux` int(11) NULL DEFAULT NULL COMMENT '是否有人领养',
  PRIMARY KEY (`teamid`) USING BTREE,
  INDEX `team_id`(`team_id`) USING BTREE,
  CONSTRAINT `team_id` FOREIGN KEY (`team_id`) REFERENCES `pute_team` (`pute_team_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of team_pute
-- ----------------------------
INSERT INTO `team_pute` VALUES (1, '哈瑞', 2, '宠物狗类', '公', '湖南-永州', '可爱宠物', '015.jpg', 2, 0, '2023-03-22 15:14:37', NULL, 0);
INSERT INTO `team_pute` VALUES (4, '小菲', 4, '宠物猫类', '母', '湖南-长沙', '可爱宠物', '5.jpg', 1, 0, '2023-03-28 15:15:21', NULL, 0);
INSERT INTO `team_pute` VALUES (5, '旺才', 4, '宠物狗类', '母', '湖南-长沙', '可爱宠物', '6.jpg', 2, 0, '2023-03-28 15:15:21', NULL, 0);
INSERT INTO `team_pute` VALUES (6, '一休', 4, '宠物狗类', '母', '广州-深圳', '可爱宠物', '7.jpg', 1, 1, '2023-03-28 15:15:21', NULL, 0);
INSERT INTO `team_pute` VALUES (8, '毛头', 4, '宠物猫类', '母', '湖南-长沙', '可爱宠物', '7.jpg', 1, 1, '2023-03-28 15:15:21', NULL, 0);
INSERT INTO `team_pute` VALUES (10, '强2', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '21.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (12, '强4', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '23.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (13, '强5', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '24.jpg', 2, 0, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (14, '强6', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '25.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (15, '强7', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '26.jpg', 2, 0, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (16, '强8', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '27.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (17, '强9', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '28.jpg', 2, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (18, '强0', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '29.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (19, '强a', 3, '宠物猫类', '公', '湖南-长沙', '修狗', '30.jpg', 2, 0, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (20, '强1', 3, '宠物猫类', '母', '湖南-长沙', '修狗', '31.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (22, '强z', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '34.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);
INSERT INTO `team_pute` VALUES (23, '强c', 2, '宠物狗类', '公', '湖南-长沙', '修狗', '33.jpg', 1, 1, '2023-03-22 15:06:07', NULL, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userID` int(11) NOT NULL,
  `Phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '王强6', '1126', 1, '18511623177', '湖南-邵阳', '为人很5', 'd2edfc7c-60b0-4848-ae59-44c1999eb308.jpg', 1);
INSERT INTO `user` VALUES (2, 'admin', '2', 2, '16211396633', '湖南-长沙', '友善', '04.jpg', 1);
INSERT INTO `user` VALUES (3, '李文强', '3', 1, '16652337466', '湖北-武汉', 'ListFllite', '011.jpg', 1);
INSERT INTO `user` VALUES (4, '屈凯', '2', 2, '16522334489', '四川-雅安', 'UiistAndUyou', '1.jpg', 1);
INSERT INTO `user` VALUES (5, '问问', '111', 1, 'fsfer', 'fserew', 'fsere', '1.jpg', 1);

-- ----------------------------
-- Table structure for zhiyuanzhe
-- ----------------------------
DROP TABLE IF EXISTS `zhiyuanzhe`;
CREATE TABLE `zhiyuanzhe`  (
  `zhiyuan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '志愿者id',
  `zhiyuan_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '志愿者名称',
  `zhiyuan_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `zhiyuan_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '所在地区',
  `zhiyuan_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `zhiyuan_age` int(11) NULL DEFAULT NULL,
  `zhiyuan_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `zhiyuan_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `suoshu_team_id` int(11) NULL DEFAULT NULL COMMENT '所属团队id',
  PRIMARY KEY (`zhiyuan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhiyuanzhe
-- ----------------------------
INSERT INTO `zhiyuanzhe` VALUES (1, '王小红', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 1);
INSERT INTO `zhiyuanzhe` VALUES (2, '王磊', '2.jpg', '湖南-长沙', '有爱心', 24, '男', '6633995523', 2);
INSERT INTO `zhiyuanzhe` VALUES (3, '王小红1', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 2);
INSERT INTO `zhiyuanzhe` VALUES (4, '王小红2', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 2);
INSERT INTO `zhiyuanzhe` VALUES (5, '王小红3', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 2);
INSERT INTO `zhiyuanzhe` VALUES (6, '王小红4', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 1);
INSERT INTO `zhiyuanzhe` VALUES (7, '王小红5', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 2);
INSERT INTO `zhiyuanzhe` VALUES (8, '王小红6', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 1);
INSERT INTO `zhiyuanzhe` VALUES (9, '王小红7', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 1);
INSERT INTO `zhiyuanzhe` VALUES (10, '王小红8', '3.jpg', '湖南-永州', '热心', 15, '女', '22336669933', 1);

SET FOREIGN_KEY_CHECKS = 1;
