/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class NPCS {

    private int rango;
    private int dinero;
    private int probabilidades;
    ImageIcon imagen;
    String rutaI;

    public NPCS(int rango, int dinero, int probabilidades, String rutaI) {
        URL url = getClass().getResource(rutaI);
        if (url == null) {
            System.err.println("No se encontró la imagen: " + rutaI);
        } else {
            ImageIcon original = new ImageIcon(url);
            Image imagenResize = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            this.imagen = new ImageIcon(imagenResize);
        }
        //Eso es para convertirlo a ImageIcon con la ruta
        this.rutaI = rutaI;
        this.probabilidades = probabilidades;
        this.dinero = dinero;
        this.rango = rango;
    }

    private boolean daDinero() {
        Random random = new Random();
        
        int r = random.nextInt(100) + 1;
        
        System.out.println("random = "+r);
        System.out.println("Probabilidades = "+probabilidades);
        if (r <= this.probabilidades) {
            System.out.println("entro");
            return true;
        } else {
            return false;
        }
    }
    
    public int cambio()
    {
    if (daDinero())
    {
    Random random = new Random();
    int maxDinero = (dinero - 1);
    int calculo = random.nextInt(maxDinero) +1;
    return calculo;
    
    }
    else
    {
    return 0;
    }
    }
    
    
    

}
