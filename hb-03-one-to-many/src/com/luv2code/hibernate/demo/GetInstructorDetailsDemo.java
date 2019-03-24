package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;

public class GetInstructorDetailsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor details object
			int theId = 2;
			InstructorDetail tempInscructorDetails = session.get(InstructorDetail.class, theId);
			// print the instructor detail
			System.out.println("tempInscructorDetails: " + tempInscructorDetails);
			// print the associated instructor
			System.out.println("the associated Instructor: " + tempInscructorDetails.getInstructor());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
