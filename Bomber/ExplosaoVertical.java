import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosaoVertical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosaoVertical extends Actor
{
    private int tempoParaSumir = 30;
    
    private GreenfootImage img1 = new GreenfootImage("explosao-vertical.png");
    private GreenfootImage img2 = new GreenfootImage("explosao-vertical3.png");
    public void act()
    {
        tempoParaSumir--;
        
        if ((tempoParaSumir / 5) % 2 == 0) {
            setImage(img1);
        } else {
            setImage(img2);
        }
        
        if (tempoParaSumir <= 0) {
            getWorld().removeObject(this);
        }
    }
}
