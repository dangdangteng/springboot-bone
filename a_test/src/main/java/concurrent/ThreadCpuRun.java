package concurrent;

/**
 * @author baiyang
 * @date 2021/3/9
 */
public class ThreadCpuRun {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    // 测试 cpu 乱序执行
    // cpu 如何禁止重排序  == 内存屏障

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            // 出现00组合 证明cpu乱序执行了
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }

}
