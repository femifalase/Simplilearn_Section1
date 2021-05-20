package ap.commons.hibernate.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students002")
public class StudentBidirectional {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long studentId;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "email_id")
	private String emailId;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<PhoneNumbersBidirectional> phoneNumbers;

	public StudentBidirectional(String fname, String lname, String emailId,
			Set<PhoneNumbersBidirectional> phoneNumbers) {
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.phoneNumbers = phoneNumbers;
	}

	public StudentBidirectional() {
		// TODO Auto-generated constructor stub
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumbers() {
		StringBuilder sb = new StringBuilder();
		if (phoneNumbers != null && phoneNumbers.size() > 0) {
			for (PhoneNumbersBidirectional p : phoneNumbers) {
				sb.append(p.getPhoneNumber() + ",");
			}
		}
		return sb.toString();
	}

	public void setPhoneNumbers(Set<PhoneNumbersBidirectional> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
