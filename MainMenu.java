
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
        byte bytUserOption = 0;
        boolean exist = false;

        //code an opening statement for the user
        JOptionPane.showMessageDialog(null,"Welcome to Match Mania!!!! \nThis is a memory card game, to test your memory!!!!");

        //giving the user the rules
        JOptionPane.showMessageDialog(null, getGameRules());

        //
        bytUserOption = (byte)JOptionPane.showConfirmDialog(null,"Are you a new User?");

        if (bytUserOption == 0)
        {
            //call sign up method
            SignUP(strUserName,strPassword);
        }
        else if (bytUserOption == 1)
        {
            //call log in method
            Login(strUserName,strPassword,exist);
        }
        else
        {
            return;
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
            + "\nIf the letters do not match, you lose health."
            + "\nWhen your health reaches 0, the game ends."
            + "\nBut if you match all pairs before running out of health, you win!");

    }

    //void method for the user to sign up or login
    public static void Login(String u, String p, boolean e)
    {
        boolean b = false;

        //initializing and populating the users username in order to check if they exist
        u = JOptionPane.showInputDialog("Please enter your UserName");

        Player player = new Player(u,p);

        e = Profile.checker(player);

        if (e == true)
        {

            player = Profile.Login(player);

            do 
            {
                p = JOptionPane.showInputDialog("Please enter your password");

                if (p.equals(player.getstrPassword()))
                {
                    JOptionPane.showMessageDialog(null,"Welcome " + player.getstrUserName() + "!!!!!");
                    b= true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong password try again!!");
                    b = false;
                    JOptionPane.showMessageDialog(null,player.getstrPassword());
                }
            }while(b == false);

        }
        else
        {
            JOptionPane.showMessageDialog(null,"This player does nopt exist!!!, Please signUp");

            SignUP(u,p);
        }

    }

    public static void SignUP(String u, String p)
    {
        boolean correct = false;
        //
        u = JOptionPane.showInputDialog("Please enter your UserName");

        p = JOptionPane.showInputDialog("Please enter a password between 1-5");

        do
        {

            if (p.length() <= 5 && p.length() >= 1)
            {
                JOptionPane.showMessageDialog(null,"Perfect!!");
                correct = true;
            }
            else 
            {

                correct = false;
            }
        }
        while(correct == false);

        //output a friendly message to the user
        JOptionPane.showMessageDialog(null,"Make sure to remember your username and passowrd because you will need it for next time!!!");

        //JOptionPane.showMessageDialog(null,p);
        Player player = new Player(u,p);  

        Profile.Signup(player);

        //output a friendly message to the user
        JOptionPane.showMessageDialog(null,"Welcome " + player.getstrUserName() + "!!!!!");

    }
}