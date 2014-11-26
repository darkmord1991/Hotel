package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import de.richter.main.interfaces.MainWindow;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckoutWindow {

	private JFrame frmAuschecken;
	private JTextField textFieldName;
	private JTextField textFieldPrename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutWindow window = new CheckoutWindow();
					window.frmAuschecken.setVisible(true);
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
		
		JComboBox comboBoxGuestnumber = new JComboBox();
		comboBoxGuestnumber.setBounds(25, 72, 116, 20);
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
	
}
