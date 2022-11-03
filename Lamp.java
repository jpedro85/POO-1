import greenfoot.*;  

/**
 * Objeto que tem uma luz variavel quando está desligado ou ligado
 */
public class Lamp extends Actor
{
    private Light light_ligada , light_desligada;
    private GreenfootImage img_off, img_on;
    private boolean state;
    
    /**
     * Inicia Luz ligada e Luz Desligada e as imagens do objeto que imete luz.
     */
    public Lamp(Light light_ligada ,Light light_desligada , String img_off ,String img_on  )
    {
        this.light_ligada = light_ligada;
        this.light_desligada = light_desligada;
        this.img_off = new GreenfootImage(img_off);
        this.img_on = new GreenfootImage(img_on);
        this.state = false;
        this.setImage(this.img_off);
    }
    
    /**
     * Muda o estádo da lampada.
     */
    public void changeState()
    {
        this.state = !this.state;
        this.updateLight();
    }
    
    /**
     * Liga a lampada.
     */
    public void ligar()
    {
        this.state = true;
        this.updateLight();
    }
    
    /**
     * Desliga a lampada.
     */
    public void desligar()
    {
        this.state = false;
        this.updateLight();
    }
    
    /**
     * Aletera a luz assoassiada ao estado.
     */
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
    
    /**
     * Retorna se está ligada.
     */
    public boolean isligado()
    {
        return this.state;
    }
}
