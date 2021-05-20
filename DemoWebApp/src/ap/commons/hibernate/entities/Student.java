package ap.commons.hibernate.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

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

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name = "student_phone", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "PHONE_ID") })
	private Set<PhoneNumbers> phoneNumbers;

	public Student(String fname, String lname, String emailId, Set<PhoneNumbers> phoneNumbers) {
		this.fname = fname;
		this.lname = lname;
		this.emailId=emailId;
		this.phoneNumbers = phoneNumbers;
	}
	
	public Student() {
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
		if(phoneNumbers!=null && phoneNumbers.size()>0) {
			for(PhoneNumbers p : phoneNumbers) {
				sb.append(p.getPhoneNumber()+",");
			}
		}
		return sb.toString();
	}

	public void setPhoneNumbers(Set<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
