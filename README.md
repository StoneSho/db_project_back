一、项目结构
src/main/java/com/project/library_management/
controller/：控制层，处理HTTP请求（如StudentController、CourseController等）。
entity/：实体类，对应数据库表（如Student、Course、Grade）。
mapper/：数据访问层，MyBatis-Plus的Mapper接口。
service/：业务逻辑层（目前为空，建议补充Service及其实现类）。
src/main/resources/
application.properties：核心配置文件，包含数据库、端口、Swagger等配置。
二、技术栈
1. 核心框架
Spring Boot 3.4.5
快速构建独立、生产级Spring应用。
Spring Cloud Gateway
微服务网关，负责路由和请求转发。
Spring Data JPA
持久层框架，简化数据库操作（但实际主要用MyBatis-Plus）。
MyBatis-Plus 3.5.11
MyBatis增强工具，简化CRUD操作。
Druid 1.2.21
阿里巴巴数据库连接池，提升数据库访问性能。
MySQL 8.x
关系型数据库，存储学生、课程、成绩等数据。
2. 其他依赖
springdoc-openapi（Swagger UI）
自动生成API文档，方便接口调试与测试。
spring-boot-devtools
热部署工具，提高开发效率。
spring-boot-starter-test
单元测试依赖。
3. 配置说明
server.port=8088：服务端口为8088。
spring.datasource.*：配置了Druid数据源和MySQL连接。
mybatis-plus.*：MyBatis-Plus相关配置。
springdoc.swagger-ui.*：Swagger文档相关配置。
