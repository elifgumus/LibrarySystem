package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Dergi;
import Model.Student;
import Model.myUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Magazin extends JFrame {

	private JPanel contentPane;
	private JTextField tfDergi;
	private JTextField tfDergiSayisi;
	private JTextField tfDergiTuru;
	private JTextField tfBasimAyi;
	private JTextField tfRafNo;
	private JTextField tfDergiId;
	private JTable table_1;
	  private JTextField textField;
	   private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	DefaultTableModel modelim2 = new DefaultTableModel();
	  Object[] kolonlar= {"Dergi","DergiSayisi","DergiTuru","BasimAyi","RafNo","DergiId"};
	   Object[] satirlar= new Object[6];
	   Object[] kolon= {"Dergi","DergiSayisi","DergiTuru","BasimAyi","RafNo","DergiId"};
	   Object[] satir= new Object[6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Magazin frame = new Magazin();
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
	public Magazin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 302, 390);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMagazin = new JLabel("Dergi");
		lblMagazin.setBounds(12, 114, 56, 16);
		panel.add(lblMagazin);
		
		tfDergi = new JTextField();
		tfDergi.setBounds(92, 111, 198, 22);
		panel.add(tfDergi);
		tfDergi.setColumns(10);
		
		JLabel lblDergiSays = new JLabel("Dergi Say\u0131s\u0131");
		lblDergiSays.setBounds(12, 149, 72, 16);
		panel.add(lblDergiSays);
		
		tfDergiSayisi = new JTextField();
		tfDergiSayisi.setBounds(92, 146, 198, 22);
		panel.add(tfDergiSayisi);
		tfDergiSayisi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dergi T\u00FCr\u00FC");
		lblNewLabel.setBounds(12, 184, 72, 16);
		panel.add(lblNewLabel);
		
		tfDergiTuru = new JTextField();
		tfDergiTuru.setBounds(92, 181, 198, 22);
		panel.add(tfDergiTuru);
		tfDergiTuru.setColumns(10);
		
		JLabel lblBasmAy = new JLabel("Bas\u0131m Ay\u0131");
		lblBasmAy.setBounds(12, 225, 56, 16);
		panel.add(lblBasmAy);
		
		JLabel lblRafNo = new JLabel("Raf No");
		lblRafNo.setBounds(12, 254, 56, 16);
		panel.add(lblRafNo);
		
		JLabel lblDergiId = new JLabel("Dergi ID");
		lblDergiId.setBounds(12, 283, 56, 16);
		panel.add(lblDergiId);
		
		tfBasimAyi = new JTextField();
		tfBasimAyi.setBounds(92, 216, 198, 22);
		panel.add(tfBasimAyi);
		tfBasimAyi.setColumns(10);
		
		tfRafNo = new JTextField();
		tfRafNo.setBounds(92, 251, 198, 22);
		panel.add(tfRafNo);
		tfRafNo.setColumns(10);
		
		tfDergiId = new JTextField();
		tfDergiId.setBounds(92, 280, 198, 22);
		panel.add(tfDergiId);
		tfDergiId.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(92, 350, 141, 16);
		panel.add(lblMessage);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\dergi.png"));
		lblNewLabel_1.setBounds(98, 25, 155, 73);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String  Dergi = tfDergi.getText().trim();
				    String DergiSayisi =tfDergiSayisi.getText().trim();
					String  DergiTuru = tfDergiTuru.getText().trim();							
					String BasimAyi = tfBasimAyi.getText().trim();
					String RafNo = tfRafNo.getText().trim();
					String DergiId = tfDergiId.getText().trim();
					
					Dergi d = new Dergi();
					d.setDergi(Dergi);
				    d.setDergiSayisi(DergiSayisi);
					d.setDergiTuru(DergiTuru);
					d.setBasimAyi(BasimAyi);
					d.setRafNo(RafNo);
					d.setDergiId(DergiId);
					
					int result = d.addDergi(d); 
						
				if(result>0) {
					
					    lblMessage.setText("Dergi Added.");
						lblMessage.setForeground(Color.BLACK);	
					}
					
						else {
							lblMessage.setText("Student Not Added.");
							lblMessage.setForeground(Color.BLACK);	}
						
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				//	JOptionPane.showMessageDialog(null,e.getMessage(), "System Error", "JOptionPane.ERROR_MESSAGE");
				}

			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(92, 316, 97, 25);
		panel.add(btnNewButton);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(305, 0, 430, 390);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Show Magazins");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Dergi d = new Dergi();
					
						ResultSet rs = d.viewDergi();
						table_1.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(31, 13, 164, 25);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 51, 371, 145);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table_1.setModel(modelim);
		scrollPane.setViewportView(table_1);
		table_1.setBounds(79, 204, 260, 49);
		
		textField = new JTextField();
		textField.setBounds(36, 234, 124, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 269, 371, 51);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(modelim2);
		scrollPane_1.setViewportView(table);
		table.setBounds(266, 293, 124, 51);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String DergiId = textField.getText().trim();
					Dergi d = new Dergi();
					
					ResultSet rs = d.searchDergiByDergiId(DergiId);
					
					table.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(194, 233, 105, 25);
		panel_1.add(btnNewButton_2);
		
	/*	JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 269, 371, 51);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(modelim2);
		scrollPane_1.setViewportView(table);
		table.setBounds(266, 293, 124, 51); */
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(31, 352, 73, 2);
		panel_1.add(separator);
		
		JLabel lblMessage2 = new JLabel("");
		lblMessage2.setBounds(31, 361, 164, 16);
		panel_1.add(lblMessage2);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Dergi d = new Dergi();
					int t = d.deleteDergi((textField.getText()));  
					if(t>0) {

				        lblMessage2.setText("Dergi Deleted.");
						lblMessage2.setForeground(Color.BLACK);	
				}
					else {
					lblMessage2.setText("Dergi Not Deleted.");
					lblMessage2.setForeground(Color.BLACK);	}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(31, 333, 97, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				personelhome ph = new personelhome();
				ph.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\backk.png"));
		lblNewLabel_3.setBounds(344, 333, 74, 44);
		panel_1.add(lblNewLabel_3);
		
	
		//panel_1.add(table);
		//panel_1.add(table_1);
		
	
		
	}
}
