import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Permite criar um ator padr�o com uma imagem � escolha.
 */
public class Actor_Decor extends Actor
{
    /**
     * Cria o ator
     */
    public Actor_Decor(String img)
    {
        this.setImage( new GreenfootImage(img) );
    }
}
