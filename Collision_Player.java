import greenfoot.*;

/**
 * Define métodos para colisoes entre um ator e um ator player.
 */
public abstract class Collision_Player extends Collision
{
    /**
     * Verifica com quê que está a culidir e determina a colisão entre os dois.
     */
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
    
    /**
     * Altera a ordem de pintura. Não concluido.
     */
    protected void Collision_PASSUNDER(Collision actor)
    {     
        this.getWorld().setPaintOrder(Tooltip.class, actor.getClass() , Players.class );
    }
    
    /**
     * Altera a ordem de pintura. Não concluido.
     */
    protected void Collision_PASSHOVER(Collision actor)
    {
        this.getWorld().setPaintOrder(Tooltip.class, Players.class , actor.getClass() );
    }
}
