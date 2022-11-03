import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Permite modificar um valor arrastando o rato.
 */
public class Slider extends UIElement
{
    private int value,max_value,min_value;
    private int last_mouse_x;
    private int p_x,p_y;
    private boolean drag;
    double step;
    
    /**
     * Cria a imagem de fundo e inicia as variaveis.
     */
    public Slider(int width,int heigth,int min_value ,int max_value)
    {   
        this.start_vars();
        this.drag =false;
        this.value = min_value;
        this.max_value = max_value;
        this.min_value = min_value;
        this.p_y = 3;
        this.step = (Math.abs(min_value - (double)max_value)/(width-9));
        this.creat_images(width,heigth);
        this.setImage(this.getBackground_Defaut());
        this.p_x = this.getBackground_Defaut().getWidth()-9;
        this.updateImage();
    }
    
    /**
     * Overload inicia as variaveis mas utiliza imagens ja feitas.
     */
    public Slider(GreenfootImage background,GreenfootImage selected, int min_value ,int max_value)
    {   
        this.start_vars();
        this.drag =false;
        this.value = min_value;
        this.max_value = max_value;
        this.min_value = min_value;
        this.p_y = 3;
        this.step = (Math.abs(min_value-max_value)/(background.getWidth()-9));
        this.setBackground_Defaut(background);
        this.setBackground_Selected(selected);
        this.setImage(this.getBackground_Defaut());
        this.p_x = this.getBackground_Defaut().getWidth()-9;
        this.updateImage();
    }
    
    /**
     * Cria as imagens
     */
    private void creat_images(int width,int heigth)
    {
        if(width<100)
            width = 150;
        if(heigth<20)
            heigth = 20;
        GreenfootImage temp = new GreenfootImage(width,heigth);
        temp.setColor(Color.BLACK);
        temp.fillRect(3,(int)((heigth-2)/2) , width-6, 2);
        
        this.setBackground_Defaut( new GreenfootImage(temp) );
        temp.setColor(this.TEXTCOLOR_DOURADO);
        temp.drawRect(0, 0, width-1,heigth-1);
        this.setBackground_Selected(temp);
    }
    
    /**
     * Ação quando se clica.
     */
    @Override
    public void mouse_CLick()
    {
        this.last_mouse_x = Greenfoot.getMouseInfo().getX(); 
    }
    
    /**
     * Ferifica e atualiza o movimeto
     */
    @Override
    protected void check_move()
    {
        super.check_move();
        if( Greenfoot.mouseDragged(this) )
        {
            int deltax = (Greenfoot.getMouseInfo().getX() - this.last_mouse_x);
            
            if (deltax > this.getImage().getWidth() )
                 this.last_mouse_x = Greenfoot.getMouseInfo().getX(); 
                 
            else{
                this.p_x = this.p_x + deltax;
                
                if(this.p_x <3)
                    this.p_x = 3;
                else if (this.p_x > getImage().getWidth()-9)
                    this.p_x = getImage().getWidth()-9;
                    
                this.updateImage();
                this.updateValue();
                
                this.last_mouse_x = Greenfoot.getMouseInfo().getX(); 
            }
            
            this.drag = true;
            
        }else
        {
            this.drag = false;
        }
    }
    
    /**
     * Atualiza a imagem.
     */
    @Override
    public void update()
    {
        super.update();
        this.updateImage();
    }
    
    /**
     * Executado cada tick.
     */
    @Override
    public void act()
    {
        this.check_states();
    }
    
    /**
     * Cria uma nova imagem com o retangulo numa dada posição.
     */
    private void updateImage()
    {
        GreenfootImage  image;
        if (this.isMouseHover())
            image = new GreenfootImage(this.getBackground_Selected());
        else
            image = new GreenfootImage(this.getBackground_Defaut());
        
        image.setColor(Color.GRAY);    
        image.fillRect(this.p_x,this.p_y,6,image.getHeight()-6);
        this.setImage(image);
    }
    
    /**
     * Atualiza o valor.
     */
    private void updateValue()
    {
        if(this.p_x == 3)
            this.value=this.min_value;
        else if(this.p_x == this.getImage().getWidth()-9)
            this.value=this.max_value;
        else
            this.value = this.min_value + (int)((double)this.step*(this.p_x-3));
    }
    
    /**
     * retorna o valor.
     */
    public int getValue()
    {
        return this.value;
    }
    
    /**
     * Atribui um valor.
     */
    public void setValue(int value)
    {
        if(value >= this.min_value && value <= this.max_value)
        {
            this.value = value - this.min_value ;
            this.p_x = (int) (this.value/this.step);
            this.updateImage();
        }
    }
    
    /**
     * Retorna se o rato esta a fazer drag sobre o UIElement
     */
    public boolean isDrag()
    {
        return this.drag; 
    }
    
    /**
     * Retorna uma string que representa o objeto.
     */
    @Override
    public String toString()
    {
        return "Slider: " + super.toString();
    }    
}
