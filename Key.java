import greenfoot.*;  

/**
 * Chase nessessário para abrir portas.
 */
public class Key extends AdvancedActor
{
    private GreenfootSound sound;
    private int counter;
    private boolean active;
    
    /**
     * Construtor
    */
    public Key(String tooltip_text)
    {       
        super(tooltip_text,CollisionType.NONE,CollisionType.PASSHOVER);
        this.counter=0;
        this.active=false;
        this.sound = new GreenfootSound("apanhar.mp3");
    }
    
    /**
     * Chamado a cada tick.
    */
    @Override
    public void act()
    {
        check_player();
        on_Animate();
    }
    
    /**
     * Ação quando o jogador clica no butão de use.
    */
    public void action()
    {
       this.getUser().showTooltip(this.getTooltipText());
    }
    
    /**
     * Faz a animação quando se pega a chave.
     */
    private void on_Animate()
    {
        if(counter <= 6 && this.active)
            {   
                GreenfootImage temp = this.getImage();
                double factor = counter >= 3 ? 1.05 : 0.975;
                //double factor = counter >= 4 ? 0.95 : 1.05;
                temp.scale( (int)(temp.getWidth()*factor) ,(int)(temp.getHeight()* factor) );
                setImage(temp);
                counter++;
            }
            else if(this.active)
            {
                Game.updateChaves(this.getLastUser());
                this.getWorld().removeObject(this);
            }
    }
    
    /**
     * Verifica se um player apanhou a chave.
     */
    private void check_player()
    {
        if(isTouching(Players.class) && !this.active)
        {
            this.active=true;
            this.sound.play();
            this.setLastUser((Players)getOneIntersectingObject(Players.class));
        }
    }
}
