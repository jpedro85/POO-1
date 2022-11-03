import greenfoot.*;  

/**
 * Ator para verificar a condi��o se final de jogo.
 */
public class ChangeWorld extends Actor
{   
    /**
     *Inicia o objeto defenindo a largura e a altura da �rea de final de jogo.
    */
    public ChangeWorld(int altura,int largura){
        this.setImage(new GreenfootImage(largura,altura));
    }  
    
    /**
     * Verifica a condi��o de final de jogo.
    */
    public boolean isTouchingPlayers(){
        return isTouching(Player2.class) && isTouching(Player1.class);
    }
}

