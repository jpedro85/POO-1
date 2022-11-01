import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends UIElement
{
    private String text;
    private int counter;
         
    public Button(Color background,Color textColor, String text)
    {
        this.start_vars();
        this.setTextColor(textColor);
        /*
        this.background_defaut = new GreenfootImage(" "+text+" ",thisgetFont().getSize(),background,textColor);
        this.background_hover = new GreenfootImage(this.background_defaut);
        this.background_hover.scale(this.background_defaut.getWidth(),(int)(this.background_defaut.getHeight()*1.4));   
        */
        
        this.setBackground_Defaut( new GreenfootImage((int)(this.getFont().getSize()*text.length()*TEXTWIDTH_POR+20),(int)(this.getFont().getSize()*TEXTHEIGHT_POR+10)) );
        this.getBackground_Defaut().setColor(background);
        this.getBackground_Defaut().fill();
        
        this.setBackground_Selected( new GreenfootImage(this.getBackground_Defaut()) );
        this.getBackground_Selected().scale((int)(this.getBackground_Defaut().getWidth()*1.1),(int)(this.getBackground_Defaut().getHeight()*1.1));
        
        /*this.background_defaut = new GreenfootImage((int)(font.getSize()*text.length()*TEXTWIDTH_POR+20),(int)(font.getSize()*TEXTHEIGHT_POR+10));
        this.background_defaut.setColor(background);
        this.background_defaut.fill();
        this.background_hover = new GreenfootImage(this.background_defaut);
        this.background_hover.scale((int)(this.background_defaut.getWidth()*1.1),(int)(this.background_defaut.getHeight()*1.1)); */
        
        setText(text,getTexColor());
        this.setImage(this.getBackground_Defaut());
    }
    
    public Button(String background_defaut, String background_hover)
    {
        this.start_vars();
         
        this.setBackground_Defaut(background_defaut);
        this.setBackground_Selected(background_hover);
        
        setImage(this.getBackground_Defaut());
    }
 
    public void act()
    {
        check_states();
    }
 
    public void mouse_CLick()
    {
        //System.out.println("Button"+ this +" Name: " + getText());
    }
    
    protected void on_Animation()
    {
        if(counter <= 6)
            {   
                GreenfootImage temp = new GreenfootImage(this.getImage());
                double factor = counter >= 3 ? 1.05 : 0.975;
                //double factor = counter >= 4 ? 0.95 : 1.05;
                temp.scale( (int)(temp.getWidth()*factor) ,(int)(temp.getHeight()* factor) );
                setImage(temp);
                counter++;
            }
            else 
            {
                setImage(this.getBackground_Selected());
                this.setAnimateState(false);
                counter = 0;
                
            }
    }
   
    public void setText(String text)
    {
        setText(text,this.getTexColor() == null ? TEXTCOLOR_DEFAUT: this.getTexColor());
    }
    public void setText(String text,Color color)
    {   
        this.text = text;
        if(this.getBackground_Defaut() != null){
            
            int size = this.getFont().getSize();
            int conta = (int)(this.getBackground_Defaut().getHeight()-(size*TEXTWIDTH_POR))/2;
            int deltax = conta > 0 ? conta : 2 ;
            conta = (int)(this.getBackground_Defaut().getWidth()-(size*text.length()*TEXTHEIGHT_POR))/2;
            int deltay = conta > 0 ? conta : 2 ;
                
            drawtext(this.getBackground_Defaut(),text,deltax,this.getBackground_Defaut().getHeight()-deltay,color);

            if (this.getBackground_Selected() != null)
            {
                conta= (int)(this.getBackground_Selected().getHeight()-(size*TEXTWIDTH_POR))/2;
                deltax = conta > 0 ? conta : 2 ;
                conta= (int)(this.getBackground_Selected().getWidth()-(size*text.length()*TEXTHEIGHT_POR))/2;
                deltay = conta > 0 ? conta : 2 ;
                drawtext(this.getBackground_Selected(),text,deltax ,this.getBackground_Selected().getHeight()-deltay,color);
            
            };
        }
    }
    private void drawtext(GreenfootImage image,String text,int width,int height,Color color)
    {
        image.setColor(color);
        image.setFont(this.getFont());
        image.drawString(text, width, height);
    }
        
    public String getText()
    {
        return this.text;
    } 
    
    public String toString()
    {
        return "Button: " + super.toString();
    }
}