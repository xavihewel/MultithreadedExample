/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.multithreadedexample;

import java.util.concurrent.Callable;

/**
 *
 * @author xavier.verges
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int total = 0;
        for (int i = 0; i <= 5; i++) {
            total += i;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
        return total;
    }
}
