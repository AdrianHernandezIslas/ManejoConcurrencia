/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnm.oaxaca.manejoconcurencia.main;

import com.tecnm.oaxaca.manejoconcurencia.Buffer;
import com.tecnm.oaxaca.manejoconcurencia.Consumidor;
import com.tecnm.oaxaca.manejoconcurencia.Productor;

/**
 *
 * @author Adrian
 */
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor("consumidor",buffer);
        //Consumidor consumidor2 = new Consumidor("consumidor2",buffer);
        //Consumidor consumidor3 = new Consumidor("consumidor3",buffer);
        
        consumidor.start();
        //consumidor2.start();
        //consumidor3.start();
        productor.start();
    }
}
