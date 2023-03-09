/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Multiplicar;
import Clases.Hilo_Restar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danndev
 */
public class PanelHiloMultiplicar extends JPanel {

    JLabel LblMUltiplicar;
    Hilo_Multiplicar hilo;

    public PanelHiloMultiplicar() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() {
        LblMUltiplicar = new JLabel("La multiplicacion es");
        LblMUltiplicar.setBounds(100, 20, 250, 30);
        LblMUltiplicar.setHorizontalAlignment(JLabel.CENTER);
        LblMUltiplicar.setForeground(Color.BLACK);
        this.add(LblMUltiplicar);

        JButton botonInicio = new JButton("Iniciar hilo");
        botonInicio.setBounds(120, 70, 150, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Multiplicar(1, 2, LblMUltiplicar, botonInicio);
            hilo.start();
        });
        // Añadir un efecto de sombra
        botonInicio.setFocusPainted(false);
        botonInicio.setContentAreaFilled(false);
        botonInicio.setOpaque(true);
        botonInicio.setBorderPainted(false);
        botonInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonInicio.setBackground(new Color(30, 144, 255));
                botonInicio.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonInicio.setBackground(new Color(0, 128, 255));
                botonInicio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            }
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
        JButton botonTerminar = new JButton("detener hilo");
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
