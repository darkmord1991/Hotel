package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class RoomstatusWindow {

	private JFrame frmRoomstatus;
	private JTable tableRoom;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomstatusWindow window = new RoomstatusWindow();
					window.frmRoomstatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomstatusWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRoomstatus = new JFrame();
		frmRoomstatus.setBounds(100, 100, 450, 300);
		frmRoomstatus.setTitle("Zimmerstatus");
		frmRoomstatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRoomstatus.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 219);
		frmRoomstatus.getContentPane().add(scrollPane);
		
		tableRoom = new JTable();
		tableRoom.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Zimmernr.", "Zimmerart", "Pl\u00E4tze", "Gastnr.", "belegt bis"
			}
		));
		// Um die Tabelle zu sehen unter ScrollPane einordnen und diese Codezeile einfügen:
		scrollPane.setViewportView(tableRoom);
		
		btnClose = new JButton("Schlie\u00DFen");
		btnClose.setBounds(149, 230, 134, 23);
		frmRoomstatus.getContentPane().add(btnClose);
	}

	public JFrame getFrmRoomstatus() {
		return frmRoomstatus;
	}

	public void setFrmRoomstatus(JFrame frmRoomstatus) {
		this.frmRoomstatus = frmRoomstatus;
	}
	
}
