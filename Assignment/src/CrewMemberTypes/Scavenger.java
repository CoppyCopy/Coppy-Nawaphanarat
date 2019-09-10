package CrewMemberTypes;

/**
 * Desc: A scavenger type for the crew
 * @author sna134 and cyh29
 *
 */
public class Scavenger extends Types{
	
	/**
	 * Desc: A constructor function that sends the information about the type.
	 */
	public Scavenger() {
		super("A scavenger able to tells the crews if this planet has any parts (only for spaceship parts).", "Scavenger", "Alert every crew members if there is a spaceship part on the current planet. Only available once per day.");
	}
}
