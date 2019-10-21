package services;

import daos.PhoneNumberDao;
import entities.PhoneNumber;

public class PhoneNumberService {

	private PhoneNumberDao phoneNumberDao;
	

	public void createPhoneNumber(PhoneNumber phone) 
	{

		phoneNumberDao.createPhoneNumber(phone);
	}
	
	public void searchPhoneNumber() {
		
	}
	
	public void updatePhoneNumber()
	{
		
	}
	
	public void deletePhoneNumber()
	{
		
	}
}
