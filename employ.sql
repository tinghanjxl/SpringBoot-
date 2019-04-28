/*
Navicat MySQL Data Transfer

Source Server         : employ
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : employ

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-27 17:20:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `company_info`
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `funds` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `scale` varchar(50) DEFAULT NULL,
  `industry` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_info
-- ----------------------------
INSERT INTO `company_info` VALUES ('1', '东软', '100M', '121313', '软件大道', 'B', 'IT', '国内领先的软件企业', '2019-03-23 09:45:16');
INSERT INTO `company_info` VALUES ('2', '工商银行', '200M', '13131', '新街口1号', 'B', '金融', '国有银行', '2019-03-22 09:55:52');
INSERT INTO `company_info` VALUES ('3', '建设银行', '200M', '112412', '新街口1号', 'B', '金融', '国有银行', '2019-03-21 09:02:41');
INSERT INTO `company_info` VALUES ('4', '软通', '50M', '123213', '新街口1号', 'B', '教育', '国内软件企业', '2019-03-20 09:02:48');
INSERT INTO `company_info` VALUES ('5', '文都', '60M', '2421', '新街口1号', 'S', '教育', '考研机构', '2019-03-19 09:02:56');
INSERT INTO `company_info` VALUES ('6', '启航', '27M', '12321', '洪武路20号', 'S', 'IT', '考研机构', '2019-03-18 09:03:05');
INSERT INTO `company_info` VALUES ('7', '海天', '68M', '12321', '洪武路20号', 'S', '教育', '考研机构', '2019-03-17 09:03:11');
INSERT INTO `company_info` VALUES ('8', '海学', '42M', '21421', '洪武路20号', 'S', 'IT', '考研机构', '2019-03-16 09:41:46');
INSERT INTO `company_info` VALUES ('9', '新东方', '20M', '12421', '洪武路20号', 'B', 'IT', '教育机构', '2019-03-15 09:41:53');

-- ----------------------------
-- Table structure for `graduate_info`
-- ----------------------------
DROP TABLE IF EXISTS `graduate_info`;
CREATE TABLE `graduate_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `university` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of graduate_info
-- ----------------------------
INSERT INTO `graduate_info` VALUES ('1', '贾雪磊', '0', '江苏理工学院', '中吴大道1801号', '17327190317', '本科生');
INSERT INTO `graduate_info` VALUES ('2', '黄政杰', '1', '江苏理工', '中吴大道1801号', '15901871235', '本科生');
INSERT INTO `graduate_info` VALUES ('3', '张三', '0', '江理工', '中吴大道1801号', '132343324', '研究生');

-- ----------------------------
-- Table structure for `link_info`
-- ----------------------------
DROP TABLE IF EXISTS `link_info`;
CREATE TABLE `link_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link_info
-- ----------------------------
INSERT INTO `link_info` VALUES ('1', '新浪', '2017-09-01 14:19:39', 'http://www.sina.com', null);
INSERT INTO `link_info` VALUES ('2', '百度', '2017-07-30 14:19:43', 'http://www.baidu.com', null);
INSERT INTO `link_info` VALUES ('3', '网易', '2017-07-18 14:19:46', 'http://www.163.com', null);
INSERT INTO `link_info` VALUES ('4', '搜狐', '2017-06-28 14:19:49', 'http://www.sohu.com', null);
INSERT INTO `link_info` VALUES ('5', '腾讯', '2017-06-30 16:50:34', 'https://www.qq.com/', null);

-- ----------------------------
-- Table structure for `news_info`
-- ----------------------------
DROP TABLE IF EXISTS `news_info`;
CREATE TABLE `news_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT '' COMMENT '标题',
  `contents` varchar(1000) DEFAULT '' COMMENT '内容',
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_info
-- ----------------------------
INSERT INTO `news_info` VALUES ('1', '河北省2019年度公务员录用省市县乡四级联考公告', '一）招录的范围和对象。从以下符合条件的人员中招录：\r\n\r\n1、全日制高等院校2019年普通类应届毕业生。\r\n\r\n2、硕士研究生及以上学历学位人员。\r\n\r\n3、具有《法律职业资格证书》且报考各级法院、检察院要求具有此证书职位的人员。\r\n\r\n4、具有河北省常住户籍或高考生源地为河北省的其他人员，户籍以2019年4月27日户口所在地为准。“服务基层四项目人员”“退役大学生士兵”报考其专门职位的人员，可视为具有其服务地、服役地户籍；报考者配偶、父母、岳父母、公婆如有河北省常住户籍的，报考者可视为具有其户籍。\r\n\r\n以下人员不在招录范围：现役军人，公务员及参照公务员法管理的工作人员（含试用期人员），全日制高等院校普通类在读学生（2019年应届毕业生除外）。', '2019-04-26 10:36:06');
INSERT INTO `news_info` VALUES ('2', '河南师范大学博管办2019年招聘启事', '品学兼优，身体健康，年龄不超过35周岁，取得博士学位不超过3年，或通过博士学位论文答辩的应届博士均可申请进站从事博士后研究工作。\r\n\r\n1、申请普通博士后岗位者，满足以上基本条件即可。\r\n\r\n2、申请师资博士后，要求具有较好的研究基础和较大的学术发展潜力科研业绩要求达到的条件如下：\r\n\r\n物理学、化学、环境科学与工程：近5年至少在本专业SCI二区及以上期刊发表1篇学术论文（第一作者或除导师外第一作者）。\r\n\r\n生物学：近五年以第一作者或除导师外第一作者在JCR三区以上（含三区）SCI源期刊发表学术论文1篇，或SCI学术论文2篇。\r\n\r\n3、达到师资博士后入站条件的海外博士，进站后薪酬待遇及考核办法参照师资博士后执行；未能达到师资博士后入站条件者仍按海外博士后兑现。', '2019-04-25 10:36:47');
INSERT INTO `news_info` VALUES ('3', '淮北师范大学2019年人才招聘方案', '淮北师范大学位于国家能源基地、国家园林城市安徽省淮北市，是一所多科性省属重点大学。1974年建校，时为安徽师范大学淮北分校。1978年12月经国务院批准，定名为淮北煤炭师范学院，隶属原煤炭工业部，面向全国招生。1998年9月实行“中央与地方共建，以安徽省管理为主”的管理体制。2010年3月经教育部批准，更名为淮北师范大学。2003年获得硕士学位授予权。2007年在教育部本科教学工作水平评估中获得“优秀”等次。2009年增列为省级立项建设博士研究生培养单位和博士后培养单位。', '2019-04-24 10:37:21');
INSERT INTO `news_info` VALUES ('4', '东莞理工学院2019年青年博士招聘公告', '1.政治思想素质好，遵纪守法，作风正派，具有良好的职业道德，团队合作意识强。\r\n\r\n2.全日制博士研究生，理工科年龄在30周岁及以下，人文社科年龄在33周岁及以下。\r\n\r\n3.具有较强的研究潜质和科研能力，近5年取得较好的学术成果。符合下列条件之一：\r\n\r\n（1）以第一作者在本学科发表SCI收录的当年属二区及以上的学术论文3篇及以上；\r\n\r\n（2）以第一作者在本学科发表SCI收录的当年属一区的学术论文1篇并且发表SCI收录的当年属二区的学术论文1篇；\r\n\r\n（3）以第一作者在本学科发表SSCI收录的学术论文3篇及以上；\r\n\r\n（4）以第一作者在本学科发表SCI收录的当年属二区的学术论文2篇且作为第一发明人获得发明专利2项；\r\n\r\n（5）以第一发明人获得发明专利5项及以上；\r\n\r\n（6）主持国家级科研项目；\r\n\r\n（7）获得省部级以上科研奖励一等奖前3名，二等奖前2名1项；\r\n\r\n（8）取得其他特别优秀学术成果。\r\n\r\n导师为第一作者，本人为第二作者的论文和发明专利，可视同本人为第一作者。', '2019-04-17 10:37:51');
INSERT INTO `news_info` VALUES ('5', '国家卫生健康委科学技术研究所2019年公开招聘公告', '国家卫生健康委科学技术研究所是以人类生殖、遗传优生、出生缺陷、生殖健康等基础及应用研究为主的多学科、综合性的社会公益型国家级科研机构，为国家卫生健康委员会直属事业单位。因工作需要，现面向社会公开招聘纪检监察室正式工作人员1名。\r\n\r\n一、岗位具体要求：\r\n\r\n1、 具有北京户口；\r\n\r\n2、 年龄在40周岁以下；\r\n\r\n3、 大学本科以上学历；\r\n\r\n4、 有三年以上工作经验，中共党员；\r\n\r\n5、 有法律、行政管理、党务等相关专业背景，有纪检监察工作经历者优先；\r\n\r\n二、联系方式：\r\n\r\n应聘者请将个人简历（附个人照片）电子版发至kysflb@163.com\r\n\r\n地址：北京市海淀区大慧寺12号\r\n\r\n邮编：100081\r\n\r\n联系人：吕老师62177825；张老师62173448\r\n\r\n对初选合格者，将以电话或电子邮件方式通知面试。', '2019-04-04 10:38:30');

-- ----------------------------
-- Table structure for `post_info`
-- ----------------------------
DROP TABLE IF EXISTS `post_info`;
CREATE TABLE `post_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `workplace` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_info
-- ----------------------------
INSERT INTO `post_info` VALUES ('1', '华为', '软件开发工程师', '3', '0', '本科', '10000', '上海', '技术，创新', '2019-04-26 15:56:03');
INSERT INTO `post_info` VALUES ('2', '小米', '销售', '5', '1', '本科', '5000', '北京', '技术，创新', '2019-04-25 15:56:06');
INSERT INTO `post_info` VALUES ('3', '海信', '数据库工程师', '2', '0', '研究生', '5000', '北京', '硬件，技术', '2019-04-24 09:50:45');
INSERT INTO `post_info` VALUES ('4', '苹果', '软件测试工程师', '5', '0', '本科', '5000', '杭州', '技术，创新', '2019-04-23 09:52:21');
INSERT INTO `post_info` VALUES ('5', '腾讯', '前端开发工程师', '3', '0', '研究生', '10000', '深圳', '游戏，软件', '2019-04-22 15:55:59');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('2', 'test', '111', '2019-04-21 16:02:45', '0');
INSERT INTO `user_info` VALUES ('4', 'jxl', '1111', '2019-04-25 15:42:58', '0');
INSERT INTO `user_info` VALUES ('5', 'admin', '123456', '2019-04-26 19:17:39', '0');
INSERT INTO `user_info` VALUES ('6', 'hzj', '111', '2019-04-26 19:19:43', '0');
INSERT INTO `user_info` VALUES ('7', 'hzj', '12222', '2019-04-26 19:20:13', '0');
INSERT INTO `user_info` VALUES ('8', 'mm', '1234', '2019-04-26 19:23:17', '0');
INSERT INTO `user_info` VALUES ('9', 'mm', 'www', '2019-04-26 19:23:29', '0');
