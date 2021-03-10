package concurrent.sync;

/**
 * @author baiyang
 * @date 2021/1/4
 */
public class SyncDemo {
    /**
     * 查看字节码
     *
     * Synchronized 是由 JVM 实现的一种实现互斥同步的一种方式，如果 你查看被 Synchronized 修饰过的程序块编译后的字节码，会发现， 被 Synchronized 修饰过的程序块，在编译前后被编译器生成了
     * monitorenter 和 monitorexit 两 个 字 节 码 指 令 。
     */
    /**
     * // class version 52.0 (52)
     * // access flags 0x21
     * public class concurrent/sync/SyncDemo {
     *
     *   // compiled from: SyncDemo.java
     *
     *   // access flags 0x1
     *   public <init>()V
     *    L0
     *     LINENUMBER 7 L0
     *     ALOAD 0
     *     INVOKESPECIAL java/lang/Object.<init> ()V
     *     RETURN
     *    L1
     *     LOCALVARIABLE this Lconcurrent/sync/SyncDemo; L0 L1 0
     *     MAXSTACK = 1
     *     MAXLOCALS = 1
     *
     *   // access flags 0x21
     *   public synchronized test()V
     *    L0
     *     LINENUMBER 15 L0
     *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
     *     LDC "---------- Synchronized ------------"
     *     INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
     *    L1
     *     LINENUMBER 16 L1
     *     RETURN
     *    L2
     *     LOCALVARIABLE this Lconcurrent/sync/SyncDemo; L0 L2 0
     *     MAXSTACK = 2
     *     MAXLOCALS = 1
     *
     *   // access flags 0x9
     *   public static main([Ljava/lang/String;)V
     *     // parameter  args
     *    L0
     *     LINENUMBER 19 L0
     *     NEW concurrent/sync/SyncDemo
     *     DUP
     *     INVOKESPECIAL concurrent/sync/SyncDemo.<init> ()V
     *     ASTORE 1
     *    L1
     *     LINENUMBER 20 L1
     *     ALOAD 1
     *     INVOKEVIRTUAL concurrent/sync/SyncDemo.test ()V
     *    L2
     *     LINENUMBER 21 L2
     *     ALOAD 1
     *     INVOKEVIRTUAL concurrent/sync/SyncDemo.test1 ()V
     *    L3
     *     LINENUMBER 22 L3
     *     RETURN
     *    L4
     *     LOCALVARIABLE args [Ljava/lang/String; L0 L4 0
     *     LOCALVARIABLE syncDemo Lconcurrent/sync/SyncDemo; L1 L4 1
     *     MAXSTACK = 2
     *     MAXLOCALS = 2
     *
     *   // access flags 0x1
     *   public test1()V
     *     TRYCATCHBLOCK L0 L1 L2 null
     *     TRYCATCHBLOCK L2 L3 L2 null
     *    L4
     *     LINENUMBER 25 L4
     *     ALOAD 0
     *     DUP
     *     ASTORE 1
     *     MONITORENTER
     *    L0
     *     LINENUMBER 26 L0
     *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
     *     LDC "=============== demo ==============="
     *     INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
     *    L5
     *     LINENUMBER 27 L5
     *     ALOAD 1
     *     MONITOREXIT
     *    L1
     *     GOTO L6
     *    L2
     *    FRAME FULL [concurrent/sync/SyncDemo java/lang/Object] [java/lang/Throwable]
     *     ASTORE 2
     *     ALOAD 1
     *     MONITOREXIT
     *    L3
     *     ALOAD 2
     *     ATHROW
     *    L6
     *     LINENUMBER 28 L6
     *    FRAME CHOP 1
     *     RETURN
     *    L7
     *     LOCALVARIABLE this Lconcurrent/sync/SyncDemo; L4 L7 0
     *     MAXSTACK = 2
     *     MAXLOCALS = 3
     * }
     */
    public synchronized void test(){
        System.out.println("---------- Synchronized ------------");
    }

    public static void main(String[] args) throws Exception {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.test();
        syncDemo.test1();
    }

    public void test1() throws InterruptedException {
        synchronized (this){
            this.wait();
            System.out.println("=============== demo ===============");
        }
    }

}
