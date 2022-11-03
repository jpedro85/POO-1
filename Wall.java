import greenfoot.*;  

/**
 * Actorcom colisão total com e player e atores.
 */
public class Wall extends AdvancedActor
{
    /**
     * Act - do whatever the wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wall(String filename)
    {       
        super("",CollisionType.TOTAL,CollisionType.TOTAL);
        this.setImage(new GreenfootImage(filename));
    }
    
    /**
     * Inicia a super classe advancedActor
     */
    public Wall()
    {       
        super("",CollisionType.TOTAL,CollisionType.TOTAL);
    }
    
    /**
     * Quando o player usa.
     */
    public void action(){} 
}
