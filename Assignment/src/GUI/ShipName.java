package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import GameEnvironment.Game;

import javax.swing.JButton;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * Desc: A class that creates a spaceship window to allow the player creates the name of it.
 * @author sna134 and cyh27.
 *
 */
public class ShipName {
	private JFrame frmNameYourShip;
	private JTextField txtShipName;
	public static String shipName = "", message = "";
	
	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipName window = new ShipName();
					window.frmNameYourShip.setVisible(true);
					window.frmNameYourShip.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipName() {
		initialize();
	}
	
	/**
	 * Desc: A function that updates the message status
	 * @param tempMsg, a variable that receives the update message status
	 */
	public static void updateMessage(String tempMsg) {
		message = tempMsg;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNameYourShip = new JFrame();
		frmNameYourShip.setTitle("Name your ship");
		frmNameYourShip.setBounds(100, 100, 341, 243);
		frmNameYourShip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtShipName = new JTextField();
		txtShipName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent name) {
				char names = name.getKeyChar();
				String tempName = Character.toString(names);
				if (!Pattern.matches("[a-zA-Z[0-9]]", tempName)) {
					name.consume();
				}
			}
		});
		txtShipName.setBounds(39, 50, 260, 19);
		txtShipName.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status: " + message);
		lblStatus.setBounds(32, 80, 281, 14);
		frmNameYourShip.getContentPane().add(lblStatus);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.shipNameVerification(txtShipName.getText()) == true) {
					// Add a window that shows how to play the game and the instructions
					shipName = txtShipName.getText();
					ViewStatus.setSpaceshipName(shipName);
					LobbyRoom.createWindow();
					frmNameYourShip.dispose();
				} else {
					lblStatus.setText("Status: " + message);
				}
			}
		});
		btnNewButton.setBounds(39, 127, 109, 25);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.resetCrew();
				frmNameYourShip.dispose();
				CrewTypesWindow.createWindow();
			}
		});
		btnGoBack.setBounds(185, 127, 109, 25);
		frmNameYourShip.getContentPane().setLayout(null);
		frmNameYourShip.getContentPane().add(txtShipName);
		frmNameYourShip.getContentPane().add(btnNewButton);
		frmNameYourShip.getContentPane().add(btnGoBack);
	}
}
