import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{
    protected int velocidade = 2;
    protected int maxBomb = 1;
    protected int activesbombs = 0;
    protected String teclaCima;
    protected String teclaBaixo;
    protected String teclaEsq;
    protected String teclaDir;
    protected String teclaAcao; 

    public void act()
    {
       walk();
       createBomb();
       destruicao();
    }
    
    public void destruicao(){
        if(isTouching(Explosao.class) || isTouching(ExplosaoLateral.class) || isTouching(ExplosaoVertical.class) ){
            getWorld().removeObject(this);
        }
    }
    
    public void walk(){
         if (Greenfoot.isKeyDown(teclaCima)) {
            setLocation(getX(), getY() - velocidade);
            if(isTouching(BlocoIndestrutivel.class) || isTouching(BlocoDestrutivel.class)) { setLocation(getX(), getY() + velocidade); }
        }
         if (Greenfoot.isKeyDown(teclaBaixo)) {
            setLocation(getX(), getY() + velocidade);
            if(isTouching(BlocoIndestrutivel.class) || isTouching(BlocoDestrutivel.class)) {setLocation(getX(), getY() - velocidade);}
        }
        if (Greenfoot.isKeyDown(teclaEsq)) {
            setLocation(getX() - velocidade, getY());
            if(isTouching(BlocoIndestrutivel.class) || isTouching(BlocoDestrutivel.class)) { setLocation(getX() + velocidade, getY()); }
        }
        if (Greenfoot.isKeyDown(teclaDir)) {
            setLocation(getX() + velocidade, getY());
            if(isTouching(BlocoIndestrutivel.class) || isTouching(BlocoDestrutivel.class)) { setLocation(getX() - velocidade, getY());}
        }
    }
    
    public void createBomb(){
        if (Greenfoot.isKeyDown(teclaAcao)){
            if(activesbombs < maxBomb){
                int tamanhoBloco = 24;
                int metadeBloco = tamanhoBloco / 2;
                
                int bombaX = ((getX() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
                int bombaY = ((getY() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
    
                Bomba newbomba = new Bomba(this); 
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
