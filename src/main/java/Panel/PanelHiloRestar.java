/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Clases.Hilo_Restar;
import Clases.Hilo_Sumar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

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
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() {
        LblResta = new JLabel("La resta es");
        LblResta.setBounds(120, 20, 150, 30);
        LblResta.setHorizontalAlignment(JLabel.CENTER);
        LblResta.setForeground(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, 18);
        LblResta.setFont(font);
        this.add(LblResta);

        JButton botonInicio = new JButton("Iniciar hilo");
        botonInicio.setBounds(120, 70, 150, 30);
        botonInicio.addActionListener(e -> {
            hilo = new Hilo_Restar(1000, 2, LblResta, botonInicio);
            hilo.start();
        });
        propiedadesBotones(botonInicio);
        this.add(botonInicio);

        JButton botonParar = new JButton("Ṕarar hilo");
        botonParar.setBounds(120, 120, 150, 30);
        botonParar.addActionListener(e -> {
            if (hilo != null) {
                hilo.pausarHilo();
            }
        });
        propiedadesBotones(botonParar);
        this.add(botonParar);
        JButton botonContinuar = new JButton("Cotinuar");
        botonContinuar.setBounds(120, 170, 150, 30);
        botonContinuar.addActionListener(e -> {
            if (hilo != null) {
                hilo.continuarHilo();
            }
        });
        propiedadesBotones(botonContinuar);
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
        propiedadesBotones(botonTerminar);
        this.add(botonTerminar);

    }

    public static void propiedadesBotones(JButton btn) {

        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        btn.setBorder(border);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(30, 144, 255));
                MatteBorder border = new MatteBorder(0, 0, 1, 0, new Color(30, 144, 255));
                btn.setBorder(border);
                btn.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(30, 144, 255));
                MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
                btn.setBorder(border);
                btn.setBackground(Color.white);
                btn.setForeground(Color.BLACK);
            }
        });
    }

}
