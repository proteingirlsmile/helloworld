import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

// 5 teacher id ,return 5 list


public class Thread_teacher {
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


    public Thread_teacher() {
    }

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, List> resultCollector = new HashMap<Integer, List>();
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            MultiThread mt = new MultiThread(i, resultCollector,reentrantLock);
            mt.start();
        }
        System.out.println(resultCollector);


    }

}
