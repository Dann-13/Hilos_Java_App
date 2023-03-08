/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContenedoresJFrame;

import Clases.Hilo_Sumar;
import Panel.PanelHilos;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author danndev
 */
public class JFrame_Hilos extends JFrame {
    PanelHilos panelHilos;
    public JFrame_Hilos() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        //este metodo se encarga de dar las propiedades de la ventana contenedora del panel
        this.setSize(800, 600); //Alto y ancho de nuestro frame
        this.setTitle("Hilos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout(2, 2));
    }

    private void inicializadorObjetos() {
        panelHilos = new PanelHilos();
        this.getContentPane().add(panelHilos);
    }

}
