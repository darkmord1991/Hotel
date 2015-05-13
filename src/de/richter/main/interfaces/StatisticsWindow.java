package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsWindow {
	private String came;
	private String there;
	private String away;

	private JFrame frmStatistics;
	private JButton btnClose;
	
	JLabel lblGuestNow = new JLabel("");
	JLabel lblGuestThere = new JLabel("");
	JLabel lblGuestGone = new JLabel("");

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

	public StatisticsWindow() {
		updateStats();
		initialize();
	}

	public void updateStats() {
		// Statistiken laden
		BufferedReader stats_br = null;
		String stats;
		try {
			System.out.println("***  Statistik-Fenster-Statistiken werden geladen  ***");
			stats_br = new BufferedReader(new FileReader("statistics.txt"));
			while ((stats = stats_br.readLine()) != null && !stats.isEmpty()) {
				System.out.println(stats);
				String[] arr = stats.split(";");
				came = arr[0];
				there = arr[1];
				away = arr[2];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblGuestNow.setText(came);
		lblGuestThere.setText(there);
		lblGuestGone.setText(away);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {					
		frmStatistics = new JFrame();
		frmStatistics.setBounds(100, 100, 280, 210);
		frmStatistics.setTitle("Statistiken");
//		frmStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Wegen WindowListener nicht n�tig
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
		
		btnClose = new JButton("Schlie\u00DFen");
		btnClose.setBounds(179, 130, 95, 29);
		frmStatistics.getContentPane().add(btnClose);
		
		lblGuestNow.setBounds(142, 31, 46, 14);
		frmStatistics.getContentPane().add(lblGuestNow);
		
		lblGuestThere.setBounds(142, 62, 46, 14);
		frmStatistics.getContentPane().add(lblGuestThere);
		
		lblGuestGone.setBounds(142, 90, 46, 14);
		frmStatistics.getContentPane().add(lblGuestGone);
		
		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStats();
			}
		});
		btnRefresh.setBounds(30, 130, 117, 29);
		frmStatistics.getContentPane().add(btnRefresh);
	}

	public JFrame getFrmStatistics() {
		return frmStatistics;
	}

	public void setFrmStatistics(JFrame frmStatistics) {
		this.frmStatistics = frmStatistics;
	}
	
	public JButton getBtnClose() {
		return btnClose;
	}
	
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}

}
