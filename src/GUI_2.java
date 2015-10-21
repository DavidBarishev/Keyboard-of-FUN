import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI_2 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91)
						|| (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					start_time = System.currentTimeMillis();
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if(lastTimePressed == -1){
					lastTimePressed = System.currentTimeMillis();
				}
				
				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91)
						|| (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					end_time = System.currentTimeMillis();
					timePressed = (int) (end_time - start_time);
					System.out.println("Time pressed : " + timePressed);
					
					System.out.println("idle for : " + ( end_time - lastTimePressed));
					creator.add(Character.toLowerCase(charPressed),timePressed);
					creator.addIdleTime((int)(end_time - lastTimePressed));
					lastTimePressed = end_time;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() > 64 && e.getKeyCode() < 91)
						|| (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
					charPressed = e.getKeyChar();
					System.out.println("key character = '" + e.getKeyChar()
							+ "'");
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
	}
}
