
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
        File file = new File(player.getstrUserName()+".txt");
            
            if (file.exists())
            {
                return true;

            }
            else
            {
                return false;
            }
    }
    
    public static void Login(Player player)
    {
        try
        {
            
            //declare a variable to store the ObjectInputStream (OIS)
            //called in
            ObjectInputStream in;
            
            //build an object using the default constructor
            player = new Player();
            
            //Create a Scanner object and connect it to the filereader object
            //fileReader access the file
            //scanner allows us to read in the info
            //build the OIS and connect FileInputStream - specific 
            //for objects
            in = new ObjectInputStream(new FileInputStream(player.getstrUserName()+".txt"));
            
            //the object get set to the class with the OIS.readobject 
            player = (Player)in.readObject();
            
            //closing the scanner and filereader
            in.close();
        } 
        catch (ClassNotFoundException e) 
        {
            //System.out.println("Error: Object'c class does not match");
            
            
        } 
        catch (FileNotFoundException e) 
        {
            //System.out.println("Error: Cannot open file for reading");
            
        } 
        catch (IOException e) 
        {
            //System.out.println("Error: Cannot read from file");
            
        }
    }

    public static void Signup(Player newPlayer)
    {
        try
        {

            //declare a variable of type OOS - which will write the entire
            //object to the file
            ObjectOutputStream out;

            //calling the overload constructor
            newPlayer = new Player(newPlayer.getstrUserName());
            

            //build an OOS object and connect it with a FOS to create the txt file
            out = new ObjectOutputStream(new FileOutputStream(newPlayer.getstrUserName()+".txt"));

            //use the OOS method writeobject and send in the name of the 
            //object
            out.writeObject(newPlayer);

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