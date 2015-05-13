package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import de.richter.main.listener.CheckoutListener;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class CheckoutWindow {
	
	private int came;
	private int there;
	private int away;

	private JFrame frmAuschecken;
	private JTextField textFieldName;
	private JTextField textFieldPrename;
	JComboBox<String> comboBoxGuestnumber = new JComboBox<>();
	
	//Variablen
	@SuppressWarnings("unused")
	private int zeile = 0;
	List<String> table = new ArrayList<String>();
	List<String> boxitems = new ArrayList<String>();
	List<String> prename = new ArrayList<String>();
	List<String> lastname = new ArrayList<String>();
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutWindow window = new CheckoutWindow();
					window.frmAuschecken.setVisible(true);
					window.frmAuschecken.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public CheckoutWindow() {
		initialize();
		updateLists();
	}

	public void updateLists() {
		// Listen clearen
		boxitems.clear();
		lastname.clear();
		prename.clear();
		table.clear();
		// L�schdaten einlesen
				zeile = 0;
				BufferedReader br = null;
				String line;
				try {
					System.out.println("***  Auschecken-Tabllen-Daten werden geladen  ***");
					br = new BufferedReader(new FileReader("tableData.txt"));
					while ((line = br.readLine()) != null && !line.isEmpty()) {
						System.out.println(line);
						// String aufsplitten
						String[] arr = line.split(";");
						// Tabelleninhalt wird in Liste gespeichert
						table.add(line);
						// Als n�chste die Index der Gastnummer bekommen, aus der
						// Table-liste l�schen und Datei neu abspeichern!
						boxitems.add(arr[0]);
						if (arr[4] != null && arr[5] != null) {
						lastname.add(arr[4]);
						prename.add(arr[5]);
						}
						zeile++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
				// Statistiken laden
				BufferedReader stats_br = null;
				String stats;
				try {
					System.out.println("***  Auschecken-Statistiken werden geladen  ***");
					stats_br = new BufferedReader(new FileReader("statistics.txt"));
					while ((stats = stats_br.readLine()) != null) {
						System.out.println(stats);
						String[] arr = stats.split(";");
						came = Integer.parseInt(arr[0]);
						there = Integer.parseInt(arr[1]);
						away = Integer.parseInt(arr[2]);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comboBoxGuestnumber.setModel(new DefaultComboBoxModel<>(new String[] {"Bitte ausw\u00E4hlen"}));
				for (String item : boxitems) {
					comboBoxGuestnumber.addItem(item);
				}
	}

	private void initialize() {		
		frmAuschecken = new JFrame();
		frmAuschecken.setTitle("Auschecken");
		frmAuschecken.setBounds(100, 100, 450, 200);
//		frmAuschecken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Wegen WindowListener nicht n�tig
		frmAuschecken.getContentPane().setLayout(null);

//		for (int i=0; i < boxitems.size(); i++) {

		comboBoxGuestnumber.setBounds(25, 72, 116, 20);
		CheckoutListener cl = new CheckoutListener(boxitems, prename, lastname, this);
		comboBoxGuestnumber.addItemListener(cl);
		frmAuschecken.getContentPane().add(comboBoxGuestnumber);
		
		JLabel LabelGuestchoose = new JLabel("Gastauswahl");
		LabelGuestchoose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelGuestchoose.setBounds(25, 11, 104, 29);
		frmAuschecken.getContentPane().add(LabelGuestchoose);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(177, 72, 86, 20);
		frmAuschecken.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrename = new JTextField();
		textFieldPrename.setBounds(295, 72, 86, 20);
		frmAuschecken.getContentPane().add(textFieldPrename);
		textFieldPrename.setColumns(10);
		
		JLabel lblGuestInfo = new JLabel("Gastinformation");
		lblGuestInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGuestInfo.setBounds(177, 11, 197, 29);
		frmAuschecken.getContentPane().add(lblGuestInfo);
		
		JLabel lblGuestnumber = new JLabel("Gastnr.");
		lblGuestnumber.setBounds(25, 51, 104, 13);
		frmAuschecken.getContentPane().add(lblGuestnumber);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(177, 48, 104, 13);
		frmAuschecken.getContentPane().add(lblName);
		
		JLabel lblPrename = new JLabel("Vorname");
		lblPrename.setBounds(295, 51, 104, 13);
		frmAuschecken.getContentPane().add(lblPrename);
		
		JButton btnCheckout = new JButton("Auschecken");
		btnCheckout.setBounds(25, 114, 116, 36);
		// Hier weitermachen (Datei �berschreiben etc.)
		btnCheckout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int deleteindex = comboBoxGuestnumber.getSelectedIndex()-1;
				table.remove(deleteindex);
				BufferedWriter bfw;
				try {
					bfw = new BufferedWriter(new FileWriter("tableData.txt"));
					for (int i = 0; i < table.size(); i++) {
						bfw.write(table.get(i));
						bfw.newLine();
					}
					  bfw.close();	
			
				System.out.println("Gastdaten wurden gel�scht!");
				} catch (IOException e) {
				e.printStackTrace();
				}
				
				// Hier noch herausfinden, wieso er keine Datei abspeichert. Evtl. neuen Bfw erzeugen
				away = away+1;
				String came, there, away;
				came = "" + CheckoutWindow.this.came;
				there = "" + CheckoutWindow.this.there;
				away = "" + CheckoutWindow.this.away;
				try {
					bfw = new BufferedWriter(new FileWriter("statistics.txt"));
					bfw.write(came);
					bfw.write(";");
					bfw.write(there);
					bfw.write(";");
					bfw.write(away);
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		});
		frmAuschecken.getContentPane().add(btnCheckout);
		
		btnClose = new JButton("Schlie\u00DFen");
		btnClose.setBounds(295, 114, 104, 36);
		frmAuschecken.getContentPane().add(btnClose);
		
		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLists();
			}
		});
		btnRefresh.setBounds(327, 14, 117, 29);
		frmAuschecken.getContentPane().add(btnRefresh);
	}
	
	public JButton getBtnClose() {
		return btnClose;
	}
	
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}

	public JFrame getFrmAuschecken() {
		return frmAuschecken;
	}

	public void setFrmAuschecken(JFrame frmAuschecken) {
		this.frmAuschecken = frmAuschecken;
	}
	
	public void setTextName(String s) {
		textFieldName.setText(s);
	}
	
	public void setTextPrename(String s) {
		textFieldPrename.setText(s);
	}
	
}
