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
    Slot blackJack[];

    public Fotos() {
        blackJack = new Slot[14];
        slot = new Slot[16];

        slot[0] = new Slot("Nombre", 0, "/casino/Imagenes/1.png", false);
        slot[1] = new Slot("Nombre2", 1, "/casino/Imagenes/2.png", false);
        slot[2] = new Slot("Nombre2", 2, "/casino/Imagenes/3.png", false);
        slot[3] = new Slot("Nombre2", 3, "/casino/Imagenes/4.png", false);
        slot[4] = new Slot("Nombre2", 4, "/casino/Imagenes/5.png", false);
        slot[5] = new Slot("Nombre2", 5, "/casino/Imagenes/6.png", false);
        slot[6] = new Slot("Nombre2", 6, "/casino/Imagenes/7.png", false);
        slot[7] = new Slot("Nombre2", 7, "/casino/Imagenes/8.png", false);
        slot[8] = new Slot("Nombre2", 8, "/casino/Imagenes/9.png", false);
        slot[9] = new Slot("Nombre2", 9, "/casino/Imagenes/10.png", false);
        slot[10] = new Slot("Nombre2", 10, "/casino/Imagenes/11.png", false);
        slot[11] = new Slot("Nombre2", 11, "/casino/Imagenes/12.png", false);
        slot[12] = new Slot("Nombre2", 12, "/casino/Imagenes/13.png", false);
        slot[13] = new Slot("Nombre2", 13, "/casino/Imagenes/14.png", false);
        slot[14] = new Slot("Nombre2", 14, "/casino/Imagenes/15.png", false);
        slot[15] = new Slot("Nombre2", 15, "/casino/Imagenes/16.png", false);

        //slot[15] = new Slot("Nombre2", 15 , "/casino/Foto1.png" ,false);
        blackJack[0] = new Slot("Ace", 1, "/casino/BlackJack/1.png", true);
        blackJack[1] = new Slot("Nombre", 2, "/casino/BlackJack/2.png", false);
        blackJack[2] = new Slot("Nombre", 3, "/casino/BlackJack/3.png", false);
        blackJack[3] = new Slot("Nombre", 4, "/casino/BlackJack/4.png", false);
        blackJack[4] = new Slot("Nombre", 5, "/casino/BlackJack/5.png", false);
        blackJack[5] = new Slot("Nombre", 6, "/casino/BlackJack/6.png", false);
        blackJack[6] = new Slot("Nombre", 7, "/casino/BlackJack/7.png", false);
        blackJack[7] = new Slot("Nombre", 8, "/casino/BlackJack/8.png", false);
        blackJack[8] = new Slot("Nombre", 9, "/casino/BlackJack/9.png", false);
        blackJack[9] = new Slot("Nombre", 10, "/casino/BlackJack/10.png", false);
        blackJack[10] = new Slot("Nombre", 10, "/casino/BlackJack/11.png", false);
        blackJack[11] = new Slot("Nombre", 10, "/casino/BlackJack/12.png", false);
        blackJack[12] = new Slot("Nombre", 10, "/casino/BlackJack/13.png", false);
        blackJack[13] = new Slot("Vuelta", 0, "/casino/BlackJack/Vuelta.png", false);

    }

    public Slot getSlot(int valor) {
        for (Slot slot1 : slot) {
            if (slot1.valor == valor) {
                return slot1;
            }
        }
        return null;
    }
    
    public Slot getBlackJack(int valor)
    {
    return blackJack[valor];
    }

}
