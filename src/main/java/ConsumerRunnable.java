import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerRunnable implements Runnable {
    private ReentrantLock reentrantLock;
    public BlockingQueue<Integer> blockingQueue;

    public ConsumerRunnable(BlockingQueue<Integer> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }


    public void run() {
        while (true) {
            try {
                System.out.println("consumer " + blockingQueue.take());

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ");
        }
    }
}
