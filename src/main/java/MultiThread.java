import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread extends Thread {
    private final ReentrantLock reentrantLock;
    public Integer teacherId;
    public Map<Integer,List> resultList;

    MultiThread(Integer teacherId, Map<Integer, List> resultList, ReentrantLock reentrantLock){

         this.teacherId=teacherId;
         this.resultList=resultList;
         this.reentrantLock=reentrantLock;
    }


    @Override
    public void run() {

        List studentList = new ArrayList();
        for(int i=0;i<5;i++){
            studentList.add(teacherId.intValue()-(i+1));
        }
        try {
            reentrantLock.lock();
            resultList.put(this.teacherId, studentList);

        }finally {
            reentrantLock.unlock();
        }
    }

}