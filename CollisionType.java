/**
 * Oferece tipos de colisao.
 */
public enum CollisionType 
{
    TOTAL("total",3),PASSUNDER("passar em baixo",2),PASSHOVER("passar em cima",1),NONE("nenhum",0);
    
    private String type;
    private int value;
    
    private CollisionType(String str,int value)
    {
        this.type = str;
    }
    
    public int toInt()
    {
        return this.value;
    }
    
    public String toString()
    {
        return this.type;
    }
}
