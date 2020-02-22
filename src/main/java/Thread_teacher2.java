import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

// 5 teacher id ,return 5 list


public class Thread_teacher2 {
//    public class MultiThread extends Thread {
//        public HashMap student;
//        public HashMap teacher;
//
//        @Override
//        public synchronized void run() {
//            for (Map.Entry<String, Integer> entry : teacher.entrySet()) {
//                String sKey = "Student" + entry.getValue();
//                student.put(sKey, entry.getValue() - 1);
//
//            }
//
//        }


    public Thread_teacher2() {
    }


    public static void main(String[] args) throws InterruptedException {
        Map<Integer, List> resultCollector = new ConcurrentHashMap<Integer, List>();
//        ReentrantLock reentrantLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 100; i++) {
//            MultiThread mt = new MultiThread(i, resultCollector);
//            mt.start();
            Runnable runnable = new MyRunnable(i,resultCollector);
            executorService.submit(runnable);
        }
        executorService.shutdown();
        System.out.println(resultCollector);


    }

}
