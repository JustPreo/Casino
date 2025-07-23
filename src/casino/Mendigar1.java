/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author user
 */
public class Mendigar1 extends JFrame {

    private PlayerLocal jugador;
    private JButton persona1, persona2, persona3;
    private JLabel personaje, fondo1, piso;
    private NPCS[] npcs;
    private NPCS[] spawner;

    public Mendigar1(PlayerLocal jugador, int limiteNPCS) {
        this.jugador = jugador;
        spawner = new NPCS[limiteNPCS];
        npcs = new NPCS[3];
        //Formato = (int rango, int dinero, int probabilidades, String rutaI
        npcs[0] = new NPCS(1, 5, 50, "/casino/MENDIGAR/pobre.png");
        npcs[1] = new NPCS(1, 10, 40, "/casino/MENDIGAR/promedio.png");
        npcs[2] = new NPCS(1, 20, 10, "/casino/MENDIGAR/rico.png");

        for (int i = 0; i < spawner.length; i++) {
            Random random = new Random();
            int n = random.nextInt(3);
            if (n == 2) {
                int probabilidad = random.nextInt(100);
                if (probabilidad < 50) {
                    n = 0;
                }
            }
            spawner[i] = npcs[n];
            System.out.println("NPC AGREGADO AL SPAWNER");
        }

        ImageIcon fondo = new ImageIcon(getClass().getResource("/casino/Fondos/Random.jpg"));
        fondo1 = new JLabel(fondo);
        //fondo1.setBackground(fondo);
        fondo1.setBounds(0, 0, 1280, 720); // Tamaño igual al JFrame
        setContentPane(fondo1);
        fondo1.setLayout(null);
        setTitle("Aaron's Palace"); //Nombre de la ventana)?
        setSize(1280, 720);

        piso = new JLabel("A");

        piso.setBounds(00, 420, 1280, 300);
        piso.setOpaque(true);
        piso.setForeground(Color.yellow);
        piso.setBackground(Color.green);
        fondo1.add(piso);

        persona1 = new JButton();
        persona1.setBounds(275, 50, 100, 100);
        persona1.setIcon(npcs[0].imagen);
        //Esta seccion quita el resaltado del boton 
        persona1.setBorderPainted(false);
        persona1.setContentAreaFilled(false);
        fondo1.add(persona1);
        persona1.setVisible(true);

        persona2 = new JButton();
        persona2.setBounds(375, 50, 100, 100);
        persona2.setIcon(npcs[1].imagen);
        //Esta seccion quita el resaltado del boton x2
        persona2.setBorderPainted(false);
        persona2.setContentAreaFilled(false);
        fondo1.add(persona2);
        persona2.setVisible(true);

        spawnear();

        //Listeners
        persona1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(npcs[0].cambio());

            }
        });

        persona2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(npcs[2].cambio());

            }
        });

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void animar(JButton boton, int xdeseada, int ydeseada, int intervalo, int posArreglo) {
        int posicionx = boton.getX();
        int posiciony = boton.getY();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            int posx = posicionx;
            int posy = posiciony;

            @Override
            public void run() {
                posx += xdeseada;
                posy += ydeseada;

                int limitePantalla = fondo1.getWidth();
                if (posx > limitePantalla) {
                    posx = 0;
                    posy = posiciony;

                    Random random = new Random();
                    int n = random.nextInt(3);
                    if (n == 2) {
                        int probabilidad = random.nextInt(100);
                        if (probabilidad < 50) {
                            n = 0;
                        }
                    }
                    spawner[posArreglo] = npcs[n];
                    boton.setIcon(spawner[posArreglo].imagen);
                    System.out.println("Se cambio el npc?");
                    repaint();
                }

                boton.setBounds(posx, posy, boton.getWidth(), boton.getHeight());

            }
        };
        timer.scheduleAtFixedRate(task, 0, intervalo);

    }//Fin de animar

    public void spawnear() {
        Random random = new Random();

        int xI = 0;
        int yI = 100;

        for (int i = 0; i < spawner.length; i++) {
            int espacio = 0 - random.nextInt(100, 150);
            JButton persona = new JButton();
            persona.setBounds((i * espacio), 100, 100, 100);
            persona.setIcon(spawner[i].imagen);
            //Esta seccion quita el resaltado del boton 
            persona.setBorderPainted(false);
            persona.setContentAreaFilled(false);
            System.out.println("Spawned");

            int i2 = i;
            persona.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(spawner[i2].cambio());
                    fondo1.remove(persona);
                    fondo1.repaint();
                }
            });

            fondo1.add(persona);
            persona.setVisible(true);

            animar(persona, 5, 0, 30, i);
        }
        fondo1.repaint();

    }

    public static void main(String[] args) {
        PlayerLocal jugador = new PlayerLocal();
        Mendigar1 mendigar = new Mendigar1(jugador, 15);
        mendigar.setVisible(true);
    }

}
