import greenfoot.*;  

/**
 * Class para definir metodos de colisão entre atores.
 * 
 * O objetivo quaisquer dois actor que nao os player tivesem colisoes entre si, não foi posivel concluir.
 */
public abstract class Collision_Actor extends Collision
{
    private CollisionType Collision_ToPlayer;
    private CollisionType Collision_ToActor;
    
    protected void check_Collision()
    {
       /* this.setActorInRangeList( this.getIntersectingObjects(AdvancedActor.class) ) ;

        for(Collision_Actor actor : this.getActorInRangeList() )
        {
            switch(actor.getCollision_ToActor()) //verificado qual a colisao deste this com o player
            {
                case TOTAL:
                    this.check_CollisionToActor_ifthisTOTAL(actor);
                    break;
                case PASSHOVER:
                    this.check_CollisionToActor_ifthisPASSHOVER(actor);
                    break;
                case PASSUNDER:
                    this.check_CollisionToActor_ifthisPASSUNDER(actor);
                    break;
                default:
                    break;
            }
        }*/
    }

    private void check_CollisionToActor_ifthisTOTAL (Collision actor)
    {
       
    }

    private void check_CollisionToActor_ifthisPASSHOVER(Collision actor)
    {
       /* if(actor.getCollision_ToActor() != CollisionType.NONE)
        {
            this.Collision_HOVER_OR_UNDER(actor,this);  
        }*/
    }

    private void check_CollisionToActor_ifthisPASSUNDER(Collision actor)
    {
       /* if(actor.getCollision_ToActor() != CollisionType.NONE)
        {
            this.Collision_HOVER_OR_UNDER(this,actor);  
        }*/
    }
    
    protected final void setCollision_ToPlayer( CollisionType collisionType )
    {
        this.Collision_ToPlayer = collisionType;
    }

    protected final void setCollision_ToActor( CollisionType collisionType )
    {
        this.Collision_ToActor = collisionType;
    }

    public CollisionType getCollision_ToPlayer()
    {
        return this.Collision_ToPlayer;
    }

    public CollisionType getCollision_ToActor()
    {
        return this.Collision_ToActor;
    }
}
