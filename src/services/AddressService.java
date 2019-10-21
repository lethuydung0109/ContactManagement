package services;

import daos.AddressDao;
import entities.Address;

public class AddressService {
	
	private AddressDao addressDao;
	

	public int createAddress(Address address) 
	{

		return AddressDao.createAddress(address);
	}
	
	public void searchAddress() {
		
	}
	
	public void updateAddress()
	{
		
	}
	
	public void deleteAddress(int aid)
	{
		AddressDao.deleteAddress(aid);
	}
	
}
