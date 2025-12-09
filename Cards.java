
/**
 * Description: this program will have a variable of type char for
 * the sublclasses' char variable (to be inherited). It will have
 * a constructor to initialize the char, an equals method to compare
 * two cards, and a to string method to output the char.
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class Cards
{
    
    //code a variable of type char to hold the value of the card
    static char chrValue;
    
    //initialize the constructor and set the char to the parameter value\
    public Cards(char v)
    {
        this.chrValue = v;
    }
    
    //code an equals method to compare two cards
    public static boolean equals(Cards card1, Cards card2)
    {

        if (card1 == card2)
        {

            return true;

        }
        
        //return
        return false;
    
    }

    //code a to String to ouput the character the card is holding
    public String toString()
    {
        
        //return character
        return "Value: " + this.chrValue;
        
    }
    
}