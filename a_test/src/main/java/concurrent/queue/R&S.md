## ReentrantLock和Synchronized

```java
Synchronized是Lock的一种简化实现，一个Lock可以对应多个 Condition，而synchronized把Lock和Condition合并了，一个 synchronized Lock只对应一个Condition，可以说Synchronized是 Lock的简化版本。
在JDK 5，Synchronized要比Lock慢很多，但是在JDK 6中，它们的 效率差不多。
```

### concurrent.lock & condition

```java
    禁止使用wait() & notiffy() & notiffyAll()
    对应应使用 await() & singal() & singalAll()
```