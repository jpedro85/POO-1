import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pressure_Plate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pressure_Plate extends AdvancedActor
{
    private boolean active;
    private GreenfootImage pad_active;
    private GreenfootImage pad_off;
    public Pressure_Plate(String text,String filename)
    {
        super(text,CollisionType.NONE,CollisionType.NONE);
        this.active=false;
        this.pad_off= new GreenfootImage(filename);
        this.pad_active=new GreenfootImage(filename);
        this.setImage(this.pad_off);
        this.pad_active.scale((int)(pad_active.getWidth()*(double)1.2), (int)(pad_active.getHeight()*(double)1.2));
    }

    /**
     * Act - do whatever the Pressure_Plate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.check_Actor();
        this.check_Collision();
        this.activate();
    }
    
    @Override
    public void action()
    {
        if(getOneObjectAtOffset(0, 0, Ball.class) == null){
            this.getUser().showTooltip(this.getTooltipText());
        }
    }

    public void activate()
    {
        if(isTouching(Ball.class) ){
            this.setImage(pad_active);
            this.active=true;
        }
        else if(isTouching(Players.class))
        {
            this.setImage(pad_active);
            this.active=true;
            Players player = (Players)getOneIntersectingObject( Players.class );
            this.setLastUser( player );
        }
        else{
            this.setImage(pad_off);
            this.active=false;
        }
    }
    
    public boolean isPressed(){
        return this.active;
    }
}
