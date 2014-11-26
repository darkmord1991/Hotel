package de.richter.main.model;

import javax.swing.table.DefaultTableModel;

public class CheckinModel extends DefaultTableModel{
		    private int guestnumber;
		    private String name;
		    private String prename;
		    private String street;
		    private String number;
		    private int postcode;
		    private String city;
		    private String mail;
		    private int phone;
		    
		    // Letzte Stunde erstellt, nächstes mal fragen.
//		    public CheckinModel(Object[][] arg0, Object[] arg1) {
//				super(arg0, arg1);
//				// TODO Auto-generated constructor stub
//				
//				// Hier methode erstelle, die die Rows updatet
//			}

			public CheckinModel(int guestnumber, String name, String prename, String street, String number, int postcode, String city, String mail, int phone) {
				
		    }

			public int getGuestnumber() {
				return guestnumber;
			}

			public void setGuestnumber(int guestnumber) {
				this.guestnumber = guestnumber;
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
