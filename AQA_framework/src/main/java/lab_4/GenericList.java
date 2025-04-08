import java.util.*;

public class GenericList<T> {
    private List<T> elements = new ArrayList<>();

    public void add(T item) {
        elements.add(item);
    }

    public void printElements() {
        for (T item : elements) {
            System.out.println(item);
        }
    }
}
