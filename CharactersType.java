/**
 * Oferece tipos de skin.
 */
public enum CharactersType
{

    RICARDO("Ricardo"),PEDRO("Pedro"),JOAOPEDRO("Joao");

    private String type;

    private CharactersType(String str)
    {
        this.type = str;
    }

    public String toString()
    {
        return this.type;
    }
}
