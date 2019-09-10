package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Desc: A class that implements the GUI for Medic Room
 * @author sna134 and cyh29
 *
 */
public class MedicRoom {
	/**
	 * A string type variable that initializes the message status.
	 */
	public static String message;
	private JFrame frmMedicalRoom;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicRoom window = new MedicRoom();
					window.frmMedicalRoom.setVisible(true);
					window.frmMedicalRoom.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicalRoom = new JFrame();
		frmMedicalRoom.setTitle("Medical Room");
		frmMedicalRoom.setBounds(100, 100, 450, 300);
		frmMedicalRoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMedicalRoom.getContentPane().setLayout(null);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(49, 34, 66, 15);
		frmMedicalRoom.getContentPane().add(lblDoctor);
		
		JComboBox<String> cbDoctor = new JComboBox<String>();
		cbDoctor.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbDoctor.setBounds(265, 29, 134, 24);
		for (int i=0; i<Game.getCrewType().size(); i++) {
			if (Game.getCrewType().get(i).equals("Medic")) {
				cbDoctor.addItem(Game.getCrewName().get(i));
			}
		}
		frmMedicalRoom.getContentPane().add(cbDoctor);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(22, 148, 389, 43);
		frmMedicalRoom.getContentPane().add(lblStatus);
		
		JLabel lblSelectACrew = new JLabel("Select a crew member to heal:");
		lblSelectACrew.setVerticalAlignment(SwingConstants.TOP);
		lblSelectACrew.setBounds(12, 91, 254, 15);
		frmMedicalRoom.getContentPane().add(lblSelectACrew);
		
		JComboBox<String> cboCrew = new JComboBox<String>();
		cboCrew.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cboCrew.setBounds(265, 86, 134, 24);
		for (int i=0; i<Game.getCrewName().size(); i++) {
			cboCrew.addItem(Game.getCrewName().get(i));
		}
		frmMedicalRoom.getContentPane().add(cboCrew);
		
		JButton btnHeal = new JButton("HEAL");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.getCrewHealth().get(Game.getCrewName().indexOf(cbDoctor.getSelectedItem().toString())) < 100 && Game.getCrewStatus().get(Game.getCrewName().indexOf(cbDoctor.getSelectedItem().toString())).equals("Unhealthy")) {
					if (Game.checkCrewMemberTiredness(cbDoctor.getSelectedItem().toString()) == true) {
						Game.heal(cboCrew.getSelectedItem().toString());
						lblStatus.setText("<html>Status: " + message + " </html>");
					} else {
						lblStatus.setText("<html>Status: " + cbDoctor.getSelectedItem().toString() + " has already taken an action for today.</html>");
					}
				} else {
					lblStatus.setText("<html>Status: " + cboCrew.getSelectedItem().toString() + " is already at full health and healthy.</html>");
				}
			}
		});
		btnHeal.setBounds(63, 203, 114, 25);
		frmMedicalRoom.getContentPane().add(btnHeal);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LobbyRoom.createWindow();
				frmMedicalRoom.dispose();
			}
		});
		btnGoBack.setBounds(265, 203, 114, 25);
		frmMedicalRoom.getContentPane().add(btnGoBack);
	}
	
	
	public static void updateMessage(String tempMsg) {
		message = tempMsg;
	}
}
