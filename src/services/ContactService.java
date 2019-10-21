package services;

import java.sql.SQLException;

import javax.naming.NamingException;

import daos.ContactDao;
import entities.Contact;

public class ContactService {

	private ContactDao contactDao;
	
	
	
	public void createContact(Contact contact, int idAddress) throws SQLException, NamingException
	{
		ContactDao.createContact(contact, idAddress);
	}
	
	public void searchContact() {
		
	}
	
	public void updateContact()
	{
		
	}
	
	public void deleteContact(int id, String email)
	{
		ContactDao.deleteContact(id, email);
	}
}
