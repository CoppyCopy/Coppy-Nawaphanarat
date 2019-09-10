package FoodMedicItems;

/**
 * Desc: A class that contains about Beef Jerky.
 * @author sna134 and cyh27
 *
 */

public class BeefJerky extends Items {
	public static String desc = "Beef Jerky increases hunger by 10 and it heals by 5. It costs $5.";
	public static int hunger = 10, thirst = 0, price = 5, health = 5;
	/**
	 * Desc: A constructor function that sends the information about the item.
	 */
	public BeefJerky() {
		super(desc, hunger, thirst, health, price);
	}
}
