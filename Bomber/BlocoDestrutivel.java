import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blocoDestrutivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlocoDestrutivel extends Actor
{
    /**
     * Act - do whatever the blocoDestrutivel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        destruicao();
    }
    
     public void destruicao(){
        if(isTouching(Explosao.class) || isTouching(ExplosaoLateral.class) || isTouching(ExplosaoVertical.class) ){
            getWorld().removeObject(this);
        }
    }
}
