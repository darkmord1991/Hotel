package de.richter.main.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RoomstatusWindow {
	private int zeile, spalte;

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
	 * Create the application. Ï
	 */
	public RoomstatusWindow() {
		initialize();
		updateTable();
	}

	public void updateTable() {
		// Tabelle überschreiben
		System.out.println("***  Roomstatus-Tabellen-Daten werden aktualisiert  ***");
		zeile = 0;
		System.out.println("Row: " + tableRoom.getRowCount());
		System.out.println("Col: " + tableRoom.getColumnCount());
		for (int row = 0; row < tableRoom.getRowCount(); row++) {
			for (int col = 0; col < tableRoom.getColumnCount(); col++) {
				getRoomstatusModel().setValueAt(null, row, col);
			}
		}
		// Tabelleninhalt (vorhanden) einf�gen
		zeile = 0;
		String line;
		try {
			zeile = 0;
			System.out.println("***  Zimmerstatus-Tabellen-Daten werden geladen  ***");
			BufferedReader br = new BufferedReader(new FileReader("tableData.txt"));
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				System.out.println(line);
				// String aufsplitten
				String[] arr = line.split(";");
				spalte = 0;
				getRoomstatusModel().setValueAt(arr[1], zeile, spalte++);
				getRoomstatusModel().setValueAt(arr[13], zeile, spalte++);
				getRoomstatusModel().setValueAt(arr[12], zeile, spalte++);
				getRoomstatusModel().setValueAt(arr[0], zeile, spalte++);
				getRoomstatusModel().setLastValueAt(arr[3], zeile, spalte++);
				zeile++;
			}
			br.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRoomstatus = new JFrame();
		frmRoomstatus.setBounds(100, 100, 450, 300);
		frmRoomstatus.setTitle("Zimmerstatus");
		// frmRoomstatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Wegen
		// WindowListener nicht n�tig
		frmRoomstatus.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 219);
		frmRoomstatus.getContentPane().add(scrollPane);

		tableRoom = new JTable();
		tableRoom.setModel(new de.richter.main.model.RoomstatusModel(
				new Object[][] { { null, null, null, null, null },
						{ null, null, null, null, null }, }, new String[] {
						"Zimmernr.", "Zimmerart", "Pl\u00E4tze", "Gastnr.",
						"belegt bis" }));
		// Um die Tabelle zu sehen unter ScrollPane einordnen und diese
		// Codezeile einf�gen:
		scrollPane.setViewportView(tableRoom);

		btnClose = new JButton("Schlie\u00DFen");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Zimmerstatus wird geschlossen");
				frmRoomstatus.setVisible(false);
			}
		});
		btnClose.setBounds(300, 231, 134, 23);
		frmRoomstatus.getContentPane().add(btnClose);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tabelle überschreiben
				System.out.println("***  Roomstatus-Tabellen-Daten werden aktualisiert  ***");
				zeile = 0;
				System.out.println("Row: " + tableRoom.getRowCount());
				System.out.println("Col: " + tableRoom.getColumnCount());
				for (int row = 0; row < tableRoom.getRowCount(); row++) {
					for (int col = 0; col < tableRoom.getColumnCount(); col++) {
						getRoomstatusModel().setValueAt(null, row, col);
					}
				}
				// Tabelleninhalt (vorhanden) einf�gen
				zeile = 0;
				String line;
				try {
					zeile = 0;
					System.out.println("***  Zimmerstatus-Tabellen-Daten werden geladen  ***");
					BufferedReader br = new BufferedReader(new FileReader("tableData.txt"));
					while ((line = br.readLine()) != null && !line.isEmpty()) {
						System.out.println(line);
						// String aufsplitten
						String[] arr = line.split(";");
						spalte = 0;
						getRoomstatusModel().setValueAt(arr[1], zeile, spalte++);
						getRoomstatusModel().setValueAt(arr[13], zeile, spalte++);
						getRoomstatusModel().setValueAt(arr[12], zeile, spalte++);
						getRoomstatusModel().setValueAt(arr[0], zeile, spalte++);
						getRoomstatusModel().setLastValueAt(arr[3], zeile, spalte++);
						zeile++;
					}
					br.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(50, 231, 117, 29);
		frmRoomstatus.getContentPane().add(btnRefresh);
	}

	/**
	 * Methode getRoomstatusModel
	 * 
	 * @return = das Model f�r setLastValueAt
	 */
	private de.richter.main.model.RoomstatusModel getRoomstatusModel() {
		return ((de.richter.main.model.RoomstatusModel) tableRoom.getModel());
		// Syntax f�r Eintr�ge in CheckinWindow anschauen
	}

	public JFrame getFrmRoomstatus() {
		return frmRoomstatus;
	}

	public void setFrmRoomstatus(JFrame frmRoomstatus) {
		this.frmRoomstatus = frmRoomstatus;
	}
	
	public JButton getBtnClose() {
		return btnClose;
	}
	
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}
}
