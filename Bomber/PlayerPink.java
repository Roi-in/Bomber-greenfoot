import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerPink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPink extends Player{
    public PlayerPink(){
        
        super("player-pink.png", "pink-andar1.png", "pink-andar2.png");

        teclaCima = "w";
        teclaBaixo = "s";
        teclaEsq = "a";
        teclaDir = "d";
        teclaAcao = "j";
}
}

