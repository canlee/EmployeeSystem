/*
MySQL Data Transfer
Source Host: localhost
Source Database: employee_system
Target Host: localhost
Target Database: employee_system
Date: 2013/7/15 13:53:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for applychangedep
-- ----------------------------
CREATE TABLE `applychangedep` (
  `applyDepId` int(11) NOT NULL auto_increment,
  `applyTime` date NOT NULL,
  `empId` varchar(16) collate utf8_unicode_ci NOT NULL,
  `applyDepartment` varchar(20) collate utf8_unicode_ci NOT NULL,
  `applyPost` varchar(20) collate utf8_unicode_ci NOT NULL,
  `description` text collate utf8_unicode_ci,
  `status` varchar(1) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`applyDepId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for applyholiday
-- ----------------------------
CREATE TABLE `applyholiday` (
  `applyHolidayId` int(11) NOT NULL auto_increment,
  `holidayDays` int(11) NOT NULL,
  `applyTime` date NOT NULL,
  `empId` varchar(16) collate utf8_unicode_ci NOT NULL,
  `startTime` date NOT NULL,
  `description` text collate utf8_unicode_ci,
  `status` varchar(1) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`applyHolidayId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for applysalaryincrease
-- ----------------------------
CREATE TABLE `applysalaryincrease` (
  `applySalaryId` int(11) NOT NULL auto_increment,
  `applyTime` date NOT NULL,
  `empId` varchar(16) collate utf8_unicode_ci NOT NULL,
  `applySalary` double NOT NULL,
  `description` text collate utf8_unicode_ci,
  `status` varchar(1) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`applySalaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
CREATE TABLE `authority` (
  `authorityId` int(11) NOT NULL auto_increment,
  `authorityName` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`authorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for department
-- ----------------------------
CREATE TABLE `department` (
  `depId` int(11) NOT NULL auto_increment,
  `depName` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
CREATE TABLE `employee` (
  `empId` varchar(16) collate utf8_unicode_ci NOT NULL,
  `postId` int(11) NOT NULL,
  `empName` varchar(10) collate utf8_unicode_ci NOT NULL,
  `sex` varchar(1) collate utf8_unicode_ci default NULL,
  `phone` varchar(20) collate utf8_unicode_ci default NULL,
  `email` varchar(30) collate utf8_unicode_ci default NULL,
  `birthday` date default NULL,
  `salary` double NOT NULL,
  `address` varchar(100) collate utf8_unicode_ci default NULL,
  `password` varchar(16) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employee_authority
-- ----------------------------
CREATE TABLE `employee_authority` (
  `authId` int(11) NOT NULL,
  `empId` varchar(16) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`authId`,`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for post
-- ----------------------------
CREATE TABLE `post` (
  `postId` int(11) NOT NULL auto_increment,
  `depId` int(11) NOT NULL,
  `postName` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
