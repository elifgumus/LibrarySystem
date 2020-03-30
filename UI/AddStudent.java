package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Student;
import Model.myUtils;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfEmail;
	private JPasswordField pfPassword;
	private JTextField tfID;
	private JTable table;
    private JTable table_1;
    DefaultTableModel modelim = new  DefaultTableModel();
    
    Object[] kolonlar= {"Name","Surname","Email","Password","StudentId"};
    Object[] satirlar= new Object[5];
   // private JTable table_1;
    DefaultTableModel modelim2 = new  DefaultTableModel();
    Object[] kolon= {"Name","Surname","Email","Password","StudentId"};
    Object[] satir= new Object[5];
    private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 272, 412);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 144, 68, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 183, 68, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\dgxfh.jpg"));
		lblNewLabel_1.setBounds(60, 13, 177, 118);
		panel.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(83, 147, 177, 22);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfSurname = new JTextField();
		tfSurname.setBounds(83, 181, 177, 22);
		panel.add(tfSurname);
		tfSurname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(12, 214, 56, 16);
		panel.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(83, 212, 177, 22);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(12, 249, 68, 16);
		panel.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(83, 247, 177, 22);
		panel.add(pfPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(12, 284, 56, 16);
		panel.add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(83, 282, 177, 22);
		panel.add(tfID);
		tfID.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
				//	JOptionPane.showMessageDialog(null,e.getMessage(), "System Error", "JOptionPane.ERROR_MESSAGE");
					JOptionPane.showMessageDialog(null, e.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
 
			}
		});
		btnAdd.setBackground(new Color(244, 164, 96));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(83, 317, 97, 25);
		panel.add(btnAdd);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(83, 372, 66, 2);
		panel.add(separator_1);
		separator_1.setBackground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("UPDATE");
		lblNewLabel_4.setBounds(82, 355, 86, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent e) {
                     try {
					String Email = tfEmail.getText().trim();							
					String Password = pfPassword.getText().trim();
					
		     		Student std = new Student();
					std.setEmail(Email);
					std.setPassword(Password);
					
					int result = std.updateStudent(std); 
					
					if(result>0)
						JOptionPane.showMessageDialog(null, "Student Updated");
					else
						JOptionPane.showMessageDialog(null, "Student Not Updated");
					} catch(Exception e5){
						
					}
			}
		}); 
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(274, 0, 483, 412);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				personelhome ph= new personelhome();
				ph.setLocationRelativeTo(null);
				ph.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\aszfs.png"));
		lblNewLabel_3.setBounds(451, 0, 45, 56);
		panel_1.add(lblNewLabel_3);

		
		JScrollPane scrollPane = new JScrollPane();
	/*	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfName.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				tfSurname.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				tfEmail.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				pfPassword.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				tfID.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
			}
		}); */
		scrollPane.setBounds(12, 56, 445, 169);
		panel_1.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table.setModel(modelim);
		table.setBounds(62, 204, 311, 133);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Students");
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Student std = new Student();
					
						ResultSet rs = std.viewStudent();
						table.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(12, 20, 216, 29);
		panel_1.add(btnNewButton);
	
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(32, 364, 66, 2);
		panel_1.add(separator);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(27, 379, 182, 21);
		panel_1.add(lblMessage);
		//panel_1.add(table_1);
		//panel_1.add(table);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Student std = new Student();
					int t = std.deleteStudent((textField.getText()));  
					if(t>0) {

				        lblMessage.setText("Student Deleted.");
						lblMessage.setForeground(Color.BLACK);	
				}
					else {
					lblMessage.setText("Student Not Deleted.");
					lblMessage.setForeground(Color.BLACK);	}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}
		});
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDelete.setBounds(32, 346, 81, 16);
		panel_1.add(lblDelete);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfName.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
				tfSurname.setText(modelim.getValueAt(table.getSelectedRow(),1).toString());
				tfEmail.setText(modelim.getValueAt(table.getSelectedRow(),2).toString());
				pfPassword.setText(modelim.getValueAt(table.getSelectedRow(),3).toString());
				tfID.setText(modelim.getValueAt(table.getSelectedRow(),4).toString());
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 294, 423, 39);
		panel_1.add(scrollPane_1);
		
		
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolon);
		modelim2.addRow(satir);
		table_1.setModel(modelim2);
		table_1.setBounds(22, 329, 132, 15);
		scrollPane_1.setViewportView(table_1);
		
		
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String StudentId = textField.getText().trim();
					//String IDNumber = tfSearch.getText().trim();
					Student std = new Student();
					
					ResultSet rs = std.searchStudentByStudentId(StudentId);
					
					table_1.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(12, 259, 152, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		

		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setBounds(192, 256, 115, 25);
		panel_1.add(btnNewButton_1);
		
		
	}
}
