class StepThread1 extends Thread {

    // общий для двух потоков lock
    private Object lock;

    public StepThread1(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] strings) {
        Object lock = new Object();
        new StepThread1(lock).start();
        new StepThread1(lock).start();
    }
}