package lab_6;

import jakarta.persistence.*;
import lab_6.model.Address;

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
}
