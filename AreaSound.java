import greenfoot.*; 
/**
 * Permite atribuir um som a uma area do mapa.
 */
public class AreaSound  
{
    // instance variables - replace the example below with your own
    private int x,y,width,height;
    private boolean playing;
    private String str_sound;

    /**
     * Constructor for objects of class AreaSound
     */
    public AreaSound( int x, int y,int width,int height , String sound)
    {
        this.str_sound = sound;
        this.x = x;
        this.y = y;
        this.width  =width ;
        this.height = height;
    }

    /**
     * Retorna true se o actor estiver dentro da árrea.
     */
    public boolean isIn(Actor actor)
    {
        return (actor.getX() >= this.x && actor.getX() <= this.x + this.width) && 
                (actor.getY()+ actor.getImage().getHeight()/2 >= this.y && actor.getY()+ actor.getImage().getHeight()/2 <= this.y + this.height);
    }
    
    /**
     * Retorna o filename do som.
     */
    public String getSound()
    {
        return this.str_sound;
    }
}
