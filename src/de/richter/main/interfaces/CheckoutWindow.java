package de.richter.main.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CheckoutWindow {

	private JFrame frmAuschecken;
	private JTextField textName;
	private JTextField textPrename;

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
		
		textName = new JTextField();
		textName.setBounds(177, 72, 86, 20);
		frmAuschecken.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPrename = new JTextField();
		textPrename.setBounds(295, 72, 86, 20);
		frmAuschecken.getContentPane().add(textPrename);
		textPrename.setColumns(10);
		
		JLabel LabelGuestInfo = new JLabel("Gastinformation");
		LabelGuestInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelGuestInfo.setBounds(177, 11, 197, 29);
		frmAuschecken.getContentPane().add(LabelGuestInfo);
		
		JLabel LabelGuestnumber = new JLabel("Gastnr.");
		LabelGuestnumber.setBounds(25, 51, 104, 13);
		frmAuschecken.getContentPane().add(LabelGuestnumber);
		
		JLabel LabelName = new JLabel("Name");
		LabelName.setBounds(177, 48, 104, 13);
		frmAuschecken.getContentPane().add(LabelName);
		
		JLabel LabelPrename = new JLabel("Vorname");
		LabelPrename.setBounds(295, 51, 104, 13);
		frmAuschecken.getContentPane().add(LabelPrename);
		
		JButton btnCheckout = new JButton("Auschecken");
		btnCheckout.setBounds(25, 114, 116, 36);
		frmAuschecken.getContentPane().add(btnCheckout);
		
		JButton btnClose = new JButton("Schlie\u00DFen");
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
