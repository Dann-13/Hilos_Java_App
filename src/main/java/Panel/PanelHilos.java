/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Sumar;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danndev
 */
public class PanelHilos extends JPanel {

    JLabel LblSuma;
    private Hilo_Sumar hilo;

    public PanelHilos() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
    }

    private void inicializadorObjetos() {
        LblSuma = new JLabel("La suma de 5 y 2 es: 7");
        LblSuma.setBounds(10, 20, 200, 30);
        this.add(LblSuma);

        JButton botonInicio = new JButton("Iniciar hilo");
        botonInicio.setBounds(50, 90, 150, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Sumar(0, 1, LblSuma);
            hilo.start();
        });
        this.add(botonInicio);

        JButton botonParar = new JButton("Ṕarar hilo");
        botonParar.setBounds(50, 50, 100, 30);
        botonParar.addActionListener(e -> {
            if (hilo != null) {
                hilo.pausarHilo();
            }
        });

        this.add(botonParar);
        JButton botonContinuar = new JButton("Conyinuar");
        botonContinuar.setBounds(50, 200, 100, 30);
        botonContinuar.addActionListener(e -> {
            if (hilo != null) {
                hilo.continuarHilo();
            }
        });

        this.add(botonContinuar);
//        
//        JButton botondetenerse = new JButton("detener hilo");
//        botondetenerse.setBounds(50, 250, 100, 30);
//        botondetenerse.addActionListener(e -> {
//            if (hilo != null) {
//                hilo.reiniciarSuma();
//            }
//        });
//        this.add(botondetenerse);
    }

}
