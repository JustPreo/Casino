/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.*;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import javax.swing.Timer;

/**
 *
 * @author elmas
 */
public class Gambling extends JFrame {

    private PlayerLocal jugador;

    private JLabel fondo1;
    boolean jugando = false;
    Fotos fotos = new Fotos();
    //Declaracion botones
    JButton bet1, bet2, bet3, Atras;
    JLabel slot1I, slot2I, slot3I, Dinero;
    Random random = new Random();
    //Timer timer = new Timer();

    int slot1, slot2, slot3;

    public Gambling(PlayerLocal jugador) {
        try {
            URL sonido = getClass().getResource("/casino/WAV/letsgo.wav");
            if (sonido == null) {
                System.out.println("WOMP WOMP NULL");
            } else {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(sonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.jugador = jugador;
        setTitle("GAMBLING");
        setSize(800, 500);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/casino/Fondos/BlackJack.jpg"));
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel fondo1 = new JLabel(iconoEscalado);
        fondo1.setBounds(0, 0, 800, 500); // Tamaño igual al JFrame
        setContentPane(fondo1);
        fondo1.setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //Jlabel?
        Dinero = new JLabel("TOKENS: " + jugador.tokens);
        Dinero.setForeground(Color.BLACK);
        Dinero.setOpaque(true);
        Dinero.setBackground(Color.white);
        Dinero.setBounds(0, 0, 100, 30);
        fondo1.add(Dinero);

        slot1I = new JLabel();
        slot1I.setIcon(fotos.getSlot(1).imagen);
        slot1I.setBounds(250, 75, 250, 250);
        fondo1.add(slot1I);

        slot2I = new JLabel();
        slot2I.setIcon(fotos.getSlot(1).imagen);
        slot2I.setBounds(350, 75, 250, 250);
        fondo1.add(slot2I);

        slot3I = new JLabel();
        slot3I.setIcon(fotos.getSlot(1).imagen);
        slot3I.setBounds(450, 75, 250, 250);
        fondo1.add(slot3I);

        //Botones
        bet1 = new JButton("BET 1");
        bet1.setBounds(250, 250, 100, 100);
        fondo1.add(bet1);

        bet2 = new JButton("BET 2");
        bet2.setBounds(350, 250, 100, 100);
        fondo1.add(bet2);

        bet3 = new JButton("BET 3");
        bet3.setBounds(450, 250, 100, 100);
        fondo1.add(bet3);

        Atras = new JButton("Atras");
        Atras.setBounds(660, 410, 125, 50);
        fondo1.add(Atras);

        int[] contador = {0};
        Slot[] slots = new Slot[3];
        //Action Listeners
        bet1.addActionListener(new ActionListener() { //Cuando le de al boton de jugar
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets

                funcion(1);

            }
        });

        bet2.addActionListener(new ActionListener() { //Cuando le de al boton de jugar
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets
                funcion(2);

            }
        });

        bet3.addActionListener(new ActionListener() { //Cuando le de al boton de jugar
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets
                funcion(3);

                if (jugando) {
                    System.out.println("Jugando");
                }

            }
        });

        Atras.addActionListener(new ActionListener() { //Cuando le de al boton de jugar
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets

                if (!jugando) {
                    Casino casino = new Casino(jugador);
                    casino.setVisible(true);
                    dispose();
                }

            }
        });

        //Visible
        setVisible(true);

    }

    /*
    public static void main(String[] args) {
        PlayerLocal jugador = new PlayerLocal();
        Gambling gambling = new Gambling(jugador);
    }
     */
    public void funcion(int bet) {
        if (jugador.tokens < bet) {
            JOptionPane.showMessageDialog(null, "No puedes apostar , ve a mendigar");
            return;
        }
        int contador[] = {0};
        Slot slots[] = new Slot[3];
        //Logica despues de bets
        if (!jugando) {
            jugador.tokens -= bet;
            Dinero.setText("TOKENS: " + jugador.tokens);
            Timer timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (contador[0] < 30) {
                        int numeroR = random.nextInt(16);

                        if (contador[0] < 10) {
                            slot1I.setIcon(fotos.getSlot(numeroR).imagen);
                            slots[0] = fotos.getSlot(numeroR);
                        }

                        if (contador[0] < 20) {
                            slot2I.setIcon(fotos.getSlot(numeroR).imagen);
                            slots[1] = fotos.getSlot(numeroR);
                        }

                        slot3I.setIcon(fotos.getSlot(numeroR).imagen);
                        slots[2] = fotos.getSlot(numeroR);
                        //DEBUG
                        System.out.println(numeroR);
                        System.out.println("Numero R");
                        contador[0]++;
                    } else {
                        ((Timer) e.getSource()).stop();
                        int multiplicador = getMultiplicador(slots[0].valor, slots[1].valor, slots[2].valor);
                        int ganancia = bet * multiplicador;
                        if (ganancia > 0) {
                            jugador.tokens += ganancia;
                            JOptionPane.showMessageDialog(null, "Ganaste " + ganancia + " con multiplicador de " + multiplicador);
                            Dinero.setText("TOKENS: " + jugador.tokens);
                            Archivo.guardarTokens(jugador);
                        } else {
                            JOptionPane.showMessageDialog(null, "WOMP WOMP");
                            Dinero.setText("TOKENS: " + jugador.tokens);
                            Archivo.guardarTokens(jugador);
                        }
                        jugando = false;

                    }

                }
            });
            jugando = true;
            timer.start(); // Inicia el timer
            contador[0] = 0;

        }

        if (jugando) {
            System.out.println("Jugando");
        }

    }

    public int getMultiplicador(int v1, int v2, int v3) {
        if (v1 == v2 && v1 == v3) {
            return 3;
        }

        if (v1 == v2 || v1 == v3 || v2 == v3) {
            return 2;
        } else {
            return 0;
        }

    }

}
