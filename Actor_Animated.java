import greenfoot.*;  
import java.util.ArrayList;
/**
 * Permite criar um ator padrão com uma animação.
 */
public class Actor_Animated extends Actor
{
    private ArrayList<GreenfootImage> image_list;
    private int delay,counter,img_index;
    
    /**
     * Inicia.
     */
    public Actor_Animated( String base_filename_ , int n_img , int delay )
    {
        this.image_list = new ArrayList();
        this.loadImages( base_filename_ , n_img );
        this.delay = delay;
    }
    
    /**
     * Executado cada tick.
     */
    public void act()
    {
        this.animate();
    }
    
    /**
     * Faz a animação.
     */
    private void animate()
    {
        if( this.counter == this.delay )
        {
            if( this.img_index == this.image_list.size() )
                this.img_index = 0;
                
            this.setImage( this.image_list.get(  (this.img_index < this.image_list.size()) ? this.img_index : 0 ) );
            this.img_index++;
            this.counter=0;
        }
        else
        {
            this.counter++;  
        }
    }
    
    /**
     * Carrega a(s) imagem(s).
     */
    private void loadImages(String base_filename, int n_img)
    {
        for(int i = 0; i<n_img;i++)
        {
            this.image_list.add( new GreenfootImage( base_filename + i + ".png" ) );
        }
    }
}
