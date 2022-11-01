import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collision_Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Collision_Player extends Collision
{
    
    protected void check_Collision()
    {
        this.setActorInRangeList( this.getIntersectingObjects(AdvancedActor.class) ) ;

        for( Collision_Actor actor : this.getActorInRangeList() )
        {
            switch( actor.getCollision_ToPlayer())

            {
                case TOTAL:
                    this.Collision_TOTAL(this,actor);
                    break;
                case PASSHOVER:
                    //this.Collision_PASSHOVER(actor);
                    break;
                case PASSUNDER:
                    //this.Collision_PASSUNDER(actor);
                    break;
                default:
                    //notthing when == NONE
                    break;
            }
        }
    }

    protected void Collision_PASSUNDER(Collision actor)
    {     
        this.getWorld().setPaintOrder(Tooltip.class, actor.getClass() , Players.class );
    }

    protected void Collision_PASSHOVER(Collision actor)
    {
        this.getWorld().setPaintOrder(Tooltip.class, Players.class , actor.getClass() );
    }
}
