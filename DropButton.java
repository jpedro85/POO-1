import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Um botao com subbotoes em que só um pode estar selecionado de cada vez.
 */
public class DropButton extends Button
{
    private GreenfootImage defaut_ori,seleted_ori;
    private ArrayList<Button> buttons_list;
    private ArrayList<String> options_list;
    private String atual_optn;
    private boolean aberto ,btn_pressed;
    private int counte;
    
    
    /**
     * Inicia o buttao principal e as suas variaveis
     */
    public DropButton(String background_defaut, String background_hover)//, String menu_background)
    {
        super(background_defaut,background_hover);
        this.start_vars();  
    }
    
    /**
     * Inicia sa variaveis.
     */
    @Override
    protected void start_vars()
    {
        super.start_vars();
        this.atual_optn = "Lista Vazia AAA ";
        this.buttons_list = new ArrayList();
        this.options_list = new ArrayList();
        this.aberto = false;
        this.btn_pressed = false;
        this.defaut_ori = this.getBackground_Defaut();
        this.seleted_ori = this.getBackground_Selected();
    }
    
    /**
     * Executado a cada ciclo.
     */
    @Override
    public void act()
    {
        super.act();    
        this.check_optn();
        this.wait_for_Animation();
    }
    
    /**
     * Da update á opção escolhida.
     */
    private void updatetext()
    {
        GreenfootImage img = new GreenfootImage(this.defaut_ori);
        img.setColor(this.getTexColor());
        img.setFont(this.getFont());
        img.drawString(this.atual_optn,30,this.getFont().getSize()+1);
        
        this.setBackground_Defaut(img);
        
        img = new GreenfootImage(this.seleted_ori);
        img.setColor(this.getTexColor());
        img.setFont(this.getFont());
        img.drawString(this.atual_optn,30,this.getFont().getSize()+1);
        
        this.setBackground_Selected(img);
        this.setImage(this.getBackground_Defaut());
    }
    
    /**
     * Faz um dilay para a animação de click do butao acabar antes de fechar todos os butoes.
     */
    private void wait_for_Animation()
    {
         if(this.btn_pressed){
        
            if (this.counte == 15){
                this.fechar();
                this.counte = 0;
                this.btn_pressed = false;
                //this.updatetext();
            }
            this.counte++;
        } 
    }
    
    /**
     * Ação a fazer quando se clica.
     */
    @Override
    public void mouse_CLick()
    {
        this.setAberto( !this.isAberto() );
        
        if(this.isAberto())
            this.abrir();
        else
            this.fechar(); 
    }
    
    /**
     * Faz aparecer os subbotoes.
     */
    public void abrir()
    {
        Button btn_last = null;
        int lastpos = (int)(this.getY());
        for(Button btn:this.buttons_list)
        {
            lastpos += (int)((btn.getImage().getHeight()*1.23));
            this.getWorld().addObject(btn,this.getX(),lastpos);
        }
    }
    
    /**
     * faz desaparecer os subbotoes.
     */
    public void fechar()
    {
        for(Button btn:this.buttons_list)
        {
            this.getWorld().removeObject(btn);
        }
        this.setAberto(false);
    }
    
    /**
     * Atualiza a opção escolhida com base no subbotao que esta escolhido.
     */
    private void check_optn()
    {
        for(Button btn:this.buttons_list)
        {
            if(btn.isPressed())
            {
                this.setOptn( this.options_list.get( this.buttons_list.indexOf(btn) ) );
                this.btn_pressed = true;
                break;
            }
        }
    }
    
    /**
     * Adiciona um botao a lista de subbotoes.
     */
    public void addSubButton(Button button,String option)
    {
        this.buttons_list.add(button); 
        this.options_list.add(option);
    }
    
    /**
     * Remove o botao da lista.
     */
    public void removeSubButton(int index)
    {
        this.buttons_list.remove(index);
        this.options_list.remove(index);
    }
    
    /**
     * Altera a opção escolhida e da update á imagem atualizando o texto.
     */
    public void setOptn(String optn)
    {
        this.atual_optn = optn;
        this.updatetext();
    }
    
    /**
     * Retorna a opção
     */
    public String getOptn()
    {
        return this.atual_optn;
    }
    
    /**
     * Modifica a variavel "aberto".
     */
    private void setAberto(boolean bool)
    {
        this.aberto = bool;
    }
    
    /**
     * Retorna "aberto".
     */
    public boolean isAberto()
    {
        return this.aberto;
    }
    
}
