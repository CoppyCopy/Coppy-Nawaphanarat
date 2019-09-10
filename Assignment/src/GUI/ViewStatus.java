package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

public class ViewStatus {
	public static String healthStatus = "", tiredness = "", name = "", health = "", type = "", hunger = "", thirst = "", currentMoney = "", spaceShipName = "", spaceShipHull = "", spaceShipShield = "", crewName = "", status = "Healthy";
	private JFrame frmCrewTeamInformation;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatus window = new ViewStatus();
					window.frmCrewTeamInformation.setVisible(true);
					window.frmCrewTeamInformation.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCrewTeamInformation = new JFrame();
		frmCrewTeamInformation.setTitle("Crew team information");
		frmCrewTeamInformation.setBounds(100, 100, 425, 441);
		frmCrewTeamInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCrewTeamInformation.getContentPane().setLayout(null);
		
		JLabel lblSelectYourCrew = new JLabel("Select your crew:");
		lblSelectYourCrew.setBounds(39, 39, 127, 15);
		frmCrewTeamInformation.getContentPane().add(lblSelectYourCrew);
		
		JLabel lblName = new JLabel("   Name:");
		lblName.setBounds(39, 93, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblName);
		
		JLabel lblType = new JLabel("    Type:");
		lblType.setBounds(39, 115, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblType);
		
		JLabel lblHealth = new JLabel(" Health:");
		lblHealth.setBounds(39, 142, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblHealth);
		
		JLabel lblHunger = new JLabel("Hunger:");
		lblHunger.setBounds(39, 158, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblHunger);
		
		JLabel lblThirst = new JLabel("   Thirst:");
		lblThirst.setBounds(39, 185, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblThirst);
		
		JLabel lblCurrentMoney = new JLabel("   Current Money: " + currentMoney);
		lblCurrentMoney.setBounds(39, 66, 195, 15);
		frmCrewTeamInformation.getContentPane().add(lblCurrentMoney);
		
		JComboBox<String> cbViewCrew = new JComboBox<String>();
		cbViewCrew.setBounds(229, 34, 127, 24);
		cbViewCrew.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		for (int i=0; i<Game.getCrewName().size(); i++) {
			cbViewCrew.addItem(Game.getCrewName().get(i));
		}
		frmCrewTeamInformation.getContentPane().add(cbViewCrew);
		
		JLabel lblSpaceshipStatus = new JLabel("Spaceship (" + spaceShipName + ") status:");
		lblSpaceshipStatus.setBounds(39, 284, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblSpaceshipStatus);
		
		JLabel lblHull = new JLabel("      Hull: " + spaceShipHull);
		lblHull.setBounds(39, 309, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblHull);
		
		JLabel lblShield = new JLabel("  Shield:" + spaceShipShield);
		lblShield.setBounds(39, 334, 317, 15);
		frmCrewTeamInformation.getContentPane().add(lblShield);
		
		JLabel lblHealthStatus = new JLabel("Health Status: ");
		lblHealthStatus.setBounds(37, 235, 355, 15);
		frmCrewTeamInformation.getContentPane().add(lblHealthStatus);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrewTeamInformation.dispose();
				LobbyRoom.createWindow();
			}
		});
		btnGoBack.setBounds(278, 361, 114, 25);
		frmCrewTeamInformation.getContentPane().add(btnGoBack);
		
		JLabel lblTiredness = new JLabel("Tiredness:");
		lblTiredness.setVerticalAlignment(SwingConstants.TOP);
		lblTiredness.setBounds(27, 212, 337, 15);
		frmCrewTeamInformation.getContentPane().add(lblTiredness);
		
		JLabel lblCrewTeamName = new JLabel("Crew team name: " + crewName);
		lblCrewTeamName.setBounds(41, 12, 337, 15);
		frmCrewTeamInformation.getContentPane().add(lblCrewTeamName);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(12, 253, 401, 24);
		frmCrewTeamInformation.getContentPane().add(lblStatus);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.viewCrew(cbViewCrew.getSelectedItem().toString()) == true) {
					lblName.setText("   Name: " + name);
					lblType.setText("    Type: " + type);
					lblHealth.setText(" Health: " + health);
					lblHunger.setText("Hunger: " + hunger);
					lblThirst.setText("   Thirst: " + thirst);
					lblTiredness.setText("Tiredness: " + tiredness);
					lblHealthStatus.setText("Health Status: " + healthStatus);
					lblStatus.setText("Status: ");
				} else {
					lblStatus.setText("<html>Status: Please select a crew member to view their attributes</html>");
				}
			}
		});
		btnView.setBounds(263, 70, 93, 25);
		frmCrewTeamInformation.getContentPane().add(btnView);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.updateSleep(cbViewCrew.getSelectedItem().toString()) == true) {
						lblStatus.setText("Status: " + status);
						lblTiredness.setText("Tiredness: " + tiredness);
				} else {
					lblStatus.setText("<html>Status: " + status + "</html>");
				}
			}
		});
		btnSleep.setBounds(39, 361, 88, 25);
		frmCrewTeamInformation.getContentPane().add(btnSleep);
		
		JButton btnNewButton = new JButton("Repair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbViewCrew.getSelectedItem().toString().isEmpty()) {
					ViewStatus.setStatus("Please select a crew member to do this action.");
				} else if (Game.getHull() < 100 || Game.getShield() < 100) {
					if (Game.checkCrewMemberTiredness(cbViewCrew.getSelectedItem().toString()) == true) {
							Game.Repair(cbViewCrew.getSelectedItem().toString());
							lblHull.setText("      Hull: " + spaceShipHull);
							lblShield.setText("  Shield: " + spaceShipShield);
							lblStatus.setText("<html>Status: " + status + "</html>");
					} else {
						lblStatus.setText("<html>Status: " + cbViewCrew.getSelectedItem().toString() + " has already taken an action for today.</html>");
					}
				} else {
					lblStatus.setText("<html>Status: The Spaceship is already at full durability.</html>");
				}
			}
		});
		btnNewButton.setBounds(165, 361, 80, 25);
		frmCrewTeamInformation.getContentPane().add(btnNewButton);
	}
	
	public static void setCrewStatus(String tempStatus) {
		healthStatus = tempStatus;
	}
	
	public static void setCrewName(String tempName) {
		crewName = tempName;
	}
	
	public static void setName(String tempName) {
		name = tempName;
	}
	
	public static void setType(String tempType) {
		type = tempType;
	}
	
	public static void setHealth(String tempHealth) {
		health = tempHealth;
	}
	
	public static void setThirst(String tempThirst) {
		thirst = tempThirst;
	}
	
	public static void setHunger(String tempHunger) {
		hunger = tempHunger;
	}
	
	public static void setMoney(String tempMoney) {
		currentMoney = tempMoney;
	}
	
	public static void setSpaceshipName(String tempName) {
		spaceShipName = tempName;
	}
	
	public static void setSpaceshipHull(String tempHull) {
		spaceShipHull = tempHull;
	}
	
	public static void setTiredness(String tempTired) {
		tiredness = tempTired;
	}
	
	public static void setSpaceshipShield(String tempShield) {
		spaceShipShield = tempShield;
	}
	
	public static void setStatus(String tempStatus) {
		status = tempStatus;
	}
 }
