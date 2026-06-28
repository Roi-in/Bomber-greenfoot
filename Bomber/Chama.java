import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chama extends AnimacaoIcone
{
    
    private int tempoImunidade = 40; 

    public Chama() {
        super(new GreenfootImage[]{
            new GreenfootImage("Chama-Branco.png"),
            new GreenfootImage("Chama-Ciano.png"),
            new GreenfootImage("Chama-Pink.png")
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
            jogador.aumentarChama();
            getWorld().removeObject(this);
        }
    }
}