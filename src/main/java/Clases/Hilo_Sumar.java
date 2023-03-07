/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author danndev
 */
public class Hilo_Sumar extends Thread {

    private int num1, num2;
    private boolean parar = false;
    private JLabel lblres;

    public Hilo_Sumar(int num1, int num2, JLabel lblres) {
        this.num1 = num1;
        this.num2 = num2;
        this.lblres = lblres;
    }

    @Override
    public void run() {
        while (!parar) {
            int resultado = num1 + num2;
            System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);
            SwingUtilities.invokeLater(() -> lblres.setText("La suma de " + num1 + " y " + num2 + " es: " + resultado));
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
