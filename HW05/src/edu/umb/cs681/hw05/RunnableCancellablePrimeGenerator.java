package edu.umb.cs681.hw05;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void setDone(){
        lock.lock();
        try {
            done = false;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            // Stop generating prime numbers if done==true
            if(done){
                System.out.println("Stopped prime numbers from generating.");
                this.primes.clear();
                break;
            }
            if( isPrime(n) ){ this.primes.add(n); }
        }
    }

    public static void main(String[] args) {
        RunnableCancellablePrimeGenerator runnableCancellablePrimeGenerator = new RunnableCancellablePrimeGenerator(1,100);
        Thread thread = new Thread(runnableCancellablePrimeGenerator);
        thread.start();
        runnableCancellablePrimeGenerator.setDone();
        try {
            thread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        runnableCancellablePrimeGenerator.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
        System.out.println("\n" + runnableCancellablePrimeGenerator.getPrimes().size() + " prime numbers are found.");
    }
}