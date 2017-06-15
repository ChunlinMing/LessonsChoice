/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : lesson_choice

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-06-15 21:32:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cqupt_building`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_building`;
CREATE TABLE `cqupt_building` (
  `BUILDING` varchar(10) NOT NULL COMMENT '教学楼名称',
  PRIMARY KEY (`BUILDING`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_building
-- ----------------------------
INSERT INTO `cqupt_building` VALUES ('实验楼');
INSERT INTO `cqupt_building` VALUES ('教学楼一');
INSERT INTO `cqupt_building` VALUES ('教学楼二');

-- ----------------------------
-- Table structure for `cqupt_class`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_class`;
CREATE TABLE `cqupt_class` (
  `CLASS` varchar(10) NOT NULL COMMENT '学生所在教学班',
  `SCHOOL` varchar(20) NOT NULL COMMENT '学院',
  PRIMARY KEY (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_class
-- ----------------------------
INSERT INTO `cqupt_class` VALUES ('1101401', '通信学院');
INSERT INTO `cqupt_class` VALUES ('1101402', '通信学院');
INSERT INTO `cqupt_class` VALUES ('1101403', '通信学院');
INSERT INTO `cqupt_class` VALUES ('1101404', '通信学院');
INSERT INTO `cqupt_class` VALUES ('1201301', '软件工程学院');
INSERT INTO `cqupt_class` VALUES ('1201302', '软件工程学院');
INSERT INTO `cqupt_class` VALUES ('1201303', '软件工程学院');
INSERT INTO `cqupt_class` VALUES ('1201304', '软件工程学院');
INSERT INTO `cqupt_class` VALUES ('1301501', '计算机学院');
INSERT INTO `cqupt_class` VALUES ('1301502', '计算机学院');
INSERT INTO `cqupt_class` VALUES ('1301503', '计算机学院');
INSERT INTO `cqupt_class` VALUES ('1301504', '计算机学院');
INSERT INTO `cqupt_class` VALUES ('1401201', '外国语学院');
INSERT INTO `cqupt_class` VALUES ('1401202', '外国语学院');
INSERT INTO `cqupt_class` VALUES ('1401203', '外国语学院');
INSERT INTO `cqupt_class` VALUES ('1401204', '外国语学院');
INSERT INTO `cqupt_class` VALUES ('1401205', '外国语学院');
INSERT INTO `cqupt_class` VALUES ('150141', '传媒学院');
INSERT INTO `cqupt_class` VALUES ('150142', '传媒学院');
INSERT INTO `cqupt_class` VALUES ('150143', '传媒学院');
INSERT INTO `cqupt_class` VALUES ('150144', '传媒学院');

-- ----------------------------
-- Table structure for `cqupt_classroom_info`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_classroom_info`;
CREATE TABLE `cqupt_classroom_info` (
  `CLASSROOM` varchar(10) NOT NULL COMMENT '教室',
  `BUILDING` varchar(10) NOT NULL COMMENT '教室所在教学楼',
  PRIMARY KEY (`CLASSROOM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_classroom_info
-- ----------------------------
INSERT INTO `cqupt_classroom_info` VALUES ('1101', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('1102', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('1103', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('1104', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('1203', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('1204', '教学楼一');
INSERT INTO `cqupt_classroom_info` VALUES ('2101', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('2102', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('2103', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('2104', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('2203', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('2204', '教学楼二');
INSERT INTO `cqupt_classroom_info` VALUES ('实验楼101', '实验楼');
INSERT INTO `cqupt_classroom_info` VALUES ('实验楼102', '实验楼');
INSERT INTO `cqupt_classroom_info` VALUES ('实验楼203', '实验楼');
INSERT INTO `cqupt_classroom_info` VALUES ('实验楼204', '实验楼');

-- ----------------------------
-- Table structure for `cqupt_grade_year`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_grade_year`;
CREATE TABLE `cqupt_grade_year` (
  `GRADE_YEAR` int(4) NOT NULL COMMENT '学生年级',
  PRIMARY KEY (`GRADE_YEAR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_grade_year
-- ----------------------------
INSERT INTO `cqupt_grade_year` VALUES ('2013');
INSERT INTO `cqupt_grade_year` VALUES ('2014');
INSERT INTO `cqupt_grade_year` VALUES ('2015');
INSERT INTO `cqupt_grade_year` VALUES ('2016');

-- ----------------------------
-- Table structure for `cqupt_lesson_choice`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_lesson_choice`;
CREATE TABLE `cqupt_lesson_choice` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STU_ID` varchar(15) NOT NULL COMMENT '学号',
  `TERM` int(5) NOT NULL COMMENT '上课学期',
  `LESSON_ID` varchar(15) NOT NULL COMMENT '课程ID',
  `LESSON_NAME` varchar(50) NOT NULL COMMENT '课程名称',
  `LESSON_TYPE` varchar(4) NOT NULL COMMENT '课程类型',
  `LESSON_SCORE` double(3,1) NOT NULL COMMENT '课程学分',
  `LESSON_TIME` varchar(15) NOT NULL COMMENT '上课的时间',
  `LESSON_WEEKS` varchar(15) NOT NULL COMMENT '上课是在哪几周',
  `CLASSROOM` varchar(10) NOT NULL COMMENT '上课教室',
  `TEACHER_ID` varchar(15) NOT NULL COMMENT '教师工号',
  `TEACHER_NAME` varchar(10) NOT NULL COMMENT '教师姓名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_lesson_choice
-- ----------------------------
INSERT INTO `cqupt_lesson_choice` VALUES ('32', '2016112964', '20162', 'X12345623', 'Oracle数据库基础', '选修', '2.0', '周四9、10节', '1周~16周', '1104', '12011018', '蒂姆库克');
INSERT INTO `cqupt_lesson_choice` VALUES ('38', '2016112964', '20162', 'A12345677', '计算机科学导论', '必修', '2.0', '周一3、4节', '2周~17周', '1101', '12008029', '张小龙');
INSERT INTO `cqupt_lesson_choice` VALUES ('40', '2016112964', '20162', 'C12345458', 'C语言基础', '必修', '4.0', '周二9、10节，四节连上', '1周~17周', '实验楼203', '13011017', '扎克伯格');
INSERT INTO `cqupt_lesson_choice` VALUES ('41', '2016112964', '20162', 'E12345637', '大学英语1（读写译）', '必修', '2.0', '周一3、4节', '2周~16周', '1102', '14015019', '朱婷');
INSERT INTO `cqupt_lesson_choice` VALUES ('53', '2016112964', '20162', 'K12345676', '课程设计1', '必修', '8.0', '周一1、2节', '17周', '实验楼102', '12015027', '马云');

-- ----------------------------
-- Table structure for `cqupt_lesson_info`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_lesson_info`;
CREATE TABLE `cqupt_lesson_info` (
  `LESSON_ID` varchar(15) NOT NULL COMMENT '课程ID',
  `LESSON_NAME` varchar(50) NOT NULL COMMENT '课程名称',
  `TEACHER_ID` varchar(15) NOT NULL COMMENT '教师工号',
  `TEACHER_NAME` varchar(10) NOT NULL COMMENT '教师姓名',
  `CLASSROOM` varchar(10) NOT NULL COMMENT '教室',
  `LESSON_TIME` varchar(15) NOT NULL COMMENT '上课时间',
  `LESSON_WEEKS` varchar(15) NOT NULL COMMENT '在哪几周上课',
  `LESSON_OPTIONAL_STU` int(3) NOT NULL COMMENT '本课程最多可选人数',
  `LESSON_CHOSED_STU` int(3) NOT NULL COMMENT '本课程当前已选人数',
  `LESSON_TYPE` varchar(4) NOT NULL COMMENT '课程类型',
  `TERM` int(5) NOT NULL COMMENT '学期',
  `LESSON_SCORE` double(3,1) NOT NULL COMMENT '课程学分',
  `GRADE_YEAR` int(4) NOT NULL COMMENT '可选课的学生年级',
  `SCHOOL` varchar(20) NOT NULL COMMENT '可选课的学院',
  PRIMARY KEY (`LESSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_lesson_info
-- ----------------------------
INSERT INTO `cqupt_lesson_info` VALUES ('A12345658', '汇编语言', '13009017', '张华路', '2102', '周五3、4节', '2周~16周', '80', '0', '必修', '20162', '3.0', '2014', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345665', 'Java编程语言程序设计', '12008029', '张小龙', '实验楼101', '周四9、10节，三节连上', '1周~17周', '90', '0', '必修', '20162', '6.0', '2015', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345667', '汇编语言', '13009017', '张华路', '1102', '周三1、2节', '2周~16周', '80', '0', '必修', '20162', '3.0', '2014', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345668', '软件工程', '12008029', '张小龙', '2101', '周一3、4节', '1周~17周', '90', '0', '必修', '20162', '3.0', '2015', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345677', '计算机科学导论', '12008029', '张小龙', '1101', '周一3、4节', '2周~17周', '90', '1', '必修', '20162', '2.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345678', '计算机科学导论', '12008029', '张小龙', '1101', '周二3、4节', '2周~17周', '90', '0', '必修', '20162', '2.0', '2016', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('A12345679', '计算机科学导论', '12008029', '张小龙', '1102', '周二5、6节', '2周~17周', '90', '0', '必修', '20162', '2.0', '2016', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('C12345458', 'C语言基础', '13011017', '扎克伯格', '实验楼203', '周二9、10节，四节连上', '1周~17周', '80', '1', '必修', '20162', '4.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E1234533', '大学英语2（读写译）', '14011021', '马龙', '2102', '周五1、2节', '2周~16周', '80', '0', '必修', '20162', '2.0', '2015', '通信学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E1234534', '大学英语2（读写译）', '14011021', '马龙', '1102', '周一5、6节', '2周~16周', '80', '0', '必修', '20162', '2.0', '2015', '外国语学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E1234535', '大学英语1（读写译）', '14015019', '朱婷', '2102', '周五1、2节', '2周~16周', '90', '0', '必修', '20162', '2.0', '2016', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E1234536', '大学英语1（读写译）', '14015019', '朱婷', '1103', '周三5、6节', '1周~15周', '90', '0', '必修', '20162', '2.0', '2016', '传媒学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345637', '大学英语1（读写译）', '14015019', '朱婷', '1102', '周一3、4节', '2周~16周', '70', '1', '必修', '20162', '2.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345672', '大学英语2（视听说）', '14011012', '马布里', '1103', '周二1、2节', '2周~16周', '80', '0', '必修', '20162', '2.0', '2015', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345673', '大学英语1（视听说）', '12015027', '马云', '2103', '周二1、2节', '2周~17周', '60', '0', '必修', '20162', '2.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345675', '大学英语2（视听说）', '14011012', '马布里', '1204', '周二1、2节', '2周~16周', '90', '0', '必修', '20162', '2.0', '2015', '外国语学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345678', '大学英语1（视听说）', '14011012', '马布里', '2204', '周四3、4节', '2周~16周', '99', '0', '必修', '20162', '2.0', '2016', '外国语学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345679', '大学英语2（视听说）', '14011012', '马布里', '1203', '周四1、2节', '2周~16周', '90', '0', '必修', '20162', '2.0', '2015', '通信学院');
INSERT INTO `cqupt_lesson_info` VALUES ('E12345699', '大学英语1（视听说）', '14011012', '马布里', '2204', '周四1、2节', '2周~16周', '99', '0', '必修', '20162', '2.0', '2016', '通信学院');
INSERT INTO `cqupt_lesson_info` VALUES ('G12346851', '高等数学', '11012019', '陈铭', '2104', '周四3、4节', '1周~17周', '80', '0', '必修', '20162', '5.5', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('G12346852', '高等数学', '11012019', '陈铭', '2203', '周二1、2节', '1周~17周', '80', '0', '必修', '20162', '5.5', '2016', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('G12346853', '高等数学', '11012019', '陈铭', '1204', '周一3、4节', '1周~17周', '80', '0', '必修', '20162', '5.5', '2016', '通信学院');
INSERT INTO `cqupt_lesson_info` VALUES ('J12345365', '计算机科学导论', '12014007', '李芳芳', '实验楼204', '周三9、10节', '8周~14周', '80', '0', '实践类型', '20162', '0.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('J12345366', '计算机科学导论', '12014007', '李芳芳', '实验楼102', '周四9、10节', '8周~14周', '80', '0', '实践类型', '20162', '0.0', '2016', '计算机学院');
INSERT INTO `cqupt_lesson_info` VALUES ('K12345676', '课程设计1', '12015027', '马云', '实验楼102', '周一1、2节', '17周', '80', '1', '必修', '20162', '8.0', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('L1234557', '离散数学', '11015012', '汪小小', '2104', '周三7、8节', '2周~17周', '80', '0', '限选', '20162', '2.5', '2016', '软件工程学院');
INSERT INTO `cqupt_lesson_info` VALUES ('L1234558', '离散数学', '11015012', '汪小小', '2203', '周四7、8节', '2周~17周', '80', '0', '限选', '20162', '2.5', '2016', '通信学院');
INSERT INTO `cqupt_lesson_info` VALUES ('M12345364', '视觉设计', '15012020', '秦明', '2204', '周五3、4节', '2周~16周', '80', '0', '必修', '20162', '4.0', '2014', '传媒学院');
INSERT INTO `cqupt_lesson_info` VALUES ('M12345568', '摄影技术', '15012020', '秦明', '1104', '周四5、6节，三节连上', '9周~16周', '120', '0', '必修', '20162', '2.0', '2014', '传媒学院');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345375', '中外电影艺术手法对比', '15012020', '秦明', '2103', '周二9、10节', '2周~9周', '120', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345376', '中外电影艺术手法对比', '15012020', '秦明', '2103', '周三9、10节', '2周~9周', '120', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345561', '英语口语', '14013011', '董卿', '1104', '周二9、10节', '10周~17周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345562', '英语口语', '14013011', '董卿', '1104', '周一9、10节', '10周~17周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345567', '外国影片赏析', '14013011', '董卿', '2102', '周一9、10节', '2周~9周', '120', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345568', '外国影片赏析', '14013011', '董卿', '2102', '周二9、10节', '2周~9周', '120', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345623', 'Oracle数据库基础', '12011018', '蒂姆库克', '1104', '周四9、10节', '1周~16周', '100', '1', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345626', 'Oracle数据库基础', '12011018', '蒂姆库克', '1203', '周一9、10节', '1周~16周', '100', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345631', 'Android开发技巧', '12011018', '蒂姆库克', '1203', '周二9、10节', '1周~16周', '100', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345635', 'Android开发技巧', '12011018', '蒂姆库克', '1203', '周三9、10节', '1周~16周', '100', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345763', '计算机基础知识', '13015013', '李彦宏', '1103', '周四9、10节', '2周~16周', '120', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345764', '计算机基础知识', '13015013', '李彦宏', '1103', '周三9、10节', '2周~16周', '120', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345834', '常见电影技术解析', '15013013', '王小波', '2101', '周二9、10节', '2周~9周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345835', '常见电影技术解析', '15013013', '王小波', '2101', '周三9、10节', '2周~9周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345864', 'Flash技术', '15013013', '王小波', '1204', '周四9、10节', '2周~9周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345865', 'Flash技术', '15013013', '王小波', '1204', '周二9、10节', '2周~9周', '100', '0', '选修', '20162', '1.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345967', '浅析主流通信技术', '11011015', '蔡洪波', '2204', '周四9、10节', '2周~16周', '80', '0', '选修', '20162', '2.0', '0', 'All');
INSERT INTO `cqupt_lesson_info` VALUES ('X12345968', '浅析主流通信技术', '11011015', '蔡洪波', '2204', '周三9、10节', '2周~16周', '80', '0', '选修', '20162', '2.0', '0', 'All');

-- ----------------------------
-- Table structure for `cqupt_lesson_type`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_lesson_type`;
CREATE TABLE `cqupt_lesson_type` (
  `LESSON_TYPE_NAME` varchar(4) NOT NULL COMMENT '课程类型',
  PRIMARY KEY (`LESSON_TYPE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_lesson_type
-- ----------------------------
INSERT INTO `cqupt_lesson_type` VALUES ('实践类型');
INSERT INTO `cqupt_lesson_type` VALUES ('必修');
INSERT INTO `cqupt_lesson_type` VALUES ('选修');
INSERT INTO `cqupt_lesson_type` VALUES ('限选');

-- ----------------------------
-- Table structure for `cqupt_login_info`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_login_info`;
CREATE TABLE `cqupt_login_info` (
  `USER_ID` varchar(15) NOT NULL COMMENT '用户登录ID，为学号或工号',
  `USER_PWD` varchar(256) NOT NULL COMMENT '登录密码',
  `USER_TYPE` int(1) NOT NULL COMMENT '用户类型，0表示管理员，1表示教师，2为学生',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_login_info
-- ----------------------------
INSERT INTO `cqupt_login_info` VALUES ('11011015', '0c10efbfbd1a7236efbfbdefbfbdefbfbdefbfbdefbfbd7f35efbfbd2d3b', '1');
INSERT INTO `cqupt_login_info` VALUES ('11012019', 'efbfbd3667efbfbdefbfbdefbfbdefbfbdefbfbdefbfbd27efbfbd3cefbfbdefbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('11015012', '166712efbfbdefbfbd1fefbfbd21efbfbd6c0e6eefbfbdefbfbdefbfbdefbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('12008029', '007b21efbfbd54efbfbd5b03efbfbdefbfbdefbfbd1a4d1aefbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('12011018', '706eefbfbd6aefbfbdc780efbfbdefbfbdefbfbdefbfbd5a04dc9defbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('12014007', '5e54efbfbd32441162efbfbd13112f5f3769efbfbd70', '1');
INSERT INTO `cqupt_login_info` VALUES ('12015027', '6defbfbd09efbfbd1dd980efbfbdefbfbdefbfbd35c68eefbfbd2defbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('13009017', '634eefbfbd3b4232c5acefbfbd3defbfbd45352664', '1');
INSERT INTO `cqupt_login_info` VALUES ('13011017', '725977d2a5611aefbfbd7016efbfbd25efbfbd4eefbfbd67', '1');
INSERT INTO `cqupt_login_info` VALUES ('13015013', 'efbfbdefbfbd5c50623d666defbfbdefbfbdefbfbd22efbfbd00efbfbdefbfbd', '1');
INSERT INTO `cqupt_login_info` VALUES ('14011012', '55efbfbdefbfbd326658efbfbdefbfbd22efbfbd03efbfbd0260efbfbd63', '1');
INSERT INTO `cqupt_login_info` VALUES ('14011021', '72efbfbdefbfbd10efbfbd3461efbfbdefbfbd63482befbfbd4137', '1');
INSERT INTO `cqupt_login_info` VALUES ('14013011', '220d432fefbfbd14efbfbd06efbfbd340eefbfbd767eefbfbd22', '1');
INSERT INTO `cqupt_login_info` VALUES ('14015019', '7778730aefbfbd35efbfbdc48fefbfbdefbfbdefbfbd4b32efbfbd4b', '1');
INSERT INTO `cqupt_login_info` VALUES ('15012020', '5723253727efbfbd3357efbfbd0defbfbd631b3655', '1');
INSERT INTO `cqupt_login_info` VALUES ('15013013', 'efbfbd13682459efbfbd5101214defbfbdefbfbd23efbfbdefbfbd25', '1');
INSERT INTO `cqupt_login_info` VALUES ('2013110454', '450808efbfbd01efbfbdefbfbdefbfbd5215efbfbd5defbfbdefbfbd03efbfbd', '2');
INSERT INTO `cqupt_login_info` VALUES ('2013110455', '0eefbfbdefbfbdefbfbdefbfbdefbfbdefbfbd423a3368efbfbd1befbfbdefbfbdefbfbd', '2');
INSERT INTO `cqupt_login_info` VALUES ('2013112963', '6634efbfbdefbfbd6e53efbfbd2f49223d4631efbfbd0a3d', '2');
INSERT INTO `cqupt_login_info` VALUES ('2016112964', '201062d2a5efbfbd5b544e75efbfbdefbfbdefbfbdefbfbd41efbfbd', '2');
INSERT INTO `cqupt_login_info` VALUES ('2016113370', '3aefbfbdefbfbd2325efbfbdefbfbdefbfbdefbfbd61efbfbd061befbfbdefbfbd57', '2');
INSERT INTO `cqupt_login_info` VALUES ('admin', '1202efbfbd4cefbfbdefbfbd16d8ac06efbfbd31efbfbdefbfbd59efbfbd', '0');

-- ----------------------------
-- Table structure for `cqupt_school_name`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_school_name`;
CREATE TABLE `cqupt_school_name` (
  `SCHOOL` varchar(20) NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`SCHOOL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_school_name
-- ----------------------------
INSERT INTO `cqupt_school_name` VALUES ('传媒学院');
INSERT INTO `cqupt_school_name` VALUES ('外国语学院');
INSERT INTO `cqupt_school_name` VALUES ('计算机学院');
INSERT INTO `cqupt_school_name` VALUES ('软件工程学院');
INSERT INTO `cqupt_school_name` VALUES ('通信学院');

-- ----------------------------
-- Table structure for `cqupt_score_limit`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_score_limit`;
CREATE TABLE `cqupt_score_limit` (
  `SCORE_LIMIT` double(3,1) NOT NULL COMMENT '一次选课的学分上限',
  PRIMARY KEY (`SCORE_LIMIT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_score_limit
-- ----------------------------
INSERT INTO `cqupt_score_limit` VALUES ('28.5');

-- ----------------------------
-- Table structure for `cqupt_stu_grade`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_stu_grade`;
CREATE TABLE `cqupt_stu_grade` (
  `STU_ID` varchar(15) NOT NULL COMMENT '学号',
  `STU_NAME` varchar(10) NOT NULL COMMENT '姓名',
  `CLASS` varchar(10) NOT NULL COMMENT '班级',
  `TERM` int(5) NOT NULL COMMENT '学期',
  `LESSON_TYPE` varchar(4) NOT NULL COMMENT '课程类型',
  `LESSON_ID` varchar(15) NOT NULL COMMENT '课程ID',
  `LESSON_NAME` varchar(50) NOT NULL COMMENT '课程名称',
  `EXAM_TYPE` varchar(6) NOT NULL COMMENT '考试类型',
  `STU_GRADE` double(3,1) NOT NULL COMMENT '学生成绩',
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_stu_grade
-- ----------------------------
INSERT INTO `cqupt_stu_grade` VALUES ('2016112964', '朱厚照', '1201304', '20162', '必修', 'E12345637', '大学英语1（读写译）', '正常考试', '87.0', '1');
INSERT INTO `cqupt_stu_grade` VALUES ('2016112964', '朱厚照', '1201304', '20162', '必修', 'E12345637', '大学英语1（读写译）', '补考', '95.0', '2');
INSERT INTO `cqupt_stu_grade` VALUES ('2016112964', '朱厚照', '1201304', '20162', '必修', 'C12345458', 'C语言基础', '正常考试', '82.0', '3');
INSERT INTO `cqupt_stu_grade` VALUES ('2016112964', '朱厚照', '1201304', '20162', '必修', 'C12345458', 'C语言基础', '补考', '90.0', '4');
INSERT INTO `cqupt_stu_grade` VALUES ('2016112964', '朱厚照', '1201304', '20162', '必修', 'A12345677', '计算机科学导论', '正常考试', '80.0', '5');

-- ----------------------------
-- Table structure for `cqupt_stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_stu_info`;
CREATE TABLE `cqupt_stu_info` (
  `STU_ID` varchar(15) NOT NULL COMMENT '学号',
  `STU_NAME` varchar(10) NOT NULL COMMENT '学生姓名',
  `STU_GENDER` varchar(1) NOT NULL COMMENT '性别',
  `SCHOOL` varchar(20) NOT NULL COMMENT '学生所在学院',
  `CLASS` varchar(10) NOT NULL COMMENT '学生所在班级',
  `GRADE_YEAR` int(4) NOT NULL COMMENT '学生所在年级',
  `STU_EMAIL` varchar(35) NOT NULL COMMENT '学生邮箱',
  PRIMARY KEY (`STU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_stu_info
-- ----------------------------
INSERT INTO `cqupt_stu_info` VALUES ('2013110454', '刘享才', '男', '通信学院', '1101401', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013110455', '黄佑先', '男', '通信学院', '1101401', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013110456', '张至福', '男', '通信学院', '1101401', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013110457', '赵安然', '女', '通信学院', '1101401', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013112946', '刘路', '男', '软件工程学院', '1201301', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013112947', '李自畦', '男', '软件工程学院', '1201301', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013112948', '王为铭', '男', '软件工程学院', '1201301', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013112950', '张谈月', '女', '软件工程学院', '1201301', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013113353', '李逢棋', '男', '计算机学院', '1301501', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013113354', '吕子福', '男', '计算机学院', '1301501', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013113355', '齐家国', '男', '计算机学院', '1301501', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013113356', '张友丽', '女', '计算机学院', '1301501', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013114257', '郑月娥', '女', '外国语学院', '1401201', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013114258', '吕淼淼', '女', '外国语学院', '1401201', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013114259', '张诚', '男', '外国语学院', '1401201', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013114260', '杜子建', '男', '外国语学院', '1401201', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013114261', '李去疾', '男', '外国语学院', '1401201', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211324', '貂蝉', '女', '传媒学院', '150142', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211421', '李二', '男', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211423', '王五', '男', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211425', '文静', '女', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211426', '赵刚', '男', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211430', '赵小勇', '男', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211431', '李小霞', '女', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2013211432', '陈显秋', '女', '传媒学院', '150141', '2013', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014110458', '李怀空', '男', '通信学院', '1101402', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014110459', '陈亮', '男', '通信学院', '1101402', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014110460', '吴斯怀', '男', '通信学院', '1101402', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014110461', '王衡', '男', '通信学院', '1101402', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014112952', '王如魅', '女', '软件工程学院', '1201302', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014112953', '石开泰', '男', '软件工程学院', '1201302', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014112954', '吕金言', '男', '软件工程学院', '1201302', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014112955', '陈晓志', '男', '软件工程学院', '1201302', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014113358', '陈心然', '女', '计算机学院', '1301502', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014113359', '张志杰', '男', '计算机学院', '1301502', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014113360', '李必诚', '男', '计算机学院', '1301502', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014113361', '王显聪', '男', '计算机学院', '1301502', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014114266', '崔均', '男', '外国语学院', '1401202', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014114267', '柳芳铭', '女', '外国语学院', '1401202', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014114268', '王传熙', '女', '外国语学院', '1401202', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014114269', '金永玉', '女', '外国语学院', '1401202', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014114270', '刘昭垣', '女', '外国语学院', '1401202', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014215743', '吴刚', '男', '传媒学院', '150142', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014215744', '吴越', '男', '传媒学院', '150142', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014215746', '刘梓晨', '女', '传媒学院', '150142', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014215747', '张妃', '女', '传媒学院', '150142', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2014215748', '齐笑笑', '女', '传媒学院', '150142', '2014', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015110466', '李启明', '男', '通信学院', '1101403', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015110467', '张永亮', '男', '通信学院', '1101403', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015110468', '柳幺尧', '女', '通信学院', '1101403', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015110469', '文小娴', '女', '通信学院', '1101403', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015112958', '刘高', '男', '软件工程学院', '1201303', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015112959', '朱明', '男', '软件工程学院', '1201303', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015112960', '郑有朱', '女', '软件工程学院', '1201303', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015112961', '韩紫红', '女', '软件工程学院', '1201303', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015113366', '金全进', '男', '计算机学院', '1301503', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015113367', '柳爱词', '男', '计算机学院', '1301503', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015113368', '文枝扬', '女', '计算机学院', '1301503', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015113369', '黄灵芝', '女', '计算机学院', '1301503', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015114272', '霍留美', '女', '外国语学院', '1401203', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015114273', '姜好婕', '女', '外国语学院', '1401203', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015114274', '石清明', '女', '外国语学院', '1401203', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015114275', '吴英', '女', '外国语学院', '1401203', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015219551', '陈雯雯', '女', '传媒学院', '150143', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015219552', '卢雨荷', '女', '传媒学院', '150143', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015219553', '杨思汝', '女', '传媒学院', '150143', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015219554', '吕春芳', '女', '传媒学院', '150143', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2015219555', '黄九五', '男', '传媒学院', '150143', '2015', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016110470', '李亦觅', '女', '通信学院', '1101404', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016110471', '黄淮安', '男', '通信学院', '1101404', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016110472', '吕春秋', '男', '通信学院', '1101404', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016110473', '张涵钺', '男', '通信学院', '1101404', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016112962', '柳圆妙', '女', '软件工程学院', '1201304', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016112963', '陈证道', '男', '软件工程学院', '1201304', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016112964', '朱厚照', '男', '软件工程学院', '1201304', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016112965', '齐先', '男', '软件工程学院', '1201304', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016113370', '陈子栀', '女', '计算机学院', '1301504', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016113371', '张娴美', '女', '计算机学院', '1301504', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016113372', '刘有棋', '男', '计算机学院', '1301504', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016113373', '赵得天', '男', '计算机学院', '1301504', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114279', '张燕', '女', '外国语学院', '1401204', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114280', '李泗环', '女', '外国语学院', '1401204', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114281', '吕晴晴', '女', '外国语学院', '1401204', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114282', '姜唤琦', '女', '外国语学院', '1401204', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114288', '赵然', '女', '外国语学院', '1401205', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114289', '陈冉冉', '女', '外国语学院', '1401205', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114290', '李时杰', '男', '外国语学院', '1401205', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016114291', '王锋', '男', '外国语学院', '1401205', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016223185', '柳子厚', '男', '传媒学院', '150144', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016223190', '韩宗纬', '男', '传媒学院', '150144', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016223191', '韩琪柳', '女', '传媒学院', '150144', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016223192', '赵琳琳', '女', '传媒学院', '150144', '2016', 'chunlinming@outlook.com');
INSERT INTO `cqupt_stu_info` VALUES ('2016223193', '郑才千', '女', '传媒学院', '150144', '2016', 'chunlinming@outlook.com');

-- ----------------------------
-- Table structure for `cqupt_teacher_info`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_teacher_info`;
CREATE TABLE `cqupt_teacher_info` (
  `TEACHER_ID` varchar(15) NOT NULL COMMENT '教师工号',
  `TEACHER_NAME` varchar(10) NOT NULL COMMENT '教师姓名',
  `TEACHER_GENDER` varchar(1) NOT NULL COMMENT '教师性别',
  `SCHOOL` varchar(20) NOT NULL COMMENT '教师所属学院',
  `TEACHER_EMAIL` varchar(35) NOT NULL COMMENT '教师邮箱',
  PRIMARY KEY (`TEACHER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_teacher_info
-- ----------------------------
INSERT INTO `cqupt_teacher_info` VALUES ('11011015', '蔡洪波', '男', '通信学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('11012019', '陈铭', '男', '通信学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('11013019', '朱之锋', '男', '通信学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('11015012', '汪小小', '女', '通信学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('12008029', '张小龙', '男', '软件工程学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('12011018', '蒂姆库克', '男', '软件工程学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('12014007', '李芳芳', '女', '软件工程学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('12015027', '马云', '男', '软件工程学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('13009017', '张华路', '男', '计算机学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('13011017', '扎克伯格', '男', '计算机学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('13012022', '刘强东', '男', '计算机学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('13015013', '李彦宏', '男', '计算机学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('14006023', '郎平', '女', '外国语学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('14011012', '马布里', '男', '外国语学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('14011021', '马龙', '男', '外国语学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('14013011', '董卿', '女', '外国语学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('14015019', '朱婷', '女', '外国语学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('15012020', '秦明', '男', '传媒学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('15013013', '王小波', '男', '传媒学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('15014012', '欧阳夏丹', '女', '传媒学院', 'chunlinming@outlook.com');
INSERT INTO `cqupt_teacher_info` VALUES ('15016015', '郎永淳', '男', '传媒学院', 'chunlinming@outlook.com');

-- ----------------------------
-- Table structure for `cqupt_term`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_term`;
CREATE TABLE `cqupt_term` (
  `TERM` int(5) NOT NULL COMMENT '学期',
  PRIMARY KEY (`TERM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_term
-- ----------------------------
INSERT INTO `cqupt_term` VALUES ('20131');
INSERT INTO `cqupt_term` VALUES ('20132');
INSERT INTO `cqupt_term` VALUES ('20141');
INSERT INTO `cqupt_term` VALUES ('20142');
INSERT INTO `cqupt_term` VALUES ('20151');
INSERT INTO `cqupt_term` VALUES ('20152');
INSERT INTO `cqupt_term` VALUES ('20161');
INSERT INTO `cqupt_term` VALUES ('20162');
INSERT INTO `cqupt_term` VALUES ('20171');

-- ----------------------------
-- Table structure for `cqupt_validation_code`
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_validation_code`;
CREATE TABLE `cqupt_validation_code` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(15) NOT NULL COMMENT '工号或学号',
  `VALIDATION_CODE` varchar(15) NOT NULL COMMENT '验证码',
  `EXPIRE_FLAG` tinyint(1) NOT NULL COMMENT '是否过期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cqupt_validation_code
-- ----------------------------
INSERT INTO `cqupt_validation_code` VALUES ('1', '2013110454', 'cfqiC7gpbqsn56A', '1');
INSERT INTO `cqupt_validation_code` VALUES ('2', '2013110454', 'gy2ILWS92hZXUcc', '1');
INSERT INTO `cqupt_validation_code` VALUES ('3', '2013110454', 'tLUR7W2lLL03jWD', '1');
INSERT INTO `cqupt_validation_code` VALUES ('4', '2013110454', 'OHGnp312IzxDRhw', '1');
INSERT INTO `cqupt_validation_code` VALUES ('5', '2013110454', 'lrdsrFw0qqVCMRh', '1');
INSERT INTO `cqupt_validation_code` VALUES ('6', '2013110454', 'R6oWAlQ7GGvyEpM', '1');
INSERT INTO `cqupt_validation_code` VALUES ('7', '2013110455', 'dOzqTeTg8ux7XmV', '1');
INSERT INTO `cqupt_validation_code` VALUES ('8', '2013110455', 'UUtSq38M1jfVyW9', '1');
INSERT INTO `cqupt_validation_code` VALUES ('9', '2013110455', 'wXt2tNFkQ9RHqKt', '1');
INSERT INTO `cqupt_validation_code` VALUES ('10', '11011015', 'R0rdLupmLRtAZJF', '1');
INSERT INTO `cqupt_validation_code` VALUES ('11', '11011015', 'JeFCsO4i6cPhFcV', '1');
INSERT INTO `cqupt_validation_code` VALUES ('12', '2013110454', 'G7ckwLXT21lu0eg', '1');
INSERT INTO `cqupt_validation_code` VALUES ('13', '2013110455', 'Q4ANmjVZWiiWZRB', '1');
INSERT INTO `cqupt_validation_code` VALUES ('14', '2013110455', 'tk3io1it1QFBKvU', '1');
INSERT INTO `cqupt_validation_code` VALUES ('15', '2013110455', 'k6wO8Gv13e8FfD3', '1');
INSERT INTO `cqupt_validation_code` VALUES ('16', '12008029', 'ZsX9IeFn7ag6OE8', '1');
INSERT INTO `cqupt_validation_code` VALUES ('17', '13009017', 'TG8wUyHX7y95v7G', '1');
INSERT INTO `cqupt_validation_code` VALUES ('18', '14011012', 'CnMBf7ZZBmw1nFF', '1');
INSERT INTO `cqupt_validation_code` VALUES ('19', '15012020', '77sPoLsKhfh4bnU', '1');
INSERT INTO `cqupt_validation_code` VALUES ('20', '11012019', 'fMM80vhHoB9kPVP', '1');
INSERT INTO `cqupt_validation_code` VALUES ('21', '14015019', 'yd6DE6xY1NS7CxY', '1');
INSERT INTO `cqupt_validation_code` VALUES ('22', '14011021', 'n429I8y6HKq1vYe', '1');
INSERT INTO `cqupt_validation_code` VALUES ('23', '11015012', 'sXtOtRUAwQfGUBT', '1');
INSERT INTO `cqupt_validation_code` VALUES ('24', '13011017', 'ciRy5Lpvqn8zfrI', '1');
INSERT INTO `cqupt_validation_code` VALUES ('25', '13011017', 'vNWHQSz3QGrUgXk', '1');
INSERT INTO `cqupt_validation_code` VALUES ('26', '13011017', 'c178RGQkjpCmMrY', '1');
INSERT INTO `cqupt_validation_code` VALUES ('27', '13011017', 'yvEvzeZi7yWFJaD', '1');
INSERT INTO `cqupt_validation_code` VALUES ('28', '13011017', '6ZSvZ9eHRmbNUD0', '1');
INSERT INTO `cqupt_validation_code` VALUES ('29', '12014007', 'lvEv29BcTdL6leM', '1');
INSERT INTO `cqupt_validation_code` VALUES ('30', '12015027', 'VcMmBCUWSbYXlCE', '1');
INSERT INTO `cqupt_validation_code` VALUES ('31', '14013011', 'fcPTgwfGWgIpZ6K', '1');
INSERT INTO `cqupt_validation_code` VALUES ('32', '13015013', 'yFmgTuYX0bPrD57', '1');
INSERT INTO `cqupt_validation_code` VALUES ('33', '12011018', 'Z2p2jqX5CmRzqjf', '1');
INSERT INTO `cqupt_validation_code` VALUES ('34', '15013013', '8PV9zokt9B0OB5W', '1');
INSERT INTO `cqupt_validation_code` VALUES ('35', '11011015', 'lv0pM3BnnMGorF2', '1');
INSERT INTO `cqupt_validation_code` VALUES ('36', '2013112963', 'tDBljP1oY3qoF1D', '1');
INSERT INTO `cqupt_validation_code` VALUES ('37', '90000009', 'OssEpdP78qqoDhj', '1');
INSERT INTO `cqupt_validation_code` VALUES ('38', '14011012', 'hiFlGecgjoSfS2o', '1');
INSERT INTO `cqupt_validation_code` VALUES ('39', '14011012', 'PskUIRONse8UEAY', '1');
INSERT INTO `cqupt_validation_code` VALUES ('40', '14011012', 'S0L9YEbe6pGbHhI', '1');
INSERT INTO `cqupt_validation_code` VALUES ('41', '2016112964', '5YFexDgpANDLaOZ', '1');
INSERT INTO `cqupt_validation_code` VALUES ('42', '2016113370', 'Q1I4J7lJjKfEiDO', '1');
INSERT INTO `cqupt_validation_code` VALUES ('43', '2016112964', 'DmZRuYAGtKetVAQ', '1');
INSERT INTO `cqupt_validation_code` VALUES ('44', '14011012', 'rELzQWOm9MsVzL4', '1');
INSERT INTO `cqupt_validation_code` VALUES ('45', '14011012', 'j57IkWSNu6RYvkC', '1');
INSERT INTO `cqupt_validation_code` VALUES ('46', '14011012', '5qiPK5Cv7uSrr4w', '1');
INSERT INTO `cqupt_validation_code` VALUES ('47', '15013013', '3i7qwlT05RAx9uP', '1');
INSERT INTO `cqupt_validation_code` VALUES ('48', '2016112964', 'gKFl1sxEL5p3Cxy', '1');
