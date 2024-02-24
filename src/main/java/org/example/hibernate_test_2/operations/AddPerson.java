package org.example.hibernate_test_2.operations;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddPerson {
    public static void addPerson(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new persons name:  ");
            String name = scanner.nextLine();

            System.out.print("Enter new persons last name:  ");
            String lastName = scanner.nextLine();

            System.out.print("Enter new persons department:  ");
            String personDepartment = scanner.nextLine();

            System.out.print("Enter new persons salary:  ");
            int personSalary = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new persons city:  ");
            String city = scanner.nextLine();

            System.out.print("Enter new persons telephone number:  ");
            String telephoneNumber = scanner.nextLine();

            System.out.print("Enter new persons email:  ");
            String email = scanner.nextLine();

            session = factory.getCurrentSession();
            session.beginTransaction();
            /////////////////////////////////////
            Employee employee = new Employee(name, lastName,
                    personDepartment, personSalary);
            Detail detail = new Detail(city,telephoneNumber,
                    email);

            employee.setEmpDetail(detail);
            session.save(employee);

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
