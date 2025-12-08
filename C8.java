
/**
 * Description: this program will set the value of card 8 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C8 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C8()
    {
        
        //set super class variable equal to D for this object
        super('D');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "D";

    }
    
}