package de.richter.main.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow {

	private JFrame frmHotelprogramm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmHotelprogramm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelprogramm = new JFrame();
		frmHotelprogramm.setTitle("Hotelprogramm");
		frmHotelprogramm.setBounds(100, 100, 250, 350);
		frmHotelprogramm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelprogramm.getContentPane().setLayout(null);
		
		JButton btnCheckin = new JButton("Einchecken");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Einchecken");
				CheckinWindow checkinWindow = new CheckinWindow();
				checkinWindow.getFrmEinchecken().setVisible(true);
			}
		});
		btnCheckin.setBounds(25, 23, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckin);
		
		JButton btnCheckout = new JButton("Auschecken");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Auschecken");
				CheckoutWindow checkoutWindow = new CheckoutWindow();
				checkoutWindow.getFrmAuschecken().setVisible(true);
			}
		});
		btnCheckout.setBounds(25, 97, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckout);
		
		JButton btnRoomstatus = new JButton("Zimmerstatus");
		btnRoomstatus.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Zimmerstatus");
				RoomstatusWindow roomstatusWindow = new RoomstatusWindow();
				roomstatusWindow.getFrmRoomstatus().setVisible(true);
			}
		});
		btnRoomstatus.setBounds(25, 172, 188, 63);
		frmHotelprogramm.getContentPane().add(btnRoomstatus);
		
		JButton btnStatistics = new JButton("Statistiken");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Statistiken");
				StatisticsWindow statisticsWindow = new StatisticsWindow();
				statisticsWindow.getFrmStatistics().setVisible(true);
			}
		});
		btnStatistics.setBounds(25, 249, 188, 51);
		frmHotelprogramm.getContentPane().add(btnStatistics);
	}
}
