package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import entities.Contact;

public class ContactDao {
	
	public static void createContact(Contact c, int idAddress) 
	{
		DataSource ds = null;
		Connection cn =null;
			
		try
		{
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
			cn=ds.getConnection();
			
			String requete = "INSERT INTO Contact (firstname,lastname,email,idAddress) VALUES" + "("+ "'"+  c.getFirstname() + "', '" + c.getLastname() + "', '"+ c.getEmail() + "', '" + idAddress +"')";
			int nb = cn.createStatement().executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
			
			System.out.println("ID of the inserted line = " + nb);
			
		}
		catch(SQLException | NamingException e)
		{
			e.printStackTrace();
		}
		finally {
			try { if (cn != null) cn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
		
	}
	
	
//	public static void createContact(int id, String firstname, String lastname, String email) throws SQLException
//	{
//		//System.out.println("Création d'un contact \n id : "+id+"\nfirstname : "+firstname+"\nlastname : "+lastname+"\nemail : "+email);
//		Database db = new Database();
//		Connection cx =null;
//		Statement stmt = null;
//	
//		try
//		{
//			 cx  = db.getConnection();			
//			 stmt = (Statement) cx.createStatement();
//			 String requete = "INSERT INTO Contact (firstname,lastname,email,address) VALUES" + "("+ "'"+  firstname + "', '" + lastname + "', '"+ email + "', '" + null +"')";
//
//			int nb = stmt.executeUpdate(requete);
//			System.out.println("nb lignes mises a jour=" + nb);
//		}
//		finally {
//			try { if (cx != null) cx.close(); }
//			catch (SQLException e) { e.printStackTrace(); }
//		}
//		
//	}
	
	public static void updateContact()
	{
		System.out.println("Update Contact");
		// select le contact dont on a l'id ou le mail
		//
	}
	
	public static void searchContact() {
		System.out.println("Search Contact");
	}
	
		
	public static void deleteContact(int id, String email)
	{
		DataSource ds = null;
		Connection cn =null;
			
		try
		{
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
			cn=ds.getConnection();
			
			String requete = "Delete from Contact where id=? or email= ?";
					
			PreparedStatement ps=cn.prepareStatement(requete);
			ps.setInt(1, id);
			ps.setString(2, email);
			boolean execute = ps.execute();
			
			
			System.out.println("contact supprimé ? " + execute);
		}
		catch(SQLException | NamingException e)
		{
			e.printStackTrace();
		}
		finally {
			try { if (cn != null) cn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
//	public static void testBD(int id, String firstname, String lastname, String email)
//	{
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost/jee";
//		String uid = "root"; String passwd = "root";
//		Connection cx = null;
//		Statement stmt=null;
//		
//		try {
//			Class.forName(driver);
//			cx = (Connection) DriverManager.getConnection(url, uid, passwd);
//			stmt = (Statement) cx.createStatement();
//			String requete = "INSERT INTO Contact VALUES " + "(" + id + ", '"+ firstname + "', '" + lastname + "', '"+ email + "', '" + null +"')";
//
//			int nb = stmt.executeUpdate(requete);
//			System.out.println("nb lignes mises a jour=" + nb);
//			
//		} catch (ClassNotFoundException e) {
//			// classe du pilote introuvable
//			System.out.println("classe pilote introuvable : "+e.getMessage());
//		} catch (SQLException e) {
//			// accès à la base refusé
//			System.out.println("accès refusé : "+e.getMessage());
//		} finally {
//
//			try { if (cx != null) cx.close(); }
//			catch (SQLException e) { e.printStackTrace(); }
//
//		}
//	}
}
