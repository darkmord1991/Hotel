package de.richter.main.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
					window.frmRoomstatus.setLocationRelativeTo(null);
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
		tableRoom.setModel(new de.richter.main.model.RoomstatusModel(
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
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Zimmerstatus wird geschlossen");
				frmRoomstatus.setVisible(false);
			}
		});
		btnClose.setBounds(149, 230, 134, 23);
		frmRoomstatus.getContentPane().add(btnClose);
	}
	
	/**
	 * Methode getRoomstatusModel 
	 * @return = das Model für setLastValueAt
	 */
	private de.richter.main.model.RoomstatusModel getRoomstatusModel() {
		return ((de.richter.main.model.RoomstatusModel)tableRoom.getModel());
		// Syntax für Einträge in CheckinWindow anschauen
	}
	public JFrame getFrmRoomstatus() {
		return frmRoomstatus;
	}

	public void setFrmRoomstatus(JFrame frmRoomstatus) {
		this.frmRoomstatus = frmRoomstatus;
	}
	
}
