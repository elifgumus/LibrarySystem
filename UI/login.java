package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Person;
import Model.Personel;
import Model.Student;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 831, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfEmail.setBounds(339, 257, 278, 22);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Librarian", "Student"}));
		comboBox.setBounds(480, 202, 126, 22);
		contentPane.add(comboBox);
		
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBounds(342, 359, 97, 25);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0)
				{
					Personel p = new Personel();
					String Email=tfEmail.getText();
					String Password=new String(tfPassword.getPassword());
					try {
						ResultSet rs =p.loginPersonel(Email, Password);
						System.out.println(rs.getString("Name"));
						if(rs.next()) {
							personelhome ph = new  personelhome();
							ph.setVisible(true);
						}
						else {
							System.out.println("Yanlis");
					}
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
				 Student std= new Student();
				 String Email=tfEmail.getText();
				 String Password=new String(tfPassword.getPassword());
					try {
						ResultSet rs =std.loginStudent(Email, Password);
						System.out.println(rs.getString("Name"));
						if(rs.next()) {
							studenthome sh = new  studenthome();
							sh.setVisible(true);
						}
						else {
							System.out.println("Yanlis");
					}
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
			
		});
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnLogIn);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			sign s = new  sign();
				s.setVisible(true);
			}
		});
		btnSignUp.setBounds(496, 359, 97, 25);
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	       dispose();
			}
		});
		contentPane.add(btnSignUp);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(339, 293, 278, 22);
		contentPane.add(tfPassword);
		
		JLabel label = new JLabel("");
		label.setBounds(108, 144, 56, 16);
		contentPane.add(label);
		
		JLabel lblEmal = new JLabel("Email");
		lblEmal.setForeground(Color.WHITE);
		lblEmal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmal.setBackground(Color.WHITE);
		lblEmal.setBounds(236, 258, 56, 16);
		contentPane.add(lblEmal);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(236, 295, 91, 16);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(236, 277, 56, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(235, 313, 92, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\Reading.jpg"));
		lblNewLabel_2.setBounds(0, 0, 813, 510);
		contentPane.add(lblNewLabel_2);

	}
}
