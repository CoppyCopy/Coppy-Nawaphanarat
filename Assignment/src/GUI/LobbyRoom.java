package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GameEnvironment.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Desc: A class that leads to the Lobby Room, that is accessible to Resting room, Action room, Status, Shop, and Pilot room.
 * @author sna134 and cyh27
 *
 */
public class LobbyRoom {

	private JFrame frmLobbyRoom;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyRoom window = new LobbyRoom();
					window.frmLobbyRoom.setVisible(true);
					window.frmLobbyRoom.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LobbyRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLobbyRoom = new JFrame();
		frmLobbyRoom.setTitle("Lobby Room");
		frmLobbyRoom.setBounds(100, 100, 550, 334);
		frmLobbyRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLobbyRoom.getContentPane().setLayout(null);
		
		JLabel lblVisitOutpostShop = new JLabel("Visit Outpost Shop:");
		lblVisitOutpostShop.setBounds(71, 66, 151, 15);
		frmLobbyRoom.getContentPane().add(lblVisitOutpostShop);
		
		JButton btnShop = new JButton("Visit Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLobbyRoom.dispose();
				Shop.createWindow();
			}
		});
		btnShop.setBounds(342, 61, 114, 25);
		frmLobbyRoom.getContentPane().add(btnShop);
		
		JLabel lblActionRoom = new JLabel("Go to the Dining Room:");
		lblActionRoom.setBounds(71, 142, 199, 15);
		frmLobbyRoom.getContentPane().add(lblActionRoom);
		
		JButton btnDine = new JButton("Enter DR");
		btnDine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLobbyRoom.dispose();
				DiningRoom.createWindow();
			}
		});
		btnDine.setBounds(342, 137, 114, 25);
		frmLobbyRoom.getContentPane().add(btnDine);
		
		JLabel lblCheckStatus = new JLabel("Check Status:");
		lblCheckStatus.setBounds(71, 105, 151, 15);
		frmLobbyRoom.getContentPane().add(lblCheckStatus);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLobbyRoom.dispose();
				ViewStatus.createWindow();
			}
		});
		btnStatus.setBounds(342, 100, 114, 25);
		frmLobbyRoom.getContentPane().add(btnStatus);
		
		JLabel lblPilotRoom = new JLabel("Go to the Pilot Room:");
		lblPilotRoom.setBounds(71, 179, 199, 15);
		frmLobbyRoom.getContentPane().add(lblPilotRoom);
		
		JButton btnPilot = new JButton("Enter PR");
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLobbyRoom.dispose();
				PilotRoom.createWindow();
			}
		});
		btnPilot.setBounds(342, 174, 114, 25);
		frmLobbyRoom.getContentPane().add(btnPilot);
		
		JLabel lblMedicRoom = new JLabel("Go to the Medic Room:");
		lblMedicRoom.setBounds(71, 216, 228, 15);
		frmLobbyRoom.getContentPane().add(lblMedicRoom);
		
		JButton btnEnterMr = new JButton("Enter MR");
		btnEnterMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.getCrewType().contains("Medic")) {
					// Create a medic room window here
					frmLobbyRoom.dispose();
					MedicRoom.createWindow();
				} else {
					JOptionPane.showMessageDialog(null, "Your crew team does not have a Medic. So, this room is inaccessible.", "Unable to access to Medic Room", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnterMr.setBounds(342, 211, 114, 25);
		frmLobbyRoom.getContentPane().add(btnEnterMr);
		
		JLabel lblCurrentDay = new JLabel("Current Day: " + Game.currentDay + "/" + Game.day);
		lblCurrentDay.setBounds(71, 23, 185, 15);
		frmLobbyRoom.getContentPane().add(lblCurrentDay);
		
		JLabel lblGoToThe = new JLabel("Go to the next day:");
		lblGoToThe.setBounds(71, 255, 151, 15);
		frmLobbyRoom.getContentPane().add(lblGoToThe);
		
		JButton btnNextDay = new JButton("Go Next");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.currentDay += 1;
				if (Game.currentDay > Game.day) {
					JOptionPane.showMessageDialog(null, "Your final day has ended. So, your trip is now concluded.", "The game has ended", JOptionPane.WARNING_MESSAGE);
					Game.currentDay -= 1;
					frmLobbyRoom.dispose();
					ConcludeWindow.createWindow();
				} else {
					lblCurrentDay.setText("Current Day: " + Game.currentDay + "/" + Game.day);
				}
				for (int i=0; i<Game.getCrewAction().size(); i++) {
					Game.getCrewAction().set(i, 0);
					if (Game.getCrewStatus().get(i).equals("Unhealthy")) {
						if (Game.getCrewType().get(i).equals("Absolute Unit")) {
							if (Game.getCrewHealth().get(i) <= 10) {
								Game.removeCrew(Game.getCrewName().get(i));
								JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
							} else {
								Game.getCrewHealth().set(i, Game.getCrewHealth().get(i) - 10);
							}
						}else {
							if (Game.getCrewHealth().get(i) <= 20) {
								Game.removeCrew(Game.getCrewName().get(i));
								JOptionPane.showMessageDialog(null, "One of your crew member has died.", "Rest In Peace", JOptionPane.WARNING_MESSAGE);
							} else {
								Game.getCrewHealth().set(i, Game.getCrewHealth().get(i) - 20);
							}
						}
					}
				}
			}
		});
		btnNextDay.setBounds(342, 250, 114, 25);
		frmLobbyRoom.getContentPane().add(btnNextDay);
	}
}
