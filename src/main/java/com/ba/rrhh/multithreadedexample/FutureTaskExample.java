/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.multithreadedexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *
 * @author xavier.verges
 */
public class FutureTaskExample {

    public static void main(String[] args) {
        MyRunnable myrunnableobject1 = new MyRunnable(5000);
        MyRunnable myrunnableobject2 = new MyRunnable(10000);

        FutureTask<String> futureTask1 = new FutureTask<>(myrunnableobject1,
                "FutureTask1 is complete");
        FutureTask<String> futureTask2 = new FutureTask<>(myrunnableobject2,
                "FutureTask2 is complete");

        // create therad pool of 2 size for ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(futureTask1);

        executor.submit(futureTask2);

        while (true) {
            try {
                while (!futureTask2.isDone()) {
                    System.out.println("Calculating...");
                }
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Both FutureTask Complete");
                    System.out.println("FutureTask1 output = " + futureTask1.get());
                    System.out.println("FutureTask2 output = " + futureTask2.get());
                    //shutdown executor service
                    executor.shutdown();
                    return;
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }
}
