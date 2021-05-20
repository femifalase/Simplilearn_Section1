package ap.commons.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone002")
public class PhoneNumbersBidirectional {

	@Id
	@GeneratedValue
	@Column(name = "phone_id")
	private long phoneId;

	@Column(name = "phone_type", nullable = false, length = 10)
	private String phoneType;

	@Column(name = "phone_number", nullable = false, length = 15)
	private String phoneNumber;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentBidirectional student;

	public PhoneNumbersBidirectional(String phoneType, String phoneNumber) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumbersBidirectional() {

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

	public StudentBidirectional getStudent() {
		return student;
	}

	public void setStudent(StudentBidirectional student) {
		this.student = student;
	}
}
