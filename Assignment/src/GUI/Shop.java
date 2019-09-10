package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import GameEnvironment.Game;

/**
 * Desc: A class that stores the outpost shop and other selling items.
 * @author sna134 and cyh27
 *
 */
public class Shop {
	private JFrame frmOutpostShop;
	/**
	 * A constant string type for the medicine items list.
	 */
	public static final List<String> medicItems = Arrays.asList("Hi-Recovery", "Recovery", "Anti-Plague"), foodItems = Arrays.asList("Beef Jerky", "French Fries", "Fruit Punch", "Deluxe Set", "Spicy Water", "Steak Set");
	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop window = new Shop();
					window.frmOutpostShop.setVisible(true);
					window.frmOutpostShop.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Shop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOutpostShop = new JFrame();
		frmOutpostShop.setTitle("Outpost shop");
		frmOutpostShop.setBounds(100, 100, 450, 410);
		frmOutpostShop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOutpostShop.getContentPane().setLayout(null);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(26, 219, 401, 40);
		frmOutpostShop.getContentPane().add(lblStatus);
		
		JComboBox<String> cbShop = new JComboBox<String>();
		cbShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("Status :");
			}
		});
		cbShop.setBounds(191, 39, 144, 24);
		cbShop.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Beef Jerky", "French Fries", "Fruit Punch", "Deluxe Set", "Spicy Water", "Steak Set", "Hi-Recovery", "Recovery", "Anti-Plague"}));
		frmOutpostShop.getContentPane().add(cbShop);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cbShop.getSelectedItem().toString().isEmpty()) {
					Game.viewItem(cbShop.getSelectedItem().toString());
				} else {
					JOptionPane.showMessageDialog(null, "Please choose an item to see its content.", "Missing an item!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnView.setBounds(347, 39, 80, 25);
		frmOutpostShop.getContentPane().add(btnView);
		
		JLabel lblSelect = new JLabel("Select item to buy:");
		lblSelect.setBounds(26, 44, 161, 15);
		frmOutpostShop.getContentPane().add(lblSelect);
		
		JLabel lblCurrentMoney = new JLabel("Current Money:");
		lblCurrentMoney.setBounds(26, 82, 401, 15);
		lblCurrentMoney.setText("Current Money: " + Double.toString(Game.getMoney()));
		frmOutpostShop.getContentPane().add(lblCurrentMoney);
		
		JLabel lblCurrentItems = new JLabel("Current Item(s): ");
		lblCurrentItems.setBounds(26, 109, 161, 15);
		lblCurrentItems.setText("Current Item(s): ");
		frmOutpostShop.getContentPane().add(lblCurrentItems);
		
		JLabel lblItems = new JLabel("");
		lblItems.setVerticalAlignment(SwingConstants.TOP);
		lblItems.setBounds(178, 109, 249, 104);
		lblItems.setText("<html>" + Game.getItems() + "</html>");
		frmOutpostShop.getContentPane().add(lblItems);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Game.checkBalanceAndItems(Game.getMoney(), cbShop.getSelectedItem().toString()) == true) {
					Game.getCrewItems().add(cbShop.getSelectedItem().toString());
					Game.updateItems(cbShop.getSelectedItem().toString());
					lblCurrentMoney.setText("Current Money: " + Game.getMoney());
					lblItems.setText("<html>" + Game.getItems() + "</html>");
					lblStatus.setText("Status: You have successfully purchased " + cbShop.getSelectedItem().toString());
				} else if (Game.getCrewItems().size() >= 10) {
					lblStatus.setText("<html>Status: You cannot buy anymore items, due to a maximum capacity of 10 items.</html>");
					
				}else {
					lblStatus.setText("<html>Status: You do not have enough money to buy " + cbShop.getSelectedItem().toString() + "</html>");
				}
			}
		});
		btnBuy.setBounds(51, 271, 114, 25);
		frmOutpostShop.getContentPane().add(btnBuy);
		

		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOutpostShop.dispose();
				LobbyRoom.createWindow();
			}
		});
		btnGoBack.setBounds(276, 271, 114, 25);
		frmOutpostShop.getContentPane().add(btnGoBack);
	}
	
	public static List<String> getFoodItems() {
		return foodItems;
	}
	
	public static List<String> getMedicItems() {
		return medicItems;
	}
}
