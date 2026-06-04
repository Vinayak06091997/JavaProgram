package Multithreading;

public class MonitorLock {
    static class MonitorLockTask {

        synchronized void  task1()  {
            try {
                System.out.println("task1 is executing by thread: " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("task1 is completed by thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        void task2() {
            System.out.println("Task2 before synchronise");
            synchronized (this){
                System.out.println("task2 inside synchronise and completed " + Thread.currentThread().getName());
            }
        }

        void task3() {
            System.out.println("task3 is executing by thread: " + Thread.currentThread().getName());
        }
    }

    void main() throws InterruptedException {
        MonitorLockTask monitorLockTask=new MonitorLockTask();
        Thread thread1=new Thread(monitorLockTask::task1);
        Thread thread2=new Thread(monitorLockTask::task2);
        Thread thread3=new Thread(monitorLockTask::task3);
        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
    }

}

