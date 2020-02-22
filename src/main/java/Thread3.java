public class Thread3 {

    public static void main(String[] args) {
        Thread thd = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("mythread run");
            }
        };
        thd.start();
        System.out.println("main");
    }
}
