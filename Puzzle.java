import greenfoot.*;
import java.util.ArrayList;
/**
 * Class define os metodos que um puzzle deve ter.
 */
public abstract class Puzzle  
{
    private World level ;
    private int points; 
    private int countplayer1 ,countplayer2;
    private boolean complete,scoreAdded;
    
    /**
     * Inicia um puzzle, atribuindo pontos.
     */
    protected void setPoints(int points)
    {
        this.points = (points > 0) ? points : this.points ;
    }
    
    /**
     * Retorna uma lista que comtem referencias ao player que usou por ultimo cada um dos objetos com interações.
     */
    public abstract ArrayList<Players> getLastUserList();
    
    /**
     * Medotos para ser chamado no act.
     */
    public abstract void atAct();
    
    /**
     * Metodo para verificar o estado do puzzle.
     */
    protected abstract void check_complete();
    
    /**
     * Altera o mundo.
     */
    public void setWorld(World world)
    {
        this.level = world;
    }
    
    /**
     * Retorna o mundo do puzzle.
    */
    public World getWorld()
    {
        return this.level;
    }
    
    /**
     * Retorna os pontos do puzzle.
    */
    public int getPoints()
    {
        return this.points;
    }
    
    /**
     * Aletra a variavel booleana scoreadded.
    */
    public void setScoreAdded(boolean added)
    {
         this.scoreAdded = added;
    }
    
    /**
     * Aletra a variavel booleana complete.
    */
    protected void setComplete(boolean complete)
    {
        this.complete = complete;
    }
    
    /**
     * Retorna se esta completo.
    */
    public boolean isComplete()
    {
        return this.complete;
    }
    
    /**
     * Retorna se o score foi adicionado.
    */
    public boolean isScoreAdded()
    {
        return this.scoreAdded ;
    }
}
