package GameEnvironment;

import FoodMedicItems.*;
import CrewMemberTypes.*;
import GUI.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Desc: Game Environment that stores all the implementations, datas, and other stuff that is related to the Spaceship game.
 * 
 * @author sna134 and cyh29
 *
 */

public class Game {
	/**
	 * These are the initializes for int type variables for game logics.
	 */
	public static int findPieces = 0, currentPieces = 0, currentDay = 1, score = 0, searched = 1, travelled = 1, cooldown = 0, action = 0, lost, nitem, crew, number, anotherOne, damage, pieces, count, day, current = 1, health = 100, thirst = 100, hunger = 100, hull = 100, shield = 100, tiredness = 100;
	/**
	 * This is a double type variable, money, for the game logic.
	 */
	public static double money = 100;
	/**
	 * This is a constant int type variable for the repair efficiency.
	 */
	public static final int repairEfficiency = 50;
	/**
	 * These are the initializes for string type lists for game logics.
	 */
	public static ArrayList<String> partPieces = new ArrayList<String>(), crewType = new ArrayList<String>(), crewName = new ArrayList<String>(), crewItems = new ArrayList<String>(), crewStatus = new ArrayList<String>();
	/**
	 * These are the initializes for integer type lists for game logics.
	 */
	public static ArrayList<Integer> crewAction = new ArrayList<Integer>(), crewTiredness = new ArrayList<Integer>(), crewHealth = new ArrayList<Integer>(), crewHunger = new ArrayList<Integer>(), crewThirst = new ArrayList<Integer>(), spaceshipHull = new ArrayList<Integer>(), spaceshipShield = new ArrayList<Integer>();
	/**
	 * These are the initializes for string type variables for game logics.
	 */
	public static String name = "", typeName = "", num = "", items = "", item = "", status = "Healthy";
	/**
	 * This is a reference variable for BeefJerky class.
	 */
	public static BeefJerky beefjerky = new BeefJerky();
	/**
	 * This is a reference variable for FruitPunch class.
	 */
	public static FruitPunch fruitpunch = new FruitPunch();
	/**
	 * This is a reference variable for FrenchFries class.
	 */
	public static FrenchFries frenchfries = new FrenchFries();
	/**
	 * This is a reference variable for DeluxeSet class.
	 */
	public static DeluxeSet deluxeset = new DeluxeSet();
	/**
	 * This is a reference variable for SpicyWater class.
	 */
	public static SpicyWater spicywater = new SpicyWater();
	/**
	 * This is a reference variable for SteakSet class.
	 */
	public static SteakSet steakset = new SteakSet();
	/**
	 * This is a reference variable for RecoveryPotion class.
	 */
	public static RecoveryPotion recoverypotion = new RecoveryPotion();
	/**
	 * This is a reference variable for HiRecoveryPotion class.
	 */
	public static HiRecoveryPotion hirecoverypotion = new HiRecoveryPotion();
	/**
	 * This is a reference variable for PlagueAntidote class.
	 */
	public static PlagueAntidote plagueantidote = new PlagueAntidote();
	/**
	 * This is a reference variable for Repairer.
	 */
	public static Repairer repairer = new Repairer();
	/**
	 * This is a reference variable for AbsoluteUnit class.
	 */
	public static AbsoluteUnit absoluteunit = new AbsoluteUnit();
	/**
	 * This is a reference variable for Scavenger class.
	 */
	public static Scavenger scavenger = new Scavenger();
	/** 
	 * This is a reference variable for TacticalCommander class.
	 */
	public static TacticalCommander tacticalcommander = new TacticalCommander();
	/**
	 * This is a reference variable for Medic class
	 */
	public static Medic medic = new Medic();
	/**
	 * This is a reference variable for Barterer class
	 */
	public static Barterer barterer = new Barterer();
	
	/**
	 * Desc: A function that stores days of travel, member counts, and spaceship name.
	 * 
	 * @param tempDay, a variable that stores the user's input for days
	 * @param tempCount, a variable that stores the number of crew members
	 * @param tempName, a variable that stores the name of its spaceship name
	 */
	public static void storeCrew(int tempDay, int tempCount, String tempName) {
		count = tempCount;
		day = tempDay;
		name = tempName;
		findPieces = (day * 2) / 3;
		pieces = findPieces;
		ViewStatus.setCrewName(name);
		ViewStatus.setSpaceshipHull(Integer.toString(hull));
		ViewStatus.setSpaceshipShield(Integer.toString(shield));
	}
	
	/**
	 * Desc: A function verify the SpaceShip name.
	 * @param tempName, a variable receives the SpaceShip name.
	 * @return Returns true if the SpaceShip name is not empty. Otherwise, returns false.
	 */
	public static boolean shipNameVerification(String tempName) {
		if (tempName.isEmpty()) {
			ShipName.updateMessage("Your SpaceShip name is empty.");
			return false;
		}
		return true;
	}
	
	/**
	 * Desc: Stores the crew's information and making sure that it does not contains the same crew's name. Also, limited to one of Medic and one of Tactical Commander.
	 * 
	 * @param tempName, a variable that receives the crew's name.
	 * @param tempType, a variable that receives the crew's type.
	 * 
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean crewInfo(String tempName, String tempType) {
		if (crewType.size() == 0 && crewName.size() == 0) {
			CrewTypesWindow.updateMessage("Sucessfully added to your team.");
			crewType.add(tempType);
			crewName.add(tempName);
			crewHunger.add(hunger);
			crewThirst.add(thirst);
			crewHealth.add(health);
			crewTiredness.add(tiredness);
			crewAction.add(action);
			crewStatus.add(status);
			return true;
		}else if (crewName.contains(tempName)) {
			CrewTypesWindow.updateMessage("This crew's name is already in use.");
			return false;
		} else if (tempType.equals(medic.getName()) && getCrewType().contains(medic.getName())) {
			CrewTypesWindow.updateMessage("You can only have one medic in the crew.");
			return false;
		} else if (tempType.equals(tacticalcommander.getName()) && getCrewType().contains(tacticalcommander.getName())) { 
			CrewTypesWindow.updateMessage("You can only have one Tactical Commander in the crew.");
			return false;
		} else if (current < count){
			CrewTypesWindow.updateMessage("Sucessfully added to your team.");
			crewType.add(tempType);
			crewName.add(tempName);
			crewHunger.add(hunger);
			crewThirst.add(thirst);
			crewHealth.add(health);
			crewTiredness.add(tiredness);
			crewAction.add(action);
			crewStatus.add(status);
			current += 1;
			return true;
		}
		CrewTypesWindow.updateMessage("Your team has the total required members.");
		return false;
	}
	
	
	/**
	 * Desc: A function that verifies that the user does input a correct format for each of them.
	 * 
	 * @param dayCheck, a variable that receives the user's input for days
	 * @param countCheck, a variable that receives the number of crew members
	 * @param nameCheck, a variable that receives the name of its crew team
	 * @return Returns true if all the verifications are met. Otherwise, returns false.
	 */
	public static boolean crewVerification(int dayCheck, int countCheck, String nameCheck) {
		if (nameCheck.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One piece of information is missing.", "Information is missing", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/**
	 * Desc: A function that allows the user to view each types.
	 * 
	 * @param type, a variable that reveals the types for the crew members.
	 * 
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean viewTypes(String type) {
		if (type.equals("Repairer")) {
			InfoWindow.type = repairer.getName();
			InfoWindow.desc = repairer.getDesc();
			InfoWindow.spec = repairer.getSpec();
			InfoWindow.createWindow();
			return true;
		} else if (type.equals("Absolute Unit")) {
			InfoWindow.type = absoluteunit.getName();
			InfoWindow.desc = absoluteunit.getDesc();
			InfoWindow.spec = absoluteunit.getSpec();
			InfoWindow.createWindow();
			return true;
		} else if (type.equals("Scavenger")) {
			InfoWindow.type = scavenger.getName();
			InfoWindow.desc = scavenger.getDesc();
			InfoWindow.spec = scavenger.getSpec();
			InfoWindow.createWindow();
			return true;
		} else if (type.equals("Tactical Commander")) { // Tactical Jump minus Yamato cannon
			InfoWindow.type = tacticalcommander.getName();
			InfoWindow.desc = tacticalcommander.getDesc();
			InfoWindow.spec = tacticalcommander.getSpec();
			InfoWindow.createWindow();
			return true;
		} else if (type.equals("Medic")) {
			InfoWindow.type = medic.getName();
			InfoWindow.desc = medic.getDesc();
			InfoWindow.spec = medic.getSpec();
			InfoWindow.createWindow();
			return true;
		} else if (type.equals("Barterer")) {
			InfoWindow.type = barterer.getName();
			InfoWindow.desc = barterer.getDesc();
			InfoWindow.spec = barterer.getSpec();
			InfoWindow.createWindow();
			return true;
		}
		return false;
	}
	
	/**
	 * Desc: A boolean function that check the player's money if it is sufficient to buy an item from the shop.
	 * @param tempMoney, an int variable that receives the player's current money.
	 * @param item, a string variale that receives the item's name.
	 * @return Returns true if the player's curreny money is sufficient to buy a selected item then, updates the money. Otherwise, returns false.
	 */
	public static boolean checkBalanceAndItems(double tempMoney, String item) {
		if (getCrewItems().size() < 10) {
			if (item.equals("Beef Jerky")) {
				if (tempMoney >= beefjerky.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(beefjerky.getPrice()-discount(beefjerky.getPrice())));
					return true;
				} else if (tempMoney >= beefjerky.getPrice()) {
					updateMoney(getMoney()-beefjerky.getPrice());
					return true;
				}
			} else if (item.equals("French Fries")) {
				if (tempMoney >= frenchfries.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(frenchfries.getPrice()-discount(frenchfries.getPrice())));
					return true;
				} else if (tempMoney >= frenchfries.getPrice()){
					updateMoney(getMoney()-frenchfries.getPrice());
					return true;
				}
			} else if (item.equals("Deluxe Set")) {
				if (tempMoney >= deluxeset.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(deluxeset.getPrice()-discount(deluxeset.getPrice())));
					return true;
					
				} else if(tempMoney >= deluxeset.getPrice()){
					updateMoney(getMoney()-deluxeset.getPrice());
					return true;
				}
			} else if (item.equals("Fruit Punch")) {
				if (tempMoney >= fruitpunch.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(fruitpunch.getPrice()-discount(fruitpunch.getPrice())));
					return true;
				} else if (tempMoney >= fruitpunch.getPrice()) {
					updateMoney(getMoney()-fruitpunch.getPrice());
					return true;
				}
			} else if (item.equals("Steak Set")) {
				if (tempMoney >= steakset.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(steakset.getPrice()-discount(steakset.getPrice())));
					return true;
				} else if (tempMoney >= steakset.getPrice()) {
					updateMoney(getMoney()-steakset.getPrice());
					return true;
				}
			} else if (item.equals("Spicy Water")) {
				if (tempMoney >= spicywater.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(spicywater.getPrice()-discount(spicywater.getPrice())));
					return true;
				} else if (tempMoney >= spicywater.getPrice()){
					updateMoney(getMoney()-spicywater.getPrice());
					return true;
				}
			} else if (item.equals("Hi-Recovery")) {
				if (tempMoney >= hirecoverypotion.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(hirecoverypotion.getPrice()-discount(hirecoverypotion.getPrice())));
					return true;
				} else if (tempMoney >= hirecoverypotion.getPrice()){
					updateMoney(getMoney()-hirecoverypotion.getPrice());
					return true;
				}
			} else if (item.equals("Recovery")) {
				if (tempMoney >= recoverypotion.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(recoverypotion.getPrice()-discount(recoverypotion.getPrice())));
					return true;
				} else if (tempMoney >= recoverypotion.getPrice()) {
					updateMoney(getMoney()-recoverypotion.getPrice());
					return true;
				}
			} else if (item.equals("Anti-Plague")) {
				if (tempMoney >= plagueantidote.getPrice() && getCrewType().contains("Barterer")) {
					updateMoney(getMoney()-(plagueantidote.getPrice()-discount(plagueantidote.getPrice())));
					return true;
				} else if (tempMoney >= plagueantidote.getPrice()) {
					updateMoney(getMoney()-plagueantidote.getPrice());
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Desc: A function that allows the player's to view the status of its current selected crew's name from its list
	 * @param tempName, a variable that receives the selected crew's name from its list
	 * 
	 * @return Returns true if a condition is met. Otherwise, returns false.
	 */
	public static boolean viewCrew(String tempName) {
		for (int i=0; i<getCrewName().size(); i++) {
			if (getCrewName().get(i).equals(tempName)) {
				ViewStatus.setName(tempName);
				ViewStatus.setType(getCrewType().get(i));
				ViewStatus.setHealth(getCrewHealth().get(i).toString());
				ViewStatus.setHunger(getCrewHunger().get(i).toString());
				ViewStatus.setThirst(getCrewThirst().get(i).toString());
				ViewStatus.setTiredness(getCrewTiredness().get(i).toString());
				ViewStatus.setCrewStatus(getCrewStatus().get(i).toString());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Desc: A function that allows the player to look at the item's information
	 * @param tempItem, a string variable that receives the player's selected item's name.
	 * 
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean viewItem(String tempItem) {
		final String hungerText = "It increases hunger by ",
		thirstText = "It increases thirst by ",		
		altThirstText = ", thirst by ",	
		healText = "It heals by ",
		altHealText = ", and it heals by ";
				
		if (tempItem.equals("Beef Jerky")) {
			InfoWindow.type = "Beef Jerky";
			InfoWindow.desc = beefjerky.getDesc();
			InfoWindow.spec = hungerText + beefjerky.getHunger() + altHealText + beefjerky.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("French Fries")) {
			InfoWindow.type = "French Fries";
			InfoWindow.desc = frenchfries.getDesc();
			InfoWindow.spec = hungerText + frenchfries.getHunger() + altHealText + frenchfries.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Deluxe Set")) {
			InfoWindow.type = "Deluxe Set";
			InfoWindow.desc = deluxeset.getDesc();
			InfoWindow.spec = hungerText + deluxeset.getHunger() + altThirstText + deluxeset.getThirst() + altHealText + deluxeset.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Steak Set")) {
			InfoWindow.type = "Steak Set";
			InfoWindow.desc = steakset.getDesc();
			InfoWindow.spec = hungerText + steakset.getHunger() + altThirstText + steakset.getThirst() + altHealText + steakset.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Spicy Water")) {
			InfoWindow.type = "Spicy Water";
			InfoWindow.desc = spicywater.getDesc();
			InfoWindow.spec = thirstText + spicywater.getThirst() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Fruit Punch")) {
			InfoWindow.type = "Fruit Punch";
			InfoWindow.desc = fruitpunch.getDesc();
			InfoWindow.spec = thirstText + fruitpunch.getThirst() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Recovery")) {
			InfoWindow.type = "Recovery";
			InfoWindow.desc = recoverypotion.getDesc();
			InfoWindow.spec = healText + recoverypotion.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Hi-Recovery")) {
			InfoWindow.type = "Hi-Recovery";
			InfoWindow.desc = hirecoverypotion.getDesc();
			InfoWindow.spec = healText + hirecoverypotion.getHealth() + ".";
			InfoWindow.createWindow();
			return true;
		} else if (tempItem.equals("Anti-Plague")) {
			InfoWindow.type = "Recovery";
			InfoWindow.desc = plagueantidote.getDesc();
			InfoWindow.spec = "It cures a crew member.";
			InfoWindow.createWindow();
			return true;
		}
		return false;
	}
	
	/**
	 * Desc: A function that randomly selected an event (Alien's Pirate, Space Plague, and Asteroid belt) whenever a new day occurs.
	 */
	public static void randomEvent() {
		Random rand = new Random();
		number = rand.nextInt(3); // This randoms a number between 0 - 2.
		crew = rand.nextInt(getCrewStatus().size()); // This randoms a number between 0 to a total number of crews.
		anotherOne = rand.nextInt(getCrewStatus().size()); // This randoms a number between 0 - 1.
		damage = 25 ; //This is a quarter damage to the ship. But to the shield should be double.
		lost = rand.nextInt(30) + 10; //This randoms a number between 10 to 30.
		
		if (number == 0) {
			//This is an invasion by BillyTheKidzz's (Alien) pirates.
			if (getCrewItems().size() > 0) {
				nitem = rand.nextInt(getCrewItems().size()); // This randoms a number between 0 to a total number of items.
				BillyThekidzz.removeItem(getCrewItems().get(nitem));
				BillyThekidzz.updateMessage("BillyTheKidzz's pirate has boarded your ship! They stolen your " + getCrewItems().get(nitem) + " from inventory!");
				BillyThekidzz.updateButton("Ah shot, here we go again.");
				getCrewItems().remove(nitem);
				Game.items = "";
				for (int i=0; i<Game.getCrewItems().size(); i++) {
					Game.updateItems(Game.getCrewItems().get(i));
				}
				BillyThekidzz.createWindow();
			} else {
				if (getMoney() < lost) {
					BillyThekidzz.updateMessage("Poor thing! You do not have anything we can steal. Well, have a good day!");
					BillyThekidzz.updateButton("Ah shot, here we go again.");
					BillyThekidzz.createWindow();
				} else {
					updateMoney(getMoney()-lost);
					BillyThekidzz.updateMessage("Heck! You do not have any items! Well, I will steal some of your money! You have lost $" + lost + ".");
					BillyThekidzz.updateButton("Ah shot, here we go again.");
					BillyThekidzz.createWindow();
				}
			}
		} else if (number == 1) {
			//This is the Space Plague event
			if (anotherOne == 0) {
				if (getCrewStatus().get(crew).equals("Unhealthy")) {
					
					if (getCrewHealth().get(crew) <= 20) {
						removeCrew(getCrewName().get(crew));
						JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
					} else if (getCrewType().get(crew).equals("Absolute Unit")){
						getCrewHealth().set(crew, getCrewHealth().get(crew) - 10);
						JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 10 damage. Since, their type is Absolute Unit will takes only half the damage.", "Yikes", JOptionPane.WARNING_MESSAGE);
					} else {
						getCrewHealth().set(crew, getCrewHealth().get(crew) - 20);
						JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 20 damage", "Yikes", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					getCrewStatus().set(crew, "Unhealthy");
					JOptionPane.showMessageDialog(null, "One crew member has been affected by the Space Plague.", "MEDIC!!!", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				if (getCrewName().size() >= 2 && anotherOne != crew) {
					if (getCrewStatus().get(crew).equals("Unhealthy")) {
						if (getCrewHealth().get(crew) <= 20) {
							removeCrew(getCrewName().get(crew));
							JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
						} else if (getCrewType().get(crew).equals("Absolute Unit")){
							getCrewHealth().set(crew, getCrewHealth().get(crew) - 10);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 10 damage. Since, their type is Absolute Unit will takes only half the damage.", "Yikes", JOptionPane.WARNING_MESSAGE);
						} else {
							getCrewHealth().set(crew, getCrewHealth().get(crew) - 20);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 20 damage", "Yikes", JOptionPane.WARNING_MESSAGE);
						}
					} else if (getCrewStatus().get(anotherOne).equals("Unhealthy")) {
						if (getCrewHealth().get(anotherOne) <= 20) {
							removeCrew(getCrewName().get(anotherOne));
							JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
						} else if (getCrewType().get(anotherOne).equals("Absolute Unit")){
							getCrewHealth().set(anotherOne, getCrewHealth().get(anotherOne) - 10);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 10 damage. Since, their type is Absolute Unit will takes only half the damage.", "Yikes", JOptionPane.WARNING_MESSAGE);
						} else {
							getCrewHealth().set(anotherOne, getCrewHealth().get(anotherOne) - 20);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 20 damage", "Yikes", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						getCrewStatus().set(crew, "Unhealthy");
						getCrewStatus().set(anotherOne, "Unhealthy");
						JOptionPane.showMessageDialog(null, "One or more crew members has been affected by the Space Plague.", "MEDIC!!!", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (getCrewStatus().get(anotherOne).equals("Unhealthy")) {
						getCrewHealth().set(anotherOne, getCrewHealth().get(anotherOne) - 20);
						if (getCrewHealth().get(anotherOne) <= 20) {
							removeCrew(getCrewName().get(anotherOne));
							JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
						} else if (getCrewType().get(anotherOne).equals("Absolute Unit")){
							getCrewHealth().set(anotherOne, getCrewHealth().get(anotherOne) - 10);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 10 damage. Since, their type is Absolute Unit will takes only half the damage.", "Yikes", JOptionPane.WARNING_MESSAGE);
						} else {
							getCrewHealth().set(anotherOne, getCrewHealth().get(anotherOne) - 20);
							JOptionPane.showMessageDialog(null, "One of your crew member is still untreated, then they takes 20 damage", "Yikes", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						getCrewStatus().set(anotherOne, "Unhealthy");
						JOptionPane.showMessageDialog(null, "One crew member has been affected by the Space Plague.", "MEDIC!!!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		} else if (number == 2) {
			//This is the Asteroid Belt event.
			
			if (shield > 0) {
				shield -= damage * 2;
			} else {
				//If hull is less than or equal to damage then, the game is over.
				if (hull <= damage) {
					BillyThekidzz.updateMessage("I can see your Spaceship just blew up. I guess that it is over for you.");
					BillyThekidzz.updateButton("Defeated");
					BillyThekidzz.createWindow();
				} else {
					hull -= damage;
				}
			}
			ViewStatus.setSpaceshipHull(Integer.toString(hull));
			ViewStatus.setSpaceshipShield(Integer.toString(shield));
			JOptionPane.showMessageDialog(null, "Your spaceship flies through an Asteroid Belt!", "Spaceship has taken damage!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * A function that checks the crew member's attributes if they have enough energy to do an action.
	 * 
	 * @param tempName, a string variable that receives the crew's name
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean checkCrewMemberTiredness(String tempName) {
		int member = getCrewName().indexOf(tempName);
		if (!tempName.isEmpty()) {
			if (getCrewAction().get(member) == 0) {
				if (getCrewTiredness().get(member) >= 20 && getCrewHunger().get(member) >= 20 && getCrewThirst().get(member) >= 20) {
					getCrewTiredness().set(member, getCrewTiredness().get(member) - 20);
					getCrewHunger().set(member, getCrewHunger().get(member) - 20);
					getCrewThirst().set(member, getCrewThirst().get(member) - 20);
					getCrewAction().set(getCrewName().indexOf(tempName), 1);
					return true;
				} else {
					ViewStatus.setStatus(tempName + " is too tired.");
					return false;
				}
			} else {
				ViewStatus.setStatus(tempName + " has already taken an action for today.");
				return false;
			}
		} 
		ViewStatus.setStatus("Please select a crew member to do this action.");
		return false;
	}
	
	/**
	 * Desc: A function that reset the crew's tiredness after taken a sleep.
	 * @param tempName, a string variable that receives the crew's name.
	 * 
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean updateSleep(String tempName) {
		if (!tempName.isEmpty()) {
			if (getCrewName().contains(tempName) && getCrewAction().get(getCrewName().indexOf(tempName)) != 1) {
				if (getCrewTiredness().get(getCrewName().indexOf(tempName)) < 100) {
					getCrewTiredness().set(getCrewName().indexOf(tempName), 100);
					getCrewAction().set(getCrewName().indexOf(tempName), 1);
					ViewStatus.setTiredness(getCrewTiredness().get(getCrewName().indexOf(tempName)).toString());
					ViewStatus.setStatus(getCrewName().get(getCrewName().indexOf(tempName)) + " has slept and is fully awake!");
					return true;
				} else {
					getCrewAction().set(getCrewName().indexOf(tempName), 0);
					ViewStatus.setStatus(getCrewName().get(getCrewName().indexOf(tempName)) + " is still fully awake.");
					return false;
				}
			} else {
				ViewStatus.setStatus(getCrewName().get(getCrewName().indexOf(tempName)) + " has already taken an action for today.");
				return false;
			}
		} 
		
		ViewStatus.setStatus("Please select a crew member to do this action.");
		return false;
	}
	
	/**
	 * Desc: A function that repairs the spaceship
	 * @param tempName, a string variable that receives the crew's name to do this action.
	 */
	public static void Repair(String tempName) {
		
		if (hull < (repairEfficiency * Repairer.getEfficiency()) && shield < (repairEfficiency * Repairer.getEfficiency()) && getCrewName().contains(tempName) && getCrewType().get(getCrewName().indexOf(tempName)).equals("Repairer")) {
			hull += (repairEfficiency * Repairer.getEfficiency());
			shield += (repairEfficiency * Repairer.getEfficiency());
			if (hull > 100) {
				hull = (repairEfficiency * 2);
			}
			if (shield > 100) {
				shield = (repairEfficiency * 2);
			}
		} else if (hull >= (repairEfficiency * Repairer.getEfficiency()) && shield >= repairEfficiency * Repairer.getEfficiency() && getCrewName().contains(tempName) && getCrewType().get(getCrewName().indexOf(tempName)).equals("Repairer")) {
			hull = repairEfficiency * 2;
			shield = repairEfficiency * 2;
		} else {
			hull += repairEfficiency;
			shield += repairEfficiency;
			if (hull > 100) {
				hull = repairEfficiency * 2;
			} 
			if (shield > 100) {
				shield = repairEfficiency * 2;
			}
		}
		
		ViewStatus.setSpaceshipShield(Integer.toString(shield));
		ViewStatus.setStatus("The Spaceship has been successfully repaired.");
	}
	
	/**
	 * Desc: A function that heals a crew member from a medic member.
	 * @param tempName, a string variable that receives the crew's name.
	 */
	public static void heal(String tempName) {
		int member = getCrewName().indexOf(tempName);
		getCrewHealth().set(member, 100);
		getCrewStatus().set(member, "Healthy");
		MedicRoom.updateMessage(tempName + " is now healthy and fully healed!");
	}
	
	/**
	 * Desc: A function that feeds a crew member from a selected item.
	 * @param tempItem, a string variable receives the item's name.
	 * @param tempName, a string variable receives the crew's name.
	 * 
	 * @return Returns true if one of these conditions is met. Otherwise, returns false.
	 */
	public static boolean feed(String tempItem, String tempName) {
		int member = getCrewName().indexOf(tempName);

		if (getCrewAction().get(member) == 0) {
			//System.out.println(getCrewAction().get(member));
			if (tempItem.equals("Beef Jerky")) {
				if (getCrewHunger().get(member) < 100 || getCrewHealth().get(member) < 100) {
					if (getCrewHunger().get(member) + beefjerky.getHunger() < 100) {
						getCrewHunger().set(member, getCrewHunger().get(member) + beefjerky.getHunger());
					} else {
						getCrewHunger().set(member, 100);
					} 
					
					if (getCrewHealth().get(member) + beefjerky.getHealth() < 100) {
						getCrewHealth().set(member, getCrewHealth().get(member) + beefjerky.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not hungry yet.");
					return false;
				}
				
			} else if (tempItem.equals("Deluxe Set")) { 
				if (getCrewHunger().get(member) < 100 || getCrewThirst().get(member) < 100 || getCrewHealth().get(member) < 100) {
					if (getCrewHunger().get(member) + deluxeset.getHunger() < 100) {
						getCrewHunger().set(member, getCrewHunger().get(member) + deluxeset.getHunger());
					} else {
						getCrewHunger().set(member, 100);
					} 
					
					if (getCrewThirst().get(member) + deluxeset.getThirst() < 100) {
						getCrewThirst().set(member, getCrewThirst().get(member) + deluxeset.getThirst());
					} else {
						getCrewThirst().set(member, 100);
					}
					
					if (getCrewHealth().get(member) + deluxeset.getHealth() < 100) {
						getCrewHealth().set(member, getCrewHealth().get(member) + deluxeset.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not hungry/thirsty yet.");
					return false;
				}
			} else if (tempItem.equals("Steak Set")) {
				if (getCrewHunger().get(member) < 100 || getCrewThirst().get(member) < 100 || getCrewHealth().get(member) < 100) {
					if (getCrewHunger().get(member) + steakset.getHunger() < 100) {
						getCrewHunger().set(member, getCrewHunger().get(member) + steakset.getHunger());
					} else {
						getCrewHunger().set(member, 100);
					} 
					
					if (getCrewThirst().get(member) + steakset.getThirst() < 100) {
						getCrewThirst().set(member, getCrewThirst().get(member) + steakset.getThirst());
					} else {
						getCrewThirst().set(member, 100);
					}
					
					if (getCrewHealth().get(member) + steakset.getHealth() < 100) {
						getCrewHealth().set(member, getCrewHealth().get(member) + steakset.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not hungry/thirsty yet.");
					return false;
				}
			} else if (tempItem.equals("French Fries")) {
				if (getCrewHunger().get(member) < 100 || getCrewHealth().get(member) < 100) {
					if (getCrewHunger().get(member) + frenchfries.getHunger() < 100) {
						getCrewHunger().set(member, getCrewHunger().get(member) + frenchfries.getHunger());
					} else {
						getCrewHunger().set(member, 100);
					} 
					
					if (getCrewHealth().get(member) + frenchfries.getHealth() < 100) {
						getCrewHealth().set(member, getCrewHealth().get(member) + frenchfries.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not hungry yet.");
					return false;
				}
			} else if (tempItem.equals("Spicy Water")) {
				if (getCrewThirst().get(member) < 100) {
					if (getCrewThirst().get(member) + spicywater.getThirst() < 100) {
						getCrewThirst().set(member, getCrewThirst().get(member) + spicywater.getThirst());
					} else {
						getCrewThirst().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not thirsty yet.");
					return false;
				}
			} else if (tempItem.equals("Fruit Punch")) {
				if (getCrewThirst().get(member) < 100) {
					if (!(getCrewThirst().get(member) + fruitpunch.getThirst() >= 100)) {
						getCrewThirst().set(member, getCrewThirst().get(member) + fruitpunch.getThirst());
					} else {
						getCrewThirst().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are not thirsty yet.");
					return false;
				}
			} else if (tempItem.equals("Recovery")) {
				if (getCrewHealth().get(member) < 100) {
					if (!(getCrewHealth().get(member) + recoverypotion.getHealth() >= 100)) {
						getCrewHealth().set(member, getCrewHealth().get(member) + recoverypotion.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are still at full health");
					return false;
				}
			} else if (tempItem.equals("Hi-Recovery")) {
				if (getCrewHealth().get(member) < 100) {
					if (!(getCrewHealth().get(member) + hirecoverypotion.getHealth() >= 100)) {
						getCrewHealth().set(member, getCrewHealth().get(member) + hirecoverypotion.getHealth());
					} else {
						getCrewHealth().set(member, 100);
					}
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are still at full health.");
					return false;
				}
			} else if (tempItem.equals("Anti-Plague")) {
				if (!(getCrewStatus().get(member).equals("Healthy"))) {
					getCrewStatus().set(member, "Healthy");
					DiningRoom.updateMessage("Successfully consumed.");
					getCrewItems().remove(tempItem);
					getCrewAction().set(member, 1);
					return true;
				} else {
					DiningRoom.updateMessage("You are already healthy!");
					return false;
				}
			} 
		} 
		DiningRoom.updateMessage(tempName + " has already taken an action for today.");
		
		return false;
	}
	
	/**
	 * A function that removes the crew's attributes whenever they died.
	 * @param tempName, removes the crew's attributes under their name.
	 * @return Returns true if it is succeeded removed the crew's attributes.
	 */
	public static boolean removeCrew(String tempName) {
		int member = getCrewName().indexOf(tempName);
		getCrewName().remove(member);
		getCrewType().remove(member);
		getCrewHealth().remove(member);
		getCrewThirst().remove(member);
		getCrewStatus().remove(member);
		getCrewAction().remove(member);
		getCrewHunger().remove(member);
		getCrewTiredness().remove(member);
		return true;
	}
	
	/**
	 * Desc: A function that randomly generates the planet before the crew able to go on expedition.
	 * 
	 * @param generate, an integer variable that receives a random number for the planet generator.
	 */
	public static void randomPlanetGenerator(int generate) {
		Random rand = new Random();
		int money = rand.nextInt(50); 
		int food = rand.nextInt(Shop.getFoodItems().size()-1);
		int medic = rand.nextInt(Shop.getMedicItems().size()-1);
		money += 10; 		
		if (generate == 4) {
			updatePieces(1); 
			updateMoney(money + getMoney());
			if (getCrewItems().size() < 10) {
				getCrewItems().add(Shop.getFoodItems().get(food));
				getCrewItems().add(Shop.getMedicItems().get(medic));
				updateItems(Shop.getFoodItems().get(food));
				updateItems(Shop.getMedicItems().get(medic));
				JOptionPane.showMessageDialog(null, "You found a missing transport part, " + "$" + money + ", " + Shop.getFoodItems().get(food) + ", and " + Shop.getMedicItems().get(medic) + "!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You found a missing transport part, " + "$" + money + ", " + Shop.getFoodItems().get(food) + ", and " + Shop.getMedicItems().get(medic) + "! But, it looks like your inventory is full.", "Congratulations! Kinda.", JOptionPane.INFORMATION_MESSAGE);
			}
			currentPieces += 1;
			score += 1000;
			

		} else if (generate == 3) {
			updatePieces(1);
			updateMoney(money + getMoney());
			currentPieces += 1;
			score += 500;
			JOptionPane.showMessageDialog(null, "You found a missing transport part, " + "and $" + money + "!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);

		} else if (generate == 2) {
			if (getCrewItems().size() < 10) {
				getCrewItems().add(Shop.getFoodItems().get(food));
				getCrewItems().add(Shop.getMedicItems().get(medic));
				updateItems(Shop.getFoodItems().get(food));
				updateItems(Shop.getMedicItems().get(medic));
				JOptionPane.showMessageDialog(null, "You found " + Shop.getFoodItems().get(food) + " and " + Shop.getMedicItems().get(medic) + "!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
			} else { 
				JOptionPane.showMessageDialog(null, "You found " + Shop.getFoodItems().get(food) + " and " + Shop.getMedicItems().get(medic) + "! But, It looks like your inventory is full.", "Congratulations! Kinda.", JOptionPane.INFORMATION_MESSAGE);
			}
			score += 500;

		} else if (generate == 1) {
			if (getCrewItems().size() < 10) {
				getCrewItems().add(Shop.getFoodItems().get(food));
				updateItems(Shop.getFoodItems().get(food));
				JOptionPane.showMessageDialog(null, "You found " + Shop.getFoodItems().get(food) + "!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
			} else { 
				JOptionPane.showMessageDialog(null, "You found " + Shop.getFoodItems().get(food) + "! But, It looks like your inventory is full.", "Congratulations! Kinda.", JOptionPane.INFORMATION_MESSAGE);
			}
			score += 250;

		}else if (generate == 0) {
			updatePieces(1);
			currentPieces += 1;
			score += 250;
			JOptionPane.showMessageDialog(null, "You found a missing transport part!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (currentPieces == findPieces) {
			BillyThekidzz.updateMessage("It looks like you found every single pieces for your transport ship! Congratulations and farewell!");
			BillyThekidzz.updateButton("Victory");
			BillyThekidzz.createWindow();
		}
	}
	/*
	 * Desc: A function that discount the price in the shop, unless there is a barterer.
	 */
	public static double discount(double tempItem) {
		return tempItem * 0.1;
	}
	
	/**
	 * A getter function that returns the crew's tiredness level list.
	 * @return a list of crew's tiredness.
	 */
	public static ArrayList<Integer> getCrewTiredness() {
		return crewTiredness;
	}
	
	/**
	 * Desc: A function that tells the user how many addtional for their crew requirement before they confirm.
	 * @return Returns the total amount of additonal crew requirement for the user's team.
	 */
	public static int getAdditionalCrewRequirement() {
		return count - (getCrewName().size()) ;
	}
	
	/**
	 * Desc: A function verify the user's team is met the requirement for the number of members on their team.
	 * @return Returns true if the user added to the total of members requirement on their team. Otherwise, returns false.
	 */
	public static boolean confirmVerification() {
		if (current < count) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Desc: A getter function that returns the player's current money
	 * @return Returns player's current money.
	 */
	public static double getMoney() {
		return money;
	}
	
	/**
	 * Desc: A function that iterates through the player's items and added into item variable.
	 * @return Returns items of the player's items.
	 */
	public static String getItems() {
		return items;
	}
	
	/**
	 * An update funciton that keep up with the current crew's items
	 * @param item, a string type variable that receives the items whenever it get changed/added into the crew's item list.
	 */
	public static void updateItems(String item) {
		if (items.isEmpty()) {
			items += item;
		} else {
			items += ", " + item;
		}
	}
	
	/**
	 * Desc: Change the current money after add/subtract the incomes
	 * @param tempMoney, a double variable that receives the updated money.
	 */
	public static void updateMoney(double tempMoney) {
		money = tempMoney;
		ViewStatus.setMoney(Double.toString(money));
	}
	
	/**
	 * Desc: A function that resets the current number of crews
	 */
	public static void resetCurrent() {
		current = 1;
	}
	
	/**
	 * Desc: A getter function that returns the Spaceship's current hull durability
	 * @return Returns its current hull durability.
	 */
	public static int getHull() {
		return hull;
	}
	
	/**
	 * A getter function that returns the total days of cooldown on the Tactical Jump on the Spaceship.
	 * @return how many days left until they can use the Tactical Jump again.
	 */
	public static int getCooldown() {
		return cooldown;
	}
	
	/**
	 * A setter function that sets the cooldown for the Tactical Jump on the Spaceship whenever it has been used for 2 days.
	 */
	public static void setCooldown() {
		cooldown = 2;
	}
	
	/**
	 * Desc: An update function that reduces the time taken each time they go to the next day before they can use the Tactical Jump again.
	 */
	public static void updateCooldown() {
		cooldown -= 1;
	}
	
	/**
	 * A getter function that returns the string type list of crew's items.
	 * @return a list of crew's items.
	 */
	public static ArrayList<String> getCrewItems() {
		return crewItems;
	}
	
	/**
	 * A getter function that returns how many pieces they need to find for the missing transport parts
	 * @return the current pieces need to be found.
	 */
	public static int getPieces() {
		return pieces;
	}
	
	/**
	 * A update function each time the crew members managed to find the missing transport parts.
	 * @param tempPiece, a int type variable that receives how many parts did the crew members find.
	 */
	public static void updatePieces(int tempPiece) {
		pieces -= tempPiece;
	}
	/**
	 * Desc: A getter function that returns the Spaceship's current shield durability
	 * @return Returns its current shield durability.
	 */
	public static int getShield() {
		return shield;
	}
	
	/**
	 * A getter function that returns the crew's action
	 * @return the crew's action
	 */
	public static ArrayList<Integer> getCrewAction() {
		return crewAction;
	}
	
	/**
	 * Desc: A getter function that returns the crew's name list
	 * @return Returns the crew's name list
	 */
	public static ArrayList<String> getCrewName() {
		return crewName;
	}
	
	/**
	 * Desc: A getter function that returns the crew's type list
	 * @return Returns the crew's type list.
	 */
	public static ArrayList<String> getCrewType() {
		return crewType;
	}
	
	/**
	 * Desc: A getter function that returns the crew's health list
	 * @return Returns the crew's health list.
	 */
	public static ArrayList<Integer> getCrewHealth() {
		return crewHealth;
	}
	
	/**
	 * Desc: A getter function that returns the crew's hunger list
	 * @return Returns the crew's hunger list.
	 */
	public static ArrayList<Integer> getCrewHunger() {
		return crewHunger;
	}
	
	/**
	 * Desc: A getter function that returns the crew's thirst list
	 * @return Returns the crew's thirst list.
	 */
	public static ArrayList<Integer> getCrewThirst() {
		return crewThirst;
	}
	
	/**
	 * Desc: A function that verifies that the user does input a correct format before adding a crew into the team.
	 * @param nameCheck, a variable that receives the user's input for crew's name.
	 * @param typeCheck, a variable that receives the user's input for crew's type.
	 * @return Returns true if the verification is met. Otherwise, returns false.
	 */
	public static boolean crewInfoVerification(String nameCheck, String typeCheck) {
		if (nameCheck.isEmpty() || typeCheck.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Desc: A function that resets the crew's count, day, and crew's team name.
	 */
	public static void reset() {
		count = 0;
		day = 0;
		name = null;
		typeName = null;
	}
	
	/**
	 * Desc: A function that resets the information about crew team
	 */
	public static void resetCrew() {
		resetCurrent();
		getCrewName().clear();
		getCrewType().clear();
		getCrewHealth().clear();
		getCrewThirst().clear();
		getCrewStatus().clear();
		getCrewAction().clear();
		getCrewHunger().clear();
		getCrewTiredness().clear();
	}
	
	/**
	 * A function that returns the string type list for crew status.
	 * @return the crew status.
	 */
	public static ArrayList<String> getCrewStatus() {
		return crewStatus;
	}
	
	/**
	 * Desc: A function that initializes the game.
	 * @param args, initializes the game.
	 */
	public static void main(String[] args) {
		SelectWindow.createWindow();
	}
}
