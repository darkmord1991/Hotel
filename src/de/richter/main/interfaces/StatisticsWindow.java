package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsWindow {

	private JFrame frmStatistics;
	private JTextField textFieldGuestday;
	private JTextField textFieldGuestcame;
	private JTextField textFieldGuestaway;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsWindow window = new StatisticsWindow();
					window.frmStatistics.setVisible(true);
					window.frmStatistics.setLocationRelativeTo(null);
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
		frmStatistics = new JFrame();
		frmStatistics.setBounds(100, 100, 280, 210);
		frmStatistics.setTitle("Statistiken");
		frmStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistics.getContentPane().setLayout(null);
		
		JLabel lblGuestday = new JLabel("G\u00E4ste/Tag:");
		lblGuestday.setBounds(30, 31, 189, 14);
		frmStatistics.getContentPane().add(lblGuestday);
		
		JLabel lblGuesthere = new JLabel("G\u00E4ste angereist:");
		lblGuesthere.setBounds(30, 62, 189, 14);
		frmStatistics.getContentPane().add(lblGuesthere);
		
		JLabel lblGuestaway = new JLabel("G\u00E4ste abgereist:");
		lblGuestaway.setBounds(30, 90, 189, 14);
		frmStatistics.getContentPane().add(lblGuestaway);
		
		textFieldGuestday = new JTextField();
		textFieldGuestday.setBounds(133, 31, 86, 20);
		frmStatistics.getContentPane().add(textFieldGuestday);
		textFieldGuestday.setColumns(10);
		
		textFieldGuestcame = new JTextField();
		textFieldGuestcame.setColumns(10);
		textFieldGuestcame.setBounds(133, 59, 86, 20);
		frmStatistics.getContentPane().add(textFieldGuestcame);
		
		textFieldGuestaway = new JTextField();
		textFieldGuestaway.setColumns(10);
		textFieldGuestaway.setBounds(133, 87, 86, 20);
		frmStatistics.getContentPane().add(textFieldGuestaway);
		
		JButton btnClose = new JButton("Schlie\u00DFen");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Statistiken werden geschlossen");
				frmStatistics.setVisible(false);
			}
		});
		btnClose.setBounds(83, 131, 95, 29);
		frmStatistics.getContentPane().add(btnClose);
	}

	public JFrame getFrmStatistics() {
		return frmStatistics;
	}

	public void setFrmStatistics(JFrame frmStatistics) {
		this.frmStatistics = frmStatistics;
	}
	
}
