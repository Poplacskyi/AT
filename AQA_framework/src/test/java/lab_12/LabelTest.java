package lab_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LabelTest {

    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void setUp() {
        // Налаштування ChromeDriver через WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testLabel() {
        LabelWrapper labelWrapper = buttonsPage.getLabelWrapper();
        String text = labelWrapper.getText();
        System.out.println("Header text: " + text);
        assertTrue(text.contains("Buttons"), "Header does not contain 'Buttons'");
        assertTrue(labelWrapper.verifyLabelExists(), "Header is not displayed");
        assertTrue(labelWrapper.waitForText("Buttons"), "Header text is not as expected");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
