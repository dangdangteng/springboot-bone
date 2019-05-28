# error 总结
## 高版本无法启动服务
> 2.2.0 M3 无法运行服务

> Failed to bind properties under 'eureka.client.service-url' to java.util.Map<java.lang.String, java.lang.String>
```
eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka1:8761/eureka
```