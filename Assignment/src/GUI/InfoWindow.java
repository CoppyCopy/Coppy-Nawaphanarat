package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Desc: A class that implements the GUI for view type window.
 * @author sna134 and cyh29
 *
 */
public class InfoWindow {

	private JFrame frmViewType;
	public static String type, desc, spec;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoWindow window = new InfoWindow();
					window.frmViewType.setVisible(true);
					window.frmViewType.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InfoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewType = new JFrame();
		frmViewType.setTitle("Information");
		frmViewType.setBounds(100, 100, 450, 292);
		frmViewType.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmViewType.getContentPane().setLayout(null);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setBounds(33, 25, 378, 15);
		lblInfo.setText(type);
		frmViewType.getContentPane().add(lblInfo);
		
		JLabel lblDesc = new JLabel("");
		lblDesc.setBounds(33, 52, 378, 75);
		lblDesc.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesc.setText("<html>" + desc + "</html>"); // Warp the texts inside the box
		lblDesc.setVerticalAlignment(SwingConstants.TOP);
		frmViewType.getContentPane().add(lblDesc);
		
		JLabel lblSpecialAbility = new JLabel("Information contains:");
		lblSpecialAbility.setBounds(33, 142, 378, 15);
		frmViewType.getContentPane().add(lblSpecialAbility);
		
		JLabel lblMoreInfo = new JLabel("");
		lblMoreInfo.setBounds(32, 169, 389, 65);
		lblMoreInfo.setText("<html>" + spec + "</html>");
		lblMoreInfo.setVerticalAlignment(SwingConstants.TOP);
		frmViewType.getContentPane().add(lblMoreInfo);
	}
}
