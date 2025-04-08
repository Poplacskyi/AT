import java.util.*;

public class ArrayRotationWithLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Введення кількості позицій для обертання
        System.out.print("Enter number of positions to rotate: ");
        int positions = scanner.nextInt();

        // Обертання масиву вправо
        int[] rotated = rotateArray(arr, positions);

        // Виведення оберненого масиву
        System.out.println("Rotated Array: " + Arrays.toString(rotated));

        // Створення LinkedList та виконання операцій
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : rotated) {
            list.add(num);
        }

        System.out.println("Initial LinkedList: " + list);

        //  Додавання елемента на початок
        list.addFirst(99);
        System.out.println("After adding 99 to the beginning: " + list);

        //  Додавання елемента в кінець
        list.addLast(100);
        System.out.println("After adding 100 to the end: " + list);

        //  Видалення першого елемента
        list.removeFirst();
        System.out.println("After removing the first element: " + list);

        //  Видалення останнього елемента
        list.removeLast();
        System.out.println("After removing the last element: " + list);

        //  Виведення у зворотному порядку
        System.out.print("List in reverse order: ");
        Iterator<Integer> desc = list.descendingIterator();
        while (desc.hasNext()) {
            System.out.print(desc.next() + " ");
        }
        System.out.println();
    }

    // Метод для обертання масиву вправо
    private static int[] rotateArray(int[] array, int positions) {
        int length = array.length;
        int[] result = new int[length];
        positions = positions % length;

        for (int i = 0; i < length; i++) {
            result[(i + positions) % length] = array[i];
        }
        return result;
    }
}
// в програмі ми обчислюєм результат ділення числа на значення, яке отримали при зазначені обєму масива
// і якщо значення буде ноль (а на нуль ділити наможна) то видасть помилку ArithmeticException