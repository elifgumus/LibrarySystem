package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Model.Personel;
import Model.Student;
import Model.myUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Librarian extends JFrame {

	private JPanel contentPane;
	private JTextField tFName;
	private JTextField tFSurname;
	private JTextField tFEmail;
	private JPasswordField pFPassword;
	private JTextField tFID;
	private JTable table;
	 private JTextField textField;
	 private JTable table_1;
	 
	DefaultTableModel model = new DefaultTableModel();
	Object[] kolon = {"Name","Surname","Email","Password","PersonelId"};
	 Object[] satir= new Object[5];
	
	 DefaultTableModel tblSearch = new DefaultTableModel();
	 Object[] kolonlar= {"Name","Surname","Email","Password","PersonelId"};
	 Object[] satirlar= new Object[5];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian frame = new Librarian();
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
	public Librarian() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 266, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 134, 56, 16);
		panel.add(lblName);
		
		tFName = new JTextField();
		tFName.setBounds(68, 131, 175, 22);
		panel.add(tFName);
		tFName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(12, 166, 56, 16);
		panel.add(lblSurname);
		
		tFSurname = new JTextField();
		tFSurname.setBounds(68, 163, 175, 22);
		panel.add(tFSurname);
		tFSurname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 202, 56, 16);
		panel.add(lblEmail);
		
		tFEmail = new JTextField();
		tFEmail.setBounds(68, 199, 175, 22);
		panel.add(tFEmail);
		tFEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 234, 56, 16);
		panel.add(lblPassword);
		
		pFPassword = new JPasswordField();
		pFPassword.setBounds(68, 231, 175, 22);
		panel.add(pFPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 269, 56, 16);
		panel.add(lblId);
		
		tFID = new JTextField();
		tFID.setBounds(68, 266, 175, 22);
		panel.add(tFID);
		tFID.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String  Name = tFName.getText().trim();
				    String Surname =tFSurname.getText().trim();
					String  Email = tFEmail.getText().trim();							
					String Password = pFPassword.getText().trim();
					String PersonelId = tFID.getText().trim();
					
					Personel p = new Personel();
					p.setName(Name);
				    p.setSurname(Surname);
					p.setEmail(Email);
					p.setPassword(Password);
					p.setPersonelId(PersonelId);
					
					int result = p.addPersonel(p); 
						
				if(result>0) {
					//   JOptionPane.showMessageDialog(null, "Student Added.","Display Message",JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "Librarian Added.");
					}
					else
						JOptionPane.showMessageDialog(null, "Librarian Not Added.");
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				} 
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setBackground(new Color(244, 164, 96));
		btnAdd.setBounds(68, 305, 97, 25);
		panel.add(btnAdd);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(68, 362, 69, 2);
		panel.add(separator);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdate.setBounds(68, 343, 89, 16);
		panel.add(lblUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\admn.png"));
		lblNewLabel.setBounds(84, 36, 142, 86);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(268, 0, 380, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 356, 158);
		panel_1.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolon);
		model.addRow(satir);
		table.setModel(model);
		table.setBounds(60, 150, 207, 61);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Librarians");
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Personel p = new Personel();
					
						ResultSet rs = p.viewPersonel();
						table.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(12, 26, 143, 27);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 254, 143, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String PersonelId = textField.getText().trim();
					//String IDNumber = tfSearch.getText().trim();
					Personel p = new Personel();
					
					ResultSet rs = p.searchPersonelByPersonelId(PersonelId);
					
					table_1.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(167, 252, 97, 25);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 289, 356, 36);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		/*table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tFName.setText(tblSearch.getValueAt(table_1.getSelectedRow(),0).toString());
				tFSurname.setText(tblSearch.getValueAt(table_1.getSelectedRow(),1).toString());
				tFEmail.setText(tblSearch.getValueAt(table_1.getSelectedRow(),2).toString());
				pFPassword.setText(tblSearch.getValueAt(table_1.getSelectedRow(),3).toString());
				tFID.setText(tblSearch.getValueAt(table_1.getSelectedRow(),4).toString());
			}
		});*/
		tblSearch.setColumnIdentifiers(kolonlar);
		tblSearch.addRow(satirlar);
		table_1.setModel(tblSearch);
		table_1.setBounds(203, 324, 56, 40);
		scrollPane_1.setViewportView(table_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(12, 354, 71, 2);
		panel_1.add(separator_1);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(12, 362, 143, 16);
		panel_1.add(lblMessage);
		
		JLabel lblNewLabel_1 = new JLabel("DELETE");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Personel p = new Personel();
					int t = p.deletePersonel((textField.getText()));  
					if(t>0) {

				        lblMessage.setText("Librarian Deleted.");
						lblMessage.setForeground(Color.BLACK);	
				}
					else {
					lblMessage.setText("Librarian Not Deleted.");
					lblMessage.setForeground(Color.BLACK);	}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 338, 79, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				personelhome ph = new personelhome();
				ph.setLocationRelativeTo(null);
				ph.setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\aszfs.png"));
		lblNewLabel_2.setBounds(333, 13, 35, 40);
		panel_1.add(lblNewLabel_2);
		
	
		//panel_1.add(table_1);
		//panel_1.add(table);
	}
}
