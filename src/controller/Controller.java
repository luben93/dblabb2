package controller;

import java.awt.EventQueue;

import view.View;

public class Controller {
	public static void main (String[] args){
		//MainController program =new MainController();
		
		//DatabaseConnection program=new Connector();
		//program.start();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection program=new Connector();
					View frame = new View(program);
					frame.setVisible(true);
					program.start();

				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Could not start program, " + e.toString());
					// e.printStackTrace();// test only
				}
			}
		});
	}
		
		
		
}	
