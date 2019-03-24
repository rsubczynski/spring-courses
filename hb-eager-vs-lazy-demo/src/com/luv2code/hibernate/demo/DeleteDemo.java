package com.luv2code.hibernate.demo;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int theId = 1;
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found inscructor: " + tempInstructor);

			// delete instructors

			Optional.ofNullable(tempInstructor).ifPresent(inscructor -> deleteInscructor(session, tempInstructor));

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

	private static void deleteInscructor(Session session, Instructor tempInstructor) {
		System.out.println("Deleting: " + tempInstructor);
		// Note: will ALSO delete associated "details" object
		session.delete(tempInstructor);
	}

}
