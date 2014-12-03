package de.richter.main.model;

import javax.swing.table.DefaultTableModel;

public class RoomstatusModel extends DefaultTableModel {
	private int roomnr;
	private String roomCat;
	private int places;
	private int  guestnumber;
	private String end;

	public RoomstatusModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	// Hier wird nur der Wert gesetzt
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		super.setValueAt(arg0, arg1, arg2);

	}
	
	// Hier wird der Werte gesetzt und eine neue Zeile wird hinzugefügt
	public void setLastValueAt(Object arg0, int arg1, int arg2) {
		setValueAt(arg0, arg1, arg2);
		super.addRow(new Object[11]);
	}
	
	public int getRoomnr() {
		return roomnr;
	}

	public void setRoomnr(int roomnr) {
		this.roomnr = roomnr;
	}

	public String getRoomCat() {
		return roomCat;
	}

	public void setRoomCat(String roomCat) {
		this.roomCat = roomCat;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public int getGuestnumber() {
		return guestnumber;
	}

	public void setGuestnumber(int guestnumber) {
		this.guestnumber = guestnumber;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
