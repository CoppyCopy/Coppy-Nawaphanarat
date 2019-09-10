package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * Desc: A pilot room
 * @author sna134 and cyh27
 *
 */

public class PilotRoom {
	/**
	 * A string type variable that initializes the current planet they are on.
	 */
	private static String currentPlanet = "Earth";
	/**
	 * An int type variable that stores the random number for the random planet generator.
	 */
	private static int num;
	/**
	 * A string type list that stores the planet that the crew members already been on.
	 */
	private static ArrayList<String> travelledPlanet = new ArrayList<String>();
	private JFrame frmPilotRoom;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PilotRoom window = new PilotRoom();
					window.frmPilotRoom.setVisible(true);
					window.frmPilotRoom.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PilotRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPilotRoom = new JFrame();
		frmPilotRoom.setTitle("Pilot Room");
		frmPilotRoom.setBounds(100, 100, 450, 439);
		frmPilotRoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPilotRoom.getContentPane().setLayout(null);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(31, 300, 382, 62);
		frmPilotRoom.getContentPane().add(lblStatus);
		
		JComboBox<String> cbPilot1 = new JComboBox<String>();
		cbPilot1.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbPilot1.setBounds(262, 137, 151, 24);
		frmPilotRoom.getContentPane().add(cbPilot1);
		
		JComboBox<String> cbPilot2 = new JComboBox<String>();
		cbPilot2.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbPilot2.setBounds(262, 183, 151, 24);
		frmPilotRoom.getContentPane().add(cbPilot2);
		
		JComboBox<String> cbSearchMember = new JComboBox<String>();
		cbSearchMember.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbSearchMember.setBounds(262, 237, 151, 24);
		frmPilotRoom.getContentPane().add(cbSearchMember);
		
		for (int i=0; i<Game.getCrewAction().size(); i++) {
			if (Game.getCrewAction().get(i) != 1) {
				cbPilot1.addItem(Game.getCrewName().get(i));
				cbPilot2.addItem(Game.getCrewName().get(i));
				cbSearchMember.addItem(Game.getCrewName().get(i));
			}
		}
		
		JLabel lblCurrentPlanet = new JLabel("Current planet: " + currentPlanet);
		lblCurrentPlanet.setBounds(31, 210, 382, 15);
		frmPilotRoom.getContentPane().add(lblCurrentPlanet);
		
		JLabel lblChooseFirstPilot = new JLabel("Choose first pilot:");
		lblChooseFirstPilot.setBounds(31, 142, 191, 15);
		frmPilotRoom.getContentPane().add(lblChooseFirstPilot);
		
		JLabel lblChooseSecondPilot = new JLabel("Choose second pilot:");
		lblChooseSecondPilot.setBounds(31, 188, 191, 15);
		frmPilotRoom.getContentPane().add(lblChooseSecondPilot);
		
		JLabel lblPartLeft = new JLabel("Part pieces left to find: " + Game.getPieces() + "/" + (Game.day * 2)/3);
		lblPartLeft.setBounds(31, 110, 352, 15);
		frmPilotRoom.getContentPane().add(lblPartLeft);
		
		JComboBox<String> cbPlanet = new JComboBox<String>();
		cbPlanet.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Mernus", "Sacuranus", "Humongousaturn", "Koolest Krab", "MonkaS", "Gavinong", "OMEGALUL", "SENG201 Final"}));
		cbPlanet.setBounds(261, 25, 151, 24);
		frmPilotRoom.getContentPane().add(cbPlanet);
		
		JLabel lblSelectAPlanet = new JLabel("Select a planet to travel:");
		lblSelectAPlanet.setBounds(31, 30, 191, 15);
		frmPilotRoom.getContentPane().add(lblSelectAPlanet);
		
		JLabel lblNewLabel = new JLabel("Use Tactical Jump?");
		lblNewLabel.setBounds(31, 76, 196, 15);
		frmPilotRoom.getContentPane().add(lblNewLabel);
		
		JComboBox<String> cbTacJump = new JComboBox<String>();
		cbTacJump.setModel(new DefaultComboBoxModel<String>(new String[] {"No", "Yes"}));
		cbTacJump.setBounds(326, 71, 86, 24);
		frmPilotRoom.getContentPane().add(cbTacJump);
		
		JLabel lblScores = new JLabel("Scores: " + Game.score);
		lblScores.setBounds(31, 273, 352, 15);
		frmPilotRoom.getContentPane().add(lblScores);
		
		JButton btnTravel = new JButton("Travel");
		btnTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cbPlanet.getSelectedItem().equals("")) {
					if (Game.searched == 1) {
						if (!travelledPlanet.contains(cbPlanet.getSelectedItem().toString())) {
							if (!(cbPilot1.getSelectedItem() == null) || !(cbPilot2.getSelectedItem() == null)) {
								if (!cbPilot1.getSelectedItem().toString().equals(cbPilot2.getSelectedItem().toString()) && !cbPilot2.getSelectedItem().toString().equals(cbPilot1.getSelectedItem().toString()) && !cbPilot1.getSelectedItem().toString().isEmpty() && !cbPilot2.getSelectedItem().toString().isEmpty()) {
									currentPlanet = cbPlanet.getSelectedItem().toString();
									if (cbTacJump.getSelectedItem().equals("Yes")) {
										if (Game.getCrewType().contains("Tactical Commander")) {
											if (Game.getCooldown() == 0) {
												if (Game.checkCrewMemberTiredness(cbPilot1.getSelectedItem().toString()) == true && Game.checkCrewMemberTiredness(cbPilot2.getSelectedItem().toString()) == true) {
													Game.setCooldown();
													Game.getCrewAction().set(Game.getCrewName().indexOf(cbPilot1.getSelectedItem().toString()), 1);
													Game.getCrewAction().set(Game.getCrewName().indexOf(cbPilot2.getSelectedItem().toString()), 1);
													cbPilot1.removeAllItems();
													cbPilot2.removeAllItems();
													cbSearchMember.removeAllItems();
													for (int i=0; i<Game.getCrewAction().size(); i++) {
														if (Game.getCrewAction().get(i) != 1) {
															cbPilot1.addItem(Game.getCrewName().get(i));
															cbPilot2.addItem(Game.getCrewName().get(i));
															cbSearchMember.addItem(Game.getCrewName().get(i));
														}
													}
													Game.searched = 0;
													Game.travelled = 0;
													travelledPlanet.add(currentPlanet);
													lblCurrentPlanet.setText("Current Planet: " + currentPlanet);
													lblStatus.setText("<html>Status: Successfully travelled without incident.</html>");
													Random rand = new Random();
													int generate = rand.nextInt(5); //This random a number between 0 and 4;
													if ((generate == 4 || generate == 3) && Game.getCrewType().contains("Scavenger")) {
														num = generate;
														lblStatus.setText("<html>Status: There is a missing transport part in this planet! Better search the planet!</html>");
													} else {
														num = generate;
													}
												} else {
													lblStatus.setText("<html>Status: One of your pilots is tired</html>");
												}
											} else {
												lblStatus.setText("<html>Status: You still need to wait for another " + Game.getCooldown() + " day(s) to use the Tactical Jump again.</html>");
												Game.updateCooldown();
											}
										} else {
											lblStatus.setText("<html>Status: You need a Tactical Commander to do Tactical Jump!</html>");
										}
									} else {
										if (Game.checkCrewMemberTiredness(cbPilot1.getSelectedItem().toString()) == true && Game.checkCrewMemberTiredness(cbPilot2.getSelectedItem().toString()) == true) {
											Game.randomEvent();
											Game.getCrewAction().set(Game.getCrewName().indexOf(cbPilot1.getSelectedItem().toString()), 1);
											Game.getCrewAction().set(Game.getCrewName().indexOf(cbPilot2.getSelectedItem().toString()), 1);
											cbPilot1.removeAllItems();
											cbPilot2.removeAllItems();
											cbSearchMember.removeAllItems();
											cbPilot1.addItem("");
											cbPilot2.addItem("");
											cbSearchMember.addItem("");
											for (int i=0; i<Game.getCrewAction().size(); i++) {
												if (Game.getCrewAction().get(i) != 1) {
													cbPilot1.addItem(Game.getCrewName().get(i));
													cbPilot2.addItem(Game.getCrewName().get(i));
													cbSearchMember.addItem(Game.getCrewName().get(i));
												}
											}
											Game.searched = 0;
											Game.travelled = 0;
											travelledPlanet.add(currentPlanet);
											lblCurrentPlanet.setText("Current Planet: " + currentPlanet);
											lblStatus.setText("Status: Successfully travelled.");
											Random rand = new Random();
											int generate = rand.nextInt(5); //This random a number between 0 and 4;
											if ((generate == 4 || generate == 3) && Game.getCrewType().contains("Scavenger")) {
												num = generate;
												lblStatus.setText("<html>Status: There is a missing transport part in this planet! Better search the planet!</html>");
											} else {
												num = generate;
											}
										} else {
											lblStatus.setText("<html>Status: One of your pilots is tired</html>");
										}
									}
								} else {
									lblStatus.setText("<html>Status: You cannot have the same crew member pilot the Spaceship or you have not selected a crew member for each pilot station!</html>");
								}
							} else {
								lblStatus.setText("<html>Status: It looks like most of your crew members are already taken an action. Go on to the next day to recovers their actions.</html>");
							}
						} else {
							lblStatus.setText("<html>Status: You already been to this planet before.</html>");
						}
					} else {
						lblStatus.setText("<html>Status: You forgot to search before you left the planet!</html>");
					}
				} else {
					lblStatus.setText("<html>Status: You have yet to select any planet to travel.</html>");
				}
				
				if (Game.getCrewName().size() == 0) {
					BillyThekidzz.updateMessage("It seems I do not detect any life source from your Spaceship anymore. Are they all dead? It looks like they are.");
					BillyThekidzz.updateButton("Defeated");
					BillyThekidzz.createWindow();
				}
			}
		});
		btnTravel.setBounds(31, 374, 114, 25);
		frmPilotRoom.getContentPane().add(btnTravel);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LobbyRoom.createWindow();
				frmPilotRoom.dispose();
			}
		});
		btnGoBack.setBounds(299, 374, 114, 25);
		frmPilotRoom.getContentPane().add(btnGoBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cbSearchMember.getSelectedItem().toString().isEmpty()) {
					if (Game.travelled == 0 && Game.getCrewAction().get(Game.getCrewName().indexOf(cbSearchMember.getSelectedItem().toString())) == 0) {
						if (Game.checkCrewMemberTiredness(cbSearchMember.getSelectedItem().toString()) == true) {
							if (cbPlanet.getSelectedItem().toString().equals("SENG201 Final")) {
								if (Game.searched == 0) {
									Game.randomPlanetGenerator(num);
									Game.searched = 1;
									Game.travelled = 1;
									Game.getCrewAction().set(Game.getCrewName().indexOf(cbSearchMember.getSelectedItem()), 1);
									lblPartLeft.setText("Part pieces left to find: " + Game.getPieces() + "/" + (Game.day * 2)/3);
									cbPilot1.removeAllItems();
									cbPilot2.removeAllItems();
									cbSearchMember.removeAllItems();
									cbPilot1.addItem("");
									cbPilot2.addItem("");
									cbSearchMember.addItem("");
									for (int i=0; i<Game.getCrewAction().size(); i++) {
										if (Game.getCrewAction().get(i) != 1) {
											cbPilot1.addItem(Game.getCrewName().get(i));
											cbPilot2.addItem(Game.getCrewName().get(i));
											cbSearchMember.addItem(Game.getCrewName().get(i));
										}
									}
									lblScores.setText("Scores: " + Game.score);
									BillyThekidzz.updateMessage("HA! You thought you can find the answers for this year's SENG201 final exam, but there is none!");
									BillyThekidzz.updateButton(":(");
									BillyThekidzz.createWindow();
								} else {
									lblStatus.setText("Status: You already searched on this planet!");
								}
							} else {
								if (Game.searched == 0) {
									Game.randomPlanetGenerator(num);
									Game.searched = 1;
									Game.travelled = 1;
									Game.getCrewAction().set(Game.getCrewName().indexOf(cbSearchMember.getSelectedItem()), 1);
									lblPartLeft.setText("Part pieces left to find: " + Game.getPieces() + "/" + (Game.day * 2)/3);
									cbPilot1.removeAllItems();
									cbPilot2.removeAllItems();
									cbSearchMember.removeAllItems();
									cbPilot1.addItem("");
									cbPilot2.addItem("");
									cbSearchMember.addItem("");
									for (int i=0; i<Game.getCrewAction().size(); i++) {
										if (Game.getCrewAction().get(i) != 1) {
											cbPilot1.addItem(Game.getCrewName().get(i));
											cbPilot2.addItem(Game.getCrewName().get(i));
											cbSearchMember.addItem(Game.getCrewName().get(i));
										}
									}
									lblScores.setText("Scores: " + Game.score);
								} else {
									lblStatus.setText("Status: You already searched on this planet!");
								}
							}
						} else {
							lblStatus.setText("<html>Status: Your search member is too tired.</html>");
						}
					} else {
						lblStatus.setText("Status: You need to travel to a new planet first!");
					}
				} else {
					lblStatus.setText("<html>Status: You have yet to select any crew member to search the planet.</html>");
				}
			}
		});
		btnSearch.setBounds(170, 374, 104, 25);
		frmPilotRoom.getContentPane().add(btnSearch);
		
		JLabel lblChooseASearch = new JLabel("Choose a search member:");
		lblChooseASearch.setBounds(31, 240, 212, 15);
		frmPilotRoom.getContentPane().add(lblChooseASearch);
	}
}
