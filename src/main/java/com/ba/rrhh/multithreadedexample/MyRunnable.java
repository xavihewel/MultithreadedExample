/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.multithreadedexample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xavier.verges
 */
public class MyRunnable implements Runnable {

    private static final Logger LOG = Logger.getLogger(MyRunnable.class.getName());

    private final long waitTime;

    public MyRunnable(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waitTime);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
}
