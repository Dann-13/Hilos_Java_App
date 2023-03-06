/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hilos_app_java;

import Clases.Hilo_Sumar;

/**
 *
 * @author danndev
 * Maven
 */
public class Hilos_App_Java {

    public static void main(String[] args) {
        Hilo_Sumar hs = new Hilo_Sumar(5, 2);
        hs.start();
        try {
            Thread.sleep(5000); // espera de 5 segundos antes de detener el hilo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hs.detener();
    }
}
