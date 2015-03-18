package de.richter.main.listener;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowListener implements java.awt.event.WindowListener {
	
	private JFrame parent;
	
	public WindowListener (JFrame frmHotelprogramm) {
		this.parent = frmHotelprogramm;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JFrame source = (JFrame) e.getSource();	
		source.dispose();
		parent.setVisible(true);
		System.out.println("durchgelaufen");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
