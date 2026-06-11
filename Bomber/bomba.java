import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bomba extends Actor
{
    private int tempoParaExplodir = 120;
    private Actor jogador;
    
    
    public bomba(Actor jogadorQueCriou){
        this.jogador = jogadorQueCriou;
    }

    public void act()
    {
        tempoParaExplodir--;
        if(tempoParaExplodir <= 0){
            
            if(jogador instanceof playerPink){
                ((playerPink)jogador).reduzirBombaAtiva();
            }
            
            else if(jogador instanceof playerCiano){
                ((playerCiano) jogador ).reduzirBombaAtiva();
            }
            
            getWorld().addObject(new explosao(), getX(), getY());
            
            getWorld().removeObject(this);
        }
        
    }
}
