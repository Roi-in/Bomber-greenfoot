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
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        playerPink playerPink = new playerPink();
        addObject(playerPink,256,143);
        playerPink.setLocation(252,141);
        removeObject(playerPink);
        blocoIndestrutivel blocoIndestrutivel = new blocoIndestrutivel();
        addObject(blocoIndestrutivel,306,170);
        playerPink playerPink2 = new playerPink();
        addObject(playerPink2,145,164);
        blocoDestrutivel blocoDestrutivel = new blocoDestrutivel();
        addObject(blocoDestrutivel,307,128);
        playerCiano playerCiano = new playerCiano();
        addObject(playerCiano,145,208);

        removeObject(blocoIndestrutivel);
        removeObject(blocoDestrutivel);
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
                addObject(new blocoIndestrutivel(), posX, posY);
            } 
            // Desenha os pilares internos
            else if (x % 2 == 0 && y % 2 == 0) {
                addObject(new blocoIndestrutivel(), posX, posY);
            }
        }
    }
}
}
