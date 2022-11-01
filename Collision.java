import greenfoot.*;  
import java.util.List;

/**
 * Write a description of class Collision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Collision extends Actor
{
    private List<AdvancedActor> actorInRangeList;

    protected abstract void check_Collision();

    protected void Collision_TOTAL(Collision actor_move , Collision actor_fixed )
    {
        int deltaX = actor_move.getX()-actor_fixed.getX();
        int deltaY = actor_move.getY()-actor_fixed.getY();
        double actor_move_Width = actor_move.getImage().getWidth()/2;
        double actor_move_Height = actor_move.getImage().getHeight()/2;
        double actor_fixed_Width = actor_fixed.getImage().getWidth()/2;
        double actor_fixed_Height = actor_fixed.getImage().getHeight()/2;
        
        if ( actor_move.getX() < actor_fixed.getX()-actor_fixed_Width- (double)(actor_move.getImage().getWidth()/(double)2.8) || 
             actor_move.getX() > actor_fixed.getX()+actor_fixed_Width+(double)(actor_move.getImage().getWidth()/(double)2.8)   )
        {
            while ( (deltaX < 0 ) && (deltaX) > (-1* (actor_fixed_Width + actor_move_Width) ) )
            {
                actor_move.setLocation(actor_move.getX() -1 ,actor_move.getY());
                deltaX = actor_move.getX()-actor_fixed.getX();
            }
            //verifica se tem objetos a esquerda do ator
            while ( (deltaX > 0 ) && (deltaX) <  (actor_fixed_Width + actor_move_Width) ) 
            {
                actor_move.setLocation( actor_move.getX() + 1 , actor_move.getY() );
                deltaX = actor_move.getX()-actor_fixed.getX();
            }
        }

        if ( actor_move.getY() < actor_fixed.getY()-actor_fixed_Height-(double)(actor_move.getImage().getHeight()/(double)2.8) || 
             actor_move.getY() >= actor_fixed.getY()+actor_fixed_Height+(double)(actor_move.getImage().getHeight()/(double)2.8) )
        {
            //verifica se tem objetos a baixo do ator
            while ( (deltaY < 0 ) && (deltaY) > (-1* (actor_fixed_Height + actor_move_Height) ) )
            {
                actor_move.setLocation(actor_move.getX(), actor_move.getY()-1);
                deltaY = actor_move.getY()-actor_fixed.getY();
            }
            //verifica se tem objetos a cima do ator
            while ( (deltaY > 0 ) && (deltaY) < (actor_fixed_Height + actor_move_Height) )
            {
                actor_move.setLocation(actor_move.getX(), actor_move.getY()+1);
                deltaY = actor_move.getY()-actor_fixed.getY();
            }
        }
    }

    protected void Collision_HOVER_OR_UNDER(Collision actor_hover , Collision actor_Under)
    {
        this.getWorld().setPaintOrder(Tooltip.class, actor_hover.getClass() , actor_Under.getClass() );
    }

    protected List<AdvancedActor> getActorInRangeList()
    {
        return this.actorInRangeList;
    }

    protected List<AdvancedActor> setActorInRangeList(List<AdvancedActor> list)
    {
        return this.actorInRangeList = list;
    }
}

