package scdAssignment3;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextArea;

class NullSelectionException extends Exception {

    public NullSelectionException(String message) {

        super(message);
    }
}

class InvalidDateException extends Exception {

    public InvalidDateException(String message) {

        super(message);
    }
}

class InvalidRollNumberException extends Exception {

    public InvalidRollNumberException(String message) {

        super(message);
    }
}

class EmptyFieldException extends Exception {

    public EmptyFieldException(String message) {

        super(message);
    }
}

public class LibraryGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField regField;

	private final ButtonGroup editionGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI frame = new LibraryGUI();
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
	public LibraryGUI() {
		setBackground(new Color(64, 128, 128));
		setForeground(new Color(64, 128, 128));

		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 240, 255)); 
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// title

		JLabel titleLabel = new JLabel("Library Book Issue Portal");
		titleLabel.setBackground(new Color(128, 0, 255));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Century", Font.BOLD, 28));
		titleLabel.setForeground(new Color(64, 128, 128));
		titleLabel.setBounds(150, 20, 390, 40);
		contentPane.add(titleLabel);

		// labels

		JLabel nameLabel = new JLabel("Student Name");
		nameLabel.setFont(new Font("Century", Font.PLAIN, 16));
		nameLabel.setBounds(80, 90, 150, 25);
		contentPane.add(nameLabel);

		JLabel regLabel = new JLabel("Registration Number");
		regLabel.setFont(new Font("Century", Font.PLAIN, 16));
		regLabel.setBounds(80, 140, 170, 25);
		contentPane.add(regLabel);

		JLabel categoryLabel = new JLabel("Select Category");
		categoryLabel.setFont(new Font("Century", Font.PLAIN, 16));
		categoryLabel.setBounds(80, 190, 150, 25);
		contentPane.add(categoryLabel);

		JLabel bookLabel = new JLabel("Select Book");
		bookLabel.setFont(new Font("Century", Font.PLAIN, 16));
		bookLabel.setBounds(80, 240, 150, 25);
		contentPane.add(bookLabel);

		JLabel editionLabel = new JLabel("Book Edition");
		editionLabel.setFont(new Font("Century", Font.PLAIN, 16));
		editionLabel.setBounds(80, 290, 150, 25);
		contentPane.add(editionLabel);

		// text fields

		nameField = new JTextField();
		nameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		nameField.setBackground(new Color(255, 250, 250));
		nameField.setBounds(260, 90, 280, 30);
		contentPane.add(nameField);

		regField = new JTextField();
		regField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		regField.setBackground(new Color(255, 250, 250));
		regField.setBounds(260, 140, 280, 30);
		contentPane.add(regField);

		// combo box

		JComboBox<String> categoryCombo = new JComboBox<>();
		categoryCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		categoryCombo.setBackground(new Color(255, 255, 255));
		categoryCombo.setBounds(260, 190, 280, 30);

		categoryCombo.addItem("IT");
		categoryCombo.addItem("Science");
		categoryCombo.addItem("Arts");
		categoryCombo.addItem("Maths");
		categoryCombo.addItem("History");
		categoryCombo.setSelectedIndex(-1);
		contentPane.add(categoryCombo);
	

		JComboBox<String> bookCombo = new JComboBox<>();
		bookCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		bookCombo.setBackground(new Color(255, 255, 255));
		bookCombo.setBounds(260, 240, 280, 30);

		contentPane.add(bookCombo);

		// category action

		categoryCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				bookCombo.removeAllItems();
				
				if(categoryCombo.getSelectedItem() == null) {
					return;
				}

				String category = categoryCombo.getSelectedItem().toString();


				if (category.equals("IT")) {

					bookCombo.addItem("Artificial Intelligence");
					bookCombo.addItem("Java Programming");
					bookCombo.addItem("Learn C++");
					bookCombo.addItem("Machine Learning Basics");
					bookCombo.addItem("React JS Development");
					bookCombo.addItem("Node JS Guide");
					
				}

				else if (category.equals("Science")) {

					bookCombo.addItem("Astro Physics");
					bookCombo.addItem("Quantum Mechanics");
					bookCombo.addItem("The Art of Universe");
					bookCombo.addItem("Biology Essentials");
					bookCombo.addItem("Chemistry in Daily Life");
					bookCombo.addItem("Human Anatomy");
				}

				else if (category.equals("Arts")) {

					bookCombo.addItem("Modern Art");
					bookCombo.addItem("Creative Sketching");
					bookCombo.addItem("History of Painting");
					bookCombo.addItem("Graphic Design Basics");
					bookCombo.addItem("Photography Essentials");
					bookCombo.addItem("Visual Communication");
				}

				else if (category.equals("Maths")) {

					bookCombo.addItem("Calculus Fundamentals");
					bookCombo.addItem("Discrete Mathematics");
					bookCombo.addItem("Linear Algebra");
					bookCombo.addItem("Statistics for Beginners");
					bookCombo.addItem("Trigonometry Made Easy");
					bookCombo.addItem("Advanced Algebra");
				}

				else if (category.equals("History")) {

					bookCombo.addItem("World War II");
					bookCombo.addItem("Ancient Civilizations");
					bookCombo.addItem("History of Pakistan");
					bookCombo.addItem("Mughal Empire");
					bookCombo.addItem("Islamic History");
					bookCombo.addItem("The Industrial Revolution");
				}
				bookCombo.setSelectedIndex(-1);
			}
		});

		JRadioButton newEdition = new JRadioButton("New Edition");
		newEdition.setFont(new Font("Century", Font.PLAIN, 12));
		newEdition.setBackground(new Color(245, 240, 255));
		newEdition.setBounds(260, 290, 130, 30);

		JRadioButton oldEdition = new JRadioButton("Old Edition");
		oldEdition.setFont(new Font("Century", Font.PLAIN, 12));
		oldEdition.setBackground(new Color(245, 240, 255));
		oldEdition.setBounds(410, 290, 130, 30);

		editionGroup.add(newEdition);
		editionGroup.add(oldEdition);

		contentPane.add(newEdition);
		contentPane.add(oldEdition);

		JButton issueButton = new JButton("Issue Book");
		issueButton.setForeground(new Color(255, 255, 255));
		issueButton.setFont(new Font("Century", Font.BOLD, 14));
		issueButton.setBackground(new Color(0, 128, 0)); 
		issueButton.setBounds(80, 430, 150, 40);

		contentPane.add(issueButton);

		JButton resetButton = new JButton("Reset");
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setFont(new Font("Century", Font.BOLD, 14));
		resetButton.setBackground(new Color(0, 128, 128)); 
		resetButton.setBounds(272, 430, 150, 40);

		contentPane.add(resetButton);

		JButton exitButton = new JButton("Exit");
		exitButton.setForeground(new Color(255, 255, 255));
		exitButton.setFont(new Font("Century", Font.BOLD, 14));
		exitButton.setBackground(new Color(255, 0, 0)); 
		exitButton.setBounds(457, 430, 150, 40);

		contentPane.add(exitButton);
		
		JLabel lblNewLabel = new JLabel("Remarks");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 343, 117, 25);
		contentPane.add(lblNewLabel);

		JTextArea remarksField = new JTextArea();
		remarksField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		remarksField.setBackground(new Color(255, 250, 250));
		remarksField.setForeground(Color.GRAY);
		remarksField.setBorder(new EmptyBorder(8, 8, 8, 8));
		remarksField.setLineWrap(true);
		remarksField.setWrapStyleWord(true);

		remarksField.setText("Write your remarks here...");

		remarksField.addFocusListener(new java.awt.event.FocusAdapter() {

			public void focusGained(java.awt.event.FocusEvent e) {

				if(remarksField.getText().equals(
						"Write your remarks here...")) {

					remarksField.setText("");
					remarksField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(java.awt.event.FocusEvent e) {

				if(remarksField.getText().trim().isEmpty()) {

					remarksField.setText(
							"Write your remarks here...");

					remarksField.setForeground(Color.GRAY);
				}
			}
		});

		remarksField.setBounds(260, 327, 292, 70);
		contentPane.add(remarksField);
		
		
		issueButton.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

		        try {

		            String studentName =nameField.getText().trim();

		            String regNo = regField.getText().trim();

		            // Empty Field Validation

		            if(studentName.isEmpty()) {
		                throw new EmptyFieldException("Student name cannot empty");
		            }

		            if(regNo.isEmpty()) {
		                throw new EmptyFieldException("Registration number cannot be empty");
		            }


		            
		            if(!regNo.matches("\\d+")) {
		               throw new InvalidRollNumberException( "Registration number must contain digits only.");
		            }



		            int roll = Integer.parseInt(regNo);



		            if(categoryCombo.getSelectedItem() == null) {

		                throw new NullSelectionException("category is required!");
		            }


		            if(bookCombo.getSelectedItem() == null) {

		                throw new NullSelectionException( "Book is required!");
		            }

		            if(!newEdition.isSelected()&& !oldEdition.isSelected()) {
		                throw new NullSelectionException("Please select book edition");
		            }

		            String category =categoryCombo.getSelectedItem().toString();

		            String book = bookCombo.getSelectedItem().toString();

		            String edition = "";

		            if(newEdition.isSelected()) {
		                edition = "New Edition";
		            }
		            else {
		                edition = "Old Edition";
		            }

		            String remarks =remarksField.getText();

		            if(remarks.equals("Write your remarks here...")) {
		                remarks = "No Remarks";
		            }


		            LocalDate issueDate = LocalDate.now();

		            LocalDate returnDate =issueDate.plusDays(7);

		            if(returnDate.isBefore(issueDate)) {
		                throw new InvalidDateException( "Return date cannot be less than issue date");
		            }

		            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
		            String formattedIssueDate =issueDate.format(formatter);
		            String formattedReturnDate =returnDate.format(formatter);

		            String message =
		                    "Book Issued Successfully!\n\n"
		                    + "Student Name: "  + studentName
		                    + "\nRegistration No: "+regNo
		                    + "\n\nCategory: " + category
		                    + "\nBook: "+ book
		                    + "\nEdition: "+ edition

		                    + "\n\nIssue Date: "
		                    + formattedIssueDate

		                    + "\nReturn Date: "
		                    + formattedReturnDate

		                    + "\n\nRemarks: "
		                    + remarks;

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    message,
		                    "Issue Confirmation",
		                    JOptionPane.INFORMATION_MESSAGE);

		        }

		        catch(EmptyFieldException ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    ex.getMessage(),
		                    "Empty Field Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        catch(InvalidRollNumberException ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    ex.getMessage(),
		                    "Invalid Roll Number",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        catch(NullSelectionException ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    ex.getMessage(),
		                    "Selection Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        catch(InvalidDateException ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    ex.getMessage(),
		                    "Date Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        catch(NumberFormatException ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    "Only numeric values are allowed.",
		                    "Number Format Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        catch(Exception ex) {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    "Unexpected Error: "
		                    + ex.getMessage(),
		                    "System Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }

		        finally {

		            JOptionPane.showMessageDialog(
		                    issueButton,
		                    "Operation Completed");
		        }
		    }
		});
		
		resetButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				nameField.setText("");
				regField.setText("");

				categoryCombo.setSelectedIndex(-1);
				bookCombo.removeAllItems();
				bookCombo.setSelectedIndex(-1);

				editionGroup.clearSelection();
				
				remarksField.setText(
						"Write your remarks here...");

				remarksField.setForeground(
						Color.GRAY);
			
			}
		});


		exitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}
}

