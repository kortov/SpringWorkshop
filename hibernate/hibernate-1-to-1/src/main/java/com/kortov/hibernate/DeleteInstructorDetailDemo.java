package com.kortov.hibernate;

import com.kortov.hibernate.entity.Instructor;
import com.kortov.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("InstructorDetail: " + instructorDetail);
            System.out.println("The assosiated instructor: " + instructorDetail.getInstructor());
            System.out.println("Deleting instructorDetail: " + instructorDetail);
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
