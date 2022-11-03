import greenfoot.*;
import java.util.ArrayList;
/**
 * O Segundo puzzle do nível 1
 */
public class Puzzel_Level_1_pressureplate extends Puzzle 
{
    private boolean halfcomplete;
    private boolean pressure1,pressure2;
    private Pressure_Plate plate1,plate2;
    private Ball ball;
    private Door door_building2,door_building3;

    /**
     * Cria um novo puzle.
     */
    public Puzzel_Level_1_pressureplate(World world)
    {
        this.pressure1=false;
        this.pressure2=false;
        this.setComplete(false);
        this.setPoints(100);
        this.setWorld(world);
        this.start_objects();
    }
    
    /**
     * Para chamar a cada tick no World.act().
     */
    public void atAct()
    {
        this.check_complete();
        this.checkplate1();
    }
    
    /**
     * Inicia os objetos do puzle.
     */
    private void start_objects()
    {
        this.plate1= new Pressure_Plate("Preciso de algo pesado aqui","interactables\\pressure_pad.png");
        this.plate2= new Pressure_Plate("Preciso de algo pesado aqui","interactables\\pressure_pad.png");
        this.getWorld().addObject(this.plate1,600,785);
        this.getWorld().addObject(this.plate2,1025,725);
        
        this.ball = new Ball();
        this.getWorld().addObject(this.ball,350,600);
        
        this.door_building2 = new Door("Puzzle 2", "interactables\\door2.png", "door1_open.mp3","door1_close.mp3", false, -1, 0);
        this.door_building3 = new Door("Puzzle 2", "interactables\\door2.png", "door1_open.mp3","door1_close.mp3", false, -1, 0);
        this.getWorld().addObject(this.door_building2,1166,276);
        this.getWorld().addObject(this.door_building3,1166,635);
    }
    
    /**
     * Verifica se a placa de pressão 1 está ativada.
     */
    private void checkplate1()
    {
        if(this.plate1.isPressed())
        {
            this.halfcomplete=true;
            this.door_building3.open();
        }
        else
        {
            this.halfcomplete=false;
            this.door_building3.close();
        }
    }
    
    /**
     * Devolve uma lista com os players que utilizar os objetos do puzle logo antes de estar completo.
     */
    public ArrayList<Players> getLastUserList()
    {
        ArrayList<Players> LastUsers = new ArrayList();
        LastUsers.add(this.plate1.getLastUser());
        LastUsers.add(this.plate2.getLastUser());
        LastUsers.add(this.ball.getLastUser());
        return LastUsers;
    }
    
    /**
     * Verifica se o puzle está completo
     */
    protected void check_complete()
    {
        if(this.plate1.isPressed() && this.plate2.isPressed())
        {
            this.setComplete(true);
            Game.update_Score(this.getLastUserList(), this);
            this.door_building2.open();
        }
        else
        {
            this.setComplete(false);
            this.door_building2.close();
        }
    }
    
    /**
     * Devolve se está metade completo
     */
    public boolean isHalfComplete()
    {
        return halfcomplete;
    }
}
