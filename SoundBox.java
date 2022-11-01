import greenfoot.*;
import java.util.ArrayList ;
/**
 * Ofereçe metodos para controlar todos ou um som especifico.
 * Comtem uma Lista de sons e uma lista de strings com nomes dos sons.
 */
public abstract class SoundBox  
{
    private static ArrayList<GreenfootSound> soundList = new ArrayList();
    private static ArrayList<String> soundList_String = new ArrayList();
    
    /**
     * Retorna o indice do som , -1 se não existir.
    */
    public static int getSound(String sound)
    {
        return soundList_String.indexOf(sound);
    }
    
    /**
     * Adiciona o som com filename "sound" a lista de sons. 
     * Filename passa a ser uma referencia para o som.
     */
    public static void addSound(String sound)
    {
        soundList.add( new GreenfootSound(sound) );
        soundList_String.add( sound );
    }
    
    /**
     * Adiciona o som <sound> a lista de sons. 
     * "name" é a areferencia para o som.
     */
    public static void addSound(String sound , String name)
    {
        soundList.add(new GreenfootSound(sound) );
        soundList_String.add( name );
    }    
    
    /**
     * Remove o som com a referencia "name".
     */
    public static void removeSound(String name)
    {
        soundList.remove( soundList_String.indexOf(name) );
        soundList_String.remove(name);
    }

    /**
     * PlayLoop() para o som com referencia "name".
     */
    public static void playLoop(String name)
    {
        soundList.get( soundList_String.indexOf(name) ).playLoop();
    }
    
    /**
     * Play() para o som com referencia "name".
     */
    public static void play(String name)
    {
        soundList.get( soundList_String.indexOf(name) ).play();
    }
    
    /**
     * Pause() para o som com referencia "name".
     */
    public static void pause(String name)
    {
        soundList.get( soundList_String.indexOf(name) ).pause();
    }
    
    /**
     * Stop() para o som com referencia "name".
     */
    public static void stop(String name)
    {
        soundList.get( soundList_String.indexOf(name) ).stop();
    }
    
    /**
     * PlayLoop() para todos os sons adicionados.
     */
    public static void playLoop_AllSounds()
    {
        for(GreenfootSound sound :soundList)
        {
            sound.playLoop();
        }
    }

    /**
     * Play() para todos os sons adicionados.
     */
    public static void play_AllSounds()
    {
        for(GreenfootSound sound :soundList)
        {
            sound.play();
        }
    }

    /**
     * Pause() para todos os sons adicionados.
     */
    public static void pause_AllSounds()
    {
        for(GreenfootSound sound :soundList)
        {
            sound.pause();
        }
    }
    
    /**
     * Stop() para todos os sons adicionados.
     */
    public static void stop_AllSounds()
    {
        for(GreenfootSound sound :soundList)
        {
            sound.stop();
        }
    }
    
    /**
     * Apaga todos os Sons Adicionados depois de fazer stopAll;
     */
    public static void clearSounds()
    {
        stop_AllSounds();
        soundList.clear();
        soundList_String.clear();
    }
}
