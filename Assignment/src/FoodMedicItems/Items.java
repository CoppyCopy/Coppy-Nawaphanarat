package FoodMedicItems;

/**
 * Desc: A class that retrieves the item's informations and assigned.
 * @author sna134 and cyh27
 *
 */
public class Items {
	public String desc;
	public int hunger, thirst, health;
	public double price;
	
	/**
	 * Desc: A construct function that receives the item's information and assigned to each variable, desc, hunger, thirst, and price.
	 * @param tempDesc, a string variable that receives the description of the item.
	 * @param tempHunger, an integer variable that receives the hunger value of the item.
	 * @param tempThirst, an integer variable that receives the thirst value of the item.
	 * @param tempPrice, an integer variable that receives the price value of the item.
	 * @param tempHealth, an integer variable that receives the healing factor of the item.
	 */
	public Items(String tempDesc, int tempHunger, int tempThirst, int tempHealth, double tempPrice) {
	    desc = tempDesc;
		hunger = tempHunger;
		thirst = tempThirst;
		health = tempHealth;
		price = tempPrice;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public int getThirst() {
		return thirst;
	}
	
	public int getHealth() {
		return health;
	}
	
	public double getPrice() {
		return price;
	}
}
