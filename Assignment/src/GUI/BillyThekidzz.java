package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Desc: This is just for a MEME, Gaviscon.
 * @author sna134 and cyh29
 */
public class BillyThekidzz {
	public static String item = "", message = "", button = "Ah shot, here we go again.";
	private JFrame frmGaviscon;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillyThekidzz window = new BillyThekidzz();
					window.frmGaviscon.setVisible(true);
					window.frmGaviscon.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillyThekidzz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGaviscon = new JFrame();
		frmGaviscon.setTitle("GAVISCON");
		frmGaviscon.setBounds(100, 100, 450, 277);
		frmGaviscon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGaviscon.getContentPane().setLayout(null);
		
		JLabel lblStatus = new JLabel("Hello");
		lblStatus.setBounds(72, 150, 334, 43);
		lblStatus.setText("<html>" + message + "</html>");
		frmGaviscon.getContentPane().add(lblStatus);
		
		JButton btnConfirm = new JButton(button);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button.equals("Defeated")) {
					System.exit(0);
				} else if (button.equals("Victory")) {
					ConcludeWindow.createWindow();
				} else {
					frmGaviscon.dispose();
				}
			}
		});
		btnConfirm.setBounds(82, 205, 281, 25);
		frmGaviscon.getContentPane().add(btnConfirm);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BillyThekidzz.class.getResource("/GUI/thekidz.png")));
		lblNewLabel.setBounds(160, 12, 111, 126);
		frmGaviscon.getContentPane().add(lblNewLabel);
	}
	
	public static void removeItem(String tempItem) {
		item = tempItem;
	}
	
	public static void updateMessage(String tempMsg) {
		message = tempMsg;
	}
	
	public static void updateButton(String tempBtn) {
		button = tempBtn;
	}
}
