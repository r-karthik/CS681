package edu.umb.cs681.hw04;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {
        RunnablePrimeGenerator runnablePrimeGenerator = new RunnablePrimeGenerator(1L, 2000000L);
        Thread thread = new Thread(runnablePrimeGenerator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        runnablePrimeGenerator.getPrimes().forEach( (Long prime)-> System.out.println(prime + ", ") );
        long primeNum = runnablePrimeGenerator.getPrimes().size();
        System.out.println("\n" + primeNum + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 2 threads
        RunnablePrimeGenerator runnablePrimeGenerator1 = new RunnablePrimeGenerator(1L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator2 = new RunnablePrimeGenerator(1000001L, 2000000L);
        Thread thread1 = new Thread(runnablePrimeGenerator1);
        Thread thread2 = new Thread(runnablePrimeGenerator2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        runnablePrimeGenerator1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum1 = runnablePrimeGenerator1.getPrimes().size() + runnablePrimeGenerator2.getPrimes().size();
        System.out.println("\n" + primeNum1 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 4 threads
        RunnablePrimeGenerator runnablePrimeGenerator3 = new RunnablePrimeGenerator(1L, 500000L);
        RunnablePrimeGenerator runnablePrimeGenerator4 = new RunnablePrimeGenerator(500001L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator5 = new RunnablePrimeGenerator(1000001L, 1500000L);
        RunnablePrimeGenerator runnablePrimeGenerator6 = new RunnablePrimeGenerator(1500001L, 2000000L);
        Thread thread3 = new Thread(runnablePrimeGenerator3);
        Thread thread4 = new Thread(runnablePrimeGenerator4);
        Thread thread5 = new Thread(runnablePrimeGenerator5);
        Thread thread6 = new Thread(runnablePrimeGenerator6);
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        runnablePrimeGenerator3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum2 = runnablePrimeGenerator3.getPrimes().size() + runnablePrimeGenerator4.getPrimes().size() + runnablePrimeGenerator5.getPrimes().size() +
                runnablePrimeGenerator6.getPrimes().size();
        System.out.println("\n" + primeNum2 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 8 threads
        RunnablePrimeGenerator runnablePrimeGenerator7  = new RunnablePrimeGenerator(1L, 250000L);
        RunnablePrimeGenerator runnablePrimeGenerator8  = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator runnablePrimeGenerator9  = new RunnablePrimeGenerator(500000L,750000L);
        RunnablePrimeGenerator runnablePrimeGenerator10 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator11 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator runnablePrimeGenerator12 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator runnablePrimeGenerator13 = new RunnablePrimeGenerator(1500000L,1750000L);
        RunnablePrimeGenerator runnablePrimeGenerator14 = new RunnablePrimeGenerator(1750000L, 2000000L);

        Thread thread7  = new Thread(runnablePrimeGenerator7);
        Thread thread8  = new Thread(runnablePrimeGenerator8);
        Thread thread9  = new Thread(runnablePrimeGenerator9);
        Thread thread10 = new Thread(runnablePrimeGenerator10);
        Thread thread11 = new Thread(runnablePrimeGenerator11);
        Thread thread12 = new Thread(runnablePrimeGenerator12);


        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();

        try {
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
            thread12.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        runnablePrimeGenerator7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator9.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator10.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator11.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        runnablePrimeGenerator12.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum3 = runnablePrimeGenerator7.getPrimes().size() + runnablePrimeGenerator8.getPrimes().size() + runnablePrimeGenerator9.getPrimes().size() +
                runnablePrimeGenerator10.getPrimes().size() + runnablePrimeGenerator11.getPrimes().size() + runnablePrimeGenerator12.getPrimes().size();
        System.out.println("\n" + primeNum3 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

    }
}
