import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public Wall()
    {       
        super("",CollisionType.TOTAL,CollisionType.TOTAL);
       // this.setImage(new GreenfootImage(filename));
    }
    
    public void action(){} 
}
