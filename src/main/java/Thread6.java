import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Thread6 {

    static class Count{
        int value =0;
        Object lock =new Object();

        public synchronized void increase() throws InterruptedException {
            value++;
            if(value%2==0){
                wait();

            }
            System.out.println(value);
        }

        public void increase1() {
            synchronized(this) {
                value++;
            }
            System.out.println(value);
        }

        public void increase2() {
            synchronized(lock) {
                value++;
            }
        }

        public synchronized void decrease() {
            value--;
        }

        public static  synchronized void print() {
            System.out.println(123);
        }


        public static  synchronized void print1() {
            System.out.println(123);
        }

    }

    static class MyRunable implements Runnable{
        ReentrantLock reentrantLock ;
        public Thread5.Count countb;

        public MyRunable(Thread5.Count count, ReentrantLock reentrantLock) {
            this.reentrantLock=reentrantLock;
            countb=count;
        }

        public void run() {

            for (int i = 0; i < 10000; i++) {

//                reentrantLock.lock();
                try {
                    countb.increase();
                    countb.decrease();
                }
                catch(Exception e){

                }
                finally {
//                    reentrantLock.unlock();
                }

            }
            System.out.println(countb);
            System.out.println("run" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread5.Count count = new Thread5.Count();
        final ReentrantLock reentrantLock = new ReentrantLock();
        MyRunable runable=new MyRunable(count,reentrantLock);
        MyRunable runable1=new MyRunable(count,reentrantLock);
        executorService.submit(runable);
        executorService.submit(runable1);

    }
}
