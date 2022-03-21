package edu.umb.cs681.hw07;

public class RunnableConcurrentSingleton implements Runnable{
    @Override
    public void run() {
        System.out.println(ConcurrentSingleton.getInstance());
    }

    public static void main(String[] args) {
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
    }

}
