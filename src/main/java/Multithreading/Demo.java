package Multithreading;

public class Demo {

    static class MyDemoUsingImpl implements  Runnable{
        @Override
        public void run(){
            System.out.println("inside Thread is: "+Thread.currentThread().getName());
        }
    }

    static class MyDemoUsingExtends extends Thread{
        @Override
        public void run(){
            System.out.println("inside Thread is: "+Thread.currentThread().getName());
        }
    }

    void main()
    {
        System.out.println("Thread name is:"+Thread.currentThread().getName());
        MyDemoUsingImpl myDemo= new MyDemoUsingImpl();
        Thread thread=new Thread(myDemo);
        thread.start();
        System.out.println("Thread name is:"+Thread.currentThread().getName());

        MyDemoUsingExtends myDemoUsingExtends=new MyDemoUsingExtends();
        myDemoUsingExtends.start();
        System.out.println("Thread name is:"+Thread.currentThread().getName());

        Thread thread1=new Thread(()->{
            System.out.println("inside Thread is: "+Thread.currentThread().getName());
        });
        thread1.start();
    }
}
