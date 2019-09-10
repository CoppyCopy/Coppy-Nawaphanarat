package CrewMemberTypes;

/**
 * Desc: A class that contains about Medic.
 * @author sna134
 *
 */
public class Medic extends Types{

	/**
	 * Desc: A constructor function that sends the information about the type.
	 */
	public Medic() {
		super("A medic allows to heal one crew under abnormal status (plague, losing health, etc.). Can be heal one crew each day.", "Medic", "Heals one crew member once a day.");
	}
}
