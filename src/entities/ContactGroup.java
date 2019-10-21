package entities;

import java.util.Set;

public class ContactGroup {

	private int groupId;//auto increment dans la bdd
	private String groupName;
	private Set<Contact> contacts; // taille min = 1
	
	public ContactGroup(String groupName, Set<Contact> contacts) {
		super();
		//this.groupId = groupId;
		this.groupName = groupName;
		this.contacts=contacts;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
		
		if(!contact.getListGroups().contains(this)){
			contact.addContactGroup(this);
		}
	}

	public void removeContact(Contact contact) {
		this.contacts.remove(contact);
		
		if(contact.getListGroups().contains(this)){
			contact.removeContactGroup(this);
		}
	}
	
	
	
}
