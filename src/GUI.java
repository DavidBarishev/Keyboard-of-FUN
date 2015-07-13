import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JPanel Cards = new JPanel();
		contentPane.add(Cards);
		Cards.setLayout(new CardLayout(0, 0));
		
		final JPanel MenuPanel = new JPanel();
		Cards.add(MenuPanel, "name_39285949539102");
		MenuPanel.setLayout(null);
		
		JButton btnMakeNewProfile = new JButton("Make new profile");
		
		btnMakeNewProfile.setBounds(10, 14, 140, 23);
		MenuPanel.add(btnMakeNewProfile);
		
		JLabel lblOpensNewWindow = new JLabel("<html>Opens new window , which the user types the long ass message and we get the file of his profile</html>");
		lblOpensNewWindow.setBounds(160, 12, 342, 40);
		MenuPanel.add(lblOpensNewWindow);
		
		JButton btnNewButton = new JButton("Load profile");
		
		btnNewButton.setBounds(10, 76, 140, 23);
		MenuPanel.add(btnNewButton);
		
		JLabel lblOpensANew = new JLabel("<html> Opens a new profile with profile syntex for debugging</html>");
		lblOpensANew.setBounds(160, 72, 342, 31);
		MenuPanel.add(lblOpensANew);
		
		JButton btnNewButton_1 = new JButton("Matching profiles");
		
		btnNewButton_1.setBounds(10, 131, 140, 23);
		MenuPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("<html>This will macth between short message to a profile and will show the statistics made </html>");
		lblNewLabel_1.setBounds(160, 135, 347, 40);
		MenuPanel.add(lblNewLabel_1);
		
		final JPanel NewProfile = new JPanel();
		Cards.add(NewProfile, "name_39289054579067");
		NewProfile.setLayout(null);
		
		final creator a = new creator();
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			long start_time;
			long end_time;
			int timePressed;
			char charPressed;
			
			@Override
			public void keyPressed(KeyEvent e) {
				start_time = System.currentTimeMillis();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				end_time = System.currentTimeMillis();
				timePressed = (int) (end_time - start_time);
				System.out.println(timePressed);
				a.add(charPressed,timePressed);
			}
			@Override
			public void keyTyped(KeyEvent e) {
				charPressed = e.getKeyChar();
				System.out.println("key character = '" + e.getKeyChar() + "'");
			}
		});
		textField.setBounds(10, 201, 574, 20);
		NewProfile.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>This is the text that needs to be displayed</html>");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 574, 124);
		NewProfile.add(lblNewLabel);
		
		JLabel lblUserInputLine = new JLabel("User input line");
		lblUserInputLine.setBounds(10, 176, 89, 14);
		NewProfile.add(lblUserInputLine);
		
		JButton btnSaveProfile = new JButton("Save profile");
		
		btnSaveProfile.setBounds(142, 298, 125, 23);
		NewProfile.add(btnSaveProfile);
		
		textField_1 = new JTextField();
		textField_1.setBounds(276, 298, 86, 23);
		NewProfile.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(276, 273, 86, 14);
		NewProfile.add(lblUserName);
		
		btnSaveProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.finish(textField_1.getText());
			}
		});
		
		JButton btnBacl = new JButton("Back");
		btnBacl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cards.removeAll();
				Cards.add(MenuPanel);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		btnBacl.setBounds(10, 327, 89, 23);
		NewProfile.add(btnBacl);
		
		final JPanel profileStatistics = new JPanel();
		Cards.add(profileStatistics, "name_8864153784600");
		profileStatistics.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(MenuPanel);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		btnBack.setBounds(10, 327, 89, 23);
		profileStatistics.add(btnBack);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 11, 584, 305);
		profileStatistics.add(editorPane);
		
		
		final JFileChooser openProfile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		openProfile.setFileFilter(filter);
		JButton btnLoadUpProfile = new JButton("Load up profile");
		btnLoadUpProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(openProfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					try {
						FileReader reader = new FileReader(openProfile.getSelectedFile());
						editorPane.read(reader, openProfile.getSelectedFile().getName());
					} catch (IOException e1) {
						e1.printStackTrace();
						System.out.println("bad file");
					}
				}
			}
		});
		btnLoadUpProfile.setBounds(466, 327, 128, 23);
		profileStatistics.add(btnLoadUpProfile);
		
		JButton btnSaveToThis = new JButton("Save to this file ");
		btnSaveToThis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					BufferedWriter out = new BufferedWriter(new FileWriter(openProfile.getSelectedFile())); 
					out.write(editorPane.getText());
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
					if(openProfile.getSelectedFile() == null){
						System.out.println("File isnt selected , please load a file.");
					}
				}
				 
			}
		});
		btnSaveToThis.setBounds(333, 327, 123, 23);
		profileStatistics.add(btnSaveToThis);
		
		final JPanel matchProfiles = new JPanel();
		Cards.add(matchProfiles, "name_8901595646374");
		matchProfiles.setLayout(null);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(MenuPanel);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		btnBack_1.setBounds(10, 327, 89, 23);
		matchProfiles.add(btnBack_1);
		
		btnMakeNewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(NewProfile);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cards.removeAll();
				Cards.add(profileStatistics);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(matchProfiles);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		
	}
}
