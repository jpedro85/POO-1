import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Window windowHelp;
    private Window windowOptn;
    private Button m_play,m_optn,m_help;
    //janela optn vars
    private Slider sldier_volume,slider_brightness;
    private Button bt_aplicar,optn_fechar,help_fechar;
    private DropButton dp_dificulty,dp_personage1,dp_personage2;
    private TextBox tb_personage1,tb_personage2;
    private Button bt_dp1_optn1,bt_dp1_optn2,bt_dp1_optn3;
    private Button bt_dp2_optn1,bt_dp2_optn2,bt_dp2_optn3;

    public Menu()
    {    
        super(1700, 900, 1); 
        this.setBackground("menu_background.png");
        Game.resetPlayesDefaults();
        this.start_Buttons();
        Greenfoot.start();
        this.start_sound();
    }
    
    public void act()
    {
        this.check_m_help(); //porta ajuda
        //help ações dos butões
            this.check_help_fechar(); //porta ajuda
        
        this.check_m_optn(); //porta opções 
        //optn ações dos butões
            this.check_m_optn_Aplicar();
            this.check_Optn_Dp_Personage1();
            this.check_Optn_Dp_Personage2();
            this.check_optn_fechar();
            
        this.check_m_play(); //pota play
    }
    
    private void start_sound()
    {
        SoundBox.addSound("menu_music.mp3");
        SoundBox.playLoop_AllSounds();
    }
    
    private void check_m_play()
    {
        if(this.m_play.isPressed())
        {
            SoundBox.stop_AllSounds();
            SoundBox.clearSounds();
            Greenfoot.setWorld( new Level_1() );
        }
    }
    
    private void check_m_help()
    {
        if(this.m_help.isPressed() && this.windowHelp == null)
        {
            this.create_Window_Help();
        }
    }
    
    private void check_m_optn()
    {
        if(this.m_optn.isPressed() && this.windowOptn == null)
        {
            this.create_Window_Optn();
        }
    }
    
    private void check_optn_fechar()
    {
        if(this.optn_fechar != null && this.optn_fechar.isPressed())
        {
            this.dp_personage2.fechar();
            this.dp_personage1.fechar();
            this.dp_dificulty.fechar();
            this.windowOptn.close();
            this.optn_fechar = null;
            this.windowOptn = null;
        }
    }
    
    private void check_help_fechar()
    {
        if(this.help_fechar != null && this.help_fechar.isPressed())
        {
            this.windowHelp.close();
            this.help_fechar = null;
            this.windowHelp = null;
        }
    }
    
    private void check_m_optn_Aplicar()
    {
        if(this.bt_aplicar != null && this.bt_aplicar.isPressed())
        {
            Game.setVolume( this.sldier_volume.getValue() );
            Game.setBrightness( this.slider_brightness.getValue() );
            Game.setDificulty( this.dp_dificulty.getOptn() );
            Game.setPlayer1Name( this.tb_personage1.getText() );
            Game.setPlayer2Name( this.tb_personage2.getText() );
            Game.setPlayer1_personage( this.dp_personage1.getOptn() );
            Game.setPlayer2_personage( this.dp_personage2.getOptn() );
            SoundBox.setSoundVolume("menu_music.mp3", Game.getVolume() );
            this.updateSound();
        }
    }
    
    private void updateSound()
    {
        //botões
        this.m_play.updateVolume();
        this.m_help.updateVolume();
        this.m_optn.updateVolume();
        //Windows
        if (this.windowOptn != null)
            this.windowOptn.updateSound();
        if (this.windowHelp != null)
            this.windowHelp.updateSound();
    }
        
    private void start_Buttons()
    {
        this.m_play = new Button("portas\\defaut_play.png","portas\\selected_play.png");
        this.m_play.setSound_Selected("chain.mp3");
        this.addObject(this.m_play,850,479);
        this.m_optn = new Button("portas\\defaut_optn.png","portas\\selected_optn.png");
        this.m_optn.setSound_Selected("chain.mp3");
        this.addObject(this.m_optn,350,475);
        this.m_help = new Button("portas\\defaut_help.png","portas\\selected_help.png");
        this.m_help.setSound_Selected("chain.mp3");
        this.addObject(this.m_help,1700-350,478);
    }
    
    private void create_Window_Help()
    {
        this.windowHelp = new Window("janelas\\janela_help_background.png",680,500);
        addObject(this.windowHelp,850, 450);
        this.help_fechar = new Button("botoes\\defaut_fechar.png","botoes\\selected_fechar.png");
        this.windowHelp.add_Actor(this.help_fechar,340,470);
    }
    
    private void check_Optn_Dp_Personage1()
    {
        if( this.dp_personage1 != null  && this.dp_personage1.isAberto() )
        {
            String Optn = this.dp_personage2.getOptn();
            
            if(Optn == CharactersType.RICARDO.toString() )
            {
                this.bt_dp1_optn1.setActiveSate(false);
                this.bt_dp1_optn2.setActiveSate(true);
                this.bt_dp1_optn3.setActiveSate(true);
            }
            else if (Optn == CharactersType.JOAOPEDRO.toString() )
            {
                this.bt_dp1_optn1.setActiveSate(true);
                this.bt_dp1_optn2.setActiveSate(false);
                this.bt_dp1_optn3.setActiveSate(true);
            }
            else if (Optn == CharactersType.PEDRO.toString() )
            {
                this.bt_dp1_optn1.setActiveSate(true);
                this.bt_dp1_optn2.setActiveSate(true);
                this.bt_dp1_optn3.setActiveSate(false);
            }
        }
    }
    
    private void check_Optn_Dp_Personage2()
    {
        if(this.dp_personage2 != null && this.dp_personage2.isAberto() )
        {
            String Optn = this.dp_personage1.getOptn();
            
            if(Optn == CharactersType.RICARDO.toString() )
            {
                this.bt_dp2_optn1.setActiveSate(false);
                this.bt_dp2_optn2.setActiveSate(true);
                this.bt_dp2_optn3.setActiveSate(true);
            }
            else if (Optn == CharactersType.JOAOPEDRO.toString())
            {
                this.bt_dp2_optn1.setActiveSate(true);
                this.bt_dp2_optn2.setActiveSate(false);
                this.bt_dp2_optn3.setActiveSate(true);
            }
            else if (Optn == CharactersType.PEDRO.toString() )
            {
                this.bt_dp2_optn1.setActiveSate(true);
                this.bt_dp2_optn2.setActiveSate(true);
                this.bt_dp2_optn3.setActiveSate(false);
            }
        }
    }
    
    private void create_Window_Optn()
    {
        Font myFont = new Font("Segoe Script",true,false,20);
    
        this.windowOptn = new Window("janelas\\janela_optn_background.png",680,500);
        addObject(this.windowOptn,850, 450);
        
        this.optn_fechar = new Button("botoes\\defaut_fechar.png","botoes\\selected_fechar.png");
        this.windowOptn.add_Actor(this.optn_fechar,80,470);//i=0
        this.bt_aplicar = new Button("botoes\\defaut_aplicar.png","botoes\\selected_aplicar.png");
        this.windowOptn.add_Actor(this.bt_aplicar,600,470);//i=1
        
        this.sldier_volume = new Slider(115,25,0,100);
        this.windowOptn.add_Actor(this.sldier_volume, 565, 141);//i=2
        this.sldier_volume.setValue( Game.getVolume() );
        
        this.slider_brightness = new Slider(115,25,200,255);
        this.windowOptn.add_Actor(this.slider_brightness, 565, 169);//i=3
        this.slider_brightness.setValue( Game.getBrightness() );

        this.dp_dificulty = new DropButton("Botoes\\defaut_DropButton.png","Botoes\\selected_DropButton.png");
        this.windowOptn.add_Actor(this.dp_dificulty,565,198);//i=4
        
        Button a = new Button("botoes\\defaut_facil.png","botoes\\selected_facil.png");
        Button b = new Button("botoes\\defaut_normal.png","botoes\\selected_normal.png");
        Button c = new Button("botoes\\defaut_dificil.png","botoes\\selected_dificil.png");
        this.dp_dificulty.setTextColor(UIElement.TEXTCOLOR_DOURADO);
        this.dp_dificulty.addSubButton(a, DificultyType.EASY.toString() );
        this.dp_dificulty.addSubButton(b, DificultyType.NORMAL.toString() );
        this.dp_dificulty.addSubButton(c, DificultyType.HARD.toString());
        this.dp_dificulty.setOptn( Game.getDificulty() );
                
        this.bt_dp1_optn1 = new Button("botoes\\defaut_ricardo.png","botoes\\selected_ricardo.png");
        this.bt_dp1_optn2 = new Button("botoes\\defaut_joao.png","botoes\\selected_joao.png");
        this.bt_dp1_optn3 = new Button("botoes\\defaut_pedro.png","botoes\\selected_pedro.png");
        this.dp_personage1 = new DropButton("Botoes\\defaut_DropButton.png","Botoes\\selected_DropButton.png");
        this.windowOptn.add_Actor(this.dp_personage1,565,301);//i=5
        this.dp_personage1.setTextColor(UIElement.TEXTCOLOR_DOURADO);
        this.dp_personage1.setOptn( Game.getPlayer1_personage() );
        this.dp_personage1.addSubButton(this.bt_dp1_optn1,CharactersType.RICARDO.toString() );
        this.dp_personage1.addSubButton(this.bt_dp1_optn2,CharactersType.JOAOPEDRO.toString());
        this.dp_personage1.addSubButton(this.bt_dp1_optn3,CharactersType.PEDRO.toString() );
        
        this.tb_personage1 = new TextBox("textboxes\\defaut_jogador1.png","textboxes\\selected_jogador1.png",18,30);
        this.windowOptn.add_Actor(this.tb_personage1,478, 272);//i=6
        this.tb_personage1.setTextColor(UIElement.TEXTCOLOR_DOURADO);
        this.tb_personage1.setFont(UIElement.FONT2_DEFAUT);
        this.tb_personage1.setText( Game.getPlayer1Name() );
        
        this.bt_dp2_optn1 = new Button("botoes\\defaut_ricardo.png","botoes\\selected_ricardo.png");
        this.bt_dp2_optn2 = new Button("botoes\\defaut_joao.png","botoes\\selected_joao.png");
        this.bt_dp2_optn3 = new Button("botoes\\defaut_pedro.png","botoes\\selected_pedro.png");
        this.dp_personage2 = new DropButton("Botoes\\defaut_DropButton.png","Botoes\\selected_DropButton.png");
        this.windowOptn.add_Actor(this.dp_personage2,565,405);//i=7
        this.dp_personage2.setTextColor(UIElement.TEXTCOLOR_DOURADO);
        this.dp_personage2.setOptn( Game.getPlayer2_personage() );
        this.dp_personage2.addSubButton(this.bt_dp2_optn1,CharactersType.RICARDO.toString() );
        this.dp_personage2.addSubButton(this.bt_dp2_optn2,CharactersType.JOAOPEDRO.toString() );
        this.dp_personage2.addSubButton(this.bt_dp2_optn3,CharactersType.PEDRO.toString() );
        
        this.tb_personage2 = new TextBox("textboxes\\defaut_jogador2.png","textboxes\\selected_jogador2.png",18,30);
        this.windowOptn.add_Actor(this.tb_personage2,478, 377);//i=8
        this.tb_personage2.setTextColor(UIElement.TEXTCOLOR_DOURADO);
        this.tb_personage2.setFont(UIElement.FONT2_DEFAUT);
        this.tb_personage2.setText( Game.getPlayer2Name() );
        
    }
}

