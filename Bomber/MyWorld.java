import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600, 400, 1); 
        prepare();
        prepararCenario();
        espalharBlocosDestrutiveis();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        PlayerPink playerPink = new PlayerPink();
        addObject(playerPink,256,143);
        playerPink.setLocation(252,141);
        removeObject(playerPink);
        BlocoIndestrutivel BlocoIndestrutivel = new BlocoIndestrutivel();
        addObject(BlocoIndestrutivel,306,170);
        PlayerPink playerPink2 = new PlayerPink();
        addObject(playerPink2,145,164);
        BlocoDestrutivel BlocoDestrutivel = new BlocoDestrutivel();
        addObject(BlocoDestrutivel,307,128);
        PlayerCiano playerCiano = new PlayerCiano();
        addObject(playerCiano,145,208);

        removeObject(BlocoIndestrutivel);
        removeObject(BlocoDestrutivel);
        playerPink2.setLocation(37,42);
        playerCiano.setLocation(557,368);
        playerCiano.setLocation(565,364);
    }
    
   private void prepararCenario()
{
    // Coloque aqui o tamanho exato que você está usando agora (ex: 24)
    int tamanhoBloco = 24; 
    int metadeBloco = tamanhoBloco / 2; 
    
    // O comando Math.ceil força o arredondamento para CIMA.
    // Assim, se faltar um pedaço, ele cria uma fileira extra e esconde a sobra fora da tela!
    int colunas = (int) Math.ceil((double) getWidth() / tamanhoBloco); 
    int linhas = (int) Math.ceil((double) getHeight() / tamanhoBloco);

    for (int x = 0; x < colunas; x++) {
        for (int y = 0; y < linhas; y++) {
            
            int posX = (x * tamanhoBloco) + metadeBloco;
            int posY = (y * tamanhoBloco) + metadeBloco;

            // Desenha as bordas
            if (x == 0 || x == colunas - 1 || y == 0 || y == linhas - 1) {
                addObject(new BlocoIndestrutivel(), posX, posY);
            } 
            // Desenha os pilares internos
            else if (x % 2 == 0 && y % 2 == 0) {
                addObject(new BlocoIndestrutivel(), posX, posY);
            }
        }
    }
}

private void espalharBlocosDestrutiveis() 
{
    int tamanhoBloco = 24; 
    int metadeBloco = tamanhoBloco / 2; 

    int colunas = (int) Math.ceil((double) getWidth() / tamanhoBloco); 
    int linhas = (int) Math.ceil((double) getHeight() / tamanhoBloco);

    for (int x = 1; x < colunas - 1; x++) {
        for (int y = 1; y < linhas - 1; y++) {
            
            if (x % 2 == 0 && y % 2 == 0) {
                continue; 
            }

            boolean cantoSuperiorEsq = (x <= 2 && y <= 2);
            boolean cantoInferiorDir = (x >= colunas - 3 && y >= linhas - 3);

            if (!cantoSuperiorEsq && !cantoInferiorDir) {
                if (Greenfoot.getRandomNumber(100) < 70) { 
                    int posX = (x * tamanhoBloco) + metadeBloco;
                    int posY = (y * tamanhoBloco) + metadeBloco;
                    addObject(new BlocoDestrutivel(), posX, posY);
                }

            }
        }
    }
}
}