package services;

import daos.ContactGroupDao;
import entities.ContactGroup;

public class ContactGroupService {
	
	private ContactGroupDao contactGroupDao;
	public void createContactGroup(ContactGroup group) 
	{
		contactGroupDao.createContactGroup(group);
	}
	
	public void searchContactGroup() {
		
	}
	
	public void updateContactGroup()
	{
		
	}
	
	public void deleteContactGroup()
	{
		
	}

}
