
/**
 * Description: Main menu
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
        return ("You will be shown a grid of numbers 1–16"
        + "\nChoose two numbers from the grid."
        + "\nEach number reveals a hidden letter"
        + "\nIf the two letters match, your score increases!"
        + "\nIf the letters do not match, you lose health."
        + "\nWhen your health reaches 0, the game ends."
        + "\nBut if you match all pairs before running out of health, you win!");
        
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
            
            Profile.Login(player);
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
        u = JOptionPane.showInputDialog("Please enter your UserName");
        
        p = JOptionPane.showInputDialog("Please enter a password between 1-5");
        
        if (p.length() <= 5 && p.length() >= 1)
        {
            JOptionPane.showMessageDialog(null,"Perfect!!");
        }
        else 
        {
            p = JOptionPane.showInputDialog("Error"+"\nPlease enter a password between 1-5");
        }
        
        Player player = new Player(u, p); 
        
        Profile.Signup(player);
        
    }
}