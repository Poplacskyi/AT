package lab_6;

import lab_6.model.Address;
import org.hibernate.Session;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            // Створюємо Person
            Person person = new Person();
            person.name = "John Doe";
            person.isEmployed = true;

            // Створюємо Address 1
            Address addr1 = new Address();
            addr1.city = "Kyiv";
            addr1.person = person;

            // Створюємо Address 2
            Address addr2 = new Address();
            addr2.city = "Lviv";
            addr2.person = person;

            // Прив'язуємо адреси до Person
            person.addresses = Arrays.asList(addr1, addr2);

            // Зберігаємо в базу
            session.persist(person);

            session.getTransaction().commit();
        }
    }
}
