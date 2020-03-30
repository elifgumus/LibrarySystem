package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Student;
import Model.Personel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
public class sign extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfEmail;
	private JTextField tfID;
	private JButton btnNewButton;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign frame = new sign();
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
	public sign() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 372, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(100, 116, 202, 22);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfSurname = new JTextField();
		tfSurname.setBounds(100, 151, 202, 22);
		contentPane.add(tfSurname);
		tfSurname.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(100, 186, 202, 22);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfID = new JTextField();
		tfID.setBounds(100, 251, 202, 22);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
			login l= new login();
			l.setLocationRelativeTo(null);
			l.setVisible(true);
				try {
					String  Name = tfName.getText().trim();
				    String Surname =tfSurname.getText().trim();
					String  Email = tfEmail.getText().trim();							
					String Password = pfPassword.getText().trim();
					String StudentId = tfID.getText().trim();
					
					Student std = new Student();
					std.setName(Name);
				    std.setSurname(Surname);
					std.setEmail(Email);
					std.setPassword(Password);
					std.setStudentId(StudentId);
					
					int result = std.addStudent(std); 
					if(result>0) {
						//   JOptionPane.showMessageDialog(null, "Student Added.","Display Message",JOptionPane.INFORMATION_MESSAGE);
							JOptionPane.showMessageDialog(null, "Student Added.");
						}
						else
							JOptionPane.showMessageDialog(null, "Student Not Added.");
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(67, 301, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(24, 117, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(24, 154, 66, 16);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(24, 189, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblCreateNewAccount = new JLabel("CREATE NEW ACCOUNT");
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblCreateNewAccount.setBounds(93, 65, 215, 16);
		contentPane.add(lblCreateNewAccount);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(24, 224, 73, 16);
		contentPane.add(lblPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(22, 254, 56, 16);
		contentPane.add(lblId);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.WHITE);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				login l= new login();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setBounds(195, 301, 97, 25);
		contentPane.add(btnBack);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(100, 216, 202, 22);
		contentPane.add(pfPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\_DSC4109-Modifier-2.jpg"));
		lblNewLabel.setBounds(0, 0, 354, 449);
		contentPane.add(lblNewLabel);
	}
}
