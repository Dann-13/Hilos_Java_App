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

    private int num1, num2, guardado;
    private boolean iniciar, pausar;
    //es una referencia a un objeto que se utiliza para controlar la pausa y la reanudación del hilo.
    private Object pauseLock;
    private JLabel lblres;

    public Hilo_Sumar(int num1, int num2, JLabel lblres) {
        this.num1 = num1;
        this.num2 = num2;
        this.lblres = lblres;
        this.guardado = 0;
        this.iniciar = true;
        this.pausar = false;
        this.pauseLock = new Object();
    }

    @Override
    public void run() {
        // Desactivar el botón para evitar múltiples clics
        lblres.setEnabled(false);

        while (true) {
            // Verificar si se debe pausar el hilo
            synchronized (pauseLock) {
                while (pausar) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // Sumar los dos números y mostrar el resultado en la consola
            int resultado = num1 + num2;
            System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);
            SwingUtilities.invokeLater(() -> lblres.setText("resultado  " + resultado));
            num1 = num2;
            System.out.println(num1);
            num2 = resultado;

            // Esperar 5 segundos antes de volver a sumar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void pausarHilo() {
        pausar = true;
    }

    public void continuarHilo() {
        synchronized (pauseLock) {
            pausar = false;
            pauseLock.notifyAll();
        }
    }

}
