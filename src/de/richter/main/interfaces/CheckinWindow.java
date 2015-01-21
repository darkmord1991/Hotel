package de.richter.main.interfaces;

import java.awt.EventQueue;

import javafx.scene.control.TableCell;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.richter.main.model.CheckinModel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CheckinWindow {
	// Globale Variablen
	private int zeile;
	
	private JFrame frmEinchecken;
	private JTextField textFieldStart;
	private JTextField textFieldEnd;
	private JTextField textFieldName;
	private JTextField textFieldPrename;
	private JTextField textFieldStreet;
	private JTextField textFieldNumber;
	private JTextField textFieldPostcode;
	private JTextField textFieldCity;
	private JTextField textFieldMail;
	private JTextField textFieldPhone;
	private JTable tableCheckin;
	private JTextField textFieldGuestnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckinWindow window = new CheckinWindow();
					window.frmEinchecken.setVisible(true);
					window.frmEinchecken.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckinWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEinchecken = new JFrame();
		frmEinchecken.setTitle("Einchecken");
		frmEinchecken.setBounds(100, 100, 1351, 400);
		frmEinchecken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEinchecken.getContentPane().setLayout(null);
		
		textFieldStart = new JTextField();
		textFieldStart.setBounds(25, 64, 86, 20);
		frmEinchecken.getContentPane().add(textFieldStart);
		textFieldStart.setColumns(10);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setBounds(25, 120, 86, 20);
		frmEinchecken.getContentPane().add(textFieldEnd);
		textFieldEnd.setColumns(10);
		
		JLabel lblFrom = new JLabel("von");
		lblFrom.setBounds(25, 39, 86, 14);
		frmEinchecken.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("bis");
		lblTo.setBounds(25, 95, 86, 14);
		frmEinchecken.getContentPane().add(lblTo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(172, 39, 46, 14);
		frmEinchecken.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(172, 64, 86, 20);
		frmEinchecken.getContentPane().add(textFieldName);
		
		textFieldPrename = new JTextField();
		textFieldPrename.setColumns(10);
		textFieldPrename.setBounds(270, 64, 86, 20);
		frmEinchecken.getContentPane().add(textFieldPrename);
		
		JLabel lblStreet = new JLabel("Stra\u00DFe");
		lblStreet.setBounds(172, 95, 86, 14);
		frmEinchecken.getContentPane().add(lblStreet);
		
		JLabel lblPrename = new JLabel("Vorname");
		lblPrename.setBounds(270, 39, 86, 14);
		frmEinchecken.getContentPane().add(lblPrename);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(172, 120, 86, 20);
		frmEinchecken.getContentPane().add(textFieldStreet);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setColumns(10);
		textFieldNumber.setBounds(270, 120, 86, 20);
		frmEinchecken.getContentPane().add(textFieldNumber);
		
		JLabel lblNumber = new JLabel("Hausnummer");
		lblNumber.setBounds(270, 95, 86, 14);
		frmEinchecken.getContentPane().add(lblNumber);
		
		JLabel lblPostcode = new JLabel("Postleitzahl");
		lblPostcode.setBounds(172, 155, 184, 14);
		frmEinchecken.getContentPane().add(lblPostcode);
		
		JLabel lblCity = new JLabel("Stadt");
		lblCity.setBounds(251, 155, 105, 14);
		frmEinchecken.getContentPane().add(lblCity);
		
		textFieldPostcode = new JTextField();
		textFieldPostcode.setColumns(10);
		textFieldPostcode.setBounds(172, 180, 69, 20);
		frmEinchecken.getContentPane().add(textFieldPostcode);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(251, 180, 105, 20);
		frmEinchecken.getContentPane().add(textFieldCity);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(172, 211, 184, 14);
		frmEinchecken.getContentPane().add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(172, 230, 184, 20);
		frmEinchecken.getContentPane().add(textFieldMail);
		
		JLabel lblPhone = new JLabel("Telefon");
		lblPhone.setBounds(172, 262, 105, 14);
		frmEinchecken.getContentPane().add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(172, 287, 86, 20);
		frmEinchecken.getContentPane().add(textFieldPhone);
		
		JComboBox comboBoxPersons = new JComboBox();
		comboBoxPersons.setBounds(391, 64, 96, 20);
		frmEinchecken.getContentPane().add(comboBoxPersons);
		
		JLabel lblPersonen = new JLabel("Personen");
		lblPersonen.setBounds(391, 39, 123, 14);
		frmEinchecken.getContentPane().add(lblPersonen);
		
		JLabel lblZimmerkategorie = new JLabel("Pensionsart");
		lblZimmerkategorie.setBounds(391, 106, 123, 14);
		frmEinchecken.getContentPane().add(lblZimmerkategorie);
		
		JComboBox comboBoxPension = new JComboBox();
		comboBoxPension.setBounds(391, 139, 96, 20);
		frmEinchecken.getContentPane().add(comboBoxPension);
		
		JLabel lblRoom = new JLabel("Zimmerkategorie");
		lblRoom.setBounds(391, 170, 123, 14);
		frmEinchecken.getContentPane().add(lblRoom);
		
		JComboBox comboBoxRoom = new JComboBox();
		comboBoxRoom.setBounds(391, 205, 96, 20);
		frmEinchecken.getContentPane().add(comboBoxRoom);
		
		tableCheckin = new JTable();
		// Vorsicht! Ändert immer wieder auf DefaultTableModel, muss auf CheckinModel geändert werden
		tableCheckin.setModel(new CheckinModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Gastnr.", "von", "bis", "Name", "Vorname", "Strasse", "Hausnr.", "PLZ", "Stadt", "E-Mail", "Telefon"
			}
		));
		// Tabellenspaltenbreite wird gesetzt
		tableCheckin.getColumnModel().getColumn(0).setPreferredWidth(47);
		tableCheckin.getColumnModel().getColumn(1).setPreferredWidth(53);
		tableCheckin.getColumnModel().getColumn(2).setPreferredWidth(57);
		tableCheckin.getColumnModel().getColumn(4).setPreferredWidth(65);
		tableCheckin.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableCheckin.getColumnModel().getColumn(7).setPreferredWidth(59);
		tableCheckin.getColumnModel().getColumn(8).setPreferredWidth(90);
		tableCheckin.getColumnModel().getColumn(9).setPreferredWidth(110);
		tableCheckin.setBounds(545, 11, 329, 336);
		JLabel lblTime = new JLabel("Zeiterfassung");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(25, 11, 110, 22);
		frmEinchecken.getContentPane().add(lblTime);
		
		JLabel lblBenutzerdaten = new JLabel("Benutzerdaten");
		lblBenutzerdaten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBenutzerdaten.setBounds(167, 11, 189, 22);
		frmEinchecken.getContentPane().add(lblBenutzerdaten);
		
		JLabel lblZimmeroptionen = new JLabel("Zimmeroptionen");
		lblZimmeroptionen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblZimmeroptionen.setBounds(391, 11, 149, 22);
		frmEinchecken.getContentPane().add(lblZimmeroptionen);
		
		JLabel lblGuestnumber = new JLabel("Gastnr.");
		lblGuestnumber.setBounds(270, 262, 86, 14);
		frmEinchecken.getContentPane().add(lblGuestnumber);
		
		textFieldGuestnumber = new JTextField();
		textFieldGuestnumber.setColumns(10);
		textFieldGuestnumber.setBounds(270, 287, 86, 20);
		frmEinchecken.getContentPane().add(textFieldGuestnumber);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(533, 11, 792, 336);
		// Tabelle anzeigen: Siehe Zeile hier drunter
		scrollPane.setViewportView(tableCheckin);
		frmEinchecken.getContentPane().add(scrollPane);
		
		JButton btnCheckin = new JButton("Einchecken");
		btnCheckin.setBounds(391, 282, 110, 31);
		frmEinchecken.getContentPane().add(btnCheckin);
		
		JButton btnClose = new JButton("Schlie\u00DFen");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Einchecken wird geschlossen");
				frmEinchecken.setVisible(false);
			}
		});
		btnClose.setBounds(391, 324, 110, 31);
		frmEinchecken.getContentPane().add(btnClose);
		// Actions
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Variablendeklaration
				String start, end, name, prename, street, number, postcode, city, mail, phone, guestnumber;
				int stelle = 0;
				System.out.println("Gastdaten werden erfasst");
				// Variablen holen Inhalt der Textfelder
				start = textFieldStart.getText();
				end = textFieldEnd.getText();
				guestnumber = textFieldGuestnumber.getText();
				name = textFieldName.getText();
				prename = textFieldPrename.getText();
				street = textFieldStreet.getText();
				number = textFieldNumber.getText();
				postcode = textFieldPostcode.getText();
				city = textFieldCity.getText();
				mail = textFieldMail.getText();
				phone = textFieldPhone.getText();
				// Textfeldinhalt wird dem Tablemodel übergeben
				// Variablen zum Zählen müssen eingefügt werden für 0,0 - 0,10 usw.
				getCheckinModel().setValueAt(guestnumber, zeile, stelle++);
				getCheckinModel().setValueAt(start, zeile, stelle++);
				getCheckinModel().setValueAt(end, zeile, stelle++);
				getCheckinModel().setValueAt(name, zeile, stelle++);
				getCheckinModel().setValueAt(prename, zeile, stelle++);
				getCheckinModel().setValueAt(street, zeile, stelle++);
				getCheckinModel().setValueAt(number, zeile, stelle++);
				getCheckinModel().setValueAt(postcode, zeile, stelle++);
				getCheckinModel().setValueAt(city, zeile, stelle++);
				getCheckinModel().setValueAt(mail, zeile, stelle++);
				getCheckinModel().setLastValueAt(phone, zeile, stelle++);
				zeile++;
				textFieldStart.setText("");
				textFieldEnd.setText("");
				textFieldGuestnumber.setText("");
				textFieldName.setText("");
				textFieldPrename.setText("");
				textFieldStreet.setText("");
				textFieldNumber.setText("");
				textFieldPostcode.setText("");
				textFieldCity.setText("");
				textFieldMail.setText("");
				textFieldPhone.setText("");
				
				// Tabelleninhalt wird exportiert
				BufferedWriter bfw;
				try {
					bfw = new BufferedWriter(new FileWriter("tableData.txt"));
//					for (int i = 0; i < tableCheckin.getColumnCount(); i++) {
//						bfw.write(tableCheckin.getColumnName(i));
//						bfw.write("\t");
//					}
					for (int i = 0; i < tableCheckin.getRowCount()-1; i++) {
						for (int j = 0; j < tableCheckin.getColumnCount(); j++) {
							System.out.println(j); 
//							System.out.println(tableCheckin.getValueAt(i, j));
							bfw.write((String) (tableCheckin.getValueAt(i, j)));
							bfw.write(";");
							;
					    }
						bfw.newLine();
					  }
					  bfw.close();		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		});

	}
	
	/**
	 * Methode getCheckinModel 
	 * @return = das Model für setLastValueAt
	 */
	private CheckinModel getCheckinModel() {
		return ((CheckinModel)tableCheckin.getModel());
	}
	public void spalteninit() {
		// Hier soll er Spalte aus gespeichertem Dokument nehmen, wenn nicht vorhanden initialisieren
		zeile = 0;
	}
	public JFrame getFrmEinchecken() {
		return frmEinchecken;
	}

	public void setFrmEinchecken(JFrame frmEinchecken) {
		this.frmEinchecken = frmEinchecken;
	}
}
