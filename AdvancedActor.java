import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ofere�e m�todos para intera��es entre o player e o ator.
 */
public abstract class AdvancedActor extends Collision_Actor
{
    private String tooltip_tex;
    private Players actor; 
    private Players lastUser;
    
    /**
     * Inicia as variaveis.
    */
    public AdvancedActor(String tooltip_text,CollisionType collisionType_ToActor,CollisionType collisionType_ToPlayer)
    {
        this.tooltip_tex = tooltip_text;
        this.setCollision_ToActor(collisionType_ToActor);
        this.setCollision_ToPlayer(collisionType_ToPlayer);
    }     
    
    /**
     * Verifica se ainda est� a ser utilizado. 
     * Um ator est� a ser utilizado enquanto a tooltip est� a ser mostrada no player.
    */
    public void check_Actor()
    {
        if (this.actor != null && !this.actor.hasTooltip()) 
            this.makeAvailable(); 
    }
    
    /**
     * Retorna o texto base que o ator tem para apare�er como tooltip.
    */
    public String getTooltipText(){
        return this.tooltip_tex;
    }
    
    /**
     * Torna o ator d�sponivel para outra utiliza��o.
    */
    public void makeAvailable()
    {
        this.actor = null;
    }
    
    /**
     * Torna ocupado o ator e executra a a��o.
    */
    public void use(Players actor)
    {
        this.actor = actor;
        this.lastUser = actor;
        this.action();
    }
    
    /**
     * A��o a ser realizada
    */
    public abstract void action();
    
    /**
     * Retorna o player que est� a usar o ator.
    */
    public Players getUser()
    {
        return this.actor;
    }
    
    /**
     * Define o ultimo utilizador do ator.
    */
    protected void setLastUser(Players player)
    {
        this.lastUser = player;
    }
    
    /**
     * Retorna o ultimo utilizador.
    */
    public Players getLastUser()
    {
        return this.lastUser;
    }
    
    /**
     * Retorna true se estever a ser utilizado.
    */
    public boolean isUsed()
    {
        return (this.actor == null) ? false : true;
    }
}
