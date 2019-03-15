package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":我来看看能不能拿到锁1");
                if (lock1.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + ":哈哈我拿到锁1了！");
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                        if (lock2.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + ":哈哈我也拿到锁2了！");
                            try {
                                System.out.println(Thread.currentThread().getName() + ":My Job done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        System.out.println(Thread.currentThread().getName() + ":释放锁1");
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":我来看看能不能拿到锁2");
                if (lock2.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + ":哈哈我拿到锁2了！");
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                        if (lock1.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + ":哈哈我也拿到锁1了！");
                            try {
                                System.out.println(Thread.currentThread().getName() + ":My Job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        System.out.println(Thread.currentThread().getName() + ":释放锁2");
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
