package de.richter.main.listener;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import de.richter.main.interfaces.MainWindow;

@SuppressWarnings("unused")
public class WindowListener implements java.awt.event.WindowListener, ActionListener {
	
	private JFrame parent;
	private JFrame close;
	
	private MainWindow mainWindow;
	
	public WindowListener (JFrame frmHotelprogramm, JFrame close, MainWindow mainWindow2) {
		this.parent = frmHotelprogramm;
		this.close = close;
		this.mainWindow = mainWindow2;
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
		close();
	}


	private void close() {
		close.dispose();
		parent.setVisible(true);
		mainWindow.initialize();
		System.out.println("*** Windows-Listener switcht jetzt die Fenster ***");
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		close();
	}
	
}
