import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField ThresholdValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Field for matching
	 */
	private profile find;
	private profile[] findFrom;

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

		JLabel lblOpensNewWindow = new JLabel(
				"<html>Opens new window , which the user types the long ass message and we get the file of his profile</html>");
		lblOpensNewWindow.setBounds(160, 12, 342, 40);
		MenuPanel.add(lblOpensNewWindow);

		JButton btnNewButton = new JButton("Load profile");

		btnNewButton.setBounds(10, 76, 140, 23);
		MenuPanel.add(btnNewButton);

		JLabel lblOpensANew = new JLabel(
				"<html> Opens a new profile with profile syntex for debugging</html>");
		lblOpensANew.setBounds(160, 72, 342, 31);
		MenuPanel.add(lblOpensANew);

		JButton btnNewButton_1 = new JButton("Matching profiles");

		btnNewButton_1.setBounds(10, 131, 140, 23);
		MenuPanel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel(
				"<html>This will macth between short message to a profile and will show the statistics made </html>");
		lblNewLabel_1.setBounds(160, 135, 347, 40);
		MenuPanel.add(lblNewLabel_1);
		final creator a = new creator();
		
				final JPanel ProfileMaker = new JPanel();
				Cards.add(ProfileMaker, "name_39289054579067");
				ProfileMaker.setLayout(null);
				textField = new JTextField();
				textField.addKeyListener(new KeyAdapter() {
					long start_time;
					long end_time;
					int timePressed;
					char charPressed;

					@Override
					public void keyPressed(KeyEvent e) {
						if ((e.getKeyChar() > 64 && e.getKeyCode() < 91)
								|| (e.getKeyChar() > 96 && e.getKeyCode() < 123)) {
							start_time = System.currentTimeMillis();
						}
					}

					@Override
					public void keyReleased(KeyEvent e) {
						if ((int) e.getKeyChar() > 64 && (int) e.getKeyChar() < 91) {
							end_time = System.currentTimeMillis();
							timePressed = (int) (end_time - start_time);
							System.out.println(timePressed);
							a.add((char) (charPressed + 32), timePressed);

						} else if (e.getKeyChar() > 96 && e.getKeyChar() < 123) {
							end_time = System.currentTimeMillis();
							timePressed = (int) (end_time - start_time);
							System.out.println(timePressed);
							a.add(charPressed, timePressed);
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
				textField.setBounds(10, 201, 574, 20);
				ProfileMaker.add(textField);
				textField.setColumns(10);
				
						JLabel lblNewLabel = new JLabel(
								"<html>This is the text that needs to be displayed</html>");
						lblNewLabel.setForeground(Color.BLACK);
						lblNewLabel.setBackground(Color.RED);
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setBounds(10, 11, 574, 124);
						
								ProfileMaker.add(lblNewLabel);
								
										JLabel lblUserInputLine = new JLabel("User input line");
										lblUserInputLine.setBounds(10, 176, 89, 14);
										ProfileMaker.add(lblUserInputLine);
										
												JButton btnSaveProfile = new JButton("Save profile");
												
														btnSaveProfile.setBounds(142, 298, 125, 23);
														
																ProfileMaker.add(btnSaveProfile);
																
																		textField_1 = new JTextField();
																		textField_1.setBounds(276, 298, 86, 23);
																		ProfileMaker.add(textField_1);
																		textField_1.setColumns(10);
																		
																				JLabel lblUserName = new JLabel("User Name");
																				lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
																				lblUserName.setBounds(276, 273, 86, 14);
																				
																						ProfileMaker.add(lblUserName);
																						
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
																										
																												ProfileMaker.add(btnBacl);

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
		openProfile
				.setCurrentDirectory(new File(System.getProperty("user.dir")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"TEXT FILES", "txt", "text");
		openProfile.setFileFilter(filter);
		JButton btnLoadUpProfile = new JButton("Load up profile");
		btnLoadUpProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (openProfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					profile a = new profile(openProfile.getSelectedFile());
					String aToString = a.toString();
					editorPane.setText(aToString);
				}
			}
		});
		btnLoadUpProfile.setBounds(466, 327, 128, 23);
		profileStatistics.add(btnLoadUpProfile);

		JButton btnSaveToThis = new JButton("Save to this file ");
		btnSaveToThis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(
							openProfile.getSelectedFile()));
					out.write(editorPane.getText());
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
					if (openProfile.getSelectedFile() == null) {
						System.out
								.println("File isnt selected , please load a file.");
					}
				}

			}
		});
		btnSaveToThis.setBounds(333, 327, 123, 23);
		profileStatistics.add(btnSaveToThis);

		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setViewportView(editorPane);
		scrollPane.setBounds(10, 0, 584, 316);
		profileStatistics.add(scrollPane);

		/*
		 * Match profiles card
		 */
		final JPanel matchProfiles = new JPanel();
		Cards.add(matchProfiles, "name_8901595646374");

		final JTextArea Console = new JTextArea();
		Console.setBackground(Color.BLACK);
		Console.setForeground(Color.GREEN);
		Console.setBounds(231, 161, 363, 188);
		matchProfiles.add(Console);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBounds(10, 327, 89, 23);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(MenuPanel);
				Cards.repaint();
				Cards.revalidate();
			}
		});
		matchProfiles.setLayout(null);
		matchProfiles.add(btnBack_1);

		final JFileChooser openProfile1 = new JFileChooser();
		openProfile1.setCurrentDirectory(new File(System
				.getProperty("user.dir") + "\\Profiles"));
		openProfile1.setFileFilter(filter);

		JButton btnLoadProfile = new JButton("Load profile #1");
		btnLoadProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (openProfile1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					find = new profile(openProfile1.getSelectedFile());
					Console.append("File to match : " + find.name + "\n");
				}
			}
		});
		btnLoadProfile.setBounds(40, 65, 124, 23);
		matchProfiles.add(btnLoadProfile);

		final JFileChooser openProfile2 = new JFileChooser();
		openProfile2.setCurrentDirectory(new File(System
				.getProperty("user.dir") + "\\Profiles"));
		openProfile2.setFileFilter(filter);
		openProfile2.setMultiSelectionEnabled(true);

		JButton btnNewButton_2 = new JButton("Load profiles to compare");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (openProfile2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File[] findFromFiles = openProfile2.getSelectedFiles();
					findFrom = new profile[findFromFiles.length];
					int counter = 0;
					for (File child : findFromFiles) {
						findFrom[counter] = new profile(child);
						Console.append("File pool #" + counter + " Name : "
								+ findFrom[counter].name + "\n");
						counter++;
					}
				}
			}
		});
		btnNewButton_2.setBounds(284, 65, 178, 23);
		matchProfiles.add(btnNewButton_2);

		JLabel lblProfileWeWant = new JLabel(
				"<html>Profile we want to compare with the other. <br>\r\naka -> which of the other profiles is this</html>\r\n");
		lblProfileWeWant.setBounds(10, 9, 224, 65);
		matchProfiles.add(lblProfileWeWant);

		JLabel lblProfilesWeFind = new JLabel(
				"<html>Profiles we find in them , the selected profile<br>Can select multipule</html>\r\n\r\n");
		lblProfilesWeFind.setBounds(245, 24, 252, 42);
		matchProfiles.add(lblProfilesWeFind);

		JLabel label = new JLabel(
				"________________________________________________________________________________________________\r\n_");
		label.setBounds(10, 99, 584, 14);
		matchProfiles.add(label);

		ThresholdValue = new JTextField();
		ThresholdValue.setBounds(93, 158, 86, 20);
		matchProfiles.add(ThresholdValue);
		ThresholdValue.setColumns(10);

		final JLabel Threshold = new JLabel("Threshold : ");
		Threshold.setBounds(14, 158, 69, 17);
		matchProfiles.add(Threshold);

		JLabel lblConsoleLog = new JLabel("Console log:");
		lblConsoleLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsoleLog.setBounds(231, 129, 89, 23);
		matchProfiles.add(lblConsoleLog);

		btnMakeNewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.removeAll();
				Cards.add(ProfileMaker);
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

		JButton btnCompare = new JButton("Compare aka find");
		btnCompare.setBounds(20, 124, 144, 23);
		matchProfiles.add(btnCompare);
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int threshold = Integer.parseInt(ThresholdValue.getText());

				// Add calling to profile and getting result
				profile ans = Profiler.overallCompare(findFrom, find, threshold);
				if (ans == null) {
					Console.append("Non of the profiles is matching\n");
				} else {
					Console.append("Match found : " + ans.name);
				}
			}
		});
	}
}
