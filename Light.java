import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Luz objeto com uma anima��o pintado antes da cortina preta.
 */
public class Light extends Actor
{
    private ArrayList<GreenfootImage> animacao_list;
    private int counter , counterDelay, delay;
    private String base_name;
    private int n_img;
    
    /**
     * Inicia as imagens n_img � numero de imagens.
     */
    public Light(String base_name,int n_img)
    {
        this.counter = 0;
        this.counterDelay = 0;
        this.delay = 3;
        this.animacao_list = new ArrayList();
        this.base_name = base_name;
        this.n_img = n_img;
        this.loadAnimation( this.base_name, n_img );
        this.setImage( animacao_list.get(0) );
    }
    
    /**
     * Chamado cada tick.
     */
    public void act()
    {
        this.animate();   
    }
    
    /**
     * Adiciona ao mundo tendo em conta a posi��o do ator que � iluminado.
     */
    public void addToActorWorld(Actor actor)
    {
        if(this.getWorld() == null && actor.getWorld() != null )
            actor.getWorld().addObject(this,actor.getX(), actor.getY());        
    }
    
    /**
     * Remove do mundo.
     */
    public void removeFromWorld()
    {
        if(this.getWorld() != null )
            this.getWorld().removeObject(this);   
    }
    
    /**
     * Altera a posi��o tendo em conta a posi��o do ator que � iluminado.
     */
    public void update_Location(int x, int y,Actor actor)
    {
        if(this.getWorld() != null)
            this.setLocation(x, y);
        else
            this.addToActorWorld(actor);
    }
    
    /**
     * Carrega as imagens para um arraylist.
     */
    protected void loadAnimation(String base_name ,int n_img)
    {
        for(int i = 0; i < n_img;i++){
            this.animacao_list.add( new GreenfootImage( base_name+i+".png") );
        }
    }
    
    /**
     * Faz a anima��o.
     */
    protected void animate()
    {
        if(this.animacao_list != null)
        {
            if( this.counterDelay > this.delay )
            {
                if ( this.counter < animacao_list.size() )
                {
                    this.setImage( animacao_list.get(this.counter) );
                    this.counter += 1;
                }
                else 
                {
                    this.counter = 0;
                }
                this.counterDelay = 0;
            }
            else
                this.counterDelay++;
        }
    }
    
    /**
     * Retorna a lista com as imagens.
     */
    public ArrayList<GreenfootImage> getAnimacao_list()
    {
        return this.animacao_list;
    }
    
    /**
     * Altera o delay da anima��o.
     */
    public void setDelay(int delay)
    {
        this.delay = delay > 0 ? delay : 1;
    }
    
    /**
     * Cria e retorno uma c�pia deste objeto.
     */
    //@Overide
    public Light clone()
    {
        return new Light(this.base_name,this.n_img);
    }
    
    /**
     * Retorna o objeto em string.
     */
    public String toString()
    {
        return "Base Name: " + this.base_name + " Numero de imagesn: " + this.n_img ;
    }
}
