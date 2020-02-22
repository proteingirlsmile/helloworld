public class Thread1 {
    static class Mythread extends Thread{
        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("mythread run");
        }
    }

    public static void main(String[] args) {
        Thread thd = new Mythread();
        thd.start();
        System.out.println("main");
    }
}
