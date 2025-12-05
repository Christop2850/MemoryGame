
/**
 * Write a description of class Profile here.
 *
 * @author (Atiqat Adefioye)
 * @version (December 5th)
 */
//import entire IO library
import java.io.*;

//import Scanner class for input
import java.util.*; 
public class Profile extends Player
{
    
    
    public static boolean checker(Player player)
    {
        try
        {
            //declare a variable of type bankaccount
            player = new Player(player.getstrUserName());
            
            //Create a Scanner object and connect it to the filereader object
            //fileReader access the file
            //scanner allows us to read in the info
            Scanner in = new Scanner(new FileReader(player.getstrUserName()+".txt"));
            
            //declare variables to store info from file
            //then use the scanner to read in data
            String name = in.nextLine();
            String password = in.nextLine();
            
            player = new Player(name,password);
            //System.out.println(aBankAccount);
            
            
            //closing the scanner and filereader
            in.close();
            return true;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for reading");
            return false;
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Error: EOF encountered, file may be corrupt");
            return false; 
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot read from file");
            return false; 
        }
    }

    public static void Signup()
    {
        try
        {
            Player newPlayer =  new Player();

            //declaring a variable of type printwrite and calling it out
            PrintWriter out;

            //calling the overload constructor
            newPlayer = new Player(newPlayer.getstrUserName());

            //build the printwriter and connect a filewriter
            out = new PrintWriter(new FileWriter(newPlayer.getstrUserName()+".txt", true));

            //print a line using the printwriter - by calling a get method
            //associated with the object
            out.println(newPlayer.getstrUserName());
            out.println(newPlayer.getstrPassword());

            //write to file using the toString method in the bankaccount object
            //out.println("\n" + aBankAccount);

            //close printwriter and filewriter
            out.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for writing");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot write to file");
        }
    }
}