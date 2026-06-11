import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerPink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerCiano extends Actor
{
    private int velocidade = 2;
    private int maxBomb = 1;
    private int activesbombs = 0;
    
    public void act()
    {
       walk();
       createBomb();
    }
    
    public void walk(){
         if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - velocidade);
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX(), getY() + velocidade); }
        }
         if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + velocidade);
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) {setLocation(getX(), getY() - velocidade);}
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidade, getY());
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX() + velocidade, getY()); }
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidade, getY());
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX() - velocidade, getY());}
        }
    }
    
    public void createBomb(){
    
        if (Greenfoot.isKeyDown("1")){
            
            if(activesbombs < maxBomb){
                bomba newbomba = new bomba(this);
                getWorld().addObject(newbomba,getX(),getY());
                activesbombs++;
            }
        }
        
    }
    
    public void reduzirBombaAtiva() {
    if (activesbombs > 0) {
        activesbombs--;
    }
}
    
}
