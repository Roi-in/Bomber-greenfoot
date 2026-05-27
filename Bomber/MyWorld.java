import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 2); 
        prepare();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        playerPink playerPink = new playerPink();
        addObject(playerPink,256,143);
        playerPink.setLocation(252,141);
        removeObject(playerPink);
        blocoIndestrutivel blocoIndestrutivel = new blocoIndestrutivel();
        addObject(blocoIndestrutivel,306,170);
        playerPink playerPink2 = new playerPink();
        addObject(playerPink2,145,164);
        blocoDestrutivel blocoDestrutivel = new blocoDestrutivel();
        addObject(blocoDestrutivel,307,128);
        playerCiano playerCiano = new playerCiano();
        addObject(playerCiano,145,208);
    }
}
