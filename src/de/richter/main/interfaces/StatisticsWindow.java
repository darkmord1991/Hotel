package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StatisticsWindow {

	private JFrame frame;
	private JTable table;
	private JTextField textGuestday;
	private JTextField texGuestcame;
	private JTextField textGuestaway;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsWindow window = new StatisticsWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatisticsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 210);
		frame.setTitle("Statistiken");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 241, 464, -221);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Zimmernr.", "Art", "Pl\u00E4tze", "belegt bis", "Gastnr."
			}
		));
		frame.getContentPane().add(table);
		
		JLabel LabelGuestday = new JLabel("G\u00E4ste/Tag:");
		LabelGuestday.setBounds(30, 31, 189, 14);
		frame.getContentPane().add(LabelGuestday);
		
		JLabel LabelGuesthere = new JLabel("G\u00E4ste angereist:");
		LabelGuesthere.setBounds(30, 62, 189, 14);
		frame.getContentPane().add(LabelGuesthere);
		
		JLabel LabelGuestaway = new JLabel("G\u00E4ste abgereist:");
		LabelGuestaway.setBounds(30, 90, 189, 14);
		frame.getContentPane().add(LabelGuestaway);
		
		textGuestday = new JTextField();
		textGuestday.setBounds(133, 31, 86, 20);
		frame.getContentPane().add(textGuestday);
		textGuestday.setColumns(10);
		
		texGuestcame = new JTextField();
		texGuestcame.setColumns(10);
		texGuestcame.setBounds(133, 59, 86, 20);
		frame.getContentPane().add(texGuestcame);
		
		textGuestaway = new JTextField();
		textGuestaway.setColumns(10);
		textGuestaway.setBounds(133, 87, 86, 20);
		frame.getContentPane().add(textGuestaway);
		
		JButton btnClose = new JButton("Schlie\u00DFen");
		btnClose.setBounds(83, 131, 95, 29);
		frame.getContentPane().add(btnClose);
	}
}
