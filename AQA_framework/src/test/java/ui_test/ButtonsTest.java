package ui_test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.pages.ButtonsPage;

import static org.testng.Assert.assertTrue;

@Listeners(listeners.AllureListener.class)
public class ButtonsTest {
    private WebDriver driver;
    private ButtonsPage page;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/buttons");
        page = new ButtonsPage(driver);
    }

    @Test
    public void testDoubleClick() {
        page.doubleClickButton();
        String msg = page.getDoubleClickMessage();
        assertTrue(msg.contains("double click"));
    }

    @Test
    public void testRightClick() {
        page.rightClickButton();
        String msg = page.getRightClickMessage();
        assertTrue(msg.contains("right click"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
