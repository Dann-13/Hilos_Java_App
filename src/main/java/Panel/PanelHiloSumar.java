/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Sumar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danndev
 */
public class PanelHiloSumar extends JPanel {

    JLabel LblSuma;
    private Hilo_Sumar hilo;

    public PanelHiloSumar() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.red);
    }

    private void inicializadorObjetos() {
        LblSuma = new JLabel("La suma es");
        LblSuma.setBounds(120, 20, 150, 30);
        LblSuma.setHorizontalAlignment(JLabel.CENTER);
        LblSuma.setForeground(Color.BLACK);
        this.add(LblSuma);

        JButton botonInicio = new JButton("Iniciar hilo");
        botonInicio.setBounds(120, 70, 150, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Sumar(0, 1, LblSuma, botonInicio);
            hilo.start();
        });
        this.add(botonInicio);

        JButton botonParar = new JButton("Ṕarar hilo");
        botonParar.setBounds(120, 120, 150, 30);
        botonParar.addActionListener(e -> {
            if (hilo != null) {
                hilo.pausarHilo();
            }
        });

        this.add(botonParar);
        JButton botonContinuar = new JButton("Cotinuar");
        botonContinuar.setBounds(120, 170, 150, 30);
        botonContinuar.addActionListener(e -> {
            if (hilo != null) {
                hilo.continuarHilo();
            }
        });

        this.add(botonContinuar);
//        
        JButton botonTerminar= new JButton("detener hilo");
        botonTerminar.setBounds(120, 220, 150, 30);
        botonTerminar.addActionListener(e -> {
            if (hilo != null) {
                hilo.detenerHilo();
                hilo.reiniciar();
            }
        });
        this.add(botonTerminar);
    }

}
