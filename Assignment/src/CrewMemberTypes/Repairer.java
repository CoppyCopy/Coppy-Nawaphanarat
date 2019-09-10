package CrewMemberTypes;

/**
 * Desc: A repair type for the crew.
 * @author sna134 and cyh29 
 *
 */
public class Repairer extends Types{
	/**
	 * Desc: A constructor function that sends the information about the type.
	 */
	public Repairer() {
		super("The Repairer that can be able to repairs the space ship much more efficiency than others.", "Repairer", "1.5x Repair efficiency.");
	}
	
	public static double getEfficiency() {
		return 1.5;
	}
}
