import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class explosao extends Actor
{
    private int tempoParaSumir = 30; 
    private boolean jaEspalhou = false; 

    public void act()
    {
        if (!jaEspalhou) {
            espalharFogo();
            jaEspalhou = true;
        }

        tempoParaSumir--;
        if (tempoParaSumir <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void espalharFogo() {
    int bloco = 26; 
    int metade = 13;

    criarEFecharVaoDireita(bloco);
    criarEFecharVaoDireita(metade);


    criarEFecharVaoEsquerda(bloco);
    criarEFecharVaoEsquerda(metade);

    getWorld().addObject(new explosaoVertical(), getX(), getY() + bloco);
    getWorld().addObject(new explosaoVertical(), getX(), getY() + metade);
    getWorld().addObject(new explosaoVertical(), getX(), getY() - bloco);
    getWorld().addObject(new explosaoVertical(), getX(), getY() - metade);
    
    getWorld().addObject(new explosaoLateral(), getX() + bloco, getY());
    getWorld().addObject(new explosaoLateral(), getX() + metade, getY());
    getWorld().addObject(new explosaoLateral(), getX()- bloco, getY() );
    getWorld().addObject(new explosaoLateral(), getX() - metade, getY());
}


private void criarEFecharVaoDireita(int distancia) {
    explosaoLateral f = new explosaoLateral();
    getWorld().addObject(f, getX() + distancia, getY());
    f.setRotation(90);
}

private void criarEFecharVaoEsquerda(int distancia) {
    explosaoLateral f = new explosaoLateral();
    getWorld().addObject(f, getX() - distancia, getY());
    f.setRotation(90);
}

}