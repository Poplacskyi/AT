package lab1_2;

public class Lab1Main { // Клас з іменем Main
    public static void main(String[] args) {
        int[] numbers = {3, 6, 9, 12, 15, 18};

        System.out.println("Elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int oddCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddCount++;
            }
        }

        System.out.println("Number of odd elements: " + oddCount);
    }
}
