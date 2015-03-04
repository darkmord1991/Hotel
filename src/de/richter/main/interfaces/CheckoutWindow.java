package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import de.richter.main.interfaces.MainWindow;
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

	private JFrame frmAuschecken;
	private JTextField textFieldName;
	private JTextField textFieldPrename;
	
	//Variablen
	private int zeile = 0;
	List<String> table = new ArrayList<String>();
	List<String> boxitems = new ArrayList<String>();
	List<String> prename = new ArrayList<String>();
	List<String> lastname = new ArrayList<String>();

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
	 */
	public CheckoutWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuschecken = new JFrame();
		frmAuschecken.setTitle("Auschecken");
		frmAuschecken.setBounds(100, 100, 450, 200);
		frmAuschecken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuschecken.getContentPane().setLayout(null);
		
		zeile = 0;
		BufferedReader br = null;
		String line;

		try {
			br = new BufferedReader(new FileReader("tableData.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				// String aufsplitten
				String[] arr = line.split(";");
				// Tabelleninhalt wird in Liste gespeichert
				table.add(line);
				// Als nächste die Index der Gastnummer bekommen, aus der Table-liste löschen und Datei neu abspeichern!
				boxitems.add(arr[0]);
				lastname.add(arr[4]);
				prename.add(arr[5]);
				zeile++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JComboBox comboBoxGuestnumber = new JComboBox();
//		for (int i=0; i < boxitems.size(); i++) {
		for (String item : boxitems) {
			comboBoxGuestnumber.addItem(item);
		}
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
		// Hier weitermachen (Datei überschreiben etc.)
		btnCheckout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int deleteindex = comboBoxGuestnumber.getSelectedIndex();
				table.remove(deleteindex);
				BufferedWriter bfw;
				try {
					bfw = new BufferedWriter(new FileWriter("tableData.txt"));
					for (int i = 0; i < table.size(); i++) {
						bfw.write(table[i]);
						bfw.newLine();
					}
					  bfw.close();	
			
				System.out.println("Gastdaten wurden gelöscht!");
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		frmAuschecken.getContentPane().add(btnCheckout);
		
		JButton btnClose = new JButton("Schlie\u00DFen");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Auschecken wird geschlossen");
				frmAuschecken.setVisible(false);
			}
		});
		btnClose.setBounds(295, 114, 104, 36);
		frmAuschecken.getContentPane().add(btnClose);
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
