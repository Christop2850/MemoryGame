
/**
 * Description: this program will set the value of card 5 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C5 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C5()
    {
        
        //set super class variable equal to E for this object
        super('E');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "E";

    }
    
}