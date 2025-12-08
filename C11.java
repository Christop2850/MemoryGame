
/**
 * Description: this program will set the value of card 11 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C11 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C11()
    {
        
        //set super class variable equal to F for this object
        super('F');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "F";

    }
    
}