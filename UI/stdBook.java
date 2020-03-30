package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Model.Kitap;
import Model.myUtils;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class stdBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;

	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar= {"Book","Author","Publisher","BookTypes","YearOfIssue","ShelfNumber","BookId"};
    Object[] satirlar= new Object[7];
    
    DefaultTableModel modelim2 = new DefaultTableModel();
    Object[] kolon= {"Book","Author","Publisher","BookTypes","YearOfIssue","ShelfNumber","BookId"};
    Object[] satir= new Object[7];
    
    private JButton btnNewButton_1;
    private JScrollPane scrollPane_1;
    private JTable table_1;
    private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stdBook frame = new stdBook();
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
	public stdBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 34, 228, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 492, 58);
		contentPane.add(scrollPane);
		

		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		scrollPane.setViewportView(table);
		table.setModel(modelim);
		table.setBounds(64, 156, 176, 54);
		
	JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Book = textField.getText().trim();
					Kitap k = new Kitap();
					
					ResultSet rs = k.searchKitapByBook(Book);
					
					table.setModel(myUtils.buildTableModel(rs));
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(252, 31, 119, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("VIEW BOOKS");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Kitap k = new Kitap();
					
						ResultSet rs = k.viewKitap();
						table_1.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setBounds(12, 140, 194, 25);
		contentPane.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 178, 492, 158);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolon);
		modelim2.addRow(satir);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(modelim2);
		table_1.setBounds(258, 224, 113, 66);
		
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
		lblNewLabel.setBounds(458, 13, 43, 53);
		contentPane.add(lblNewLabel);
		
		
		//contentPane.add(table_1);
		
}

}
