
/**
 * Description: this program will set the value of card 1 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C1 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C1()
    {
        
        //set super class variable equal to A for this object
        super('A');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "A";

    }
    
}