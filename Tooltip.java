import greenfoot.*;  

/**
 * Cria um texto que aparece sobre a cabeja do player
 */
public class Tooltip extends Actor
{
    private GreenfootImage image;
    private Color myColor = new Color(143,204,255);
    private Color myColor1 = new Color(0,128,255);
    private boolean active;
    final int MAX_TICKS=30;
    private int ticks;
    private Actor actor;
    
    /**
     * Inicia tamnanho e actor para seguir.
     */
    public Tooltip(String text,int size, Actor actor) {
        createTooltip(text,size);
        this.actor = actor;
        this.active =true;
    }
    
    /**
     * Act - do whatever the Tooltip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        ticks++;
        this.removeTooltip();
        this.follow();
    }
    
    /**
     * Modifica a localização da tooltip.
     */
    private void follow()
    {
        this.setLocation(this.actor.getX(),(this.actor.getY()-(this.actor.getImage().getHeight()/2)) );
    }
    
    /**
     * Cria a Imagem da Tooltip.
     */
    private void createTooltip(String text,int size)
    {
        image=new GreenfootImage(" "+text+" ", size,Color.BLACK,myColor);
        image.setColor(myColor1);
        borderThickness(size/7);
        setImage(image);
    }
    
    /**
     * Cria uma borda para a tooltip
     */
    private void borderThickness(int thickness)
    {
        for(int i=0; i<thickness ;i++)
        {
            image.drawRect(i,i, image.getWidth()-i*2,image.getHeight()-i*2);
        }
    }
    
    /**
     * Remove a tooltip.
     */
    private void removeTooltip(){
        if (ticks==MAX_TICKS){
            ticks=0;
            this.active=false;
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Modifica Active.
     */
    public void setActive(boolean state)
    {
        this.active=state;
    }
    
    /**
     * Retorna Active
     */
    public boolean isActive()
    {
        return active;
    }
}

