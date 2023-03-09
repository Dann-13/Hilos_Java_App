/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Restar;
import Clases.Hilo_Sumar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danndev
 */
public class PanelHiloRestar extends JPanel {
    JLabel LblResta; 
    Hilo_Restar hilo;

    public PanelHiloRestar() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.blue);
    }

    private void inicializadorObjetos() {
        LblResta = new JLabel("La resta es");
        LblResta.setBounds(120, 20, 150, 30);
        LblResta.setHorizontalAlignment(JLabel.CENTER);
        LblResta.setForeground(Color.BLACK);
        this.add(LblResta);

        JButton botonInicio = new JButton("Iniciar hilo");
        botonInicio.setBounds(120, 70, 150, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Restar(1000, 2, LblResta, botonInicio);
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
