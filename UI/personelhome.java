package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class personelhome extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personelhome frame = new personelhome();
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
	public personelhome() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(new Color(255, 235, 205));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 381);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu mnFe = new JMenu("New");
		mnFe.setBackground(new Color(255, 235, 205));
		menuBar.add(mnFe);
		
		JMenuItem mnýtmLibrarian = new JMenuItem("Librarian");
		mnýtmLibrarian.setBackground(new Color(253, 245, 230));
		mnýtmLibrarian.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Librarian ln = new Librarian();
				ln.setVisible(true);
			}
		});
		mnFe.add(mnýtmLibrarian);
		
		JMenuItem mnýtmStudent = new JMenuItem("Student");
		mnýtmStudent.setBackground(new Color(253, 245, 230));
		mnýtmStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddStudent as = new AddStudent();
				as.setVisible(true);
			}
		});
		mnFe.add(mnýtmStudent);
		
		JMenu mnBook = new JMenu("Book");
		mnBook.setBackground(new Color(244, 164, 96));
		mnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				KitapEkle ke = new KitapEkle();
				ke.setVisible(true);
			}
		});
		menuBar.add(mnBook);
		
		JMenu mnNewMenu = new JMenu("Magazin");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Magazin mz = new Magazin();
				mz.setVisible(true);
			}
		});
		mnNewMenu.setBackground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewspaper = new JMenu("Newspaper");
		mnNewspaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Newspaper n = new Newspaper();
				n.setVisible(true);
			}
		});
		mnNewspaper.setBackground(new Color(244, 164, 96));
		menuBar.add(mnNewspaper);
		
		JMenu mnNewMenu_1 = new JMenu("Logout");
		mnNewMenu_1.setBackground(new Color(244, 164, 96));
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				login l = new login();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		getContentPane().setLayout(null);
	}
}
