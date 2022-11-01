import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    public Player1 (){
        super();
        if(Game.getPlayer1_personage()!="?")
        {
            setImage(new GreenfootImage("personagens\\" + Game.getPlayer1_personage() + "_down_2.png"));
            loadAnimations("personagens\\" + Game.getPlayer1_personage() + "_down_",
                "personagens\\" + Game.getPlayer1_personage() + "_up_",
                "personagens\\" + Game.getPlayer1_personage() + "_left_",
                "personagens\\" + Game.getPlayer1_personage() + "_right_");
        }
        else
        {
            System.out.println("FALTOU SELECIONAR A PERSONAGEM");
        }
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.movement("a", "d", "w", "s");
        this.update_Light_Location();
        this.check_Collision();
        this.check_Use("e");
        this.check_Tooltip();
        this.walking_sound();
    }
    
    
    
}