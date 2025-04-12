package lab_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LabelTest {
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
    public void testLabel() {
        LabelWrapper labelWrapper = new LabelWrapper(buttonsPage.getLabel());

        labelWrapper.getText();
        labelWrapper.waitForText("You have clicked");
        labelWrapper.verifyLabelExists();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
