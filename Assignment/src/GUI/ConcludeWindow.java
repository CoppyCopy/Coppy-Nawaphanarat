package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Desc: A window class that shows the score screen at the end of the game.
 * @author sna134
 *
 */
public class ConcludeWindow {
	private static String members = "";
	private JFrame frmTheScoreScreen;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcludeWindow window = new ConcludeWindow();
					window.frmTheScoreScreen.setVisible(true);
					window.frmTheScoreScreen.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConcludeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheScoreScreen = new JFrame();
		frmTheScoreScreen.setTitle("The score screen");
		frmTheScoreScreen.setBounds(100, 100, 450, 312);
		frmTheScoreScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheScoreScreen.getContentPane().setLayout(null);
		
		JLabel lblTheSpaceshipName = new JLabel("The Spaceship name: " + ShipName.shipName);
		lblTheSpaceshipName.setBounds(33, 24, 387, 15);
		frmTheScoreScreen.getContentPane().add(lblTheSpaceshipName);
		
		JLabel lblTheCrewMembers = new JLabel("<html>The crew members (" + Game.name + "):</html>");
		lblTheCrewMembers.setVerticalAlignment(SwingConstants.TOP);
		lblTheCrewMembers.setBounds(33, 51, 387, 15);
		frmTheScoreScreen.getContentPane().add(lblTheCrewMembers);
		
		JLabel lblListMember = new JLabel("");
		lblListMember.setVerticalAlignment(SwingConstants.TOP);
		lblListMember.setBounds(33, 78, 377, 60);
		for (int i=0; i<Game.getCrewName().size(); i++) {
			if (members.isEmpty()) {
				members += Game.getCrewName().get(i) + ", " + Game.getCrewType().get(i) + "<br>";
			} else {
				members += Game.getCrewName().get(i) + ", " + Game.getCrewType().get(i) + "<br>";
			}
		}
		lblListMember.setText("<html>" + members + "</html>");
		frmTheScoreScreen.getContentPane().add(lblListMember);
		
		JLabel lblDaysTaken = new JLabel("Days taken: " + (Game.currentDay) + "/" + Game.day);
		lblDaysTaken.setBounds(33, 155, 178, 15);
		frmTheScoreScreen.getContentPane().add(lblDaysTaken);
		
		JLabel lblTotalScores = new JLabel("Total scores: " + Game.score);
		lblTotalScores.setBounds(33, 209, 178, 15);
		frmTheScoreScreen.getContentPane().add(lblTotalScores);
		
		JLabel lblNewLabel = new JLabel("Parts found: " + Game.currentPieces + "/" + Game.findPieces);
		lblNewLabel.setBounds(33, 182, 156, 15);
		frmTheScoreScreen.getContentPane().add(lblNewLabel);
		
		JButton btnEndTheGame = new JButton("End the game");
		btnEndTheGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEndTheGame.setBounds(148, 236, 156, 25);
		frmTheScoreScreen.getContentPane().add(btnEndTheGame);
	}
}
