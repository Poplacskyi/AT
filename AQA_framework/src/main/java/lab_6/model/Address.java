package lab_6.model;

import jakarta.persistence.*;
import lab_6.Person;


@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person person;
}
