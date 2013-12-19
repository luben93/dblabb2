package model;

import java.util.ArrayList;

import com.mongodb.DBObject;

public class Album {
	private Object album, genre, artist, rating;

	public Album() {
		System.out.println("just smile and wave boys :)");
	}

	public Album(Object album, Object artist, Object genre, Object rating) {
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		this.rating = rating;
	}



	public String getAlbum() {
		return album.toString();
	}

	public String getArtist() {
		return artist.toString();
	}

	public String getGenre() {
		return genre.toString();
	}

	public String getRating() {
		return rating.toString();
	}


	public String toString() {
		String out = null;
		out = album + " ";

		out = out + genre + " " + rating + " " + artist;
		return out;
	}

	public String[] getArray() {
		String[] temp = new String [4];
		temp[0]= album.toString();
		temp[1]=genre.toString();
		temp[2]=rating.toString();
		temp[3]=artist.toString();


		return temp;
	}

}
