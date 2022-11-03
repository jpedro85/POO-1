import greenfoot.*;  

/**
 * Placa de pressao ativada quando o player ou a bola ficam em cima.
 */
public class Pressure_Plate extends AdvancedActor
{
    private boolean active;
    private GreenfootImage pad_active;
    private GreenfootImage pad_off;
    
    /**
     * Inicia as variaveis e cria uma imagem para quando ativa.
     */
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
     * Executado a cada tick
     */
    @Override
    public void act()
    {
        this.check_Actor();
        this.check_Collision();
        this.activate();
    }
    
    /**
     * Quando o player usa.
     */
    public void action()
    {
        if(getOneObjectAtOffset(0, 0, Ball.class) == null){
            this.getUser().showTooltip(this.getTooltipText());
        }
    }
    
    /**
     *  Verifica e alera a imagem quando esta ativa.
     */
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
    
    /**
     * Retorna se esta precionada.
     */
    public boolean isPressed(){
        return this.active;
    }
}
