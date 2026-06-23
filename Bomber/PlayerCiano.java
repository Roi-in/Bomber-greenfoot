import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerPink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCiano extends Player
{
    public PlayerCiano(){
        
        super("Player-Ciano.png", "ciano-andar1.png", "ciano-andar2.png");
        
        teclaCima = "up";
        teclaBaixo = "down";
        teclaEsq = "left";
        teclaDir = "right";
        teclaAcao = "5";
    }
    
}
