/**
 * Oferece direções de visão.
 */
public enum CharactersVision
{
    LEFT("Esquerda"),RIGHT("Direita"),UP("Cima"),DOWN("Baixo");

    private String type;

    private CharactersVision(String str)
    {
        this.type = str;
    }

    public String toString()
    {
        return this.type;
    }
}
