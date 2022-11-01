import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends AdvancedActor
{
    private GreenfootImage img;
    private boolean anima;
    private Players actor2;
    
    public Ball()
    {
        super("Esta bola parece pesada !",CollisionType.NONE , CollisionType.TOTAL);
        this.img = new GreenfootImage("interactables\\esfera\\blue_esfera_1.png");
        this.setImage(img);
        this.anima = false;
    }
    
    public void act()
    {
        super.act();
        this.animate();
        this.check_Collision();
        this.check_Actor();
    }
    
    @Override
    public void use(Players actor)
    {
        super.use(actor);
        this.actor2 = actor;
    }
    
    @Override
    public void action()
    {
        this.getUser().showTooltip(this.getTooltipText());
        this.anima = !this.anima;
    }
    
    private void animate()
    {
        if (this.isAnimated())
        {
             switch(this.actor2.getVision())
            {
                case UP:
                    this.setLocation(this.actor2.getX(), this.actor2.getY() - this.actor2.getImage().getHeight()/2 );
                    this.getWorld().setPaintOrder(Light.class,Tooltip.class,TextBox.class,Blackout.class,Players.class,Ball.class,Pressure_Plate.class);
                    break;
                case DOWN:
                    this.setLocation(this.actor2.getX(), this.actor2.getY() + this.actor2.getImage().getHeight()/2 );
                    this.getWorld().setPaintOrder(Light.class,Tooltip.class,TextBox.class,Blackout.class,Ball.class,Players.class,Pressure_Plate.class);
                    break;
                case RIGHT:
                    this.setLocation(this.actor2.getX() + this.actor2.getImage().getWidth()/2 , this.actor2.getY() );
                    this.getWorld().setPaintOrder(Light.class,Tooltip.class,TextBox.class,Blackout.class,Ball.class,Players.class,Pressure_Plate.class);
                    break;
                case LEFT:
                    this.setLocation(this.actor2.getX() - this.actor2.getImage().getWidth()/2 , this.actor2.getY() );
                    this.getWorld().setPaintOrder(Light.class,Tooltip.class,TextBox.class,Blackout.class,Ball.class,Players.class,Pressure_Plate.class);
                    break;
            }
        }
        else
        {
            this.check_Actor();
            this.actor2 = null;
        }
    }
    
    public boolean isAnimated()
    {
        return this.anima;
    }
}
