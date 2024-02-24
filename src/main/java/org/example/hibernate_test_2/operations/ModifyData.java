package org.example.hibernate_test_2.operations;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ModifyData {
    public static void modifyData() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select the employee id for the modification: ");
            int id = scanner.nextInt();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            Detail detail = session.get(Detail.class, id);

            System.out.print("Select what you want to modify " +
                    "(name/lastName/department/salary/city/phoneNumber/email):  ");
            String answer = scanner.next();

            if (employee != null) {
                switch (answer) {
                    case "name":
                        System.out.print("Enter new name for the employee: ");
                        String newName = scanner.next();
                        employee.setFirstName(newName);
                        break;
                    case "lastName":
                        System.out.print("Enter new last name for the employee: ");
                        String newLastName = scanner.next();
                        employee.setSurname(newLastName);
                        break;
                    case "department":
                        System.out.print("Enter new department for the employee: ");
                        String newDepartment = scanner.next();
                        employee.setDepartment(newDepartment);
                        break;
                    case "salary":
                        System.out.print("Enter new salary for the employee: ");
                        int newSalary = scanner.nextInt();
                        employee.setSalary(newSalary);
                        break;
                    case "city":
                        System.out.print("Enter new city for the employee: ");
                        String newCity = scanner.next();
                        detail.setCity(newCity);
                        break;
                    case "phoneNumber":
                        System.out.print("Enter new phone number for the employee: ");
                        String newPhoneNumber = scanner.next();
                        detail.setPhoneNumber(newPhoneNumber);
                        break;
                    case "email":
                        System.out.print("Enter new email for the employee: ");
                        String newEmail = scanner.next();
                        detail.setEmail(newEmail);
                        break;
                    default:
                        System.out.println("Incorrect request");
                        break;
                }

                session.save(employee);
                session.save(detail);
                session.getTransaction().commit();
                System.out.println("Done!");
            } else {
                System.out.println("There is no person with id: " + id);
            }

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

}
