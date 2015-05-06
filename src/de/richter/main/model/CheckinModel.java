package de.richter.main.model;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CheckinModel extends DefaultTableModel {
	private int guestnumber;
	private int roomnumber;
	private String start;
	private String end;
	private String name;
	private String prename;
	private String street;
	private String number;
	private int postcode;
	private String city;
	private String mail;
	private int phone;

	public CheckinModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub

	}

	@Override
	// Hier wird nur der Wert gesetzt
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		super.setValueAt(arg0, arg1, arg2);

	}
	
	// Hier wird der Werte gesetzt und eine neue Zeile wird hinzugef�gt
	public void setLastValueAt(Object arg0, int arg1, int arg2) {
		setValueAt(arg0, arg1, arg2);
		super.addRow(new Object[11]);
	}

	// public CheckinModel(int guestnumber, String name, String prename, String
	// street, String number, int postcode, String city, String mail, int phone)
	// {
	//
	// }
	
	public void removeAllRows() {
    	System.out.println("Rowcount:\t" + this.getRowCount());
    	System.out.println(this);
        if ((this.getRowCount()-1) > 0) {
        	System.out.println("\nJetzt wird der Tabelleninhalt gelöscht\n");
	    for( int i = this.getRowCount()-1; i >= 0; i-- ) {
		    	this.removeRow(i);
	        }
	    }
	}

	public int getGuestnumber() {
		return guestnumber;
	}

	public void setGuestnumber(int guestnumber) {
		this.guestnumber = guestnumber;
	}
	
	public int getRoomnumber() {
		return roomnumber;
	}
	
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
