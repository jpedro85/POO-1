/**
 * Oferece tipos de dificuldade.
 */
public enum DificultyType
{
    EASY("F�cil"),NORMAL("Normal"),HARD("Dif�cil");

    private String type;

    private DificultyType(String str)
    {
        this.type = str;
    }

    public String toString()
    {
        return this.type;
    }
}
