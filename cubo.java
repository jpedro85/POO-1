import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cubo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cubo extends AdvancedActor
{
    /**
     * Act - do whatever the cubo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public cubo(String tooltip_text,CollisionType collisionType_ToActor,CollisionType collisionType_ToPlayer)
    {       
        super(tooltip_text,collisionType_ToActor,collisionType_ToPlayer);
    }
    
    public void action()
    {
       this.getUser().showTooltip(this.getTooltipText());
    }
    
    public void act()
    {
        super.act();
        this.check_Actor();
    }
}
