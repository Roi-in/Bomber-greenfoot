import greenfoot.*;

public class TelaVitoria extends World {
    public TelaVitoria(String vencedor) {    
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage(600, 400); 
        bg.setColor(Color.BLACK); 
        bg.fill(); 
        
        bg.setColor(Color.WHITE);
        // Diminuí a fonte de 40 para 30 para caber com folga
        bg.setFont(new Font("Arial", true, false, 30)); 
        
        // Mudei o texto para o topo (Y = 60) e ajustei o X (120) para centralizar melhor
        bg.drawString("VENCEDOR: PLAYER " + vencedor.toUpperCase(), 120, 60); 
        
        setBackground(bg);

        // A imagem "VITORIA" continua no centro
        addObject(new Vitoria(), 300, 200); 
        
        // Desci o botão Reiniciar um pouco mais (Y = 320) para não ficar colado na imagem
        addObject(new BotaoReiniciar(), 300, 320); 
    }
}