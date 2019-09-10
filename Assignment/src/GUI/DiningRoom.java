package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

import javax.swing.DefaultComboBoxModel;

/**
 * Desc: A class that implements the GUI for Dining Room.
 * @author sna134 and cyh29
 *
 */
public class DiningRoom {
	public static String message;
	private JFrame frmDiningRoom;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiningRoom window = new DiningRoom();
					window.frmDiningRoom.setVisible(true);
					window.frmDiningRoom.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiningRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiningRoom = new JFrame();
		frmDiningRoom.setTitle("Dining Room");
		frmDiningRoom.setBounds(100, 100, 450, 227);
		frmDiningRoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDiningRoom.getContentPane().setLayout(null);
		
		JLabel lblSelectACrew = new JLabel("Select a crew member to feed:");
		lblSelectACrew.setBounds(22, 31, 245, 15);
		frmDiningRoom.getContentPane().add(lblSelectACrew);
		
		JComboBox<String> cbCrew = new JComboBox<String>();
		cbCrew.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbCrew.setBounds(285, 26, 125, 24);
		for (int i=0; i<Game.getCrewName().size(); i++) {
			cbCrew.addItem(Game.getCrewName().get(i));
		}
		frmDiningRoom.getContentPane().add(cbCrew);
		
		JLabel lblSelectAnItem = new JLabel("Select an item to consume:");
		lblSelectAnItem.setBounds(22, 76, 228, 15);
		frmDiningRoom.getContentPane().add(lblSelectAnItem);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(22, 103, 387, 36);
		frmDiningRoom.getContentPane().add(lblStatus);
		
		JComboBox<String> cbItems = new JComboBox<String>();
		cbItems.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbItems.setBounds(285, 71, 125, 24);
		for (int i=0; i<Game.getCrewItems().size(); i++) {
			cbItems.addItem(Game.getCrewItems().get(i));
		}
		frmDiningRoom.getContentPane().add(cbItems);
		
		JButton btnFeed = new JButton("CONSUME"); 
		btnFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (!cbCrew.getSelectedItem().toString().isEmpty()) {
						if (!cbItems.getSelectedItem().toString().isEmpty()) {
							if (Game.getCrewAction().get(Game.getCrewName().indexOf(cbCrew.getSelectedItem().toString())) != 1) {
								if (Game.getCrewItems().contains(cbItems.getSelectedItem().toString())) {
									if (Game.feed(cbItems.getSelectedItem().toString(), cbCrew.getSelectedItem().toString()) == true) {
										Game.items = "";
										for (int i=0; i<Game.getCrewItems().size(); i++) {
											Game.updateItems(Game.getCrewItems().get(i));
										}
										cbItems.removeItem(cbItems.getSelectedItem().toString());
										lblStatus.setText("Status: " + message);
									} else {
										lblStatus.setText("Status: " + message);
									}
								} else {
									lblStatus.setText("<html>Status: You do not have " + cbItems.getSelectedItem().toString() + " in your inventory.</html>");
								}
						} else {
							lblStatus.setText("<html>Status: This crew member has already taken an action.</html>");
						}
					} else {
						lblStatus.setText("<html>Status: Please select at least one item to consume.</html>");
						
					}
				} else {
					lblStatus.setText("<html>Status: Please select one of your crew members.</html>");
					
				}
			}
		});
		btnFeed.setBounds(71, 144, 114, 25);
		frmDiningRoom.getContentPane().add(btnFeed);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LobbyRoom.createWindow();
				frmDiningRoom.dispose();
			}
		});
		btnGoBack.setBounds(259, 144, 114, 25);
		frmDiningRoom.getContentPane().add(btnGoBack);
	}

	public static void updateMessage(String tempMsg) {
		message = tempMsg;
	}
}
