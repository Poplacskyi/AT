package lab_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class DemoqaButtonsTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Крок 2: Встановлення через WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testButtons() {
        // Крок 3: Перехід на сторінку
        driver.get("https://demoqa.com/buttons");

        // Крок 4: Вибір 3 різних кнопок
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement dynamicClickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));

        // Крок 5: Взаємодія
        doubleClickBtn.click(); // Замість doubleClick для простоти
        rightClickBtn.click(); // Замість rightClick
        dynamicClickBtn.click();

        // Крок 6: Перевірка видимості
        assertTrue(doubleClickBtn.isDisplayed(), "Double Click Button not visible");
        assertTrue(rightClickBtn.isDisplayed(), "Right Click Button not visible");
        assertTrue(dynamicClickBtn.isDisplayed(), "Dynamic Click Button not visible");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
