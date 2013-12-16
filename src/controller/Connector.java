package controller;

import java.awt.EventQueue;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;

import com.mongodb.*;

import view.View;
import model.Album;

public class Connector implements DatabaseConnection{
	private View frame;
	private ArrayList<Album> results;
	private Connection con = null;
	private String ip = "83.250.249.187", user = "user", database = "test";
	private char[] pwd={'1','q','2','w','3','e'};
	private DB db;
	private MongoClient mongoClient=null;

	@Override
	public void start() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new View(Connector.this);
					frame.setVisible(true);
				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Could not start program, " + e.toString());
					// e.printStackTrace();// test only
				}
			}
		});
		
		try {
			mongoClient = new MongoClient( ip );
		} catch (UnknownHostException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
		}
		db =mongoClient.getDB(database);
		db.authenticate(user,pwd);
	}

	@Override
	public void terminateCon() {
		// TODO Auto-generated method stub
		mongoClient.close();
		
		
	}

	@Override
	public void AddData(String artist, String album, String genre)
			throws DatabaseErrorExecption, NullValueExecption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddAnotherArtistToAlbum(String artist, String album)
			throws DatabaseErrorExecption, NullValueExecption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Search(String SearchColumn, String SearchedText, String Table)
			throws DatabaseErrorExecption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() throws DatabaseErrorExecption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRating(String rating, String SelectedRow)
			throws DatabaseErrorExecption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Album> getLatestQueryResults() {
		// TODO Auto-generated method stub
		return null;
	}

}
