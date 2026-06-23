import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosaoLateral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosaoLateral extends Actor
{
    private int tempoParaSumir = 30;
    
    private GreenfootImage img1 = new GreenfootImage("Explosao-lateral1.png");
    private GreenfootImage img2 = new GreenfootImage("explosao-lateral3.png");
    
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
