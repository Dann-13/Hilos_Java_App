/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Sumar;
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
        botonInicio.setBounds(50, 90, 100, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Sumar(0, 1, LblSuma);
            hilo.start();
        });
        this.add(botonInicio);

        JButton botonDetener = new JButton("Detener hilo");
        botonDetener.setBounds(50, 50, 100, 30);
        botonDetener.addActionListener(e -> {
            if (hilo != null) {
                hilo.detener();
            }
        });
        this.add(botonDetener);
    }

}
