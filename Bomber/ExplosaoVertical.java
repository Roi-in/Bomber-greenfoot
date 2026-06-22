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
    public void act()
    {
        tempoParaSumir--;
        if (tempoParaSumir <= 0) {
            getWorld().removeObject(this);
        }
    }
}
