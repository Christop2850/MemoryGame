
/**
 * Write a description of class MainMenu here.
 *
 * @author (Atiqat Adefioye)
 * @version (December 5th 2025)
 */
import javax.swing.JOptionPane;
public class MainMenu extends Player
{
    public static void main (String args[])
    {
        //settign variables for username and password
        String strUserName = "";
        String strPassword = "";
        
        boolean exist = false;
        
        //code an opening statement for the user
        JOptionPane.showMessageDialog(null,"Welcome to Match Mania!!!! \nThis is a memory card game, to test your memory!!!!");
        
        //giving the user the rules
        JOptionPane.showMessageDialog(null, getGameRules());
        
        Login(strUserName,strPassword,exist);
        
    }
    
    //non void method of type string to output the game rules
    public static String getGameRules()
    {
        //Outputting the rules to the user
        return ("You will be shown a grid of numbers from 1-16 to chose from"
        + "then you will be asked to pick 2 numbers"
        + "the numbers you have chosen will then reveal a set of letters"
        + "if the letters you chose are the same then your score will be incremented"
        + "but if they are not equal you will lose health!!!"
        + "once the health reaches 0 then the game will end"
        + "but if you get all the sets of cards before the you lose all your health then you win!!!!");
        
    }
    
    //void method for the user to sign up or login
    public static void Login(String u, String p, boolean e)
    {
        //initializing and populating the users username in order to check if they exist
        String userName = JOptionPane.showInputDialog("Please enter your UserName");
        
        Player player = new Player(userName);
        
        e = Profile.checker(player);
        
        if (e == true)
        {
            JOptionPane.showMessageDialog(null,"Welcome " + player.getstrUserName() + "!!!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"This player does nopt exist!!!, Please signUp");
            
            SignUP(userName,p);
        }
        
    }
    
    public static void SignUP(String u, String p)
    {
        //
        //
        String userName = JOptionPane.showInputDialog("Please enter your UserName");
        
    }
}