import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Window here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Window extends Actor
{
    private ArrayList<Actor> actor_list;
    private int valid_width,valid_height;
    private World world;
    
    public Window(String background, int valid_width,int valid_height)
    {
        this.setImage(new GreenfootImage(background));
        this.actor_list = new ArrayList();
        this.valid_width = valid_width;
        this.valid_height = valid_height;
    }
    
    protected void add_Actor(Actor actor,int x,int y)
    {
        this.actor_list.add(actor);
        if( x>=0 && x<=this.valid_width && y>=0 && y<=this.valid_height )
        {
            this.getWorld().addObject(actor, getX()-(int)(valid_width/2)+x , getY()-(int)(valid_height/2)+y);
        }
    }
    
    public void remove_Actor(Actor actor)
    {
        if(this.actor_list.indexOf(actor) != 0 &&  this.actor_list.indexOf(actor) != 1)
            this.actor_list.remove(actor);
    }
    
    public ArrayList getActor_Liste()
    {
        return this.actor_list;
    }
    
    public void updateSound()
    {
        for(Actor actor : this.actor_list)
        {
            ((UIElement)actor).updateVolume();
        }
    }
    
    public void close()
    {
         this.getWorld().removeObjects(this.actor_list);
         this.getWorld().removeObject(this);
    }
    
}
