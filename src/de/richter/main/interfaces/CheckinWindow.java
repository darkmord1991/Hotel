package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CheckinWindow {

	private JFrame frmEinchecken;
	private JTextField textFrom;
	private JTextField textTo;
	private JTextField textName;
	private JTextField textPrename;
	private JTextField textStreet;
	private JTextField textNumber;
	private JTextField textPostcode;
	private JTextField textCity;
	private JTextField textMail;
	private JTextField textPhone;
	private JTable checkinTable;
	private JTextField textGuestnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckinWindow window = new CheckinWindow();
					window.frmEinchecken.setVisible(true);
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
		frmEinchecken.setBounds(100, 100, 900, 400);
		frmEinchecken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEinchecken.getContentPane().setLayout(null);
		
		textFrom = new JTextField();
		textFrom.setBounds(25, 64, 86, 20);
		frmEinchecken.getContentPane().add(textFrom);
		textFrom.setColumns(10);
		
		textTo = new JTextField();
		textTo.setBounds(25, 120, 86, 20);
		frmEinchecken.getContentPane().add(textTo);
		textTo.setColumns(10);
		
		JLabel LabelFrom = new JLabel("von");
		LabelFrom.setBounds(25, 39, 86, 14);
		frmEinchecken.getContentPane().add(LabelFrom);
		
		JLabel LabelTo = new JLabel("bis");
		LabelTo.setBounds(25, 95, 86, 14);
		frmEinchecken.getContentPane().add(LabelTo);
		
		JLabel LabelName = new JLabel("Name");
		LabelName.setBounds(172, 39, 46, 14);
		frmEinchecken.getContentPane().add(LabelName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(172, 64, 86, 20);
		frmEinchecken.getContentPane().add(textName);
		
		textPrename = new JTextField();
		textPrename.setColumns(10);
		textPrename.setBounds(270, 64, 86, 20);
		frmEinchecken.getContentPane().add(textPrename);
		
		JLabel LabelStreet = new JLabel("Stra\u00DFe");
		LabelStreet.setBounds(172, 95, 86, 14);
		frmEinchecken.getContentPane().add(LabelStreet);
		
		JLabel LabelPrename = new JLabel("Vorname");
		LabelPrename.setBounds(270, 39, 86, 14);
		frmEinchecken.getContentPane().add(LabelPrename);
		
		textStreet = new JTextField();
		textStreet.setColumns(10);
		textStreet.setBounds(172, 120, 86, 20);
		frmEinchecken.getContentPane().add(textStreet);
		
		textNumber = new JTextField();
		textNumber.setColumns(10);
		textNumber.setBounds(270, 120, 86, 20);
		frmEinchecken.getContentPane().add(textNumber);
		
		JLabel LabelNumber = new JLabel("Hausnummer");
		LabelNumber.setBounds(270, 95, 86, 14);
		frmEinchecken.getContentPane().add(LabelNumber);
		
		JLabel LabelPostcode = new JLabel("Postleitzahl");
		LabelPostcode.setBounds(172, 155, 184, 14);
		frmEinchecken.getContentPane().add(LabelPostcode);
		
		JLabel LabelCity = new JLabel("Stadt");
		LabelCity.setBounds(251, 155, 105, 14);
		frmEinchecken.getContentPane().add(LabelCity);
		
		textPostcode = new JTextField();
		textPostcode.setColumns(10);
		textPostcode.setBounds(172, 180, 69, 20);
		frmEinchecken.getContentPane().add(textPostcode);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(251, 180, 105, 20);
		frmEinchecken.getContentPane().add(textCity);
		
		JLabel LabelMail = new JLabel("E-Mail");
		LabelMail.setBounds(172, 211, 184, 14);
		frmEinchecken.getContentPane().add(LabelMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(172, 230, 184, 20);
		frmEinchecken.getContentPane().add(textMail);
		
		JLabel LabelPhone = new JLabel("Telefon");
		LabelPhone.setBounds(172, 262, 105, 14);
		frmEinchecken.getContentPane().add(LabelPhone);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(172, 287, 86, 20);
		frmEinchecken.getContentPane().add(textPhone);
		
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
		
		JLabel LabelRoom = new JLabel("Zimmerkategorie");
		LabelRoom.setBounds(391, 170, 123, 14);
		frmEinchecken.getContentPane().add(LabelRoom);
		
		JComboBox comboBoxRoom = new JComboBox();
		comboBoxRoom.setBounds(391, 205, 96, 20);
		frmEinchecken.getContentPane().add(comboBoxRoom);
		
		checkinTable = new JTable();
		checkinTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Zimmernr.", "Besetzt", "Gastnr.", "Personenanz.", "Zimmerart"
			}
		));
		checkinTable.getColumnModel().getColumn(3).setPreferredWidth(81);
		checkinTable.getColumnModel().getColumn(3).setMinWidth(19);
		checkinTable.getColumnModel().getColumn(4).setPreferredWidth(70);
		checkinTable.setBounds(545, 11, 329, 336);
		
		JLabel LabelTime = new JLabel("Zeiterfassung");
		LabelTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelTime.setBounds(25, 11, 110, 22);
		frmEinchecken.getContentPane().add(LabelTime);
		
		JLabel LabellBenutzerdaten = new JLabel("Benutzerdaten");
		LabellBenutzerdaten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabellBenutzerdaten.setBounds(167, 11, 189, 22);
		frmEinchecken.getContentPane().add(LabellBenutzerdaten);
		
		JLabel LabelZimmeroptionen = new JLabel("Zimmeroptionen");
		LabelZimmeroptionen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelZimmeroptionen.setBounds(391, 11, 149, 22);
		frmEinchecken.getContentPane().add(LabelZimmeroptionen);
		
		JLabel LabelGuestnumber = new JLabel("Gastnr.");
		LabelGuestnumber.setBounds(270, 262, 86, 14);
		frmEinchecken.getContentPane().add(LabelGuestnumber);
		
		textGuestnumber = new JTextField();
		textGuestnumber.setColumns(10);
		textGuestnumber.setBounds(270, 287, 86, 20);
		frmEinchecken.getContentPane().add(textGuestnumber);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(533, 11, 351, 336);
		// Tabelle anzeigen: Siehe Zeile hier drunter
		scrollPane.setViewportView(checkinTable);
		frmEinchecken.getContentPane().add(scrollPane);
		
		JButton btnCheckin = new JButton("Einchecken");
		btnCheckin.setBounds(391, 316, 110, 31);
		frmEinchecken.getContentPane().add(btnCheckin);
	}

	public JFrame getFrmEinchecken() {
		return frmEinchecken;
	}

	public void setFrmEinchecken(JFrame frmEinchecken) {
		this.frmEinchecken = frmEinchecken;
	}
	
}
