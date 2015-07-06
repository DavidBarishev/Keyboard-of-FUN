import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("keyboard of FUN - debug GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		final CardLayout cl = (CardLayout) contentPane.getLayout();
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, "Menu");
		panel.setLayout(null);
		
		JButton btnMakeNewProfile = new JButton("Make new profile");
		btnMakeNewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Menu");
			}
		});
		btnMakeNewProfile.setBounds(10, 11, 140, 23);
		panel.add(btnMakeNewProfile);
		
		JLabel lblOpensNewWindow = new JLabel("<html>Opens new window , which the user types the long ass message and we get the file of his profile</html>");
		lblOpensNewWindow.setBounds(160, 12, 342, 40);
		panel.add(lblOpensNewWindow);
		
		JButton btnNewButton = new JButton("Open new profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 76, 140, 23);
		panel.add(btnNewButton);
		
		JLabel lblOpensANew = new JLabel("<html> Opens a new profile with profile syntex for debugging</html>");
		lblOpensANew.setBounds(160, 72, 342, 31);
		panel.add(lblOpensANew);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "Add profile");
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 201, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>This is the text that needs to be displayed</html>");
		lblNewLabel.setBackground(new Color(255, 175, 175));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 584, 124);
		panel_1.add(lblNewLabel);
	}
}
