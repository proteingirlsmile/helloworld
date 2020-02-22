import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable {
    private ReentrantLock reentrantLock;
    public Integer teacherId;
    public Map<Integer, List> resultList;

    public MyRunnable(Integer teacherId, Map<Integer, List> resultList) {

        this.teacherId = teacherId;
        this.resultList = resultList;

    }


    public void run() {
        List studentList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            studentList.add(teacherId.intValue() - (i + 1));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+teacherId);
        resultList.put(this.teacherId, studentList);

    }
}
