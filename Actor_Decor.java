import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Permite criar um ator padrão com uma imagem á escolha.
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
