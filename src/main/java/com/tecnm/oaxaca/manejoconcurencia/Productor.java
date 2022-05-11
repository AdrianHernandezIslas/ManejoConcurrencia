/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnm.oaxaca.manejoconcurencia;

/**
 *
 * @author Adrian
 */
public class Productor extends Thread {

    private Buffer buffer;
    private final int MAX_COUNT = 10;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void generate() {
        int number = (int) ((Math.random() * 100) + 1);
        buffer.addNumber(number);
    }

    @Override
    public void run() {
        try {
            int counter = 0;
            while (true) {
                Thread.sleep(2000);
                generate();
                counter++;
                System.out.println(getName()+" generated -> "+counter);
            }
        } catch (InterruptedException ex) {
           
        }
    }

}
