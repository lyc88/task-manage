
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Controller路径',
  `menu_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单编码',
  `parent_id` int(8) DEFAULT NULL COMMENT '父菜单ID',
  `menu_type` int(1) DEFAULT '0' COMMENT '菜单类型：0-菜单1-按钮',
  `order_num` int(4) DEFAULT '99' COMMENT '显示序号',
  `creator` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(1) DEFAULT '0' COMMENT '删除状态：0-存在1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` VALUES (1, '跳转任务列表页面', '/index', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (2, '跳转执行记录页面', '/taskrecords', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (3, '跳转报错日志页面', '/taskerrors', NULL, 0, 0, 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (4, '跳转新增任务页面', '/addtask', NULL, 0, 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (5, '跳转编辑任务页面', '/updatetask', NULL, 0, 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (6, 'mian', '/main', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `t_role` VALUES (2, 'ROLE_DEV');
INSERT INTO `t_role` VALUES (3, 'ROLE_USER');
COMMIT;

-- ----------------------------
-- Table structure for t_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menus`;
CREATE TABLE `t_role_menus` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色菜单id',
  `role_id` int(8) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(8) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role_menus
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menus` VALUES (1, 1, 1);
INSERT INTO `t_role_menus` VALUES (2, 1, 2);
INSERT INTO `t_role_menus` VALUES (3, 1, 3);
INSERT INTO `t_role_menus` VALUES (4, 1, 4);
INSERT INTO `t_role_menus` VALUES (5, 1, 5);
INSERT INTO `t_role_menus` VALUES (6, 1, 6);
INSERT INTO `t_role_menus` VALUES (7, 2, 1);
INSERT INTO `t_role_menus` VALUES (8, 2, 2);
INSERT INTO `t_role_menus` VALUES (9, 2, 3);
INSERT INTO `t_role_menus` VALUES (10, 2, 4);
INSERT INTO `t_role_menus` VALUES (11, 2, 5);
INSERT INTO `t_role_menus` VALUES (12, 2, 6);
INSERT INTO `t_role_menus` VALUES (13, 3, 1);
INSERT INTO `t_role_menus` VALUES (14, 3, 2);
INSERT INTO `t_role_menus` VALUES (15, 3, 4);
INSERT INTO `t_role_menus` VALUES (16, 3, 5);
INSERT INTO `t_role_menus` VALUES (17, 3, 6);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'user', '$2a$10$D5E9lza7z8uea6fP/oNOJeuRq/a/y8RXQWslTDONsqxQTPlgW7Hr6');
INSERT INTO `t_user` VALUES (2, 'admin', '$2a$10$on7jUGJN.4CyjPZzyroZce0ugjCQFzA6dRuOTcEFTBLLhe3oYe5Gu');
COMMIT;

-- ----------------------------
-- Table structure for t_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户角色对照ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(8) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
BEGIN;
INSERT INTO `t_user_roles` VALUES (1, 2, 1);
INSERT INTO `t_user_roles` VALUES (2, 1, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `t_quartz_task_details`;
CREATE TABLE `t_quartz_task_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_no` varchar(64) NOT NULL COMMENT '任务编号',
  `task_name` varchar(64) NOT NULL COMMENT '任务名称',
  `group_no` varchar(64) NOT NULL COMMENT '分组编号',
  `group_name` varchar(64) NOT NULL COMMENT '分组名称',
  `task_desc` varchar(128) NOT NULL COMMENT '任务描述',
  `corn_rule` varchar(64) NOT NULL COMMENT 'CRON表达式',
  `send_type` varchar(64) DEFAULT NULL COMMENT '请求方式',
  `send_url` varchar(64) DEFAULT NULL COMMENT '请求地址',
  `send_param` text DEFAULT NULL COMMENT '请求参数',
  `status` varchar(16) NOT NULL COMMENT '任务状态',
  `version` int(11) NOT NULL COMMENT '版本号：需要乐观锁控制',
  `prev_execute_time` bigint(13) NOT NULL COMMENT '上次执行时间',
  `next_execute_time` bigint(13) NOT NULL COMMENT '下次执行时间',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务信息表';

DROP TABLE IF EXISTS `t_quartz_task_records`;
CREATE TABLE `t_quartz_task_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_no` varchar(64) NOT NULL COMMENT '任务编号',
  `task_name` varchar(64) NOT NULL COMMENT '任务名称',
  `send_type` varchar(64) DEFAULT NULL COMMENT '请求方式',
  `send_url` varchar(64) DEFAULT NULL COMMENT '请求地址',
  `send_param` text DEFAULT NULL COMMENT '请求参数',
  `return_info` text DEFAULT NULL COMMENT '返回信息',
  `execute_time` bigint(13) NOT NULL COMMENT '执行时间',
  `task_status` varchar(16) NOT NULL COMMENT '任务状态',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_task_records_taskno` (`task_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务执行情况记录表';

DROP TABLE IF EXISTS `t_quartz_task_errors`;
CREATE TABLE `t_quartz_task_errors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taskExecuteRecordId` varchar(64) NOT NULL COMMENT '任务执行记录Id',
  `errorKey` varchar(1024) NOT NULL COMMENT '信息关键字',
  `errorValue` text COMMENT '信息内容',
  `createTime` bigint(13) NOT NULL COMMENT '创建时间',
  `lastModifyTime` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务出错现场信息表';

