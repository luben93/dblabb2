package controller;

import java.awt.EventQueue;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.bson.types.BasicBSONList;

import com.mongodb.*;

import view.View;
import model.Album;

public class Connector implements DatabaseConnection {
	private View frame;
	private ArrayList<Album> results;
	private Connection con = null;
	private String ip = "83.250.249.187", user = "user",
			database = "musicColl";
	private char[] pwd = { '1', 'q', '2', 'w', '3', 'e' };
	private DB db;
	private MongoClient mongoClient = null;
	private DBCollection AlbColl = null;

	@Override
	public void start() {
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
			mongoClient = new MongoClient(ip);
		} catch (UnknownHostException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
		}
		db = mongoClient.getDB(database);
		db.authenticate(user, pwd);

		AlbColl = db.getCollection("Album");
	}

	@Override
	public void terminateCon() {
		mongoClient.close();
	}

	@Override
	public boolean AddData(ArrayList<String> artist, String album, String genre)
			throws DatabaseErrorExecption, NullValueExecption {

		ArrayList<Album> temp;
		Search search;

		search = new Search(new BasicDBObject(DBType.album.toString(), album),
				AlbColl);
		temp = search.send();
		// search albums for duplicates before adding
		BasicDBObject albums = null;
		for (int i = 0; i < artist.size(); i++) {
			albums = new BasicDBObject("album", album).append("genre", genre)
					.append("artist", artist.get(i));
			System.out.println(artist.size());
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).getAlbum().equals(albums.get(DBType.album.toString()))) {
					throw new DatabaseErrorExecption("Duplicate was not added.");
				}
			}
			AlbColl.insert(albums);
		}
		return true;
	}

	// @Override
	// public void AddAnotherArtistToAlbum(String artist, String album)
	// throws DatabaseErrorExecption, NullValueExecption {
	// TODO Auto-generated method stub

	// }

	// @Override
	public void Search(DBType type, String SearchedText)
			throws DatabaseErrorExecption {
		BasicDBObject query = new BasicDBObject(type.toString(), SearchedText);

		Search search = new Search(query, AlbColl);
		results = search.send();

	}

	@Override
	public void selectAll() throws DatabaseErrorExecption {

		BasicDBObject query = new BasicDBObject();

		Search search = new Search(query, AlbColl);
		results = search.send();

	}

	@Override
	public void updateRating(String rating, String SelectedRow)
			throws DatabaseErrorExecption {

		BasicDBObject Search = new BasicDBObject(DBType.album.toString(),
				SelectedRow);
		/*
		 * BasicDBObject Update = new BasicDBObject(); //Update.append("$set",
		 * new BasicDBObject().append(DBType.rating.toString(), rating));
		 * //Update = Search.append(DBType.rating.toString(), rating);
		 * Update.put(DBType.rating.toString(), rating);
		 * AlbColl.update(Search,Update);
		 */
		BasicDBObject set = new BasicDBObject("$set", new BasicDBObject(
				DBType.album.toString(), SelectedRow));
		set.append("$set", new BasicDBObject(DBType.rating.toString(), rating));
		AlbColl.update(Search, set);

		/*
		 * BasicDBObject Update = new BasicDBObject();
		 * Update.put(DBType.rating.toString(), rating);
		 * 
		 * BasicDBObject Search = new
		 * BasicDBObject().append(DBType.album.toString(), SelectedRow);
		 * 
		 * AlbColl.update(Search, Update);
		 */
	}

	@Override
	public ArrayList<Album> getLatestQueryResults()
			throws DatabaseErrorExecption {
		if (results == null || results.isEmpty()) {
			throw new DatabaseErrorExecption("database returned nothing");
		}
		return results;
	}

}
