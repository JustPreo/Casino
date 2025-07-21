/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casino;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author elmas
 */
public class BlackJack extends JFrame {

    int[] excluidos = new int[16];
    Slot[] cartas = new Slot[16];
    int cantidadActual = 0;
    int valorCartas, valorCartasD, randomD2, numero = 0,bet;

    private PlayerLocal jugador;
    private JLabel fondo1, luigiCam, luigiCamText, cartas1, cartas2, cartas3, cartas4, cartas5, cartas6, cartasD1, cartasD2, cartasD3, Dinero;
    private JButton bet10, bet25, bet100, hit, stay , Atras;
    Random random = new Random();
    Fotos fotos = new Fotos();

    public BlackJack(PlayerLocal jugador) {
        
        valorCartas = 0;
        this.jugador = jugador;
        setTitle("Blackjack");
        setSize(800, 500);
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/casino/Fondos/Poker.jpg"));
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel fondo1 = new JLabel(iconoEscalado);
        fondo1.setBounds(0, 0, 800, 500); // Tamaño igual al JFrame
        setContentPane(fondo1);
        fondo1.setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Dinero = new JLabel("TOKENS: " + jugador.tokens);
        Dinero.setForeground(Color.BLACK);
        Dinero.setOpaque(true);
        Dinero.setBackground(Color.white);
        Dinero.setBounds(700, 0, 100, 30);
        fondo1.add(Dinero);

        ImageIcon gifLuigi = new ImageIcon(getClass().getResource("/casino/BlackJack/luigi-casino.gif"));
        luigiCam = new JLabel(gifLuigi);
        luigiCam.setBounds(0, 0, 125, 75); // El JLabel tiene el tamaño que quieras
        fondo1.add(luigiCam);

        luigiCamText = new JLabel("DEALER CAM");
        luigiCamText.setBounds(20, 50, 100, 100);
        luigiCamText.setForeground(Color.WHITE);
        luigiCamText.setBackground(Color.green);
        fondo1.add(luigiCamText);
        
        

        cartasD1 = new JLabel();
        cartasD1.setBounds(275, 50, 100, 100);
        cartasD1.setIcon(fotos.getBlackJack(13).imagen);
        fondo1.add(cartasD1);
        cartasD1.setVisible(false);

        cartasD2 = new JLabel();
        cartasD2.setBounds(325, 50, 100, 100);
        cartasD2.setIcon(fotos.getBlackJack(13).imagen);
        fondo1.add(cartasD2);
        cartasD2.setVisible(false);

        cartasD3 = new JLabel();
        cartasD3.setBounds(375, 50, 100, 100);
        cartasD3.setIcon(fotos.getBlackJack(13).imagen);
        fondo1.add(cartasD3);
        cartasD3.setVisible(false);

        cartas1 = new JLabel();
        cartas1.setIcon(fotos.getBlackJack(13).imagen);
        cartas1.setBounds(250, 350, 100, 100);
        fondo1.add(cartas1);
        cartas1.setVisible(false);

        cartas2 = new JLabel();
        cartas2.setIcon(fotos.getBlackJack(13).imagen);
        cartas2.setBounds(300, 350, 100, 100);
        fondo1.add(cartas2);
        cartas2.setVisible(false);

        cartas3 = new JLabel();
        cartas3.setIcon(fotos.getBlackJack(13).imagen);
        cartas3.setBounds(350, 350, 100, 100);
        fondo1.add(cartas3);
        cartas3.setVisible(false);

        cartas4 = new JLabel();
        cartas4.setIcon(fotos.getBlackJack(13).imagen);
        cartas4.setBounds(400, 350, 100, 100);
        fondo1.add(cartas4);
        cartas4.setVisible(false);

        cartas5 = new JLabel();
        cartas5.setIcon(fotos.getBlackJack(13).imagen);
        cartas5.setBounds(450, 350, 100, 100);
        fondo1.add(cartas5);
        cartas5.setVisible(false);

        cartas6 = new JLabel();
        cartas6.setIcon(fotos.getBlackJack(13).imagen);
        cartas6.setBounds(500, 350, 100, 100);
        fondo1.add(cartas6);
        cartas6.setVisible(false);
        //Botones
        bet10 = new JButton("BET 10");
        bet10.setBounds(250, 0, 100, 100);
        fondo1.add(bet10);

        bet25 = new JButton("BET 25");
        bet25.setBounds(350, 0, 100, 100);
        fondo1.add(bet25);

        bet100 = new JButton("BET 100");
        bet100.setBounds(450, 0, 100, 100);
        fondo1.add(bet100);

        stay = new JButton("STAY");
        stay.setBounds(100, 400, 100, 50);
        fondo1.add(stay);
        stay.setVisible(false);

        hit = new JButton("HIT");
        hit.setBounds(600, 400, 100, 50);
        fondo1.add(hit);
        hit.setVisible(false);
        
        Atras = new JButton("Atras");
        Atras.setBounds(660, 410, 125, 50);
        fondo1.add(Atras);

        //Listeners
        Atras.addActionListener(new ActionListener() { //Cuando le de al boton de jugar
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets

                
                    Casino casino = new Casino(jugador);
                    casino.setVisible(true);
                    dispose();
                

            }
        });
        
        hit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (numero == 0) {
                    int nrandom = random.nextInt(13);
                    Slot carta = fotos.getBlackJack(nrandom);
                    excluidos[cantidadActual] = nrandom;
                    cartas[cantidadActual] = carta;
                    cartas3.setIcon(carta.imagen);
                    cartas3.setVisible(true);
                    numero++;
                    if (cartas[cantidadActual].valor != 1) {
                        valorCartas += cartas[cantidadActual].valor;
                        if (valorCartas > 21) {
                            JOptionPane.showMessageDialog(null, "PERDISTE");
                            Casino casino = new Casino(jugador);
                            Archivo.guardarTokens(jugador);
                            dispose();
                        }
                    }
                    cantidadActual++;

                } else if (numero == 1) {
                    int nrandom = random.nextInt(13);
                    Slot carta = fotos.getBlackJack(nrandom);
                    excluidos[cantidadActual] = nrandom;
                    cartas[cantidadActual] = carta;
                    cartas4.setIcon(carta.imagen);
                    cartas4.setVisible(true);
                    numero++;
                    if (cartas[cantidadActual].valor != 1) {
                        valorCartas += cartas[cantidadActual].valor;
                        if (valorCartas > 21) {
                            JOptionPane.showMessageDialog(null, "PERDISTE");
                            Casino casino = new Casino(jugador);
                            Archivo.guardarTokens(jugador);
                            dispose();
                        }
                    }

                    
                    
                    cantidadActual++;
                } else if (numero == 2) {
                    int nrandom = random.nextInt(13);
                    Slot carta = fotos.getBlackJack(nrandom);
                    excluidos[cantidadActual] = nrandom;
                    cartas[cantidadActual] = carta;
                    cartas5.setIcon(carta.imagen);
                    cartas5.setVisible(true);
                    numero++;
                    if (cartas[cantidadActual].valor != 1) {
                        valorCartas += cartas[cantidadActual].valor;
                        if (valorCartas > 21) {
                            JOptionPane.showMessageDialog(null, "PERDISTE");
                            Casino casino = new Casino(jugador);
                            Archivo.guardarTokens(jugador);
                            dispose();
                        }
                    }

                    
                    cantidadActual++;
                } else if (numero == 3) {
                    int nrandom = random.nextInt(13);
                    Slot carta = fotos.getBlackJack(nrandom);
                    excluidos[cantidadActual] = nrandom;
                    cartas[cantidadActual] = carta;
                    cartas6.setIcon(carta.imagen);
                    cartas6.setVisible(true);
                    numero++;
                    if (cartas[cantidadActual].valor != 1) {
                        valorCartas += cartas[cantidadActual].valor;
                        if (valorCartas > 21) {
                            JOptionPane.showMessageDialog(null, "PERDISTE");
                            Casino casino = new Casino(jugador);
                            Archivo.guardarTokens(jugador);
                            dispose();
                        }
                    }

                    
                    
                    cantidadActual++;
                } else {
                    System.out.println("Hasta ahi se quedo XD");
                }

                for (int a = 2; a < cantidadActual; a++) {
                    if (excluidos[a] == 0) {
                        String[] opciones = {"1", "11"};
                        int eleccion = JOptionPane.showOptionDialog(null,
                                "¿Qué valor querés para tu As?",
                                "Elige valor para As", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                        valorCartas += (eleccion == 0) ? 1 : 11;
                        int multiplicador = condition(valorCartasD, valorCartas);

                        if (valorCartas > 21) {
                            JOptionPane.showMessageDialog(null, "PERDISTE");
                            Casino casino = new Casino(jugador);
                            Archivo.guardarTokens(jugador);
                            dispose();

                        }

                    }
                }

                /*if (valorCartas > 21) {
                    JOptionPane.showMessageDialog(null, "PERDISTE");
                    Casino casino = new Casino(jugador);
                    Archivo.guardarTokens(jugador);
                    dispose();
                }*/

            }
        });

        stay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                hit.setVisible(false);
                Slot cartaD2 = fotos.getBlackJack(randomD2);
                cartasD2.setIcon(cartaD2.imagen);

                if (valorCartasD < 17 && valorCartasD < valorCartas) {
                    int r = random.nextInt(13);
                    Slot carta = fotos.getBlackJack(r);
                    cartasD3.setIcon(carta.imagen);
                    cartasD3.setVisible(true);
                    valorCartasD = valorCartasD + carta.valor;
                }
                System.out.println("VALOR CARTAS D:"+valorCartasD);
        System.out.println("VALOR CARTAS P:"+valorCartas);
                int multiplicador = condition(valorCartasD,valorCartas);
                        
                        if (multiplicador == 0)
                        {
                        JOptionPane.showMessageDialog(null, "PERDISTE");
                        Casino casino = new Casino(jugador);
                        Archivo.guardarTokens(jugador);
                        dispose();
                        }
                        
                        else if (multiplicador == 2)
                        {
                            jugador.tokens += bet * multiplicador;
                            
                        JOptionPane.showMessageDialog(null, "GANASTE "+multiplicador+"x tu apuesta");
                        Casino casino = new Casino(jugador);
                        Archivo.guardarTokens(jugador);
                        dispose();
                        
                        }
                        
                        else if (multiplicador == 1)
                        {
                            jugador.tokens += bet * multiplicador;
                        JOptionPane.showMessageDialog(null, "EMPATE");
                        Casino casino = new Casino(jugador);
                        Archivo.guardarTokens(jugador);
                        dispose();
                        
                        }

            }
        });

        bet10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Logica despues de bets
                funcion(10);

            }
        });
        bet25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                funcion(25);

            }
        });
        bet100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                funcion(100);

            }
        });

        setVisible(true);

        JOptionPane.showMessageDialog(null, "Bienvenido a la mesa");
    }

    public void funcion(int bet) {
        if (jugador.tokens < bet)
        {
            JOptionPane.showMessageDialog(null, "Estas pobre , no puedes hacer esto");
        return;
        }
        
        jugador.tokens =jugador.tokens -  bet;
        this.bet = bet;
        int valorActual = 0;

        cantidadActual = 0;
        int r1 = random.nextInt(13);
        Slot carta1 = fotos.getBlackJack(r1);
        cartas[cantidadActual] = carta1;
        excluidos[cantidadActual] = r1;

        cantidadActual++;
        int r2;
        Slot carta2;
        r2 = random.nextInt(13);
        carta2 = fotos.getBlackJack(r2);
        excluidos[cantidadActual] = r2;
        cartas[cantidadActual] = carta2;

        cantidadActual++;
        for (int a = 0; a < cantidadActual; a++) {
            if (excluidos[a] == 0) {
                String[] opciones = {"1", "11"};
                int eleccion = JOptionPane.showOptionDialog(null,
                        "¿Qué valor querés para tu As?",
                        "Elige valor para As", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                cartas[a].valor = (eleccion == 0) ? 1 : 11;

            }
        }
        valorCartas = carta1.valor + carta2.valor;

        bet10.setVisible(false);
        bet25.setVisible(false);
        bet100.setVisible(false);
        System.out.println(r1);
        System.out.println(r2);
        cartas1.setIcon(carta1.imagen);
        cartas1.setVisible(true);
        cartas2.setIcon(carta2.imagen);
        cartas2.setVisible(true);

        int randomD1 = random.nextInt(13);
        randomD2 = random.nextInt(13);
        Slot cartaD1 = fotos.getBlackJack(randomD1);
        Slot cartaD2 = fotos.getBlackJack(randomD2);

        if (cartaD1.especial) {
            if (cartaD2.valor <= 10) {
                cartaD1.valor = 11;
                System.out.println("ACE CARTA 1");
            }
            else {
            cartaD1.valor = 1;
            }
        }
        if (cartaD2.especial) {
            if (cartaD1.valor <= 10) {
                cartaD2.valor = 11;
                System.out.println("ACE CARTA 2");
            }
            else {
            cartaD2.valor = 1;
            }
        }

        System.out.println("CARTA D 1 :"+cartaD1.valor);
        System.out.println("CARTA D 2 :"+cartaD2.valor);
        
        valorCartasD = cartaD1.valor + cartaD2.valor;
        System.out.println("VALOR CARTAS D:"+valorCartasD);
        System.out.println("VALOR CARTAS P:"+valorCartas);
        cartasD1.setIcon(cartaD1.imagen);

        cartasD1.setVisible(true);
        cartasD2.setVisible(true);

        hit.setVisible(true);
        stay.setVisible(true);
        Atras.setVisible(false);

        if (valorCartas > 21) {
            JOptionPane.showMessageDialog(null, "PERDISTE");
            Casino casino = new Casino(jugador);
            Archivo.guardarTokens(jugador);
            dispose();
        }
        Dinero.setText("TOKENS: " + jugador.tokens);

    }

    public int condition(int dealer, int jugador) {

        if (jugador > 21) {
            return 0;//Retorna el multiplicador
        }else if (dealer > 21)
        {
        return 2;
        }
        
        else if (jugador == dealer) {
            return 1;//Devuelve el bet
        } else if (jugador > dealer) {
            return 2;//Si gana jugador
        } else if (dealer > jugador) {
            return 0;//Pierde
        }

        return 0;

    }

}