package lab_11;

import lab_11.pages.ButtonsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DemoqaButtonsTest {

    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testClickButtons() {
        buttonsPage.dynamicClickButton(); // ✅ викликає правильний метод
        String actualMessage = buttonsPage.getDynamicClickMessage(); // ✅ правильний метод
        assertTrue(actualMessage.contains("You have done a dynamic click"), "Expected click message not found!");

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
