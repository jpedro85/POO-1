import greenfoot.*; 
import java.util.ArrayList;

/**
 * Nível 1
 */
public class Level_1 extends World implements InterfaceAreaSound
{
    private Puzel_Level_1_lightcomb puzle1; 
    private Puzzel_Level_1_pressureplate puzle2;
    private int timer;
    private final int MAX_TIMER_EZ=(5*60*50); // tempos limite para o nivel
    private final int MAX_TIMER_NORM=(2*60*50);
    private final int MAX_TIMER_HARD=(1*60*50);
    private AreaSound b1,b2,b3; // AreaSound wood
    private AreaSound passeio1,passeio2,passeio3,passeio4; // AreaSound stone
    private AreaSound grass1,grass2,grass3,grass4,grass5,grass6,grass7,grass8,grass9,grass10,grass11,grass12; // AreaSound grass
    private TextBox chavedisplay; 
    private ChangeWorld change;

    /**
     * Inicia Level_1.
     */
    public Level_1()
    {    
        super(1700, 900, 1); 
        this.setBackground("Mapa1final_teste.png");
        Game.setAtualPlayerWorld(this);
        Greenfoot.setSpeed(50);
        this.prepare();
        this.start_sound();
        setPaintOrder(Light.class,Tooltip.class,TextBox.class,Blackout.class,Rain.class,Players.class,Actor_Animated.class,Ball.class,Pressure_Plate.class);
    }
    
    /**
     * Executado cada tick.
     */
    @Override
    public void act()
    {
        this.startTimer();
        this.chavesShow();
        this.puzle1.atAct();
        this.puzle2.atAct();
        this.check_Final_Condition();  
    }
    
    /**
     * Verifica a condição final do nivel , se os dois players tocam no ator invisival
     */
    private void check_Final_Condition()
    {
        if(this.change.isTouchingPlayers())
            this.finish();
    }
    
    /**
     * Para todos os soms, atualiza o tempo no Game e muda para o mundo end.
     */
    private void finish()
    {
        SoundBox.stop_AllSounds();
        SoundBox.clearSounds();
        Game.setFinal_Time(this.timer);
        Greenfoot.setWorld(new End());
    }
    
    /**
     * Inicia os sons 
     */
    private void start_sound()
    {
        SoundBox.addSound("rain_sound.mp3");
        SoundBox.setSoundVolume("rain_sound.mp3", Game.getVolume() );
        SoundBox.addSound("game_background_muic.mp3");
        SoundBox.setSoundVolume("game_background_muic.mp3", Game.getVolume() );
        SoundBox.playLoop_AllSounds();
    }

    /**
     * Atualiza a textbox das chaves.
     */
    private void chavesShow()
    {
        this.chavedisplay.setText( String.valueOf( Game.getChaves() ) );
        this.chavedisplay.update_Text();
    }
    
    /**
     * Atualiza o tempo e verifica se ja chegou ao limite..
     */
    private void startTimer()
    {
        if(Game.getDificulty().equals(DificultyType.EASY.toString())){
            if (timer<MAX_TIMER_EZ)
            {
                timer++;
                showText(timer/(50*60)+":"+(timer%(60*50))/50,getWidth()/2, 15);
            }
            else
            {
                this.finish();
            }
        }
        else if(Game.getDificulty().equals(DificultyType.NORMAL.toString())){
            if (timer<MAX_TIMER_NORM)
            {
                timer++;
                showText(timer/(50*60)+":"+(timer%(60*50))/50,getWidth()/2, 15);
            }
            else
            {
                this.finish();
            }
        }
        else if(Game.getDificulty().equals(DificultyType.HARD.toString())){
            if (timer<MAX_TIMER_HARD)
            {
                timer++;
                showText(timer/(50*60)+":"+(timer%(60*50))/50,getWidth()/2, 15);
            }
            else
            {
                this.finish();
            }
        }
    }
    
    /**
     * Excuta os metodos prepare.
     */
    private void prepare()
    {
        this.preparePlayers();
        this.prepareWalls();
        this.preparePuzzles();
        this.prepareEnviorment(); 
        this.prepareDecors();
    }
    
    /**
     * Inicia as decorações.
     */
    private void prepareDecors(){
        this.chavedisplay = new TextBox("textboxes\\textbox_chaves.png","textboxes\\textbox_chaves.png",10,60);
        this.chavedisplay.setFont( new Font("Segoe Script",true,false,30) );
        this.chavedisplay.setTextColor( new Color(255,212,60) );
        this.chavesShow();
        this.chavedisplay.setEditable(false);
        this.addObject( this.chavedisplay , 130 ,100);
        this.chavedisplay.setRelativeLocation(0, 0);

        this.addObject( new Wall("decors\\tooredoportaocima.png") , 1662, 298);
        this.addObject( new Wall("decors\\tooredoportao_baixo.png") , 1662, 602);
        this.addObject( new Wall("decors\\tooredoportaocima.png") , 30, 298);
        this.addObject( new Wall("decors\\tooredoportao_baixo.png") , 30, 602);
        this.addObject( new Actor_Decor("decors\\liscas.png") , 1665, 450);
        this.addObject( new Light("luzes\\luztorres_",1), 1662, 320  );
        this.addObject( new Light("luzes\\luztorres_",1), 30, 320  );
        this.addObject( new Actor_Decor("decors\\amongus_dead.png") , 970, 210);
        this.addObject( new Wall("decors\\computer.png") , 300, 765);
        this.addObject( new Wall("decors\\computer.png") , 400, 765);
        this.addObject( new Actor_Decor("decors\\bed.png") , 1365, 700);
        this.addObject( new Actor_Decor("decors\\bed.png") , 1265, 700);
        this.addObject( new Actor_Decor("decors\\bed.png") , 1365, 150);
        this.addObject( new Actor_Decor("decors\\bed.png") , 1265, 150);
        this.addObject( new Actor_Decor("decors\\banco.png") , 1000, 315);
        this.addObject( new Wall("decors\\tree11.png") , 1350, 540);
        this.addObject( new Wall("decors\\tree11.png") , 1000, 540);
        this.addObject( new Actor_Decor("decors\\bin.png") , 1100, 665);
        this.addObject( new Actor_Decor("decors\\dumbells.png") , 1410, 315);
        this.addObject( new Actor_Decor("decors\\bench.png") , 1550, 155);
        this.addObject( new Actor_Decor("decors\\bench.png") , 1550, 240);
        this.addObject( new Actor_Decor("decors\\phone.png") , 1070, 290);
        this.addObject( new Actor_Decor("decors\\ddoor.png") , 200, 505);
        this.addObject( new Actor_Decor("decors\\ddoor.png") , 200, 383);
        this.addObject( new Wall("decors\\coffe.png") , 680, 70);
        this.addObject( new Wall("decors\\rex.png") , 150, 280);
        this.addObject( new Wall("decors\\rex.png") , 150, 600);
        this.addObject( new Wall("decors\\gnome.png") , 773, 350);
        this.addObject( new Wall("decors\\gnome.png") , 773, 530);
        this.addObject( new Actor_Decor("decors\\mat.png") , 480, 450);
    }
    
    /**
     * Inicia o ambiente.
     */
    private void prepareEnviorment(){
        //colocando escuro
        Blackout a  = new Blackout();
        a.getImage().setTransparency(Game.getBrightness());
        addObject( a , 850, 450);
        //colocando chuva
        addObject( new Rain("ambiente\\chuva\\chuva_",3,2) , 850, 450);
        //sound wood
        this.b1 = new AreaSound(197,45,560,834,"walking_wood.wav");
        this.b2 = new AreaSound(895,77,554,217,"walking_wood.wav");
        this.b3 = new AreaSound(942,630,459,178,"walking_wood.wav");
        //sound stone
        this.passeio1 = new AreaSound(4,430,186,48,"walking_stone.wav"); 
        this.passeio2 = new AreaSound(762,430,935,48,"walking_stone.wav");
        this.passeio3 = new AreaSound(1152,302,40,122,"walking_stone.wav");
        this.passeio4 = new AreaSound(1152,478,40,144,"walking_stone.wav");
        //sound wood
        this.grass1 = new  AreaSound(0,0,190,427,"walking_grass.wav");
        this.grass2 = new  AreaSound(0,475,190,427,"walking_grass.wav");
        this.grass3 = new  AreaSound(759,0,133,427,"walking_grass.wav");
        this.grass4 = new  AreaSound(759,475,178,427,"walking_grass.wav");
        this.grass5 = new  AreaSound(938,813,468,150,"walking_grass.wav");
        this.grass6 = new  AreaSound(892,0,560,70,"walking_grass.wav");
        this.grass7 = new  AreaSound(1452,0,427,413,"walking_grass.wav");
        this.grass8 = new  AreaSound(1406,475,293,424,"walking_grass.wav");
        //sound grass
        this.grass9 = new  AreaSound(891,297,254,129,"walking_grass.wav");
        this.grass10 = new  AreaSound(1196,297,254,129,"walking_grass.wav");
        this.grass11 = new  AreaSound(938,475,210,150,"walking_grass.wav");
        this.grass12 = new  AreaSound(1195,475,210,150,"walking_grass.wav");

        this.change = new ChangeWorld(200,10);
        addObject(change,1700, 450);
    }

    /**
     * Inicia os puzles.
     */
    private void preparePuzzles(){
        this.puzle1 = new Puzel_Level_1_lightcomb(this);
        this.puzle2 = new Puzzel_Level_1_pressureplate(this);
        //porta final
        addObject(new Door("","interactables\\portao.png","portao_open_close.mp3","portao_open_close.mp3",true,1,2),1650,450);
        //chaves
        addObject(new Key(""),970,140);
        addObject(new Key(""),760,900);
    }
    
    /**
     * Coloca os players.
     */
    private void preparePlayers()
    {
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        addObject(player1,30 , 390);
        addObject(player2,30 , 510);
    }
    
    /**
     * Coloca as paredes.
     */
    private void prepareWalls()
    {
        //Building1
        Wall wall1 = new Wall("mapa\\mapa1\\predio1\\Predio1_direita2.png");
        Wall wall2 = new Wall("mapa\\mapa1\\predio1\\Predio1_Superior.png");
        Wall wall3 = new Wall("mapa\\mapa1\\predio1\\Predio1_direita2.png");
        Wall wall4 = new Wall("mapa\\mapa1\\predio1\\Predio1_direita2.png");
        Wall wall5 = new Wall("mapa\\mapa1\\predio1\\Predio1_direita2.png");
        Wall wall6 = new Wall("mapa\\mapa1\\predio1\\Predio1_Superior.png");
        //placing walls in the world
        wall1.getImage().mirrorVertically();
        addObject(wall1,742 , 197);
        wall2.getImage().mirrorVertically();
        addObject(wall2,475 , 24);
        addObject(wall3,742 , 692);
        wall4.getImage().mirrorHorizontally();
        wall4.getImage().mirrorVertically();
        addObject(wall4,210,197);
        wall5.getImage().mirrorHorizontally();
        addObject(wall5,210,692);
        addObject(wall6,475,866);
        //Building2
        Wall wall12 = new Wall("mapa\\mapa1\\predio2\\Predio2_right.png");
        Wall wall13 = new Wall("mapa\\mapa1\\predio2\\Predio2_top.png");
        Wall wall14 = new Wall("mapa\\mapa1\\predio2\\Predio2_right.png");
        Wall wall15 = new Wall("mapa\\mapa1\\predio2\\Predio2_bot_left.png");
        Wall wall16 = new Wall("mapa\\mapa1\\predio2\\Predio2_bot_right.png");
        //placing walls in the world
        addObject(wall16,1325, 282);
        addObject(wall12,1435,184);
        addObject(wall13,1170,89);
        addObject(wall15,1014,282);
        wall14.getImage().mirrorHorizontally();
        addObject(wall14,904, 184);
        //Building3
        Wall wall7 = new Wall("mapa\\mapa1\\predio3\\Predio3_right.png");
        Wall wall8 = new Wall("mapa\\mapa1\\predio3\\Predio3_bottom.png");
        Wall wall9 = new Wall("mapa\\mapa1\\predio3\\Predio3_right.png");
        Wall wall10 = new Wall("mapa\\mapa1\\predio3\\Predio3_top_left.png");
        Wall wall11 = new Wall("mapa\\mapa1\\predio3\\Predio3_top_right.png");
        //placing walls in the world
        addObject(wall7,1423,732);
        addObject(wall8,1188,829);
        wall9.getImage().mirrorHorizontally();
        addObject(wall9,954,732);
        addObject(wall10,1056,636);
        addObject(wall11,1303,637);
        //fences
        Wall wall20 = new Wall("decors\\fence.png");
        Wall wall21 = new Wall("decors\\fence.png");
        Wall wall22 = new Wall("decors\\fence.png");
        Wall wall23 = new Wall("decors\\fence.png");
        addObject(wall20,1670,120);
        addObject(wall21,1670,780);
        addObject(wall22,20,120);
        addObject(wall23,20,780);
    }
    
    /**
     * Retorna todas as areas de sound numa lista.
     */
    public ArrayList<AreaSound> getAreaSounds()
    {
        ArrayList<AreaSound> areaSoundList = new ArrayList<>();
        areaSoundList.add(this.grass1);
        areaSoundList.add(this.grass2);
        areaSoundList.add(this.grass3);
        areaSoundList.add(this.grass4);
        areaSoundList.add(this.grass5);
        areaSoundList.add(this.grass6);
        areaSoundList.add(this.grass7);
        areaSoundList.add(this.grass8);
        areaSoundList.add(this.grass9);
        areaSoundList.add(this.grass10);
        areaSoundList.add(this.grass11);
        areaSoundList.add(this.grass12);
        areaSoundList.add(this.b1);
        areaSoundList.add(this.b2);
        areaSoundList.add(this.b3);
        areaSoundList.add(this.passeio1);
        areaSoundList.add(this.passeio2);
        areaSoundList.add(this.passeio3);
        areaSoundList.add(this.passeio4);
        return areaSoundList ;
    }
}
