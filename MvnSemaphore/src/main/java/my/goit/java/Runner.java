package my.goit.java;

import java.util.Random;

public class Runner {
    private SimpleSemaphore semaphore;
    Random random = new Random();
    int permits;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n The first test is beginning \n");
        new Runner().test();

        System.out.println("\n The second test is beginning \n");
        new Runner().testForAcquire();
    }

    public void test() throws InterruptedException {
        semaphore = new SimpleSemaphore(5);
        for (int i = 0; i < 10; i++) {
            permits = random.nextInt(6);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Number of permits: " + semaphore.getAvailablePermits());
                    try {
                        semaphore.acquire(permits);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread " + Thread.currentThread().getName() + " started");
                    semaphore.release(permits);
                    System.out.println("Thread " + Thread.currentThread().getName() + " finished");
                }
            }).start();
        }
    }

    public void testForAcquire() throws InterruptedException {
        semaphore = new SimpleSemaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Number of permits: " + semaphore.getAvailablePermits());
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread " + Thread.currentThread().getName() + " started");
                    semaphore.release();
                    System.out.println("Thread " + Thread.currentThread().getName() + " finished");
                }
            }).start();
        }
    }

}
