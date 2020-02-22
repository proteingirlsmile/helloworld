import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Thread5 {

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
        private final ArrayList<Object> list;
        ReentrantLock reentrantLock ;
        public Count countb;

        public MyRunable(Count count, ReentrantLock reentrantLock, ArrayList<Object> list) {
            this.reentrantLock=reentrantLock;
            countb=count;
            this.list=list;
        }

        public void run() {

            for (int i = 0; i < 10000; i++) {

//                reentrantLock.lock();
                try {
                    countb.increase();
                    countb.decrease();
                    list.add(1);
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
        Count count = new Count();
        ArrayList<Object> list = new ArrayList<Object>();
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<Object, Object>();
        final ReentrantLock reentrantLock = new ReentrantLock();

        MyRunable runnable = new MyRunable(count,reentrantLock,list) ;
//        runnable.countb=value;

        Thread thd = new Thread(runnable);

        thd.start();
        new Thread(runnable).start();
        System.out.println("main"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println(count.value);
    }
}
