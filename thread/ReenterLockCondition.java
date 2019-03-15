package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("t拿到锁");
            condition.await();
            System.out.println("t我醒啦(拿到锁才能醒哦)");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("t释放锁");
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ReenterLockCondition tl = new ReenterLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(2000);
        //通知线程t1继续执行
        lock.lock();
        System.out.println("main拿到锁");
        condition.signal();
        System.out.println("封印解除！苏醒吧t！");
        lock.unlock();//不放锁t就醒不了哦嘤嘤嘤
        System.out.println("main释放锁");
    }
}
