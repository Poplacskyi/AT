package lab_12;

import lab_8.Lab2Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Lab2Tests {

    @Test(dataProvider = "arrayData")
    public void testCountOdd(int[] array, int expectedOddCount) {
        assertEquals(Lab2Utils.countOdd(array), expectedOddCount);
    }

    @DataProvider
    public Object[][] arrayData() {
        return new Object[][] {
                { new int[]{1, 2, 3}, 2 },
                { new int[]{2, 4, 6}, 0 },
                { new int[]{1, 3, 5, 7}, 4 }
        };
    }

    @Test(dataProvider = "oddValues")
    public void testIsOdd(int value) {
        assertTrue(Lab2Utils.isOdd(value));
    }

    @DataProvider
    public Object[][] oddValues() {
        return new Object[][] {
                {1}, {3}, {5}, {7}
        };
    }

    @Test
    @Parameters({"a", "b", "c"})
    public void testCountOddWithParams(int a, int b, int c) {
        int[] array = {a, b, c};
        int count = Lab2Utils.countOdd(array);
        System.out.println("Odd count from parameters: " + count);
    }
}
