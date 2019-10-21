package entities;

public class PhoneNumber {

	private int phoneId; //pas besoin d'un phoneId, auto-generate
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;
	
	public PhoneNumber(String phoneKind, String phoneNumber) {
		
		//this.phoneId = phoneId;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		//this.contact=contact;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Contact getContact() {
		return this.contact;
	}

	// pour gérer la suppression de l'objet associé
	public void setContact(Contact contact) {
		this.contact = contact;
		
		if (!contact.getListPhones().contains(this)) {
			contact.addPhoneNumber(this);
		}
	}
	
	
}
