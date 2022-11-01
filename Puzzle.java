import greenfoot.*;
import java.util.ArrayList;
/**
 * O
 */
public abstract class Puzzle  
{
    private World level ;
    private int points; 
    private int countplayer1 ,countplayer2;
    private boolean complete,scoreAdded;

    protected void setPoints(int points)
    {
        this.points = (points > 0) ? points : this.points ;
    }
    
    public abstract ArrayList<Players> getLastUserList();
    
    public abstract void atAct();
    
    protected abstract void check_complete();
    
    public void setWorld(World world)
    {
        this.level = world;
    }

    public World getWorld()
    {
        return this.level;
    }

    public int getPoints()
    {
        return this.points;
    }

    public void setScoreAdded(boolean added)
    {
         this.scoreAdded = added;
    }
        
    protected void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public boolean isComplete()
    {
        return this.complete;
    }
    
    public boolean isScoreAdded()
    {
        return this.scoreAdded ;
    }
}
