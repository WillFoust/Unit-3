import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Unit3 {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JPasswordField passwordField;

	public static final String DATABASE_URL = "jdbc:sqlserver://localhost:53644;databaseName=Northwind;";
	public String UserName = null;
	public String Password = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unit3 window = new Unit3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	/**
	 * Create the application.
	 */
	public Unit3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 904, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(466, 170, 312, 73);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUserName.setBounds(232, 182, 139, 41);
		frame.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(232, 347, 130, 47);
		frame.getContentPane().add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UserName = textFieldUserName.getText();
					Password = passwordField.getText();
					DataView.UserName = textFieldUserName.getText();
					DataView.Password = passwordField.getText();
					connection = DriverManager.getConnection(DATABASE_URL, UserName, Password);
					JOptionPane.showMessageDialog(null, "Valid User Name and Password");
					frame.dispose();
					DataView dView = new DataView();
					dView.setVisible(true);
					
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid User Name and/or Password");
				}
			}
		});
		btnLogin.setBounds(364, 486, 160, 73);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(466, 338, 310, 73);
		frame.getContentPane().add(passwordField);
	}
}
