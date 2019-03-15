package thread;

import java.util.concurrent.*;

public class ThreadTest {
//    public static void main(String[] args) throws InterruptedException{
//        RejectThreadPoolDemo.MyTask task = new RejectThreadPoolDemo.MyTask();
//        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
//                new SynchronousQueue<>(),
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        Thread t = new Thread(r);
//                        t.setDaemon(true);
//                        System.out.println("create " + t);
//                        return t;
//                    }
//                });
//        for (int i = 0; i < 5; i++){
//            es.submit(task);
//        }
//        Thread.sleep(2000);
//    }
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i <1_00; i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        System.out.println("main走到这儿了");
    }
}
