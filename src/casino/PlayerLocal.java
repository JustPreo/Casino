/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casino;

/**
 *
 * @author elmas
 */
public class PlayerLocal {
    int tokens;
    int wins , perdidas;
    
    public PlayerLocal()
    {
    
    this.wins = 0;
    this.perdidas = 0;
    
    }
    
    public int getTokens()
    {
    return this.tokens;
    }
    
    public void setTokens(int tokens) { //Algun caso especial?
        this.tokens = tokens;
    }
    
    
    
}
