package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Gazete;
import Model.myUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class stdNewspaper extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	DefaultTableModel newspaper = new DefaultTableModel();
	 Object[] kolonlar= {"Gazete","BasimTarihi","RafNo","GazeteId"};
	   Object[] satirlar= new Object[4];
	   private JButton btnNewButton_1;
	   private JScrollPane scrollPane_1;
	   private JTable table_1;
	   private JLabel lblNewLabel;
	   
	   DefaultTableModel model = new DefaultTableModel();
	   Object[] kolon= {"Gazete","BasimTarihi","RafNo","GazeteId"};
	   Object[] satir= new Object[4];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stdNewspaper frame = new stdNewspaper();
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
	public stdNewspaper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 25, 228, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String  Gazete = textField.getText().trim();
					Gazete g = new Gazete();
					
					ResultSet rs = g.searchGazeteByGazete(Gazete);
					
					table.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(290, 24, 117, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 60, 408, 48);
		contentPane.add(scrollPane);
		
		table = new JTable();
		newspaper.setColumnIdentifiers(kolonlar);
		newspaper.addRow(satirlar);
		table.setModel(newspaper);
		scrollPane.setViewportView(table);
		table.setBounds(96, 134, 315, 37);
		
		btnNewButton_1 = new JButton("VIEW NEWSPAPER");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Gazete g = new Gazete();
					
						ResultSet rs = g.viewGazete();
						table_1.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(34, 121, 266, 25);
		contentPane.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 159, 408, 97);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		model.setColumnIdentifiers(kolon);
		model.addRow(satir);
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);
		table_1.setBounds(89, 259, 292, 37);
		
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
		lblNewLabel.setBounds(409, 269, 61, 53);
		contentPane.add(lblNewLabel);
		//contentPane.add(table_1);
	//	contentPane.add(table);
	}
}
