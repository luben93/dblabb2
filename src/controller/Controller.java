package controller;

import java.awt.EventQueue;

import view.View;

public class Controller {
	
	private static View frame;
	
	public static void main (String[] args){

		DatabaseConnection program=new Connector();
		
		program.start();
	}
		
		
		
}	
