package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {

    private double balance = 0;
    private final ReentrantLock lock = new ReentrantLock();
    Condition sufficientFundsCondition = lock.newCondition();
    Condition belowUpperLimitFundsCondition = lock.newCondition();
    public void withdraw(double amount){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ": The Current Balance is :" + balance);

        while (balance <= 0) {
        	try {
        		System.out.println(Thread.currentThread().getName() + ": The Balance below the limit : Await Deposit");
                sufficientFundsCondition.await();
        	}
        	catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + ": The Balance after withdrawal : " + balance);
        belowUpperLimitFundsCondition.signalAll();
        lock.unlock();
        
    }
    public void deposit(double amount){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ": The Current Balance is : " + balance);

        while (balance >= 300) {
        	try {
        		System.out.println(Thread.currentThread().getName() + ": The Balance exceeded the limit - Await Withdrawal");
                belowUpperLimitFundsCondition.await();
        	}
        	catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }

        balance += amount;
        System.out.println(Thread.currentThread().getName() + ": The Balance after the deposit	: " + balance);
        sufficientFundsCondition.signalAll();
        lock.unlock();
        
    }
}
