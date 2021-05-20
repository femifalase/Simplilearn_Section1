package ap.commons.hibernate.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course003")
public class CoursesManyBidirectional {

	@Id
	@GeneratedValue
	@Column(name = "course_id")
	private long courseId;

	@Column(name = "course_name", nullable = false, length = 10)
	private String courseName;

	@ManyToMany(mappedBy="courses")
	private List<StudentManyBiDirectional> students;

	public CoursesManyBidirectional(String courseName) {
		this.courseName = courseName;
	}

	public CoursesManyBidirectional() {

	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<StudentManyBiDirectional> getStudents() {
		return students;
	}

	public void setStudents(List<StudentManyBiDirectional> students) {
		this.students = students;
	}
}
