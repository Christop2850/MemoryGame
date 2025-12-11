
/**
 * Description: this method will compile the mainmenu class and the gameplay class into one method that the main test class can call to run the game
 *
 * @author (Atiqat Adefioye)
 * @version (December 10th 2025)
 */
public class Run
{
    public static void Play()
    {
        //call the main menu class to run the main menu section of the game
        MainMenu.Intro();
        
        //call gameplay class to run that section of the game
        Gameplay.gamePlay();
        
    }
}