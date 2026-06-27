import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vitoria here.
 * * @author (your name) 
 * @version (a version number or a date)
 */
public class Vitoria extends Actor
{

    private GreenfootImage imgBranca;
    private GreenfootImage imgCiano;
    private GreenfootImage imgPink;
    
    private int contador = 0;
    private int velocidadeAnimacao = 5; 
    private int estadoAtual = 0; 

    public Vitoria()
    {
        imgBranca = new GreenfootImage("Vitoria.png");
        imgCiano = new GreenfootImage("Vitoria-Ciano.png");
        imgPink = new GreenfootImage("Vitoria-Pink.png");
        
        setImage(imgBranca); 
    }

    public void act()
    {
        animarTexto();
    }
    
    private void animarTexto()
    {
        contador++; 
        
        if (contador >= velocidadeAnimacao) {
            contador = 0; 
            estadoAtual++; 
            
            if (estadoAtual > 2) {
                estadoAtual = 0;
            }
            
            if (estadoAtual == 0) {
                setImage(imgBranca);
            } 
            else if (estadoAtual == 1) {
                setImage(imgCiano);
            } 
            else if (estadoAtual == 2) {
                setImage(imgPink);
            }
        }
    }
}