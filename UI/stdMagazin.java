package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Dergi;
import Model.Kitap;
import Model.myUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class stdMagazin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	DefaultTableModel search = new DefaultTableModel();
	 Object[] kolonlar= {"Dergi","DergiSayisi","DergiTuru","BasimAyi","RafNo","DergiId"};
	   Object[] satirlar= new Object[6];
	   private JButton btnNewButton_1;
	   private JScrollPane scrollPane_1;
	   private JTable table_1;
	   
	   DefaultTableModel show = new DefaultTableModel();   
	   Object[] kolon= {"Dergi","DergiSayisi","DergiTuru","BasimAyi","RafNo","DergiId"};
	   Object[] satir= new Object[6];
	   private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stdMagazin frame = new stdMagazin();
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
	public stdMagazin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 26, 255, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Dergi = textField.getText().trim();
					Dergi d = new Dergi();
					
					ResultSet rs = d.searchDergiByDergi(Dergi);
					
					table.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(289, 23, 128, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 73, 395, 59);
		contentPane.add(scrollPane);
		
		table = new JTable();
		search.setColumnIdentifiers(kolonlar);
		search.addRow(satirlar);
		scrollPane.setViewportView(table);
		table.setModel(search);
		table.setBounds(100, 214, 255, 33);
		
		btnNewButton_1 = new JButton("VIEW MAGAZINS");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Dergi d = new Dergi();
					
						ResultSet rs = d.viewDergi();
						table_1.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e7) {
						// TODO Auto-generated catch block
						e7.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(22, 145, 160, 25);
		contentPane.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 183, 395, 105);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		show.setColumnIdentifiers(kolon);
		show.addRow(satir);
		scrollPane_1.setViewportView(table_1);
		table_1.setBounds(118, 268, 159, 38);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				studenthome sh = new studenthome();
				sh.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\backk.png"));
		lblNewLabel.setBounds(345, 301, 81, 52);
		contentPane.add(lblNewLabel);
	//	contentPane.add(table_1);
		//contentPane.add(table);
	}

}
