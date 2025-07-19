/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

/**
 *
 * @author elmas
 */
public class Fotos {

    Slot slot[];
    

    public Fotos() {

        slot = new Slot[16];

        slot[0] = new Slot("Nombre", 0 , "/casino/Imagenes/1.png" ,false);
        slot[1] = new Slot("Nombre2", 1 , "/casino/Imagenes/2.png" ,false);
        slot[2] = new Slot("Nombre2", 2 , "/casino/Imagenes/3.png" ,false);
        slot[3] = new Slot("Nombre2", 3 , "/casino/Imagenes/4.png" ,false);
        slot[4] = new Slot("Nombre2", 4 , "/casino/Imagenes/5.png" ,false);
        slot[5] = new Slot("Nombre2", 5 , "/casino/Imagenes/6.png" ,false);
        slot[6] = new Slot("Nombre2", 6 , "/casino/Imagenes/7.png" ,false);
        slot[7] = new Slot("Nombre2", 7 , "/casino/Imagenes/8.png" ,false);
        slot[8] = new Slot("Nombre2", 8 , "/casino/Imagenes/9.png" ,false);
        slot[9] = new Slot("Nombre2", 9 , "/casino/Imagenes/10.png" ,false);
        slot[10] = new Slot("Nombre2", 10 , "/casino/Imagenes/11.png" ,false);
        slot[11] = new Slot("Nombre2", 11 , "/casino/Imagenes/12.png" ,false);
        slot[12] = new Slot("Nombre2", 12 , "/casino/Imagenes/13.png" ,false);
        slot[13] = new Slot("Nombre2", 13 , "/casino/Imagenes/14.png" ,false);
        slot[14] = new Slot("Nombre2", 14 , "/casino/Imagenes/15.png" ,false);
        slot[15] = new Slot("Nombre2", 15 , "/casino/Imagenes/16.png" ,false);
        
        //slot[15] = new Slot("Nombre2", 15 , "/casino/Foto1.png" ,false);
        

}
    
    public Slot getSlot(int valor)
    {
        for (int i = 0;i < slot.length ; i++ )
        {
        if (slot[i].valor == valor)
        {
        return slot[i];
        }
        }
    return null;
    }
    
    
}
