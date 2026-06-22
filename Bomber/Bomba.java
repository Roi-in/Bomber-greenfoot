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
    
    
    public Bomba(Actor jogadorQueCriou){
        this.jogador = jogadorQueCriou;
    }

    public void act()
    {
        tempoParaExplodir--;
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
