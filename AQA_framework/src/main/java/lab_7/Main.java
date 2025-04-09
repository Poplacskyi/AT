package lab_7;

import lab_6.HibernateUtil;
import lab_6.Person;
import lab_6.model.Address;
import org.hibernate.Session;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            Person person = new Person();
            person.name = "Ivan";
            person.isEmployed = true;

            Address address1 = new Address();
            address1.city = "Lviv";
            address1.person = person;

            Address address2 = new Address();
            address2.city = "Kyiv";
            address2.person = person;

            person.addresses = new ArrayList<>();
            person.addresses.add(address1);
            person.addresses.add(address2);

            Passport passport = new Passport();
            passport.number = "AA123456";
            person.passport = passport;

            Project project1 = new Project();
            project1.name = "Project A";

            Project project2 = new Project();
            project2.name = "Project B";

            person.projects = new ArrayList<>();
            person.projects.add(project1);
            person.projects.add(project2);

            session.persist(person);
            session.getTransaction().commit();

            session.beginTransaction();
            Person found = session.get(Person.class, person.id);
            System.out.println("Found person: " + found.name);
            System.out.println("Passport: " + found.passport.number);
            System.out.println("Projects:");
            for (Project p : found.projects) {
                System.out.println("- " + p.name);
            }
            session.getTransaction().commit();

            session.beginTransaction();
            found.name = "Ivan Updated";
            found.passport.number = "BB654321";

            found.projects = new ArrayList<>(found.projects); // гарантуємо змінність
            found.projects.add(new Project() {{ name = "Project C"; }});

            session.merge(found);
            session.getTransaction().commit();

            session.beginTransaction();
            session.remove(found);
            session.getTransaction().commit();

            System.out.println("Person deleted.");
        }
    }
}
