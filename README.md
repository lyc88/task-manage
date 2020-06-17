# Task Manage

基于SpringBoto的定时任务管理系统

## 技术选型
- springboot 2.3.1
- SpringSecurity 2.3.1
- httpclient 4.5.12
- commons-lang3 3.10
- quartz 2.3.2
- druid 1.1.22
- fastjson 1.2.71

## 项目功能
1. springboot集成quartz，使用druid连接池 
2. 支持http请求任务定时调度，当前支持get、post表单(formdata)、post Json三种请求类型，并记录返回内容
3. 通过web界面进行任务管理，包括任务启动、暂停、立即运行、新增、修改、历史记录、历史任务、执行日志查看功能
4. 支持调用接口(/quartz/httpJob/add)进行http任务添加  
5. 根据jobname或jobgroup进行查询

## 功能展望
- [ ] 新增定时任务、更新定时任务
- [ ] 暂停、启动定时任务、立即执行定时任务
- [ ] 展示定时任务列表，包含请求方式、访求参数、下次执行时间
- [ ] 展示历史任务列表，历史任务的状态及失败次数
- [ ] 展示任务日志列表，执行状态、执行时间、入参、出参、错误信息
- [ ] 支持get、post-json、post-form的HTTP接口调用
- [ ] 支持Class.method()的方式调用
- [ ] 支持RPC、Fegin的方式调用服务方法
- [ ] 支持RabbitMQ、Ka的方式调用服务方法
- [X] 整合SpringSecurity实现登录、登出、RBAC权限管理

## 部署方式
1. 执行sql目录下的task_manage.sql文件，建立quartz以及httpjob需要的数据库表  
2. 修改application.yml中的数据库连接方式
3. 访问 http://localhost:8080/idnex 可通过web界面进行定时任务的管理

## 最后致谢
感谢以下开源项目提供的项目参考
- https://github.com/helloflygit/springboot-quartz
- https://gitee.com/52itstyle/spring-boot-task
- https://github.com/simonsfan/springboot-quartz-demo

