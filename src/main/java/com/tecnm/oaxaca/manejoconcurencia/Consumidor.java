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
public class Consumidor extends Thread {

    private Buffer buffer;
    private String name;

    public Consumidor(String name,Buffer buffer) {
        this.buffer = buffer;
        this.name = name;
    }

    public void consume() {
        int number = buffer.getNumber();
        System.out.println(getName()+" number ->"+number);
    }

    @Override
    public void run() {
         try {
            while (true) {
                if(!buffer.isEmty()){
                    this.consume();
                }else{
                    System.out.println("Consumidor zzzzz....");
                    Thread.sleep(1000);
                }
            }
            
        } catch (InterruptedException ex) {
           
        }
    }
}
