package lab_8;

public class Lab2Utils {
    public static void printElements(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int countOdd(int[] array) {
        int count = 0;
        for (int num : array) {
            if (isOdd(num)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }
}
