import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testes extends World
{

    /**
     * Constructor for objects of class testes.
     * 
     */
    public testes()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        Game.resetPlayesDefaults();
        setActOrder(Wall.class);
        prepare();

        //System.out.println(CollisionType.TOTAL);//teste
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player1 player1 = new Player1();
        addObject(player1,268,166);

        //System.out.println(  player1.getClass());   
        /*cubo cubo = new cubo("teste1", CollisionType.TOTAL, CollisionType.PASSUNDER);
        addObject(cubo,300,50);
        cubo cuboa = new cubo("teste2", CollisionType.TOTAL, CollisionType.PASSHOVER);*/
      //  addObject(cuboa,300,100);
        cubo cuboas = new cubo("teste3", CollisionType.TOTAL, CollisionType.TOTAL);
        addObject(cuboas,300,208);
        obs2 obs2 = new obs2("a", CollisionType.TOTAL, CollisionType.TOTAL);
        
      /*  addObject(obs2,172,229);
        cubo2.setLocation(72,105);
        cubo.setLocation(61,39);
        cubo2.setLocation(67,118);
        cubo.setLocation(55,43);
        cubo.setLocation(83,58);
        cubo3.setLocation(81,208);
        obs2.setLocation(110,318);
        cubo3.setLocation(87,204);
        obs2.setLocation(85,283);
        cubo3.setLocation(64,207);*/
       // wall wall = new wall();
       // wall.getImage().mirrorHorizontally();
       // addObject(wall,427,309);
    }
}
