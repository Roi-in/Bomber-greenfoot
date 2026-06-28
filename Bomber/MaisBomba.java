import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MaisBomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaisBomba extends AnimacaoIcone
{
    private int tempoImunidade = 40; 

    public MaisBomba() {
        super(new GreenfootImage[]{
            new GreenfootImage("Incone-Bomb-branco.png"),
            new GreenfootImage("Incone-Bomb-Ciano.png"),
            new GreenfootImage("Incone-Bomb-Pink.png")
        });
    }
    
    public void act() 
    {
        super.act(); 
        
        if (tempoImunidade > 0) {
            tempoImunidade--;
        }
        
        if (tempoImunidade == 0 && (isTouching(Explosao.class) || isTouching(ExplosaoLateral.class) || isTouching(ExplosaoVertical.class))) {
            getWorld().removeObject(this);
            return; 
        }
        
        Player jogador = (Player) getOneIntersectingObject(Player.class);
        if (jogador != null) {
            jogador.adicionarBomba();
            getWorld().removeObject(this);
        }
    }
}
