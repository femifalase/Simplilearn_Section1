package ap.commons.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ap.commons.hibernate.entities.Color;
import ap.commons.hibernate.entities.CoursesManyBidirectional;
import ap.commons.hibernate.entities.EProductAnnotated;
import ap.commons.hibernate.entities.PhoneNumbers;
import ap.commons.hibernate.entities.PhoneNumbersBidirectional;
import ap.commons.hibernate.entities.PhoneNumbersUniDirectional;
import ap.commons.hibernate.entities.Student;
import ap.commons.hibernate.entities.StudentBidirectional;
import ap.commons.hibernate.entities.StudentManyBiDirectional;
import ap.commons.hibernate.entities.StudentUniDirectional;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try {

			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					/*.addResource("EProduct.hbm.xml")*/
					.addAnnotatedClass(EProductAnnotated.class)
					.addAnnotatedClass(Color.class)
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(PhoneNumbers.class)
					.addAnnotatedClass(StudentUniDirectional.class)
					.addAnnotatedClass(PhoneNumbersUniDirectional.class)
					.addAnnotatedClass(StudentBidirectional.class)
					.addAnnotatedClass(PhoneNumbersBidirectional.class)
					.addAnnotatedClass(StudentManyBiDirectional.class)
					.addAnnotatedClass(CoursesManyBidirectional.class)
					.buildSessionFactory();
			

			return sessionFactory;

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
