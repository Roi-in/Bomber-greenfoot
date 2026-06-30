import greenfoot.*;  
import java.util.List;

public class Explosao extends Actor
{
    private int tempoParaSumir = 30; 
    private boolean jaEspalhou = false; 
    
    private int poderDaChama = 1;
    
    private GreenfootImage img1 = new GreenfootImage("explosao-central.png");
    private GreenfootImage img2 = new GreenfootImage("explosao-central2.png");

    public Explosao(int poder) {
        this.poderDaChama = poder;
    }
    
    public Explosao() {
        this.poderDaChama = 1;
    }

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
        int passo = 13; 

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            
            int limite = poderDaChama * 2; 
            
            for (int j = 1; j <= limite; j++) {
                
                int proximoX = getX() + (dx[i] * j * passo);
                int proximoY = getY() + (dy[i] * j * passo);
                
                boolean ehHorizontal = (dx[i] != 0); 

                if (temBlocoIndestrutivel(proximoX, proximoY)) {
                    break; 
                }

                if (temEDestroiBlocoDestrutivel(proximoX, proximoY)) {
                    criarFogoNoAlvo(proximoX, proximoY, ehHorizontal);
                    break;
                }

                criarFogoNoAlvo(proximoX, proximoY, ehHorizontal);
            }
        }
    
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

    private boolean temEDestroiBlocoDestrutivel(int x, int y) {
        List<BlocoDestrutivel> blocos = getWorld().getObjectsAt(x, y, BlocoDestrutivel.class);
        
        if (!blocos.isEmpty()) {
            getWorld().removeObject(blocos.get(0));
            
            if (Greenfoot.getRandomNumber(100) < 30) {
                int qualItem = Greenfoot.getRandomNumber(3); 
                
                if (qualItem == 0) {
                    getWorld().addObject(new Velocidade(), x, y);
                } else if (qualItem == 1) {
                    getWorld().addObject(new MaisBomba(), x, y);
                } else if (qualItem == 2) {
                    getWorld().addObject(new Chama(), x, y);
                }
            }
            return true;
        }
        return false;
    }
}