/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author danndev
 */
public class Hilo_Sumar extends Thread {

    private int num1, num2;
    private boolean parar = false;

    public Hilo_Sumar(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    @Override
    public void run() {
        while (!parar) {
            int resultado = num1 + num2;
            System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);
            num1 = num2;
            num2 = resultado;
            try {
                Thread.sleep(1000); //hilo duerma durante 1 segundos antes de continuar con la siguiente suma.
            } catch (InterruptedException e) {
                System.out.println("El hilo ha sido interrumpido");
            }
            
        }
        System.out.println("El hilo ha sido detenido.");

    }

    public void detener() {
        parar = true;

    }

}
