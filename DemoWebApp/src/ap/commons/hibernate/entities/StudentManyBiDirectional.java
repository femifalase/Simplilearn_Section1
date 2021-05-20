package ap.commons.hibernate.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students003")
public class StudentManyBiDirectional {

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student003_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private Set<CoursesManyBidirectional> courses;

	@Embedded
	private StudentAddress studentAddress;

	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

	public StudentManyBiDirectional(String fname, String lname, String emailId, Set<CoursesManyBidirectional> courses) {
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.courses = courses;
	}

	public StudentManyBiDirectional() {
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

	public String getCourses() {
		StringBuilder sb = new StringBuilder();
		if (courses != null && courses.size() > 0) {
			for (CoursesManyBidirectional p : courses) {
				sb.append(p.getCourseName() + ",");
			}
		}
		return sb.toString();
	}

	public void setCourses(Set<CoursesManyBidirectional> courses) {
		this.courses = courses;
	}

}
