import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        ProducerRunnable producerRunnable = new ProducerRunnable(linkedBlockingQueue);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(linkedBlockingQueue);


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            executorService.submit(producerRunnable);

        }

        ExecutorService executorServiceConsumer = Executors.newFixedThreadPool(20);
        for(int i=0;i<20;i++) {
            executorServiceConsumer.submit(consumerRunnable);
        }

    }

}
