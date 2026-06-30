import greenfoot.*;

public class TelaVitoria extends World {
    public TelaVitoria(String vencedor) {    
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage(600, 400); 
        bg.setColor(Color.BLACK); 
        bg.fill(); 
        
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", true, false, 30)); 
        
        bg.drawString("VENCEDOR: PLAYER " + vencedor.toUpperCase(), 120, 60); 
        
        setBackground(bg);

        addObject(new Vitoria(), 300, 200); 
        
        addObject(new BotaoReiniciar(), 300, 320); 
    }
}