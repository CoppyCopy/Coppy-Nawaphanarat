package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GameEnvironment.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Desc: A class that implements the GUI for Select Window
 * @author sna134 and cyh29
 *
 */
public class SelectWindow {

	private JFrame selectionWidow;
	private JLabel lblTeamName;
	private JTextField txtTeamName;
	private int teamCount, teamDay;
	private String teamName;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectWindow window = new SelectWindow();
					window.selectionWidow.setVisible(true);
					window.selectionWidow.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		selectionWidow = new JFrame();
		selectionWidow.setTitle("Crew Selection");
		selectionWidow.setBounds(100, 100, 541, 400);
		selectionWidow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectionWidow.getContentPane().setLayout(null);
		
		JLabel lblCrewMembers = new JLabel("How many crew team members?");
		lblCrewMembers.setBounds(40, 139, 221, 15);
		selectionWidow.getContentPane().add(lblCrewMembers);
		
		lblTeamName = new JLabel("What is your crew team name?");
		lblTeamName.setBounds(40, 205, 221, 15);
		selectionWidow.getContentPane().add(lblTeamName);
		
		//Making sure that the user types in only letters with/without numbers for the crew team name.
		txtTeamName = new JTextField();
		txtTeamName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent name) {
				char names = name.getKeyChar();
				String tempName = Character.toString(names);
				if (!Pattern.matches("[a-zA-Z[0-9]]", tempName)) {
					name.consume();
				}
			}
		});
		txtTeamName.setColumns(10);
		txtTeamName.setBounds(315, 203, 124, 19);
		selectionWidow.getContentPane().add(txtTeamName);
		
		JComboBox<Integer> cbDays = new JComboBox<Integer>();
		cbDays.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {3, 4, 5, 6, 7, 8, 9, 10}));
		cbDays.setBounds(315, 63, 124, 24);
		selectionWidow.getContentPane().add(cbDays);
		
		JComboBox<Integer> cbMembers = new JComboBox<Integer>();
		cbMembers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 3, 4}));
		cbMembers.setBounds(315, 134, 124, 24);
		selectionWidow.getContentPane().add(cbMembers);
		
		JLabel lblDay = new JLabel("How many days to travel?");
		lblDay.setBounds(40, 68, 221, 15);
		selectionWidow.getContentPane().add(lblDay);
		
		// A confirmation before going to the next window
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					teamCount = Integer.valueOf(cbMembers.getSelectedItem().toString());
					teamName = txtTeamName.getText();
					teamDay = Integer.valueOf(cbDays.getSelectedItem().toString());
					if (Game.crewVerification(teamDay, teamCount, teamName) == true) {
						Game.storeCrew(teamDay, teamCount, teamName);
						ViewStatus.setSpaceshipName(teamName);
						CrewTypesWindow.createWindow();
						selectionWidow.dispose(); // This closes the current window after all the verifications
					}
				} catch (Exception arrg) {
					JOptionPane.showMessageDialog(null, "One or more piece of informations is missing.", "Information is missing", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirm.setBounds(77, 292, 114, 25);
		selectionWidow.getContentPane().add(btnConfirm);
		
		// Clear every single textbox on this window
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbMembers.setSelectedIndex(0);
				cbDays.setSelectedIndex(0);
				txtTeamName.setText("");
			}
		});
		btnClear.setBounds(325, 292, 114, 25);
		selectionWidow.getContentPane().add(btnClear);
	}
}
