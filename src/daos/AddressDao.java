package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Statement;

import entities.Address;

public class AddressDao {
	
	public static int createAddress(Address a) 
	{
		DataSource ds = null;
		Connection cn =null;
		int insertId = 0;
		try
		{
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
			cn=ds.getConnection();
			
			String requete = "INSERT INTO address (street,city,zip,country) VALUES" + "("+ "'"+  a.getStreet() + "', '" + a.getCity() + "', '" + a.getZip() + "', '"+ a.getCountry() + "')";
			Statement st = cn.createStatement();
			// Cette ligne est pour prendre le ID Adresse auto-genere par mySQL, 
			// pour qu'on puisse l'ajouter dans Contacts
			st.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys(); 
			
			if(rs.next()) { 
				insertId = rs.getInt(1); 
			}
			System.out.println("ID of the inserted line = " + insertId);
			
		}
		catch(SQLException | NamingException e)
		{
			e.printStackTrace();
		}
		finally {
			try { if (cn != null) cn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
		return insertId;
	}
	
	public void searchAddress() {
		
	}
	
	public void updateAddress()
	{
		
	}
	
	public static void deleteAddress(int aid)
	{
		
	}
}
