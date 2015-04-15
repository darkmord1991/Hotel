package de.richter.main.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.richter.main.listener.WindowListener;

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
					window.frmHotelprogramm.setLocationRelativeTo(null);
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
		
		CheckinWindow checkinWindow = new CheckinWindow();
		CheckoutWindow checkoutWindow = new CheckoutWindow();
		RoomstatusWindow roomstatusWindow = new RoomstatusWindow();
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		
		// WindowListener
		WindowListener wl = new WindowListener(frmHotelprogramm, checkinWindow.getFrmEinchecken());
		WindowListener wl2 = new WindowListener(frmHotelprogramm, checkoutWindow.getFrmAuschecken());
		WindowListener wl3 = new WindowListener(frmHotelprogramm, roomstatusWindow.getFrmRoomstatus());
		WindowListener wl4 = new WindowListener(frmHotelprogramm, statisticsWindow.getFrmStatistics());
		
		//Einchecken
		JButton btnCheckin = new JButton("Einchecken");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Einchecken");
				frmHotelprogramm.setVisible(false);
				checkinWindow.getFrmEinchecken().addWindowListener(wl);
				checkinWindow.getBtnClose().addActionListener(wl);
				checkinWindow.getFrmEinchecken().setLocationRelativeTo(null);
				checkinWindow.getFrmEinchecken().setVisible(true);
			}
		});
		btnCheckin.setBounds(25, 23, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckin);
		
		//Auschecken
		JButton btnCheckout = new JButton("Auschecken");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Auschecken");
				checkoutWindow.getFrmAuschecken().addWindowListener(wl2);
				checkoutWindow.getBtnClose().addActionListener(wl2);
				frmHotelprogramm.setVisible(false);
				checkoutWindow.getFrmAuschecken().setLocationRelativeTo(null);
				checkoutWindow.getFrmAuschecken().setVisible(true);
			}
		});
		btnCheckout.setBounds(25, 97, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckout);
		
		//Zimmerstatus
		JButton btnRoomstatus = new JButton("Zimmerstatus");
		btnRoomstatus.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Zimmerstatus");
				roomstatusWindow.getFrmRoomstatus().addWindowListener(wl3);
				roomstatusWindow.getBtnClose().addActionListener(wl3);
				frmHotelprogramm.setVisible(false);
				roomstatusWindow.getFrmRoomstatus().setLocationRelativeTo(null);
				roomstatusWindow.getFrmRoomstatus().setVisible(true);
			}
		});
		btnRoomstatus.setBounds(25, 172, 188, 63);
		frmHotelprogramm.getContentPane().add(btnRoomstatus);
		
		//Statistiken
		JButton btnStatistics = new JButton("Statistiken");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				System.out.println("Statistiken");
				statisticsWindow.getFrmStatistics().addWindowListener(wl4);
				statisticsWindow.getBtnClose().addActionListener(wl4);
				frmHotelprogramm.setVisible(false);
				statisticsWindow.getFrmStatistics().setLocationRelativeTo(null);
				statisticsWindow.getFrmStatistics().setVisible(true);
			}
		});
		btnStatistics.setBounds(25, 249, 188, 51);
		frmHotelprogramm.getContentPane().add(btnStatistics);
	}
}
