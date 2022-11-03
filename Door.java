import greenfoot.*; 

/**
 * Cria uma porta.
 */
public class Door extends AdvancedActor
{
    private int chaves,counter,lado;
    private boolean open,vertical,animate,played;
    private GreenfootSound s_open,s_close;
    
    /**
     * Inicia as variaveis.
    */
    public Door(String text,String img,String sound_open, String sound_close ,boolean vertical,int delta ,int chaves)
    {
        super(text,CollisionType.NONE,CollisionType.TOTAL);
        this.open = false;
        this.vertical = vertical;
        this.animate = false;
        this.setImage(new GreenfootImage(img));
        this.counter = 0;
        this.s_open = new GreenfootSound(sound_open);
        this.s_close = new GreenfootSound(sound_close);
        this.played = false;
        this.chaves = chaves;
        if (delta != 0)
            this.lado = delta;
        else
            throw new IllegalArgumentException("Delta não é um valor correto");
    }
    
    /**
     * Executado a cada tick;
    */
    @Override
    public void act()
    {
        super.act();
        this.animate();
        this.check_Actor();
    }
    
    /**
     * Execuado quando o players usa este actor.
    */
    public void action()
    {
        if(this.chaves == 0)
        {
            this.getUser().showTooltip("Parece que consigo abir esta porta completando o " + this.getTooltipText() );
        }
        else if( Game.getChaves() < this.chaves)
        {
             this.getUser().showTooltip("Presiso de encontrar " + this.chaves +" chaves !");
        }
        else 
        {
            this.open();
        }
    }
    
    /**
     * Coloca a porta a brir a porta  
    */
    public void open()
    {
        if(!this.isOpen() && !this.animate)
        {
            this.open = true; 
            this.played = false;
            this.animate = true;
            this.animate();
        }
    }
    
    /**
     * Coloca a porta a fechar a porta  
    */
    public void close()
    {
        if(this.isOpen() && !this.animate )
        {
            this.open=false; 
            this.played = false;
            this.animate = true;
            this.animate();
        }
    }
    
    /**
     * Anima a porta afechar e a abrir.
    */
    private void animate()
    {
        int n = this.vertical ? this.getImage().getHeight() : this.getImage().getWidth();
        if(this.animate && counter< n)
        {
            if(this.open)
            {
                if(this.vertical)
                    this.setLocation(this.getX(), this.getY()+this.lado );
                else
                    this.setLocation(this.getX()+this.lado , this.getY() );   
                    
                if(!this.played)
                {
                    this.s_open.play();
                    this.played = true;
                }
                counter++;
            }
            else
            {
                if(this.vertical)
                    this.setLocation(this.getX(), this.getY()-this.lado );
                else
                    this.setLocation(this.getX()-this.lado , this.getY() );
                    
                if(!this.played)
                {
                    this.s_close.play();
                    this.played = true;
                }
                    
                counter++;
            }
        }else
        {
            this.animate = false;
            counter = 0;
        }
    }
    
    /**
     * Retorna true se a porta esta aberta.
    */
    public boolean isOpen()
    {
        return this.open;        
    }
}
