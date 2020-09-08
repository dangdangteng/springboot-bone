package com.saber.demo.metest;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;

/**
 * @author baiyang
 * @date 2020/8/25
 * <p>
 * <p>
 * 当并发越多longadder 效率比atomicinteger 高
 */
public class ConcurrentHashMapTest {

    private volatile ConcurrentHashMap<Integer, AtomicInteger> atomicIntegerConcurrentHashMap = new ConcurrentHashMap<>();

    private volatile ThreadLocal<ConcurrentHashMap<Integer, AtomicInteger>> threadLocal = new ThreadLocal<>();

    ThreadPoolExecutor fastTriggerPool = new ThreadPoolExecutor(
            50,
            200,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "xxl-job, admin JobTriggerPoolHelper-fastTriggerPool-" + r.hashCode());
                }
            });

    @Test
    public void testHash() {
        AtomicInteger atomicInteger = atomicIntegerConcurrentHashMap.putIfAbsent(1, new AtomicInteger(1));
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
            System.out.println(atomicInteger);
        }
        atomicIntegerConcurrentHashMap.clear();
        AtomicInteger atomicInteger1 = atomicIntegerConcurrentHashMap.putIfAbsent(1, new AtomicInteger(1));
        if (atomicInteger1 != null) {
            atomicInteger1.incrementAndGet();
            System.out.println(atomicInteger1);
        }
        System.out.println(atomicIntegerConcurrentHashMap.get(1));
    }

    @Test
    public void testThreadLocal() {
        System.out.println("test");
        AtomicInteger a = new AtomicInteger(1);
        for (int i = 0; i < 200; i++) {
            fastTriggerPool.execute(() -> {
                a.incrementAndGet();
                ConcurrentHashMap<Integer, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(a.get(), new AtomicInteger(new Random().nextInt()));
                threadLocal.set(concurrentHashMap);
                System.out.println(threadLocal.get().toString());
            });
        }
    }


    /**
     * @throws InterruptedException test safe concurrent
     */
    @Test
    public void testSafeHash() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                // 这里并没有锁住 会导致value 错误
                int key = map.get("key") + 1; //step 1
                map.put("key", key);//step 2
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    // 原子操作
    @Test
    public void testSafeHashSuccessLongAdder() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        map.put("key", longAdder);
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                //
                map.get("key").increment();
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        System.out.println(System.nanoTime() - startTime);
        executorService.shutdown();
    }

    // 原子操作
    @Test
    public void testSafeHashSuccessAtomic() throws InterruptedException {
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        map.put("key", new AtomicInteger(1));
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                map.get("key").incrementAndGet();
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        System.out.println(System.nanoTime() - startTime);
        executorService.shutdown();
    }


    // lock 锁实现
    @Test
    public void testSafeHashSuccessLock() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        Lock lock = new ReentrantLock();
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                lock.lock();
                try {
                    Integer key = map.get("key") + 1;
                    map.put("key", key);
                }finally {
                    lock.unlock();
                }

            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        System.out.println(System.nanoTime() - startTime);
        executorService.shutdown();
    }

    //synchronized 锁实现
    @Test
    public void testSafeHashSuccessSync() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                synchronized (this) {
                    Integer key = map.get("key") + 1;
                    map.put("key", key);
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        System.out.println(System.nanoTime() - startTime);
        executorService.shutdown();
    }


}
