package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

/**
 * Desc: A class that implement the GUI for Crew Types window
 * @author sna134 and cyh29
 *
 */
public class CrewTypesWindow {

	private JFrame frmSelectTypes;
	private JTextField txtName;
	private String[] member = new String[Game.count+1];
	private static String message = "";

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewTypesWindow window = new CrewTypesWindow();
					window.frmSelectTypes.setVisible(true);
					window.frmSelectTypes.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrewTypesWindow() {
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
		frmSelectTypes = new JFrame();
		frmSelectTypes.setTitle("Select your types for each crew members");
		frmSelectTypes.setBounds(100, 100, 505, 316);
		frmSelectTypes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		member[0] = "";
		frmSelectTypes.getContentPane().setLayout(null);
		
		JLabel lblType1 = new JLabel("Type:");
		lblType1.setBounds(51, 39, 66, 15);
		frmSelectTypes.getContentPane().add(lblType1);
		for (int i=1; i<=Game.count; i++) {
			member[i] = Integer.toString(i);
		}
		
		// List of space crew types
		JComboBox<String> cbType = new JComboBox<String>();
		cbType.setBounds(121, 34, 179, 24);
		cbType.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Repairer", "Absolute Unit", "Barterer", "Scavenger", "Tactical Commander", "Medic"}));
		frmSelectTypes.getContentPane().add(cbType);
		
		JButton btnView = new JButton("View Type");
		btnView.setBounds(326, 34, 115, 25);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbType.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "You must select one of those types to view the abilities.", "Missing Type", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.viewTypes(cbType.getSelectedItem().toString());
				}
			}
		});
		frmSelectTypes.getContentPane().add(btnView);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(52, 125, 389, 40);
		frmSelectTypes.getContentPane().add(lblStatus);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(51, 106, 66, 15);
		frmSelectTypes.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("Status: ");
			}
		});
		txtName.setBounds(121, 103, 182, 19);
		frmSelectTypes.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnBack = new JButton("Go Back");
		btnBack.setBounds(326, 217, 114, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.resetCrew();
				frmSelectTypes.dispose();
				Game.reset();
				SelectWindow.createWindow();
			}
		});
		frmSelectTypes.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(191, 217, 114, 25);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbType.setSelectedIndex(0);
				txtName.setText("");
				lblStatus.setText("Status: ");
			}
		});
		frmSelectTypes.getContentPane().add(btnClear);

		JButton btnAddToTeam = new JButton("Add");
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (Game.crewInfoVerification(txtName.getText(), (String) cbType.getSelectedItem()) == true) {
					Game.crewInfo(txtName.getText(), (String) cbType.getSelectedItem());
					lblStatus.setText("<html>Status: " + message + "</html>");
				} else {
					JOptionPane.showMessageDialog(null, "One or more piece of informations is missing.", "Information is missing", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddToTeam.setBounds(327, 101, 114, 25);
		frmSelectTypes.getContentPane().add(btnAddToTeam);
		
		// This button removes every elements in crew's name and type lists.
		JButton btnRemove = new JButton("Reset");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.resetCrew();
				lblStatus.setText("Status: Successfully resetted.");
			}
		});
		btnRemove.setBounds(326, 170, 115, 23);
		frmSelectTypes.getContentPane().add(btnRemove);
		
		JLabel lblRemoveInfo = new JLabel("");
		lblRemoveInfo.setText("<html>Click this button to reset entirely crew members if needed.</html>");
		lblRemoveInfo.setVerticalAlignment(SwingConstants.TOP);
		lblRemoveInfo.setBounds(51, 170, 251, 32);
		frmSelectTypes.getContentPane().add(lblRemoveInfo);
		
		JButton btnStart = new JButton("Confirm");
		btnStart.setBounds(51, 217, 114, 25);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.confirmVerification() == true) {
					ViewStatus.setMoney(Double.toString(Game.getMoney()));
					frmSelectTypes.dispose();
					ShipName.createWindow();
				} else {
					JOptionPane.showMessageDialog(null, "You must add another " + Game.getAdditionalCrewRequirement() + " crew(s) to your team before continue.", "Missing Type", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frmSelectTypes.getContentPane().add(btnStart);
	}
}
