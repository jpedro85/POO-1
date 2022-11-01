import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lampada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lamp extends Actor
{
    private Light light_ligada , light_desligada;
    private GreenfootImage img_off, img_on;
    private boolean state;

    public Lamp(Light light_ligada ,Light light_desligada , String img_off ,String img_on  )
    {
        this.light_ligada = light_ligada;
        this.light_desligada = light_desligada;
        this.img_off = new GreenfootImage(img_off);
        this.img_on = new GreenfootImage(img_on);
        this.state = false;
        this.setImage(this.img_off);
    }

    public void changeState()
    {
        this.state = !this.state;
        this.updateLight();
    }

    public void ligar()
    {
        this.state = true;
        this.updateLight();
    }

    public void desligar()
    {
        this.state = false;
        this.updateLight();
    }

    public void updateLight()
    {
        if(this.state)
        {
            this.setImage(this.img_on);
            this.light_desligada.removeFromWorld();
            this.light_ligada.addToActorWorld(this);
            //this.getWorld().addObject( this.light_ligada , this.getX(), this.getY() );   
        }
        else
        {
            this.setImage(this.img_off);
            this.light_ligada.removeFromWorld();   
            this.light_desligada.addToActorWorld(this);     
        }
    }

    public boolean isligado()
    {
        return this.state;
    }
}
