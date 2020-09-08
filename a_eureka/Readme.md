# eureka 注册中心
## c-s架构设计
![如图](http://www.itmind.net/assets/images/2017/springcloud/eureka-architecture-overview.png)

## 未来扩展集群部署

## 基础配置

```porperties
server:
  port: 8761

spring:
  application:
    name: spring-cloud-eureka

eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
```

## 进阶配置
```properties
---
server:
    port: 8761

spring:
    application:
        name: spring-cloud-eureka1
    profiles: eureka1

eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka2:8762/eureka,http://eureka3:8763/eureka
  instance:
    hostname: eureka1
---
server:
    port: 8762

spring:
    application:
        name: spring-cloud-eureka2
    profiles: eureka2
eureka:
    client:
        fetch-registry: false
        register-with-eureka: false
        service-url:
            defaultZone: http://eureka1:8761/eureka,http://eureka3:8763/eureka
    instance:
        hostname: eureka2
---
server:
  port: 8763

spring:
  application:
    name: spring-cloud-eureka3
  profiles: eureka3

eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka2:8762/eureka,http://eureka1:8761/eureka

  instance:
    hostname: eureka3
---
```
> 启动jvm参数配置-Dspring.profiles.active="*"

## 其他描述
> eregg 项目另一个eureka注册中心体验双机主备

> host文件配置
```
    127.0.0.1 eureka1
    127.0.0.1 eureka2
    127.0.0.1 eureka3
```

## 注意事项
> 项目中不要带数字