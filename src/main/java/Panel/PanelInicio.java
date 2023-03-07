/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import ContenedoresJFrame.Inicio;
import ContenedoresJFrame.JFrame_Hilos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danndev
 */
public class PanelInicio extends JPanel {
    JFrame_Hilos hilos;
    Inicio inicio;
    JLabel lblTitulo, labelImagen, lblHechoPor;
    JButton btnIniciar;

    public PanelInicio(Inicio inicio) {
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
        this.inicio = inicio;
    }

    private void inicializador() {
        this.setLayout(null);
    }

    private void inicializadorObjetos() {
        lblTitulo = new JLabel();
        lblTitulo.setText("Hilos en Java");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTitulo.setBounds(140, 20, 200, 30);
        this.add(lblTitulo);

        ImageIcon icon = new ImageIcon("./src/main/java/Source/upc.png");
        //Ajustamos el tamaño del la imagen al label
        icon.setImage(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        labelImagen = new JLabel();
        labelImagen.setIcon(icon);
        labelImagen.setBounds(150, 70, 100, 100);
        this.add(labelImagen);

        btnIniciar = new JButton();
        btnIniciar.setBounds(150, 200, 100, 30);
        btnIniciar.setText("Iniciar");
        btnIniciar.setBackground(new Color(152, 65, 235));
        btnIniciar.setOpaque(true);
        btnIniciar.setForeground(Color.white);
        btnIniciar.setBorder(BorderFactory.createEmptyBorder());
        this.add(btnIniciar);

        lblHechoPor = new JLabel();
        lblHechoPor.setText("Hecho Por Daniel Gomez");
        lblHechoPor.setFont(new Font("Arial", Font.PLAIN, 13));
        lblHechoPor.setForeground(Color.white);
        lblHechoPor.setHorizontalAlignment(JLabel.CENTER);
        lblHechoPor.setOpaque(true);
        lblHechoPor.setBackground(new Color(152, 65, 235));
        lblHechoPor.setBounds(0, 338, 400, 30);
        this.add(lblHechoPor);
    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnMonedas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnIniciarClick();
            }

        };
        btnIniciar.addActionListener(escuchaBtnMonedas);

    }

    private void escuchaBtnIniciarClick() {
        JFrame_Hilos conver = new JFrame_Hilos();
        conver.setVisible(true);
        this.inicio.dispose();
    }
}
