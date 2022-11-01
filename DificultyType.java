/**
 * Oferece tipos de dificuldade.
 */
public enum DificultyType
{
    EASY("Fácil"),NORMAL("Normal"),HARD("Difícil");

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
