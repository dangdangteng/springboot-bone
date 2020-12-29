## CAS

所谓的cas 就是无锁 且并发下还能确保原子性

```java
    ConcurrentHashMap 中putIfAbsent() 方法即是
    Atomic class 中 compareAndSet() 方法亦是
    
    ConcurrentHashMap并没有实现Lock-Free，只是使用了分段锁的办法
    使得能够支持多个Writer并发。 ConcurrentHashMap需要使用更多的内存。
    使用场景适用于读多写少，适合作缓存
    
    
    注意，乐观锁时必须使用:@Transactional(propagation = Propagation.NOT_SUPPORTED)
    update tabelname set id = #id where id = ?
    
    悲观锁 使用时 即上锁 @Transactional(propagation = Propagation.REQUIRED)
    读取时候就开始上锁
    
    Lock-Free算法，可以说是乐观锁，如果非激烈竞争的时候，不需要使用锁，从而开销更小，速度更快。
    
    并发越多 悲观锁效率 >> 远大于 乐观锁
```

```java
    使用支持CAS的数据结构，避免使用锁，如: AtomicXXX、ConcurrentMap、CopyOnWriteList、ConcurrentLinkedQueue
```