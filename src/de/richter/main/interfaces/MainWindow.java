package de.richter.main.interfaces;

import java.awt.EventQueue;

import de.richter.main.interfaces.CheckinWindow;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.media.jfxmedia.events.NewFrameEvent;

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
				CheckinWindow checkinWindow = new CheckinWindow();
				checkinWindow.getFrmEinchecken().setVisible(true);
			}
		});
		btnCheckin.setBounds(25, 23, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckin);
		
		JButton btnCheckout = new JButton("Auschecken");
		btnCheckout.setBounds(25, 97, 188, 63);
		frmHotelprogramm.getContentPane().add(btnCheckout);
		
		JButton btnRoomstatus = new JButton("Zimmerstatus");
		btnRoomstatus.setBounds(25, 172, 188, 63);
		frmHotelprogramm.getContentPane().add(btnRoomstatus);
		
		JButton btnStatistics = new JButton("Statistiken");
		btnStatistics.setBounds(25, 249, 188, 51);
		frmHotelprogramm.getContentPane().add(btnStatistics);
	}
}
