import greenfoot.*;  

/**
 * Base dos elementos do UI.
 */
public abstract class UIElement extends Actor
{   
    public static final Font FONT_DEFAUT = new Font("Segoe Script",false,false,15);
    public static final Font FONT2_DEFAUT = new Font("Segoe Script",true,false,20);
    public static final Color TEXTCOLOR_DOURADO  = new Color(255, 149, 0, 255);
    public static final Color TEXTCOLOR_DEFAUT = Color.BLACK;
    public static final double TEXTWIDTH_POR = 0.4 ,TEXTHEIGHT_POR = 0.75;
    private GreenfootImage background_defaut , background_selected;
    private boolean m_hover,m_pressed,active,animate; // estados 
    private Color textColor;
    private Font font;
    private GreenfootSound sound_select, sound_click;

    /**
     * Coloca na posição em que o canto superior esquerdo é igual (x,y);
     */
    public void setRelativeLocation(int x,int y)
    {   
        setLocation(x+(getImage().getWidth()/2),y+(getImage().getHeight()/2));
    }
    
    /**
     * Inicia as variavieis
     */
    protected void start_vars()
    {
        this.m_hover = false; // ativa quando o rato está em cima
        this.m_pressed = false; // ativa quando o rato clicou em cima
        this.animate =false; // ativa despois de clicar enquanto está a animar
        this.active = true; // ativa se o elemento for usavel.
        this.textColor = TEXTCOLOR_DEFAUT;
        this.font = FONT_DEFAUT;
        this.sound_select = new GreenfootSound("teste2.mp3");
        this.sound_select.setVolume(Game.getVolume());
        this.sound_click = new GreenfootSound("click-21156.mp3");
        this.sound_click.setVolume(Game.getVolume());
    }
    
    /**
     * Atualiza as variaveis de estado.
     */
    public void check_states()
    {   
        if(this.active)
        {
            this.check_click();    
            this.check_move();
            if(this.isAnimated()){
                on_Animation();
            }
        }
    }
    
    /**
     * Atualiza as variaveis de estado m_pressed.
     */
    protected void check_click()
    {
        if (Greenfoot.mouseClicked(this))
        {
            m_pressed = true;
            this.animate = true;
            this.mouse_CLick();
            this.sound_click.play();
        } else
        {
            this.m_pressed = false;
        }
    }
    
    /**
     * Atualiza as variaveis de estado m_move.
     */
    protected void check_move()
    {
        if (Greenfoot.mouseMoved(null))
        {
            if (Greenfoot.mouseMoved(this) && !m_hover )
            {
                m_hover = true;
                update();
            }
            if (!Greenfoot.mouseMoved(this) && m_hover )
            {
                m_hover = false;
                update();
            }
        }
    }
    
    /**
     * Ação a fazer quando o existe click.
     */
    public void mouse_CLick(){}
    
    /**
     * Atualiza a imagem com base nas variaveis de estado.
     */
    public void update()
    {
        if(this.isMouseHover())
        {
            this.sound_select.play();
            setImage(this.getBackground_Selected());
        }
        else
        {
            setImage(this.getBackground_Defaut());
        }
    }
    
    /**
     * Animação
     */
    protected void on_Animation(){};
    
    /**
     * Atualiza o estado.
     */
    protected void updateState()
    {
        if(this.getImage() != null)
        {
            if(this.isActive())

                this.getImage().setTransparency(255);
            else
                this.getImage().setTransparency(100);
        }
    }
    
    /**
     * Getters e setters
     */
    public void setImage(GreenfootImage image)
    {
        super.setImage(image);
        this.updateState();
    }

    public void setImage(String image)
    {
        super.setImage(image);
        this.updateState();
    }

    public void setActiveSate(boolean bool)
    {
        this.active = bool;
        updateState();
    }

    protected  void setAnimateState(boolean bool)
    {
        this.animate = bool; 
    }

    public void setFont(Font font)
    {
        if(font != null)
            this.font = font;
    }

    public void setTextColor(Color color)
    {
        this.textColor = color;
    }

    public void setBackground_Defaut(String name)
    {
        this.background_defaut = new GreenfootImage(name);
    }

    public void setBackground_Defaut(GreenfootImage image)
    {
        this.background_defaut = image;
    }

    public void setBackground_Selected(String name)
    {
        this.background_selected = new GreenfootImage(name);
    } 

    public void setBackground_Selected(GreenfootImage image)
    {
        this.background_selected = image;
    }

    public final boolean isActive()
    {
        return this.active;
    }

    public final boolean isAnimated()
    {
        return this.animate;
    }

    public final boolean isPressed()
    {
        return this.m_pressed;
    }

    public final boolean isMouseHover()
    {
        return this.m_hover;
    }

    public Font getFont()
    {
        return this.font;
    } 

    public Color getTexColor()
    {
        return this.textColor;
    }

    public GreenfootImage getBackground_Defaut()
    {
        return this.background_defaut;
    }

    public GreenfootImage getBackground_Selected()
    {
        return this.background_selected;
    }

    public int getWidth()
    {
        return this.getImage().getWidth();
    }

    public int getHeight()
    {
        return this.getImage().getHeight();
    }

    public int getRelative_X()
    {
        return this.getX()-(getImage().getWidth()/2);
    }

    public int getRelative_Y()
    {
        return this.getY()-(getImage().getHeight()/2);
    }

    public void setSound_Click(String sound)
    {
        this.sound_click = new GreenfootSound(sound) ;
        this.sound_click.setVolume(Game.getVolume());
    }

    public void setSound_Selected(String sound)
    {
        this.sound_select = new GreenfootSound(sound) ;
        this.sound_select.setVolume(Game.getVolume());
    }
    
    /**
     * Atualiza o volume dos sons.
     */
    public void updateVolume()
    {
        this.sound_click.setVolume(Game.getVolume());
        this.sound_select.setVolume(Game.getVolume());
    }
    
    /**
     * Retorna o objeto em string.
     */
    public String toString()
    {
        return "UIElement:(x,y: "+this.getX() + " , " + this.getY() + " , Active: " + this.isActive() + " , Pressed: " + this.isPressed() + " , Animated: " + this.isAnimated() +  ", Seleted: "+ this.isMouseHover() +")";
    }
}
