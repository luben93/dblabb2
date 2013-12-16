package model;

import java.util.ArrayList;

public class Album {
	private String album, genre, rating, artist;

	public Album() {
		System.out.println("just smile and wave boys :)");
	}

	public Album(String album, String genre, String rating, String artist) {
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		this.rating = rating;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtis(String artist) {
		this.artist = artist;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public String getRating() {
		return rating;
	}


	public String toString() {
		String out = null;
		out = album + " ";

		out = out + genre + " " + rating + " " + artist;
		return out;
	}

	public String[] getArray() {
		String[] temp = new String [4];
		temp[0]= album;
		temp[1]=genre;
		temp[2]=rating;
		temp[3]=artist;


		return temp;
	}

}
