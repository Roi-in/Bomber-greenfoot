import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoIniciar here.
 * * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoIniciar extends Actor
{
    private GreenfootImage img1 = new GreenfootImage("Botao-Player.png");
    private GreenfootImage img2 = new GreenfootImage("Botao-Player-Branco.png");

    public BotaoIniciar()
    {
        setImage(img1); 
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
        
        
        if (Greenfoot.mouseMoved(this)) {
            setImage(img2); 
        }
        
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(img1); 
        }
    }
}