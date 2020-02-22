public class Thread2 {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("run"+Thread.currentThread().getName());
            }
        };
        Thread thd = new Thread(runnable);
        thd.start();
        Thread.sleep(2000);
        System.out.println("main"+Thread.currentThread().getName());
    }
}
