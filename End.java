import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo final.
 */
public class End extends World
{
    private Window windowEnd;
    private Button button;
    
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        super(1700, 900, 1); 
        this.setBackground("menu_background.png");
        this.create_window_end();
    }
    
    public void act()
    {
        if(this.button.isPressed())
        {
            Greenfoot.setWorld( new Menu() );
        }
    }

    private void create_window_end()
    {
        this.windowEnd = new Window("janelas\\janela_end2_background.png",680,500);
        addObject(this.windowEnd,850, 450);
        this.button = new Button("botoes\\defaut_novoJogo.png","botoes\\selected_novoJogo.png");
        this.windowEnd.add_Actor(this.button,340,470);
        
        Font font = new Font(false,false,25);
        
        TextBox tb_player1_name = new TextBox( 250, 30, 20, 0, Game.getPlayer1Name(), font,Color.BLACK );
        tb_player1_name.setEditable(false);
        this.windowEnd.add_Actor(tb_player1_name,359, 120);
        
        TextBox tb_player1_pontos = new TextBox( 200 ,30 ,20 , 1,"Pontos : " + String.valueOf( Game.getPlayerScore_1() ) ,UIElement.FONT2_DEFAUT ,UIElement.TEXTCOLOR_DOURADO );
        tb_player1_pontos.setEditable(false);
        this.windowEnd.add_Actor(tb_player1_pontos,380, 163);

        TextBox tb_player1_chaves = new TextBox( 200 ,30 ,20 , 1,"Chaves : " + String.valueOf( Game.getChavesPlayer1() ) ,UIElement.FONT2_DEFAUT ,UIElement.TEXTCOLOR_DOURADO );
        tb_player1_chaves.setEditable(false);
        this.windowEnd.add_Actor(tb_player1_chaves,380, 197);
        
        TextBox tb_player2_name = new TextBox( 250, 30, 20, 0, Game.getPlayer2Name(), font,Color.BLACK );
        tb_player2_name.setEditable(false);
        this.windowEnd.add_Actor(tb_player2_name,359, 246);
        
        TextBox tb_player2_pontos = new TextBox( 200 ,30 ,20 , 1,"Pontos : " + String.valueOf( Game.getPlayerScore_2() ) ,UIElement.FONT2_DEFAUT ,UIElement.TEXTCOLOR_DOURADO );
        tb_player2_pontos.setEditable(false);
        this.windowEnd.add_Actor(tb_player2_pontos,380, 292);

        TextBox tb_player2_chaves = new TextBox( 200 ,30 ,20 , 1,"Chaves : " + String.valueOf( Game.getChavesPlayer2() ) ,UIElement.FONT2_DEFAUT ,UIElement.TEXTCOLOR_DOURADO );
        tb_player1_chaves.setEditable(false);
        this.windowEnd.add_Actor(tb_player2_chaves,380, 326);
    }
}
