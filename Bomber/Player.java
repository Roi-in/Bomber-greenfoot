import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{
    protected int velocidade = 2;
    protected int maxBomb = 1;
    protected int activesbombs = 0;
    protected String teclaCima;
    protected String teclaBaixo;
    protected String teclaEsq;
    protected String teclaDir;
    protected String teclaAcao; 
    
    private GreenfootImage imgParado;
    private GreenfootImage imgAndar1;
    private GreenfootImage imgAndar2;
    private int contAnimacao = 0;
    
    public Player(String nomeImgParado, String nomeImgAndar1, String nomeImgAndar2) {
        this.imgParado = new GreenfootImage(nomeImgParado);
        this.imgAndar1 = new GreenfootImage(nomeImgAndar1);
        this.imgAndar2 = new GreenfootImage(nomeImgAndar2);
    }

    public void act()
    {
       walk();
       createBomb();
       destruicao();
    }
    
    public void destruicao(){
        if(isTouching(Explosao.class) || isTouching(ExplosaoLateral.class) || isTouching(ExplosaoVertical.class) ){
            
            String vencedor = "Empate"; 
            
            if (this instanceof PlayerCiano) {
                vencedor = "Pink"; 
            } 
            else if (this instanceof PlayerPink) {
                vencedor = "Ciano";
            }
            
            Greenfoot.setWorld(new TelaVitoria(vencedor));
        }
    }
    
    public void walk(){
        boolean seMoveu = false;

        if (Greenfoot.isKeyDown(teclaCima)) {
            setLocation(getX(), getY() - velocidade);
            if(estaColidindo()) { setLocation(getX(), getY() + velocidade); }
            seMoveu = true;
        }
        if (Greenfoot.isKeyDown(teclaBaixo)) {
            setLocation(getX(), getY() + velocidade);
            if(estaColidindo()) { setLocation(getX(), getY() - velocidade); }
            seMoveu = true;
        }
        if (Greenfoot.isKeyDown(teclaEsq)) {
            setLocation(getX() - velocidade, getY());
            if(estaColidindo()) { setLocation(getX() + velocidade, getY()); }
            seMoveu = true;
        }
        if (Greenfoot.isKeyDown(teclaDir)) {
            setLocation(getX() + velocidade, getY());
            if(estaColidindo()) { setLocation(getX() - velocidade, getY()); }
            seMoveu = true;
        }

        animar(seMoveu);
    }
    
    private void animar(boolean seMoveu) {
        if (!seMoveu) {
            setImage(imgParado);
            contAnimacao = 0; 
        } else {
            contAnimacao++;
    
            if ((contAnimacao / 10) % 2 == 0) {
                setImage(imgAndar1);
            } else {
                setImage(imgAndar2);
            }
        }
    }
    
    public void createBomb(){
        if (Greenfoot.isKeyDown(teclaAcao)){
            if(activesbombs < maxBomb){
                int tamanhoBloco = 24;
                int metadeBloco = tamanhoBloco / 2;
                
                int bombaX = ((getX() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
                int bombaY = ((getY() / tamanhoBloco) * tamanhoBloco) + metadeBloco;
    
                Bomba newbomba = new Bomba(this); 
                getWorld().addObject(newbomba, bombaX, bombaY);
                activesbombs++;
            }
        }
    }
    
    public void reduzirBombaAtiva() {
        if (activesbombs > 0) {
            activesbombs--;
        }
    }
    
    private boolean estaColidindo() {
        if (isTouching(BlocoIndestrutivel.class) || isTouching(BlocoDestrutivel.class)) {
            return true;
        }
        
        Bomba bomba = (Bomba) getOneIntersectingObject(Bomba.class);
        if (bomba != null && bomba.temColisao()) {
            return true;
        }
        
        return false;
    }
}
