import java.util.concurrent.locks.ReentrantLock;

public class Thread4 {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        Runnable runnable = new Runnable() {
            public void run() {

                for (int i = 0; i < 10000; i++) {

                    reentrantLock.lock();
                    count = count + 1;
                    reentrantLock.unlock();
                }
                System.out.println("run" + Thread.currentThread().getName());
            }
        };
        Thread thd = new Thread(runnable);

        thd.start();
        new Thread(runnable).start();
        System.out.println("main"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println(count);
    }
}
