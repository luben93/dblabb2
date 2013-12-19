package controller;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import model.Album;

public class Search {

	private ArrayList<Album> resultList;
	private DBObject searchquery;
	private DBCollection coll;

	public Search(BasicDBObject searchquery, DBCollection coll) {
		this.searchquery = searchquery;
		this.coll = coll;
		resultList = new ArrayList<Album>();

	}

	public ArrayList<Album> send() {
		DBCursor cursor = coll.find(searchquery);
		System.out.println();
		Album tempalbum;
		DBObject tempobj;
		Object nullrating = null;
		try {
			while (cursor.hasNext()) {
				tempobj = cursor.next();
				if (tempobj.get(DBType.rating.toString()) == null) {
					nullrating = new BasicDBObject();
				} else {
					nullrating = tempobj.get(DBType.rating.toString());
				}

				tempalbum = new Album(tempobj.get(DBType.album.toString()),
						tempobj.get(DBType.artist.toString()), tempobj.get(DBType.genre.toString()), nullrating);
				resultList.add(tempalbum);
			}
		} finally {
			cursor.close();
		}
		return resultList;
	}

}
