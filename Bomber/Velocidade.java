import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chama here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Velocidade extends AnimacaoIcone
{
    private int tempoImunidade = 40; 

    public Velocidade() {
        super(new GreenfootImage[]{
            new GreenfootImage("Botinha-Branco.png"),
            new GreenfootImage("Botinha-Ciano.png"),
            new GreenfootImage("Botinha-Pink.png")
        });
    }
    
    public void act(){
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
            jogador.aumentarVelocidade();
            getWorld().removeObject(this);
        }
    }
}

