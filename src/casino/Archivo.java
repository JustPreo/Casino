/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author elmas
 */
public class Archivo {
    
    public static void guardarTokens(PlayerLocal jugador) {
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Jugador.txt"));
        writer.write(String.valueOf(jugador.tokens));
        writer.close();
        }
        catch (IOException e)
        {
        e.printStackTrace();
        }
    }
    
    public static int conseguirTokens()
    {
        int tokens = 0;
    try {
        File archivo = new File("Jugador.txt");
        
        if (!archivo.exists())
        {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            writer.write("50"); //Los tokens con los que inicia
            writer.close();
            System.out.println("Creando archivo...");
        }
        BufferedReader reader = new BufferedReader(new FileReader("Jugador.txt"));
        String linea = reader.readLine();
        tokens = Integer.parseInt(linea);
        reader.close();
        }
        catch (IOException e)
        {
        e.printStackTrace(); //Imprimir el error 
        }
    return tokens;
    }
    }
    

