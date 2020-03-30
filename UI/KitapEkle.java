package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Kitap;

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
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;




public class KitapEkle extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfBookTypes;
	private JTextField tfYear;
	private JTextField tfShelf;
	private JTextField tfBookId;
	private JTable table;
	 private JTextField textField;
	    private JTable table_1;
	
	DefaultTableModel book = new DefaultTableModel();
	DefaultTableModel search = new DefaultTableModel();
	Object[] kolonlar= {"Book","Author","Publisher","BookTypes","YearOfIssue","ShelfNumber","BookId"};
    Object[] satirlar= new Object[7];
    
	Object[] kolon= {"Book","Author","Publisher","BookTypes","YearOfIssue","ShelfNumber","BookId"};
    Object[] satir= new Object[7];
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitapEkle frame = new KitapEkle();
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
	public KitapEkle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 282, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setBounds(12, 114, 64, 16);
		panel.add(lblNewLabel);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(99, 111, 171, 22);
		panel.add(tfBookName);
		tfBookName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setBounds(12, 143, 56, 16);
		panel.add(lblNewLabel_1);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(98, 140, 172, 22);
		panel.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		JLabel lblStringQuery = new JLabel("Publisher");
		lblStringQuery.setBounds(12, 178, 56, 16);
		panel.add(lblStringQuery);
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(98, 175, 172, 22);
		panel.add(tfPublisher);
		tfPublisher.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Types");
		lblNewLabel_2.setBounds(12, 207, 76, 16);
		panel.add(lblNewLabel_2);
		
		tfBookTypes = new JTextField();
		tfBookTypes.setBounds(98, 204, 172, 22);
		panel.add(tfBookTypes);
		tfBookTypes.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Year Of Issue");
		lblNewLabel_3.setBounds(12, 236, 90, 16);
		panel.add(lblNewLabel_3);
		
		tfYear = new JTextField();
		tfYear.setBounds(98, 233, 172, 22);
		panel.add(tfYear);
		tfYear.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Shelf Number");
		lblNewLabel_4.setBounds(12, 265, 90, 16);
		panel.add(lblNewLabel_4);
		
		tfShelf = new JTextField();
		tfShelf.setBounds(98, 265, 172, 22);
		panel.add(tfShelf);
		tfShelf.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Book ID");
		lblNewLabel_5.setBounds(12, 297, 56, 16);
		panel.add(lblNewLabel_5);
		
		tfBookId = new JTextField();
		tfBookId.setBounds(99, 294, 171, 22);
		panel.add(tfBookId);
		tfBookId.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMessage.setBounds(99, 367, 148, 16);
		panel.add(lblMessage);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\booksfdx.png"));
		lblNewLabel_6.setBounds(83, 13, 164, 99);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Book = tfBookName.getText().trim();
				    String Author =tfAuthor.getText().trim();
					String Publisher = tfPublisher.getText().trim();							
					String BookTypes = tfBookTypes.getText().trim();
					String YearOfIssue = tfYear.getText().trim();
				    String ShelfNumber =tfShelf.getText().trim();
					String BookId = tfBookId.getText().trim();
					
					Kitap k = new Kitap();
					k.setBook(Book);
				    k.setAuthor(Author);
					k.setPublisher(Publisher);
					k.setBookTypes(BookTypes);
					k.setYearOfIssue(YearOfIssue);
					k.setShelfNumber(ShelfNumber);
					k.setBookId(BookId);
					
					int result = k.addKitap(k); 
						
				if(result>0) {
					
			        lblMessage.setText("Book Added.");
					lblMessage.setForeground(Color.BLACK);	
					}
					else {
						lblMessage.setText("Book Not Added.");
				         lblMessage.setForeground(Color.BLACK);	}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(99, 329, 97, 25);
		panel.add(btnNewButton);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(284, 0, 566, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Show Books");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Kitap k = new Kitap();
					
						ResultSet rs = k.viewKitap();
						table.setModel(myUtils.buildTableModel(rs));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(26, 13, 192, 31);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 57, 528, 159);
		panel_1.add(scrollPane);
		
		table = new JTable();
		book.setColumnIdentifiers(kolonlar);
		book.addRow(satirlar);
		table.setModel(book);
		scrollPane.setViewportView(table);
		table.setBounds(36, 236, 256, 79);
		
		textField = new JTextField();
		textField.setBounds(28, 248, 126, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String BookId = textField.getText().trim();
					Kitap k = new Kitap();
					
					ResultSet rs = k.searchKitapByBookId(BookId);
					
					table_1.setModel(myUtils.buildTableModel(rs));	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(168, 245, 126, 25);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 283, 528, 38);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		//table_1.addMouseListener(new MouseAdapter() {
			
		//});
		search.setColumnIdentifiers(kolon);
		search.addRow(satir);
		table_1.setModel(search);
		scrollPane_1.setViewportView(table_1);
		table_1.setBounds(293, 300, 192, 53);
		
		JLabel lblMessage2 = new JLabel("");
		lblMessage2.setBounds(26, 367, 160, 16);
		panel_1.add(lblMessage2);
		//panel_1.add(table_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(26, 358, 65, 2);
		panel_1.add(separator);
		
		JLabel lblNewLabel_7 = new JLabel("DELETE");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Kitap k = new Kitap();
					int t = k.deleteKitap((textField.getText()));  
					if(t>0) {

				        lblMessage2.setText("Book Deleted.");
						lblMessage2.setForeground(Color.BLACK);	
				}
					else {
					lblMessage2.setText("Book Not Deleted.");
					lblMessage2.setForeground(Color.BLACK);	}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
				
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(26, 338, 105, 16);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				personelhome ph= new personelhome();
				ph.setLocationRelativeTo(null);
				ph.setVisible(true);
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\D\u0130LEK\\Desktop\\BM-2\\icon\\backk.png"));
		lblNewLabel_8.setBounds(485, 338, 69, 51);
		panel_1.add(lblNewLabel_8);
		
	
	
		
		
	

	}
}
