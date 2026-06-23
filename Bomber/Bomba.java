import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomba extends Actor
{
    private int tempoParaExplodir = 120;
    private Actor jogador;
    
    private GreenfootImage imagemMax;
    private GreenfootImage imagemMini;
    
    public Bomba(Actor jogadorQueCriou){
        this.jogador = jogadorQueCriou;
        
        imagemMax = new GreenfootImage("Bomb-Max.png");
        imagemMini = new GreenfootImage("Bomb-mini.png");
        setImage(imagemMax);
    }
    

    public void act()
    {
        tempoParaExplodir--;
        
        if (tempoParaExplodir > 0) {
            
            if ((tempoParaExplodir / 15) % 2 == 0) {
                setImage(imagemMax);
            } else {
                setImage(imagemMini);
            }
        }
        
        if(tempoParaExplodir <= 0){
            
            if(jogador instanceof PlayerPink){
                ((PlayerPink)jogador).reduzirBombaAtiva();
            }
            
            else if(jogador instanceof PlayerCiano){
                ((PlayerCiano) jogador ).reduzirBombaAtiva();
            }
            
            getWorld().addObject(new Explosao(), getX(), getY());
            
            getWorld().removeObject(this);
        }
        
    }
}
