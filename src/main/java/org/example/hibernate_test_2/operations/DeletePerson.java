package org.example.hibernate_test_2.operations;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeletePerson {
    public static void deletePerson(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try{
            Scanner scanner = new Scanner(System.in);
            session = factory.getCurrentSession();
            session.beginTransaction();
            /////////////////////////////////////

            System.out.print("Enter the id of the employee you want to delete:  ");
            int id = scanner.nextInt();
            Employee employee = session.get(Employee.class, id);
            Detail detail = session.get(Detail.class, id);

            if (employee != null){
                session.delete(employee);
                session.delete(detail);
            }else{
                System.out.println("Employee with id: " + id + " not found");
            }

            /////////////////////////////////////
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }
}
