import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerRunnable implements Runnable {
    private ReentrantLock reentrantLock;
    public BlockingQueue<Integer> blockingQueue;

    public ProducerRunnable(BlockingQueue<Integer> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }


    public void run() {
        while (true) {
            blockingQueue.add(666);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ");
            System.out.println(blockingQueue.size());
        }
    }

}
