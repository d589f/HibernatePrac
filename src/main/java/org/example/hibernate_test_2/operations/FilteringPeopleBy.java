package org.example.hibernate_test_2.operations;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class FilteringPeopleBy {
    public static void filteringPeopleBySalary() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;

        try {
            Scanner scanner = new Scanner(System.in);
            session = factory.getCurrentSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Employee.class);
            System.out.print("select the minimum salary threshold for filtering:  ");
            int answer = scanner.nextInt();
            criteria.add(Restrictions.eq("salary", answer));
            List<Employee> employees = criteria.list();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
    public static void filteringPeopleByDepartment(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        try {
            Scanner scanner = new Scanner(System.in);
            session = factory.getCurrentSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Employee.class);
            System.out.print("Enter department which you want to filter: ");
            String answer = scanner.nextLine();
            criteria.add(Restrictions.eq("department", answer));
            List<Employee> employees = criteria.list();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}