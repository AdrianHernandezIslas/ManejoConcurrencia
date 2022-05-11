/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnm.oaxaca.manejoconcurencia;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Adrian
 */
public class Buffer {

    private final Queue<Integer> contenedor = new LinkedList<>();
    private boolean available = false;

    public synchronized void addNumber(Integer number) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        contenedor.add(number);
        available = true;
        notifyAll();
    }

    public synchronized Integer getNumber() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
        return contenedor.remove();
    }

    public synchronized boolean isEmty() {
        return contenedor.isEmpty();
    }
}
