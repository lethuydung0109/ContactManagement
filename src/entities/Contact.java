package entities;

import java.util.Set;

public class Contact {
	
	private int id; // � supprimer car auto increment dans la bdd
	private String lastname;
	private String firstname;	
	private String email;
	private Address address; // � 0 ou plusieurs address
	private Set<ContactGroup> listGroups; // appartient � 0 au plusieurs groupes
	private Set<PhoneNumber> listPhones; // � 0 ou plusieurs num�ro de t�l�phones, une foreign key qui r�f�rence contact dans la table phoneNumber
	
	
	public Contact(String firstname,String lastname,String email, Address address, Set<PhoneNumber> listPhones)
	{
		//this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;		
		this.email=email;
		this.address=address;
		this.listPhones=listPhones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<ContactGroup> getListGroups() {
		return listGroups;
	}

	public void setListGroups(Set<ContactGroup> listGroups) {
		this.listGroups = listGroups;
	}

	public void addContactGroup(ContactGroup grp){
		this.listGroups.add(grp);
		
		if(!grp.getContacts().contains(this)){
			grp.addContact(this);
		}
	}
	
	public void removeContactGroup(ContactGroup grp){
		this.listGroups.remove(grp);
		
		if(grp.getContacts().contains(this)){
			grp.removeContact(this);
		}
	}
	
	public Set<PhoneNumber> getListPhones() {
		return listPhones;
	}

	public void setListPhones(Set<PhoneNumber> listPhones) {
		this.listPhones = listPhones;
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		this.listPhones.add(phoneNumber);
		
		if (phoneNumber !=null && 
				(phoneNumber.getContact() == null||!phoneNumber.getContact().equals(this))){
			phoneNumber.setContact(this);
		}
	}
	
	public void removePhoneNumber(PhoneNumber phoneNumber) {
		this.listPhones.remove(phoneNumber);
		
		// pour g�rer la suppression de l'objet associ�
		if (phoneNumber !=null && phoneNumber.getContact() != null 
				&& phoneNumber.getContact().equals(this)){
			phoneNumber.setContact(null);
			
		}
	}
	
	public void removeAllPhoneNumber() {
		listPhones.clear();
	}
	
}
