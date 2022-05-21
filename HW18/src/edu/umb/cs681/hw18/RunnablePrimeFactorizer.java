package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {

    public RunnablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend);
        if (from >= 2 && to >= from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException("from must be >= 2, and to must be >= from." + "from==" + from + " to==" + to);
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while (dividend != 1 && divisor <= to) {
            if (divisor > 2 && isEven(divisor)) {
                divisor++;
                continue;
            }
            if (dividend % divisor == 0) {
                factors.add(divisor);
                dividend /= divisor;
            } else {
                if (divisor == 2)
                    divisor++;
                else
                    divisor += 2;
            }
        }
    }

    protected boolean isEven(long n) {
        return n % 2 == 0;
    }

    public void run() {
        generatePrimeFactors();
        System.out.println("The current Thread ID: " + Thread.currentThread().getId() + " generated " + factors);
    }


    public static void main(String[] args) {

        int one = 1826;
        int two = 1800;
        int three = 4529;

        System.out.println("Prime Factorization of " + one + " using two fixed threads pools");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new RunnablePrimeFactorizer(one, 2, (long) Math.sqrt(one) / 2));
        executor.execute(new RunnablePrimeFactorizer(two, 3, (long) Math.sqrt(two) / 2));
        executor.execute(new RunnablePrimeFactorizer(three, 5, (long) Math.sqrt(three) / 2));

        executor.shutdown();
    }
}
