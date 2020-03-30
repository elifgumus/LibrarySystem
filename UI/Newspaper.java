package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Dergi;
import Model.Gazete;
import Model.myUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class Newspaper extends JFrame {

	private JPanel contentPane;
	private JTextField tfGazete;
	private JTextField tfBasimTarihi;
	private JTextField tfRafNo;
	private JTextField tfGazeteId;
	private JTable table;

	DefaultTableModel modelim = new DefaultTableModel();
	  Object[] kolonlar= {"Gazete","BasimTarihi","RafNo","GazeteId"};
	   Object[] satirlar= new Object[4];
	   private JTextField textField;
	   private JTable table_1;
	   
	   DefaultTableModel modelim2 = new DefaultTableModel();
	   Object[] kolon= {"Gazete","BasimTarihi","RafNo","GazeteId"};
	   Object[] satir= new Object[4];
	   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newspaper frame = new Newspaper();
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
	public Newspaper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 242, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGazete = new JLabel("Gazete");
		lblGazete.setBounds(12, 128, 56, 16);
		panel.add(lblGazete);
		
		JLabel lblBasmTarihi = new JLabel("Bas\u0131m Tarihi");
		lblBasmTarihi.setBounds(12, 163, 71, 16);
		panel.add(lblBasmTarihi);
		
		tfGazete = new JTextField();
		tfGazete.setBounds(90, 125, 140, 22);
		panel.add(tfGazete);
		tfGazete.setColumns(10);
		
		tfBasimTarihi = new JTextField();
		tfBasimTarihi.setBounds(90, 160, 140, 22);
		panel.add(tfBasimTarihi);
		tfBasimTarihi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Raf No");
		lblNewLabel.setBounds(12, 192, 56, 16);
		panel.add(lblNewLabel);
		
		tfRafNo = new JTextField();
		tfRafNo.setBounds(90, 189, 140, 22);
		panel.add(tfRafNo);
		tfRafNo.setColumns(10);
		
		JLabel lblGazeteId = new JLabel("Gazete ID");
		lblGazeteId.setBounds(12, 221, 56, 16);
		panel.add(lblGazeteId);
		
		tfGazeteId = new JTextField();
		tfGazeteId.setBounds(90, 218, 140, 22);
		panel.add(tfGazeteId);
		tfGazeteId.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(90, 288, 140, 16);
		panel.add(lblMessage);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Gazete = tfGazete.getText().trim();
				    String BasimTarihi =tfBasimTarihi.getText().trim();
					String RafNo = tfRafNo.getText().trim();
					String GazeteId = tfGazeteId.getText().trim();
					
					Gazete g = new Gazete();
					g.setGazete(Gazete);
				    g.setBasimTarihi(BasimTarihi);
					g.setRafNo(RafNo);
					g.setGazeteId(GazeteId);
					
					int result = g.AddGazete(g); 
						
				if(result>0) {
					
					    lblMessage.setText("Gazete Added.");
						lblMessage.setForeground(Color.BLACK);	
					}
					
						else {
							lblMessage.setText("Gazete Not Added.");
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
		btnNewButton.setBounds(90, 253, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\newspaper.png"));
		lblNewLabel_1.setBounds(81, 28, 149, 84);
		panel.add(lblNewLabel_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(244, 0, 388, 335);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 45, 327, 108);
		panel_1.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table.setModel(modelim);
		scrollPane.setViewportView(table);
		table.setBounds(72, 137, 218, 57);
		//panel_1.add(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 225, 327, 36);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolon);
		modelim2.addRow(satir);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(modelim2);
		table_1.setBounds(276, 248, 74, 35);
		
		JButton btnNewButton_1 = new JButton("Show Newspapers");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Gazete g = new Gazete();
					
						ResultSet rs = g.viewGazete();
						table.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(37, 13, 156, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String  GazeteId = textField.getText().trim();
					Gazete g = new Gazete();
					
					ResultSet rs = g.searchGazeteByGazeteId(GazeteId);
					
					table_1.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		btnNewButton_2.setBounds(186, 187, 106, 25);
		panel_1.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(37, 188, 137, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
	
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(37, 290, 71, 2);
		panel_1.add(separator);
		
		JLabel lblMessage2 = new JLabel("");
		lblMessage2.setBounds(37, 305, 156, 16);
		panel_1.add(lblMessage2);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Gazete g = new Gazete();
					int t = g.deleteGazete((textField.getText()));  
					if(t>0) {

				        lblMessage2.setText("Gazete Deleted.");
						lblMessage2.setForeground(Color.BLACK);	
				}
					else {
					lblMessage2.setText("Gazete Not Deleted.");
					lblMessage2.setForeground(Color.BLACK);	}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(37, 274, 71, 16);
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
		lblNewLabel_3.setBounds(308, 274, 80, 47);
		panel_1.add(lblNewLabel_3);
		
		
		//panel_1.add(table_1);
	}
}
