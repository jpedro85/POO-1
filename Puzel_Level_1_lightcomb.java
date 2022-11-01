import greenfoot.*;
import java.util.ArrayList;
/**
 * O primeiro Puzle do nível 1.
 */
public class Puzel_Level_1_lightcomb extends Puzzle 
{
    private Light light_1_ligada ,light_1_desligada;
    private Light light_2_ligada ,light_2_desligada;
    private Light light_3_ligada ,light_3_desligada;
    private Light light_4_ligada ,light_4_desligada;
    private Lamp lampada1 ,lampada2 ,lampada3 ,lampada4;
    private Lever lever1 ,lever2 ,lever3 ,lever4;//1100/1110/0111/0011
    private boolean bool1 ,bool2 ,bool3 ,bool4;
    private Door double_down,double_up;
    
    /**
     * Cria um novo puzle.
     */
    public Puzel_Level_1_lightcomb( World world )
    {    
        this.bool1 = false;
        this.bool2 = false;
        this.bool3 = false;
        this.bool4 = false;
        this.setComplete(false);
        this.setScoreAdded(false);
        this.setPoints(100);
        this.setWorld(world);
        this.start_objects();
    }

    /**
     * Para chamar a cada tick no World.act().
    */
    public void atAct()
    {
        this.update_actions();
        this.check_complete();
    }
    
    /**
     * Verifica as ações do player sobre o puzle.
    */
    private void update_actions()
    {
        if( this.lever1.isON() && !bool1 )
        {
            this.lampada1.changeState();
            this.lampada2.changeState();
            bool1 = true;

        }
        else if ( !this.lever1.isON() && bool1 )
        {
            this.lampada1.changeState();
            this.lampada2.changeState();
            bool1 = false;
        }

        if( this.lever2.isON() && !bool2 )
        {
            this.lampada1.changeState();
            this.lampada2.changeState();
            this.lampada3.changeState();
            this.bool2 = true;

        }
        else if ( !this.lever2.isON() && bool2 )
        {
            this.lampada1.changeState();
            this.lampada2.changeState();
            this.lampada3.changeState();
            this.bool2 = false;
        }

        if( this.lever3.isON() && !bool3 )
        {
            this.lampada2.changeState();
            this.lampada3.changeState();
            this.lampada4.changeState();
            this.bool3 = true;

        }
        else if ( !this.lever3.isON() && bool3 )
        {
            this.lampada2.changeState();
            this.lampada3.changeState();
            this.lampada4.changeState();
            this.bool3 = false;
        }

        if( this.lever4.isON() && !bool4 )
        {
            this.lampada3.changeState();
            this.lampada4.changeState();
            this.bool4 = true;
        }
        else if ( !this.lever4.isON() && bool4 )
        {
            this.lampada3.changeState();
            this.lampada4.changeState();
            this.bool4 = false;
        }
    }
    
    /**
     * Verifica se o puzle está completo
    */
    protected void check_complete()
    {
        if (this.lampada1.isligado() && this.lampada2.isligado() && this.lampada3.isligado() && this.lampada4.isligado() )
        {
            this.setComplete(true);
            Game.update_Score(this.getLastUserList(), this);
            this.double_down.open();
            this.double_up.open();
        }     
        else
        {
            this.setComplete(false);
            this.double_down.close();
            this.double_up.close();
        }
    }
    
    /**
     * Devolve uma lista com os players que utilizar os objetos do puzle logo antes de estar completo.
    */
    public ArrayList<Players> getLastUserList()
    {
        ArrayList<Players> lastPlayer = new ArrayList();
        lastPlayer.add(this.lever1.getLastUser());
        lastPlayer.add(this.lever2.getLastUser());
        lastPlayer.add(this.lever3.getLastUser());
        lastPlayer.add(this.lever4.getLastUser());
        return lastPlayer;
    }
    
    /**
     * Inicia os objetos do puzle.
     */
    private void start_objects()
    {
        //luzes
        this.light_1_ligada = new Light("luzes\\luz_parede_verde_",2);
        this.light_1_desligada = new Light("luzes\\luz_parede_vermelha_",2);
        this.light_2_ligada = this.light_1_ligada.clone();
        this.light_2_desligada = this.light_1_desligada.clone();
        this.light_3_ligada = this.light_1_ligada.clone();
        this.light_3_desligada = this.light_1_desligada.clone();
        this.light_4_ligada = new Light("luzes\\luz_parede_verde_",2);
        this.light_4_desligada = new Light("luzes\\luz_parede_vermelha_",2);
        //lampadas
        this.lampada1 = new Lamp(this.light_1_ligada,this.light_1_desligada,"luzes\\lampada_parede_vermelha.png","luzes\\lampada_parede_verde.png");
        this.lampada2 = new Lamp(this.light_2_ligada,this.light_2_desligada,"luzes\\lampada_parede_vermelha.png","luzes\\lampada_parede_verde.png");
        this.lampada3 = new Lamp(this.light_3_ligada,this.light_3_desligada,"luzes\\lampada_parede_vermelha.png","luzes\\lampada_parede_verde.png");
        this.lampada4 = new Lamp(this.light_4_ligada,this.light_4_desligada,"luzes\\lampada_parede_vermelha.png","luzes\\lampada_parede_verde.png");
        //alavancas
        this.lever1 = new Lever("Ligar Luzes");
        this.lever2 = new Lever("Ligar Luzes");
        this.lever3 = new Lever("Ligar Luzes");
        this.lever4 = new Lever("Ligar Luzes");
        //adicionando objetos
        int x = 200;
        int y = 45;
        this.getWorld().addObject(this.lever1,x+80,y+60);
        this.getWorld().addObject(this.lever2,x+160,y+60);
        this.getWorld().addObject(this.lever3,x+240,y+60);
        this.getWorld().addObject(this.lever4,x+320,y+60);
        this.getWorld().addObject(this.lampada1,x+80,y);
        this.getWorld().addObject(this.lampada2,x+160,y);
        this.getWorld().addObject(this.lampada3,x+240,y);
        this.getWorld().addObject(this.lampada4,x+320,y);
        //atualizar as luzes
        this.lampada1.updateLight();
        this.lampada2.updateLight();
        this.lampada3.updateLight();
        this.lampada4.updateLight();
        //porta dupla
        this.double_down = new Door("Puzzle 1","interactables\\double_door.png","door1_open.mp3","door1_close.mp3",true,1,0);
        this.double_up = new Door("Puzzle 1","interactables\\double_door.png","door1_open.mp3","door1_close.mp3",true,-1,0);
        this.double_up.getImage().mirrorVertically();
        this.getWorld().addObject(this.double_down,743,475);
        this.getWorld().addObject(this.double_up,743,415);
        
        
    }
}

