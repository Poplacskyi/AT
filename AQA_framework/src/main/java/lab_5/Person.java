package lab_5;

public class Person {
    public boolean isEmployed;
    public String name;
    public Address address;

    @Override
    public String toString() {
        return name + " from " + address.city;
    }
}
