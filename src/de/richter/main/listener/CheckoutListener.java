package de.richter.main.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import de.richter.main.interfaces.CheckoutWindow;

public class CheckoutListener implements ItemListener {
	List<String> boxitems = new ArrayList<String>();
	List<String> prename = new ArrayList<String>();
	List<String> lastname = new ArrayList<String>();

	CheckoutWindow parent = null;

	public CheckoutListener(List<String> boxitems, List<String> prename,
			List<String> lastname, CheckoutWindow parent) {
		super();
		this.boxitems = boxitems;
		this.prename = prename;
		this.lastname = lastname;
		this.parent = parent;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		JComboBox<?> checkoutBox = (JComboBox<?>) event.getSource();
		parent.setTextName(lastname.get(checkoutBox.getSelectedIndex()-1));
		parent.setTextPrename(prename.get(checkoutBox.getSelectedIndex()-1));
	}

}
