package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InscructorDetails;
import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InscructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor details object
			int theId = 3;
			InscructorDetails tempInscructorDetails = session.get(InscructorDetails.class, theId);
			// print the instructor detail
			System.out.println("tempInscructorDetails: " + tempInscructorDetails);
			// print the associated instructor
			System.out.println("the associated Instructor: " + tempInscructorDetails.getInstructor());
			// commit transaction

			// now let's delete the instructor detail
			System.out.println("Deleting: " + tempInscructorDetails);
			tempInscructorDetails.getInstructor().setInscructorDetails(null);
			session.delete(tempInscructorDetails);
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
