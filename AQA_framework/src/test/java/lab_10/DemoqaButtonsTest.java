package lab_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class DemoqaButtonsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testClickButtons() {
        driver.get("https://demoqa.com/buttons");

        // Ховаємо iframe-рекламу
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('iframe').forEach(el => el.style.display = 'none');");

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        new Actions(driver).scrollToElement(clickMeButton).perform();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(clickMeButton));
        clickMeButton.click();

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertTrue(message.isDisplayed(), "Message should be displayed after clicking.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
