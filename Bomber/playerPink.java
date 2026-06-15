import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerPink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerPink extends Actor
{
    private int velocidade = 2;
    private int maxBomb = 1;
    private int activesbombs = 0;
        
    
    public void act()
    {
       walk();
       createBomb();
       destruicao();
    }
    
    public void destruicao(){
        if(isTouching(explosao.class) || isTouching(explosaoLateral.class) || isTouching(explosaoVertical.class) ){
            getWorld().removeObject(this);
        }
    }
    
    public void walk(){
         if (Greenfoot.isKeyDown("W")) {
            setLocation(getX(), getY() - velocidade);
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX(), getY() + velocidade); }
        }
         if (Greenfoot.isKeyDown("S")) {
            setLocation(getX(), getY() + velocidade);
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) {setLocation(getX(), getY() - velocidade);}
        }
        if (Greenfoot.isKeyDown("A")) {
            setLocation(getX() - velocidade, getY());
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX() + velocidade, getY()); }
        }
        if (Greenfoot.isKeyDown("D")) {
            setLocation(getX() + velocidade, getY());
            if(isTouching(blocoIndestrutivel.class) || isTouching(blocoDestrutivel.class)) { setLocation(getX() - velocidade, getY());}
        }
    }
    public void createBomb(){
    
        if (Greenfoot.isKeyDown("J")){
    
            if(activesbombs < maxBomb){
                int tamanhoBloco = 24;
                int metadeBloco = tamanhoBloco / 2;
    
                int bombaX = ((getX() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
                int bombaY = ((getY() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
    
                bomba newbomba = new bomba(this);
    
                getWorld().addObject(newbomba, bombaX, bombaY);
    
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
