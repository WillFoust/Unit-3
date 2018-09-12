import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class DataView extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;

	static final String DATABASE_URL = "jdbc:sqlserver://localhost:53644;databaseName=Northwind;";
	static String UserName = null;
	static String Password = null;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataView frame = new DataView();
					frame.setVisible(true);
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
	 * Create the frame.
	 */
	public DataView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Load Employee Table");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection(DATABASE_URL, UserName, Password);
					
					statement = connection.createStatement();
					
					resultSet = statement.executeQuery("Select * From dbo.Employees;");
					
					table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
					
				}
				catch(SQLException sqlException) {
					JOptionPane.showMessageDialog(null, "User does not have access to this table");
				}
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(Color.WHITE);
		button.setBounds(55, 51, 185, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Load Customers Table");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection(DATABASE_URL, UserName, Password);
					
					statement = connection.createStatement();
					
					resultSet = statement.executeQuery("Select CustomerID, CompanyName From dbo.Customers;");
					
					table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
					
				}
				catch(SQLException sqlException) {
					JOptionPane.showMessageDialog(null, "User does not have access to this table");
				}
			}
		});
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(294, 51, 200, 43);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Load Orders Table");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection(DATABASE_URL, UserName, Password);
					
					statement = connection.createStatement();
					
					resultSet = statement.executeQuery("Select * From dbo.Orders;");
					
					table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
					
				}
				catch(SQLException sqlException) {
					JOptionPane.showMessageDialog(null, "User does not have access to this table");
				}
			}
		});
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(542, 51, 174, 43);
		contentPane.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 110, 661, 314);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
}
