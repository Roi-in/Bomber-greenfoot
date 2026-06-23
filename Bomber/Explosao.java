import greenfoot.*;  
import java.util.List;

public class Explosao extends Actor
{
    private int tempoParaSumir = 30; 
    private boolean jaEspalhou = false; 
    
    private GreenfootImage img1 = new GreenfootImage("explosao-central.png");
    private GreenfootImage img2 = new GreenfootImage("explosao-central2.png");

    public void act()
    {
        if (!jaEspalhou) {
            espalharFogo();
            jaEspalhou = true;
        }

        tempoParaSumir--;
        
        if ((tempoParaSumir / 5) % 2 == 0) {
            setImage(img1);
        } else {
            setImage(img2);
        }
        
        if (tempoParaSumir <= 0) {
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }

    private void espalharFogo() {
        int bloco = 26; 
        int metade = 13;

        if (checarECorrerCaminho(getX() + metade, getY(), true)) {
            checarECorrerCaminho(getX() + bloco, getY(), true);
        }

        if (checarECorrerCaminho(getX() - metade, getY(), true)) {
            checarECorrerCaminho(getX() - bloco, getY(), true);
        }

        if (checarECorrerCaminho(getX(), getY() + metade, false)) {
            checarECorrerCaminho(getX(), getY() + bloco, false);
        }

        if (checarECorrerCaminho(getX(), getY() - metade, false)) {
            checarECorrerCaminho(getX(), getY() - bloco, false);
        }
    }

    private boolean checarECorrerCaminho(int x, int y, boolean ehHorizontal) {
        if (temBlocoIndestrutivel(x, y)) {
            return false; 
        }

        if (temEDestróiBlocoDestrutivel(x, y)) {
            criarFogoNoAlvo(x, y, ehHorizontal);
            return false; 
        }

        criarFogoNoAlvo(x, y, ehHorizontal);
        return true; 
    }

    private void criarFogoNoAlvo(int x, int y, boolean ehHorizontal) {
        if (ehHorizontal) {
            getWorld().addObject(new ExplosaoLateral(), x, y);
        } else {
            getWorld().addObject(new ExplosaoVertical(), x, y);
        }
    }

    private boolean temBlocoIndestrutivel(int x, int y) {
        List<BlocoIndestrutivel> blocos = getWorld().getObjectsAt(x, y, BlocoIndestrutivel.class);
        return !blocos.isEmpty();
    }

    private boolean temEDestróiBlocoDestrutivel(int x, int y) {
        List<BlocoDestrutivel> blocos = getWorld().getObjectsAt(x, y, BlocoDestrutivel.class);
        if (!blocos.isEmpty()) {
            getWorld().removeObject(blocos.get(0));
            return true;
        }
        return false;
    }
}