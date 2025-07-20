/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casino;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author elmas
 */
public class Casino extends JFrame {
    private PlayerLocal jugador;
    
    

    private JButton b1, b2, b3;
    private JLabel fondo1, palace;

    public Casino(PlayerLocal jugador) {
        this.jugador = jugador;
        System.out.println(jugador.tokens);
        //Fondo
        ImageIcon fondo = new ImageIcon(getClass().getResource("/casino/Fondos/Random.jpg"));
        fondo1 = new JLabel(fondo);
        fondo1.setBounds(0, 0, 500, 500); // Tamaño igual al JFrame

        setContentPane(fondo1);
        fondo1.setLayout(null);
        setTitle("Aaron's Palace"); //Nombre de la ventana)?

        ImageIcon jlabelimagen = new ImageIcon(getClass().getResource("/casino/Imagenes/Aaron.png"));
        Image imagenResized = jlabelimagen.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenResized);
        palace = new JLabel(imagenIcon);
        palace.setBounds(55, -20, 400, 200);
        
        fondo1.add(palace);

        //Agrego botones
        b1 = new JButton("GAMBLING");
        b1.setBounds(200, 150, 100, 50); //X , Y , WIDTH , HEIGHT
        fondo1.add(b1);

        b2 = new JButton("Blackjack");
        b2.setBounds(200, 250, 100, 50); //X , Y , WIDTH , HEIGHT
        fondo1.add(b2);

        b3 = new JButton("Salir");
        b3.setBounds(200, 350, 100, 50); //X , Y , WIDTH , HEIGHT
        fondo1.add(b3);

        //Action Perfomed
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gambling gambling = new Gambling(jugador);
                dispose();

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BlackJack blackjack = new BlackJack(jugador);
                dispose();

            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // cerrar programa
            }
        });

        //Propiedades de pantalla
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        PlayerLocal jugador = new PlayerLocal();
        jugador.tokens = Archivo.conseguirTokens();
        Casino casino = new Casino(jugador);
    }

}
