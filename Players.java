import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Collision_Player
{
    //Constantes para a velociade de movimento(DELTA) e o tempo delay para cada imagem da animacao(MAX_TICKS_FOR_NEX_IMAGE)
    private final int DELTA=5;
    private final int MAX_TICKS_FOR_NEXT_IMAGE = 10;

    private String lastValidKeyPress = "";

    private Tooltip myTooltip;
    //contador da animacao e o MaxTimer para o delay da animacao
    private int animationCounter,soundcounter;
    private int animationMaxTimer = 0;
    //arrays que contem as imagens para as animacoes
    private ArrayList<GreenfootImage> characterLeftAnimationList = new ArrayList<>();
    private ArrayList<GreenfootImage> characterRightAnimationList = new ArrayList<>();
    private ArrayList<GreenfootImage> characterUpAnimationList = new ArrayList<>();
    private ArrayList<GreenfootImage> characterDownAnimationList = new ArrayList<>();
    //
    private CharactersVision vision;
    private AdvancedActor interactting_actor;
    private Light light;

    private boolean moving,playing;
    private String walking_Sound;
    private AreaSound areasound;

    //Constructor of character
    public Players ()
    {
        this.animationCounter = 0;
        this.soundcounter = 0;
        this.vision = CharactersVision.DOWN;
        this.light = new Light("luzes\\player_light_",2);
        this.light.setDelay(5);
        this.moving = false;
        this.playing = false;
    }

    /**
     * Carrega as imagens para os repetivos arrays de animacao
     */
    protected void loadAnimations(String down,String up, String left, String right){
        for(int i=1; i<=3; i++){
            characterDownAnimationList.add(new GreenfootImage(down+i+".png"));
        }
        for(int i=1; i<=3; i++){
            characterUpAnimationList.add(new GreenfootImage(up+i+".png"));
        }
        for(int i=1; i<=3; i++){
            characterLeftAnimationList.add(new GreenfootImage(left+i+".png"));
        }
        for(int i=1; i<=3; i++){
            characterRightAnimationList.add(new GreenfootImage(right+i+".png"));
        }
    }

    /**
     * Atualiza a posição da luz de maneira a seguir o player.
     */
    protected void update_Light_Location()
    {
        this.light.update_Location(this.getX(), this.getY(), this);
    }

    /**
     * Usa as teclas inseridas no argumentos para o movimento.
     */
    protected void movement(String btn1, String btn2, String btn3, String btn4)
    {
        if(animationCounter==characterLeftAnimationList.size()){
            animationCounter=0;
        }

        if( Greenfoot.isKeyDown(btn4) || Greenfoot.isKeyDown(btn3) || Greenfoot.isKeyDown(btn2) || Greenfoot.isKeyDown(btn1)) 
        {

            if(Greenfoot.isKeyDown(btn1)){
                setLocation(getX()-DELTA,getY());
                if(animationMaxTimer<MAX_TICKS_FOR_NEXT_IMAGE){
                    animationMaxTimer++;
                }
                else if(animationMaxTimer==MAX_TICKS_FOR_NEXT_IMAGE){
                    animationCounter++;
                    animationMaxTimer=0;
                }

                animateLeft(animationCounter);
                lastValidKeyPress = btn1; 
                this.vision = CharactersVision.LEFT;
                this.moving = true;
            }

            if(Greenfoot.isKeyDown(btn2)){
                setLocation(getX()+DELTA,getY());
                if(animationMaxTimer<MAX_TICKS_FOR_NEXT_IMAGE){
                    animationMaxTimer++;
                }
                else if(animationMaxTimer==MAX_TICKS_FOR_NEXT_IMAGE){
                    animationCounter++;
                    animationMaxTimer=0;
                }

                animateRight(animationCounter);
                lastValidKeyPress = btn2; 
                this.vision = CharactersVision.RIGHT;
                this.moving = true;
            }

            if(Greenfoot.isKeyDown(btn3)){
                setLocation(getX(),getY()-DELTA);
                if(animationMaxTimer<MAX_TICKS_FOR_NEXT_IMAGE){
                    animationMaxTimer++;
                }
                else if(animationMaxTimer==MAX_TICKS_FOR_NEXT_IMAGE){
                    animationCounter++;
                    animationMaxTimer=0;
                }

                animateUp(animationCounter);
                lastValidKeyPress = btn3; 
                this.vision = CharactersVision.UP;
                this.moving = true;
            }

            if(Greenfoot.isKeyDown(btn4)){
                setLocation(getX(),getY()+DELTA);
                if(animationMaxTimer<MAX_TICKS_FOR_NEXT_IMAGE){
                    animationMaxTimer++;
                }
                else if(animationMaxTimer==MAX_TICKS_FOR_NEXT_IMAGE){
                    animationCounter++;
                    animationMaxTimer=0;
                }

                animateDown(animationCounter);
                lastValidKeyPress = btn4;
                this.vision = CharactersVision.DOWN;
                this.moving = true;
            } 

        }else
        {
            if(lastValidKeyPress.equals(btn4)){
                animationCounter=1;
                setImage(characterDownAnimationList.get(animationCounter));
                this.moving = false;
            }
            else if(lastValidKeyPress.equals(btn3)){
                animationCounter=1;
                setImage(characterUpAnimationList.get(animationCounter));
                this.moving = false;
            }
            else if(lastValidKeyPress.equals(btn2)){
                animationCounter=1;
                setImage(characterRightAnimationList.get(animationCounter));
                this.moving = false;
            }
            else if(lastValidKeyPress.equals(btn1)){
                animationCounter=1;
                setImage(characterLeftAnimationList.get(animationCounter));
                this.moving = false;
            }
        }

        // System.out.println(moving + ":" + this);
    }

    protected void check_Use(String btn)
    {
        if( Greenfoot.isKeyDown(btn))
        {
            List<AdvancedActor> actor_list = null;
            switch(this.vision)
            {
                case LEFT:
                    actor_list = this.getObjectsAtOffset(-this.getImage().getWidth()/2 -2 ,0, AdvancedActor.class);
                    break;
                case RIGHT:
                    actor_list = this.getObjectsAtOffset(this.getImage().getWidth()/2 + 2 ,0,AdvancedActor.class);
                    break;
                case DOWN:
                    actor_list = this.getObjectsAtOffset(0,this.getImage().getHeight()/2  +2 ,AdvancedActor.class);
                    break;
                case UP:
                    actor_list = this.getObjectsAtOffset(0,-this.getImage().getHeight()/2 -2,AdvancedActor.class);
                    break;
            }

            for(Actor actor : actor_list){

                if (actor != null && ((AdvancedActor)actor).isUsed() == false  )
                {
                    this.interactting_actor = (AdvancedActor)actor;
                    ((AdvancedActor)actor).use(this);
                }
            }
        }
    }

    protected void checkHitbox(){
        GreenfootImage image1 = getImage();
        image1.setColor(Color.BLACK);
        image1.drawRect(0,0,image1.getWidth()-1,image1.getHeight()-1);   
    }

    private void animateRight(int counter){
        if(counter==characterRightAnimationList.size()){
            counter=0;
        }
        setImage(characterRightAnimationList.get(counter));
    }

    private void animateLeft(int counter){
        if(counter==characterLeftAnimationList.size()){
            counter=0;
        }
        setImage(characterLeftAnimationList.get(counter));
    }

    private void animateUp(int counter){
        if(counter==characterUpAnimationList.size()){
            counter=0;
        }
        setImage(characterUpAnimationList.get(counter));
    }

    private void animateDown(int counter){
        if(counter==characterDownAnimationList.size()){
            counter=0;
        }
        setImage(characterDownAnimationList.get(counter));
    }

    /**
     * Mostra uma tooltip com um texto inserido com argumento
     */
    protected void showTooltip(String text){
        if(myTooltip==null){
            myTooltip= new Tooltip(text,20,this);
            getWorld().addObject(myTooltip,getX(),getY()-getImage().getHeight()/2);
        }
    }

    public void check_Tooltip(){
        if (this.myTooltip != null)
        {
            if(!this.myTooltip.isActive())
                this.myTooltip = null;
        }
    }

    /**
     * Verifica e toca o som de andar.
     */
    public void walking_sound(){

        if(this.moving )
        {
            for(AreaSound areaS :  Game.getAtualWorld().getAreaSounds() )
            {
                if(areaS.isIn(this))
                {    
                    if( !this.playing || areaS != this.areasound)
                    {
                        if(this.areasound != null)
                            SoundBox.stop( this.areasound.getSound() + this );
                        
                        if(  SoundBox.getSound( areaS.getSound() + this ) != -1 )
                        {
                            SoundBox.stop( areaS.getSound() + this );
                            SoundBox.removeSound( areaS.getSound() + this);
                        }
                        
                        this.walking_Sound = areaS.getSound() + this;
                        SoundBox.addSound( areaS.getSound() , this.walking_Sound );
                        SoundBox.setSoundVolume(this.walking_Sound, Game.getVolume() );  
                        SoundBox.playLoop( this.walking_Sound );
                        this.areasound = areaS;
                        this.playing =true;
                    }
                }
            }
        }
        else 
        {
            if(SoundBox.getSound( this.walking_Sound ) != -1 && this.playing)
            {
                SoundBox.stop( this.walking_Sound );
                this.playing = false;
            }
        }
    }

    /**
     * Retorna true se o player tiver tooltip.
     */
    public boolean hasTooltip()
    {
        return this.myTooltip == null ? false : true;  
    }

    public CharactersVision getVision()
    {
        return this.vision;
    }
}
