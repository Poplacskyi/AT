package lab_7;

import jakarta.persistence.*;
import lab_6.Person;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String number;

    @OneToOne(mappedBy = "passport")
    public Person person;
}
