package lab_7;

import jakarta.persistence.*;
import lab_6.Person;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @ManyToMany(mappedBy = "projects")
    public List<Person> people;
}
