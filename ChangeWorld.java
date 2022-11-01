import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChangeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChangeWorld extends Actor
{   
    public ChangeWorld(int altura,int largura){
        this.setImage(new GreenfootImage(largura,altura));
    }  
    public boolean isTouchingPlayer(){
        return isTouching(Players.class);
    }
}

