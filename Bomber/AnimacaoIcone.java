import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class AnimacaoIcone extends Actor
{
    private GreenfootImage[] imagens;
    private int frame = 0;
    private int indiceAtual = 0;   
    private int velocidade = 5;   

    public AnimacaoIcone(GreenfootImage[] imagens) {
        this.imagens = imagens;
        if (imagens != null && imagens.length > 0) {
            setImage(imagens[0]); 
        }
    }

    /**
     * O act da classe mãe gerencia a animação automaticamente.
     */
    public void act() 
    {
        animar();
    }

    /**
     * Método genérico que funciona para qualquer lista de imagens recebida
     */
    protected void animar()
    {
        if (imagens == null || imagens.length == 0) return;

        frame++;
        
        if (frame >= velocidade) {
            frame = 0; 
            
            
            indiceAtual = (indiceAtual + 1) % imagens.length;
            
            setImage(imagens[indiceAtual]);
        }
    }
}