import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Player 2
 */
public class Player2 extends Players
{
    public Player2 ()
    {
        super();
        if(Game.getPlayer2_personage()!="?")
        {
            setImage(new GreenfootImage("personagens\\" + Game.getPlayer2_personage() + "_down_2.png"));
            loadAnimations("personagens\\" + Game.getPlayer2_personage() + "_down_",
                "personagens\\" + Game.getPlayer2_personage() + "_up_",
                "personagens\\" + Game.getPlayer2_personage() + "_left_",
                "personagens\\" + Game.getPlayer2_personage() + "_right_");
        }
        else
        {
            System.out.println("FALTOU SELECIONAR A PERSONAGEM");
        }
    }
    
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act()
    {
        this.movement("left", "right", "up", "down");
        this.update_Light_Location();
        this.check_Collision();
        this.check_Use("ENTER");
        this.check_Tooltip();
        this.walking_sound();
    }
}
