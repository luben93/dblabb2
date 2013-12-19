package controller;

import view.View;

public class Controller {
	
	public static void main (String[] args){

		DatabaseConnection program=new Connector();
		
		program.start();
	}
		
		
		
}	
