package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

	//name of the database
	private String dbName="jee";
	//Object Connection of java.sql (jdbc)
	private Connection connection = null;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/jee";
	private String uid = "root"; 
	private String pwd = "root";
	
	
	/**
	 * Constructor allows to load the driver, then the method connect is calling.
	 * @param dbName name of the database
	 * @return 
	 */
	public Database()
	{
		           
			try {
				Class.forName(driver);	
				this.connection = (Connection) DriverManager.getConnection(this.url, this.uid, this.pwd);
				System.out.println("Connexion a " + this.dbName + " etablie");														
			}catch (SQLException e1){
				System.out.println("Erreur de connexion");
				System.out.println(e1.getSQLState());
	        }catch (ClassNotFoundException e2){
	        	System.out.println("classe pilote introuvable : "+e2.getMessage());
	        }
//		finally {
//
//			try { if (this.connection != null) this.connection.close(); }
//			catch (SQLException e) { e.printStackTrace(); }
//		}
	}
	
	/**
	 * Method which do the connection with the sqLite database
	 * @return true if the connection is etablished, false otherwise
	 */
	public boolean connect() {
		try {
			this.connection = (Connection) DriverManager.getConnection(this.url, this.uid, this.pwd);
			System.out.println("Connexion a " + this.dbName + " etablie");
			return true;
		
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Erreur de connexion");
			System.out.println(sqlException.getSQLState());
			return false;
		} catch (NullPointerException exception) {
			exception.printStackTrace();
			System.out.println("Base de données : "+this.dbName+" introuvable");
			return false;
		}
    }
	
	/** 
	 * Getter which allows to know the private attribute connection
	 * @return attribute connection
	 */
	public Connection getConnection(){
		return this.connection;
	}
	
	/**
	 * Getter which allows to know the private attribute dbName
	 * @return attribute dbName 
	 */
	public String getDBName(){
		return this.dbName;
	}
	
	/**
	 * Allows to close the connection if the connection is not null.
	 * @return true if the connection is close, false otherwise
	 */
	public boolean disconnect() {
		try {
			if(this.connection != null){
				connection.close();
				this.connection = null;
			}
			System.out.println("Deconnexion de " + this.dbName + " OK");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
