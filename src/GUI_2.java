import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtName;
	private JButton btnCompareMe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GUI_2 window = new GUI_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();

		creator creator = new creator();
		textField.addKeyListener(new KeyAdapter() {
			private long start_time;
			private long end_time;
			private int timePressed;
			private char charPressed;
			private long lastTimePressed = -1;
			private char lastChar = '*';

			@Override
			public void keyPressed(KeyEvent e) {

				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91) || (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					start_time = System.currentTimeMillis();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (lastTimePressed == -1) {
					lastTimePressed = System.currentTimeMillis();
				}

				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91) || (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					end_time = System.currentTimeMillis();
					timePressed = (int) (end_time - start_time);
					System.out.println("Time pressed : " + timePressed);

					System.out.println("idle for : " + (end_time - lastTimePressed));
					creator.add(Character.toLowerCase(charPressed), timePressed);
					
					if(lastChar != '*'){
						creator.addIdleTime(new timeBetweenTwoChars(lastChar, charPressed,(int) (end_time - lastTimePressed)));
						System.out.println("[" + lastChar + ","+charPressed+']' + " Time : "+(int) (end_time - lastTimePressed));
						lastChar = charPressed;
						lastTimePressed = end_time;
					}
					else{
						lastChar =(char) Character.toLowerCase(charPressed);
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91) || (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					charPressed = e.getKeyChar();
					System.out.println("key character = '" + e.getKeyChar() + "'");
				}
			}
		});
		textField.setBounds(12, 254, 758, 51);
		panel.add(textField);
		textField.setColumns(10);

		JTextArea txtrWhatToWrite = new JTextArea();
		txtrWhatToWrite.setEditable(false);
		txtrWhatToWrite.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txtrWhatToWrite.setText("What to write\r\n\r\n");
		txtrWhatToWrite.setBounds(12, 13, 758, 121);
		panel.add(txtrWhatToWrite);

		JButton btnNewButton = new JButton("Save as new profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creator.finish(txtName.getText());
			}
		});
		btnNewButton.setBounds(33, 342, 150, 25);
		panel.add(btnNewButton);

		txtName = new JTextField();
		txtName.setBounds(43, 380, 128, 22);
		panel.add(txtName);
		txtName.setColumns(10);

		btnCompareMe = new JButton("Compare me");
		btnCompareMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creator.finish("you");

				int threshold = 25;

				File dir = new File(System.getProperty("user.dir") + "\\Profiles");
				File[] files = dir.listFiles();

				int index = 0;

				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals("you.txt")) {
						index = i;
					}
				}

				File[] filesWithoutFirst = new File[files.length - 1];

				for (int i = 0; i < index; i++) {
					filesWithoutFirst[i] = files[i];
				}

				for (int i = index + 1; i < files.length; i++) {
					filesWithoutFirst[i - 1] = files[i];
				}
				
				profile[] profiles = new profile[filesWithoutFirst.length];
				for(int i = 0 ; i < profiles.length ; i++){
					profiles[i] = new profile(filesWithoutFirst[i]);
				}
				
				

				// Add calling to profile and getting result
				profile ans = Profiler.overallCompare(profiles, new profile(new File(System.getProperty("user.dir") + "\\Profiles\\you.txt")), threshold);

				if (ans == null) {
					JOptionPane.showMessageDialog(null, "Nothing was found", "", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Match : " + ans.name, "", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnCompareMe.setBounds(571, 342, 143, 25);
		panel.add(btnCompareMe);
	}
}
