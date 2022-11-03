import greenfoot.*;  

/**
 * Alavanca para puzzles.
 */
public class Lever extends AdvancedActor
{
    private GreenfootImage lever_On,lever_Off;
    private GreenfootSound sound;
    private String sounda;
    private boolean on;

    /**
     * Inicia as variaveis com imagems predefinidas
     */
    public Lever(String texto)
    {
        super(texto,CollisionType.PASSUNDER,CollisionType.TOTAL);
        this.setLeverImageON("interactables\\lever_on.png");
        this.setLeverImageOFF("interactables\\lever_off.png");
        this.on = false;
        this.sounda = "lever.mp3";
        this.setImage(this.getLeverImageOFF());
    }
    
    /**
     * Overloading inicia as variaveis com imagens distintas.
     */
    public Lever(String texto,String lever_On ,String lever_Off,String sound)
    {
        super(texto,CollisionType.TOTAL,CollisionType.PASSHOVER);
        this.setLeverImageON(lever_On);
        this.setLeverImageOFF(lever_Off);
        this.on = false;
        this.sounda = "lever.mp3";
        this.setImage(this.getLeverImageOFF());
    }
    
    /**
     * Executado a cada act.
     */
    @Override
    public void act()
    {
        this.check_Collision();
        this.check_Actor();
    }
    
    /**
     * Ação a ser executada quando o player usa
     */
    public void action()
    {
        this.getUser().showTooltip(this.getTooltipText());
        this.on = !this.on;
        this.update_image();
        this.sound = new GreenfootSound(this.sounda);
        this.sound.setVolume(Game.getVolume());
        this.sound.play();
    }
    
    /**
     * Atualiza a imagem com base no estado.
     */
    public void update_image()
    {
        if (this.isON())
            this.setImage(this.lever_On);
        else
            this.setImage(this.lever_Off);
    }
    
    /**
     * Atualiza a imagem on.
     */
    public void setLeverImageON(String img)
    {
        this.lever_On = new GreenfootImage(img);
    }
    
    /**
     * Atualiza a imagem off.
     */
    public void setLeverImageOFF(String img)
    {
        this.lever_Off = new GreenfootImage(img);
    }
    
    /**
     * Retorna a imagem on.
     */
    public GreenfootImage getLeverImageON()
    {
        return this.lever_On;
    }
    
    /**
     * Retorna a imagem off.
     */
    public GreenfootImage getLeverImageOFF()
    {
        return this.lever_Off;
    }
    
    /**
     * Retorna se está on.
     */
    public boolean isON()
    {
        return this.on;
    }
}
