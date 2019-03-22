package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InscructorDetails;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InscructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			/*
			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
			 * "darby@luv2code.com");
			 * 
			 * InscructorDetails tempInscructorDetails = new
			 * InscructorDetails("http://www.luv2code.com/youtube", "Luv 2 code!!");
			 */
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InscructorDetails tempInscructorDetails = new InscructorDetails("http://www.youtube.com", "Guitar");

			// associate the object
			tempInstructor.setInscructorDetails(tempInscructorDetails);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will AlSO save the details object
			// because of CascadeTYPE.ALL
			//
			System.out.println("Savin inscructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
