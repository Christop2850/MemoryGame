/**
 * Description: MainMenu
 * 
 * This class manages the introduction, login, and signup
 * process for the Match Mania memory game. It interacts with
 * the user using JOptionPane dialogs and communicates with
 * the Profile class to save/load Player accounts.
 * 
 * Features: 
 * 
 *  - Displays intro messages and game rules.
 *  - Allows users to sign up for a new account.
 *  - Allows returning users to log into an existing account.
 *  - Validates passwords and checks whether profiles exist.
 * 
 * 
 * @author (Atiqat Adefioye)
 * @version (December 5th 2025)
 */
import javax.swing.JOptionPane;
public class MainMenu extends Player
{

    private static Player player = new Player();
    
    // Variables for username, password, and menu selections
    private static String strUserName = "";
    private static String strPassword = "";
    private static byte bytUserOption = 0;
    private static boolean bolExist = false;
        
    /**
     * Main introduction sequence for the game.
     * Shows welcome messages, rules, and asks the user
     * whether they are a new user or a returning user.
     */
    public static void intro( )
    {
        // Opening welcome message
        JOptionPane.showMessageDialog(null,"Welcome to Match Mania!!!! \nThis is a memory card game, to test your memory!!!!");

        // Displaying the game rules
        JOptionPane.showMessageDialog(null, getGameRules());

        // Ask if the user is new (0 = Yes, 1 = No, 2 = Cancel)
        bytUserOption = (byte)JOptionPane.showConfirmDialog(null,"Are you a new User?");

        // 0 = YES → Sign up
        if (bytUserOption == 0)
        {
            //call sign up method
            signUp(strUserName,strPassword);
        }
        // 1 = NO → Log in
        else if (bytUserOption == 1)
        {
            //call log in method
            login(strUserName,strPassword,bolExist);
        }
        // 2 = CANCEL or closed dialog → exit intro
        else
        {
            JOptionPane.showMessageDialog(null,"You closed the game, bye");
            
            System.exit(0);
        }

    }
    //non void method of type string to output the game rules
    public static String getGameRules()
    {
        //Outputting the rules to the user
        return ("You will be shown a grid of numbers 1–16"
            + "\nChoose two numbers from the grid."
            + "\nEach number reveals a hidden letter"
            + "\nIf the two letters match, your score increases!"
            + "\nIf you find the lucky pair, then your health increases by 2!!!!"
            + "\nIf the letters do not match, you lose health."
            + "\nWhen your health reaches 0, the game ends."
            + "\nBut if you match all pairs before running out of health, you win!");

    }

    //void method for the user to sign up or login
    /**
     * Handles user login. If the username exists, the method loads
     * the Player file and verifies the password. If the username
     * does not exist, it redirects the user to the SignUP method.
     *
     * u Temporary username input
     * p Temporary password input
     * e Boolean flag indicating if user exists
     */
    public static void login(String u, String p, boolean e)
    {
        boolean bolValidPassword = false;

        //Prompt user for their username        
        u = JOptionPane.showInputDialog("Please enter your UserName");

        //Create a temporary Player object using the entered username
        player = new Player(u);

        //Check if the user exists using Profile.checker()
        e = Profile.checker(player);

        //If the profile exists
        if (e == true)
        {
            //Load saved Player object
            player = Profile.login(player);

            //Loop until password is correct
            do 
            {
                p = JOptionPane.showInputDialog("Please enter your password");

                if (p.equals(player.getstrPassword()))
                {
                    //output welcome message to user
                    JOptionPane.showMessageDialog(null,"Welcome " + player.getstrUserName() + "!!!!!"
                    + "\n\nYour Score was: " +player.getbytScore()
                    +"\nCan you get better???");

                    //if password is correct update boolean to ture to break loop
                    bolValidPassword= true;
                }
                else
                {
                    //Message dialog to tell user thier password is incorrect
                    JOptionPane.showMessageDialog(null,"Wrong password try again!!");

                    //if password is wrong update boolean to false to loop
                    bolValidPassword = false;

                    //Checking the password
                    //JOptionPane.showMessageDialog(null,player.getstrPassword());
                }
            }while(bolValidPassword == false);

        }
        //User does not exist
        else
        {
            //output message to user telling them to sign up
            JOptionPane.showMessageDialog(null,"This player does nopt exist!!!, Please signUp");

            //calling signUP method 
            signUp(u,p);
        }

    }

    /**
     * Handles the signup process. Prompts the user for a username
     * and a password, validates password length, and then saves
     * the new Player profile using Profile.Signup().
     */
    public static void signUp(String u, String p)
    {
        boolean bolCorrect = false;

        //Prompting the user for username
        u = JOptionPane.showInputDialog("Please enter your UserName");

        //Validate password length
        do
        {

            //Prompting the user for password
            p = JOptionPane.showInputDialog("Please enter a password between 1-5");

            //if the password is less than or equal to 5 and greater than or equal to 1
            if (p.length() <= 5 && p.length() >= 1)
            {
                //outputting user friendly dialog
                JOptionPane.showMessageDialog(null,"Perfect!!");

                //updates boolean to ture to stop from looping
                bolCorrect = true;
            }
            else 
            {
                //outputting message that tells user thier passowrd length was incorrect
                JOptionPane.showMessageDialog(null, "Invalid password length! Try again."); 
                
                //update boolean to flase to continue loop
                bolCorrect = false;
            }
        }
        while(!bolCorrect);

        //Inform user to remember credentials
        JOptionPane.showMessageDialog(null,"Make sure to remember your username and passowrd because you will need it for next time!!!");

        // Create new Player object and save it
        player = new Player(u,p);  
        Profile.signUp(player);

        //Final welcome message
        JOptionPane.showMessageDialog(null,"Welcome " + player.getstrUserName() + "!!!!!");

    }
    
    public static void updateScore(byte score)
    { 
        //sets the score in the Player object
        player.setScore(score); 
        
        //calling update profile method 
        Profile.updateProfile(player);
    }
}