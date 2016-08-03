package my.goit.java;

public class SimpleSemaphore implements Semaphore {
    private int availablePermits;
    private int maxPermits;


    public SimpleSemaphore(int permits) {
        this.availablePermits = permits;
        this.maxPermits = permits;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        if (getAvailablePermits() > 0){
            setAvailablePermits(getAvailablePermits() - 1);
        } else {
            this.wait();
        }
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits < 1){
            System.out.println("Error: permits should be > 0");
            return;
        }
        if (getAvailablePermits() - permits >= 0){
            setAvailablePermits(getAvailablePermits() - permits);
        } else {
            this.wait();
            this.notify();
        }

    }

    @Override
    public synchronized void release() {
        if (getAvailablePermits() < maxPermits) {
            setAvailablePermits(getAvailablePermits() + 1);
        }
        this.notify();
    }

    @Override
    public synchronized void release(int permits) {
        if (permits < 1){
            System.out.println("Error: permits should be > 0");
            return;
        }
        if (permits + getAvailablePermits() <= maxPermits){
            setAvailablePermits(permits + getAvailablePermits());
        } else {
            setAvailablePermits(maxPermits);
        }
        this.notify();
    }

    @Override
    public int getAvailablePermits() {
        return availablePermits;
    }

    public void setAvailablePermits(int availablePermits) {
        this.availablePermits = availablePermits;
    }
}
