package lab_6;

import jakarta.persistence.*;
import lab_6.model.Address;
import lab_7.Passport;
import lab_7.Project;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @Column(name = "is_employed")
    public boolean isEmployed;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    public Passport passport;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    public List<Project> projects;
}
