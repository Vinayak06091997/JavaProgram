package Multithreading;

public class ProducerAndConsumerThread {

    public static class SharedResource{

        boolean isItemPresent=false;

        public synchronized void addItem(){
            isItemPresent=true;
            System.out.println("Producer thread calling the notify method");
            notify();
        }
        public synchronized void consumeItem(){
            System.out.println("Thread consumer Item ");
            if(!isItemPresent){
                try{
                    System.out.println("Thread consumer Item is waiting");
                    wait();
                } catch (InterruptedException e) {

                }
            }
            isItemPresent=false;
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
//        Thread producerThread = new Thread(new Producer(sharedResource));
//        Thread consumerThread = new Thread(new Consumer(sharedResource));
//
//        producerThread.start();
//        consumerThread.start();

        Thread producerThread =new Thread(()->{
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                sharedResource.addItem();
        });
        Thread consumerThread =new Thread(sharedResource::consumeItem);

        producerThread.start();
        consumerThread.start();
    }
}
