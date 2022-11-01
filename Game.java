import java.util.ArrayList;
import greenfoot.*;
/**
 * Class que guarda todos os valores do jogo que passam entre wrold.
 */
public final class Game  
{
    private static int stg_volume = 80;
    private static int stg_brightness = 240;
    private static String stg_player1_name = "Nickname player 1" ,stg_player2_name = "Nickname player 2";
    private static String stg_player1_personage = CharactersType.RICARDO.toString() ,stg_player2_personage = CharactersType.JOAOPEDRO.toString();
    private static String stg_difficulty = DificultyType.NORMAL.toString();
    private static int player1score = 0, player2score = 0 ;
    private static int chaves1,chaves2;
    private static InterfaceAreaSound world;
    private static int final_time;

    /**
     * Inicias as variaveis.
     */
    public static void resetPlayesDefaults()
    {
        /*stg_volume = 80;
        stg_brightness = 240;
        stg_player1_name = "Nickname player 1";
        stg_player2_name = "Nickname player 2"; 
        stg_player1_personage = CharactersType.RICARDO.toString();
        stg_player2_personage = CharactersType.JOAOPEDRO.toString();
        stg_difficulty = DificultyType.NORMAL.toString();*/
        player1score = 0;
        player2score = 0;
        chaves1 = 0;
        chaves2 = 0;
    }

    /**
     * Altera o volume.
     * Volume [0,100]
     */
    public static void setVolume(int volume)
    {
        if(volume <= 100 && volume >= 0)
            stg_volume = volume;
    }

    /**
     * Altera o lominusidade.
     * Lominusidadeolume [200,255]
     */
    public static void setBrightness(int brightness)
    {
        if(brightness <= 255 && brightness >= 200)
            stg_brightness = brightness;
    }

    /**
     * Altera o nickname do jogador 1.
     */
    public static void setPlayer1Name(String name)
    {
        stg_player1_name = name;
    }

    /**
     * Altera o nickname do jogador 2.
     */
    public static void setPlayer2Name(String name)
    {
        stg_player2_name = name;
    }

    /**
     * Altera a skin do jogador 1.
     */
    public static void setPlayer1_personage(String name)
    {
        stg_player1_personage = name;
    }

    /**
     * Altera a skin do jogador 2.
     */
    public static void setPlayer2_personage(String name)
    {
        stg_player2_personage = name;
    }

    /**
     * Altera a dificuldade.
     * A dificuldade do jogo está no tempo limite para comcluir os niveis;
     */
    public static void setDificulty(String difficulty)
    {
        stg_difficulty = difficulty;
    }
    
    /**
     * Altera a dificuldade.
     * A dificuldade do jogo está no tempo limite para comcluir os niveis;
     */
    public static void setAtualPlayerWorld(InterfaceAreaSound w)
    {
        world = w;
    }
    
    /**
     * Altera o tempo final.
     */
    public static void setFinal_Time(int time)
    {
        final_time = time;
    }
    
    /**
     * Devolve o tempo final.
     */
    public static int getFinal_Time()
    {
        return final_time;
    }
    
    /**
     * Retorna o mundo atual que tem players
     */
    public static InterfaceAreaSound getAtualWorld()
    {
        return world;
    }

    /**
     * Retorna o volume.
     */
    public static int getVolume()
    {
        return stg_volume;
    }

    /**
     * Retorna a luminusidade.
     */
    public static int getBrightness()
    {
        return stg_brightness;
    }

    /**
     * Retorna o nickname do Jogador 1.
     */
    public static String getPlayer1Name()
    {
        return stg_player1_name;
    }

    /**
     * Retorna o nickname do Jogador 2.
     */
    public static String getPlayer2Name()
    {
        return stg_player2_name;
    }

    /**
     * Retorna o nome da skink do Jogador 1.
     */
    public static String getPlayer1_personage()
    {
        return stg_player1_personage;
    }

    /**
     * Retorna o nome da skink do Jogador 2.
     */
    public static String getPlayer2_personage()
    {
        return stg_player2_personage;
    }

    /**
     * Calcula o jogador que teve mais infuencia no puzle.
     * Aquele que teve mais influência é aquele que aparece mais vezes com ultimo utilizador dos objetos que fazem parte do puzle.
     * Se ambos forem influêntes a pontução é dividida pelos dois.
     */
    public static void update_Score(ArrayList<Players> LastsActorsUsingList , Puzzle puzzle )
    {
        int countplayer1 = 0,countplayer2 = 0 ;

        if(puzzle.isScoreAdded() == false)
            if ( LastsActorsUsingList !=null && puzzle.isScoreAdded() == false )
            {
                for(Players player : LastsActorsUsingList)
                {
                    if (player != null )
                    {
                        if( player.getClass() == Player1.class)
                            countplayer1 += 1;
                        else if( player.getClass() == Player2.class)
                            countplayer2 += 1;
                    }
                }

                if(countplayer1 == countplayer2)
                    Game.update_Score( puzzle.getPoints() );
                else if (countplayer1 > countplayer2)
                    Game.update_Score(true,puzzle.getPoints() );
                else
                    Game.update_Score(false,puzzle.getPoints() );

                puzzle.setScoreAdded(true);
            }
            else if (puzzle.isScoreAdded() == false)
                throw new IllegalArgumentException("LastPlayer está vazia");
    }

    /**
     * Aumenta a pontuação do jogador 1 se isplayer1 igual a true ou 2 se false.
     * score >= 0. 
     */
    public static void update_Score(boolean isplayer1,int score)
    {   
        if (score > 0)
        {
            if( isplayer1)
                player1score += score;
            else 
                player2score += score;
        }
        else
            throw new IllegalArgumentException("Score está negativo ou é zero");
    }

    /**
     * Aumenta a pontuação do jogador 1 se isplayer1 igual a true ou 2 se false.
     * score >= 0. 
     */
    public static void update_Score(int score)
    {
        if (score > 0)
        {
            player1score += score/2;
            player2score += score/2;
        }
        else
            throw new IllegalArgumentException("Score está negativo ou é zero");
    }

    /**
     * Retorna o score fo jogador 1.
     */
    public static int getPlayerScore_1()
    {
        return player1score;
    }

    /**
     * Retorna o score fo jogador 2.
     */
    public static int getPlayerScore_2()
    {
        return player2score;
    }

    /**
     * Retorna o numero de chaves.
     */
    public static int getChaves()
    {
        return chaves1 + chaves2;
    }

    /**
     * Retorna o numero de chaves do jogador 1.
     */
    public static int getChavesPlayer1()
    {
        return chaves1 ;
    }

    /**
     * Retorna o numero de chaves do jogador 2.
     */
    public static int getChavesPlayer2()
    {
        return chaves2;
    }

    /**
     * Incrementa o numero de chaves.
     */
    public static void updateChaves(Players player)
    {
        if( player.getClass() == Player1.class)
            chaves1++;
        else if( player.getClass() == Player2.class)
            chaves2++;
    }
    
    /**
     * Retorna a dificuldade do jogo.
     */
    public static String getDificulty()
    {
        return stg_difficulty;
    }
}