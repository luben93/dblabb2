package controller;

import java.util.ArrayList;

import model.Album;

public class Connector implements DatabaseConnection{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminateCon() {
		// TODO Auto-generated method stub
		
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
