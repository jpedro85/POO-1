import greenfoot.*;

/**
 * Cria um elemento para mostrar ou editar texto.
 */
public class TextBox extends UIElement
{
    private String text;
    private boolean texting,editable;
    private int limit,begin_wrinting;
    
    /**
     * Cria um "mostrador de texto" com uma imagem trasnparente ,que pode ser editado ou noa
     */
    public TextBox(int width,int height,int char_limit,int begin_wrinting,String text ,Font font, Color textColor)
    {
        this.start_vars();
        this.setCharLimit(char_limit);
        this.begin_wrinting = begin_wrinting;
        this.setBackground_Defaut( new GreenfootImage(width,height) );
        this.setBackground_Selected( new GreenfootImage(width,height) );
        this.setTextColor(textColor);
        this.setFont(font);
        this.setImage(this.getBackground_Defaut());
        this.setText(text);
        this.update_Text();
    }
    
    /**
     * Overload usa imagens ja feitas.
     */
    public TextBox(String background_defaut, String background_hover,int char_limit,int begin_wrinting)
    {
        this.start_vars();
        this.setCharLimit(char_limit);
        this.begin_wrinting = begin_wrinting;

        this.setBackground_Defaut(background_defaut);
        this.setBackground_Selected(background_hover);

        setImage(this.getBackground_Defaut());
    }
    
    /**
     * Executado cada ciclo.
     */
    @Override
    public void act()
    {
        if(this.isEditable())
        {
            check_states();

            if( this.isTexting() ){
                read_input();     
                update_Text();
            }
        }
    }
    
    /**
     * Inicia ass variaveis.
     */
    @Override
    protected void start_vars()
    {
        super.start_vars();
        this.setTexting(false);
        this.setEditable(true);
    }
    
    /**
     * Ação quando se clica.
     */
    @Override
    public void mouse_CLick()
    {
        this.setTexting(true);
        this.clear();
    }
    
    /**
     * Animação 
     */
    @Override
    protected void on_Animation()
    {
        this.setAnimateState(false);
    }
    
    /**
     * Verifica o estado.
     */
    @Override
    protected void check_move()
    {
        super.check_move();
        this.update_Text();
    }
    
    /**
     * Lê o input.
     */
    private void read_input()
    {
        String input = Greenfoot.getKey();

        if(input == "backspace"){

            if(this.getText() != null && this.getText() != "" )
            {

                if(this.getText().length() == 1 )
                    this.setText("");  
                else
                    this.setText(this.getText().substring(0,this.getText().length()-1));  

            } 

        }else if(input == "enter" || input == "escape" ){

            this.setTexting(false);

        }else if( input != null )
        {
            if (input.length()==1 || input=="space" ) 
            {
                if(input == "space" ) 
                    input = " ";
                if (this.getText() == null && getCharLimit()!=0 )
                    this.setText(input);
                else if ( getText().length( )< getCharLimit() )
                    this.setText(this.getText()+input);
            }
        }
    }
    
    /**
     * Atualiza o texto para ficar igual à varivel interna.
     */
    public void update_Text()
    {
        if (this.getImage() != null && this.getText() != null)
        {   
            GreenfootImage  image;
            if (this.isMouseHover())
                image = new GreenfootImage(this.getBackground_Selected());
            else
                image = new GreenfootImage(this.getBackground_Defaut());

            image.setColor(this.getTexColor());
            image.setFont(this.getFont());
            image.drawString(this.getText(),this.begin_wrinting,this.getImage().getHeight()-5);
            setImage(image);
        }
    }
    
    /**
     * Atualiza a cor do texto escrito.
     */
    @Override
    public void setTextColor(Color color)
    {
        super.setTextColor(color);
        this.getBackground_Defaut().setColor(color);
        this.getBackground_Selected().setColor(color);
    }
    
    /**
     * Atualia a fonte.
     */
    public void setFont(Font font)
    {
        super.setFont(font);
        this.getBackground_Defaut().setFont(font);
        this.getBackground_Selected().setFont(font);
    }
    
    /**
     * Muda o estado.
     */
    @Override
    public void setActiveSate(boolean bool)
    {
        super.setActiveSate(bool);
        this.setTexting(false);
    }
    
    /**
     * Limpa a caixa de texto.
     */
    public void clear()
    {
        this.text = "";
    }
    
    /**
     * Altera o texto.
     */
    public void setText(String text)
    {
        if(text != null)
            this.text = text;
    }   

    /**
     * Modifica se está escrevendo.
     */
    public void setTexting(boolean bool)
    {
        this.texting = bool;
    }
    
    /**
     * habilida ou desabilida a função de escrita.
     */
    public void setEditable(boolean bool)
    {
        this.editable = bool;
    }
    
    /**
     * Define a quantidade de careteres máxima.
     */
    public void setCharLimit(int limit)
    {
        this.limit = limit;
    }
    
    /**
     * Retorna o texto
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * Retorna o lim de caracteres.
     */
    public int getCharLimit()
    {
        return this.limit;
    }
    
    /**
     * Retorna se essta escrevendo.
     */
    public boolean isTexting()
    {
        return this.texting;
    }

    /**
     * Retorna se é editavel.
     */
    public boolean isEditable()
    {
        return this.editable;
    }
    
    /**
     * Retorna uma representação do objeto em String.
     */
    @Override
    public String toString()
    {
        return "Textbox: " + super.toString();
    }

}

