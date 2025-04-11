package lab_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DemoqaButtonsTest {
    WebDriver driver;
    DemoqaButtonsPage buttonsPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        buttonsPage = new DemoqaButtonsPage(driver);
    }

    @Test
    public void testClickButtons() {
        buttonsPage.openPage();

        // Двічі клік
        new Actions(driver).doubleClick(buttonsPage.getDoubleClickBtn()).perform();
        // Правий клік
        new Actions(driver).contextClick(buttonsPage.getRightClickBtn()).perform();
        // Звичайний клік
        buttonsPage.getClickMeBtn().click();

        // Перевірка результату
        assertTrue(buttonsPage.getMessage().isDisplayed(), "Dynamic message not visible!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
