package ap.commons.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class PhoneNumbers {

	@Id
	@GeneratedValue
	@Column(name = "phone_id")
	private long phoneId;

	@Column(name = "phone_type", nullable = false, length = 10)
	private String phoneType;

	@Column(name = "phone_number", nullable = false, length = 15)
	private String phoneNumber;

	public PhoneNumbers(String phoneType, String phoneNumber) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumbers() {
		
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
