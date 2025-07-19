/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author elmas
 */
public class Slot {
    String nombre;
    int valor;
    ImageIcon imagen;
    String rutaI;
    boolean especial;
    
    public Slot(String nombre, int valor , String rutaI , boolean especial) //Constructor
    {
        
    this.nombre = nombre;
    this.valor = valor;
    ImageIcon original = new ImageIcon(getClass().getResource(rutaI));
    Image imagenResize = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    this.imagen = new ImageIcon(imagenResize);
    //Eso es para convertirlo a ImageIcon con la ruta
    this.rutaI = rutaI;
    this.especial = especial;
    }
    
    
    
    
}
