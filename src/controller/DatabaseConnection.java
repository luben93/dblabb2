package controller;

	import java.sql.SQLException;
import java.util.ArrayList;

	import model.Album;
	
	/**
	 * the actual controller, handle all communication between the view and the
	 * model
	 * 
	 * @author luben and steffe
	 * 
	 */
public interface DatabaseConnection {
		
		 String ip = "83.250.249.187", user = "", pwd = "", database = "";

		/**
		 * start is the equivalent of the constructor
		 */
		public void start() ;
		
		/**
		 * terminates the connection
		 */
		public void terminateCon();

		/**
		 * update contains a insert SQL statment
		 * 
		 * @param artist
		 * @param album
		 * @param genre
		// * @throws SQLException 
		 * @return 
		 */
		public boolean AddData(ArrayList<String> artist, String album, String genre, String rating)throws DatabaseErrorExecption ,NullValueExecption;
		
		
		//public void AddAnotherArtistToAlbum(String artist, String album)throws DatabaseErrorExecption,NullValueExecption ;

		/**
		 * Search contains a select SQL statment
		 * 
		 * @param SearchOn
		 * 				
		 * @param SearchedText
		 * 
		 * @param Table
		 * @throws SQLException 
		 */
		
		//TODO SEARCH
		public void Search(DBType type, String SearchedText)throws DatabaseErrorExecption ;
		
		//TODO 
		/**
		 * selects all
		 * @throws SQLException 
		 */
		public void selectAll()throws DatabaseErrorExecption ;

		/**
		 * updates rating
		 * 
		 * @param rating
		 * @param album
		 * @throws SQLException 
		 */
		
		//TODO SEARCH F�RST. TYP KLAR MEN SEARCH ?
		public void updateRating(String rating, String SelectedRow)throws DatabaseErrorExecption;

		//@SuppressWarnings("unchecked")
		public ArrayList<Album> getLatestQueryResults() throws DatabaseErrorExecption ;


		
}
