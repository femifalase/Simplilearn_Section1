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
@Table(name = "students001")
public class StudentUniDirectional {

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Set<PhoneNumbersUniDirectional> phoneNumbers;

	public StudentUniDirectional(String fname, String lname, String emailId,
			Set<PhoneNumbersUniDirectional> phoneNumbers) {
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.phoneNumbers = phoneNumbers;
	}

	public StudentUniDirectional() {
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
			for (PhoneNumbersUniDirectional p : phoneNumbers) {
				sb.append(p.getPhoneNumber() + ",");
			}
		}
		return sb.toString();
	}

	public void setPhoneNumbers(Set<PhoneNumbersUniDirectional> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
