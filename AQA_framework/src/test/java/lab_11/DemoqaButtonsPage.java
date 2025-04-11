package lab_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaButtonsPage {
    WebDriver driver;

    public DemoqaButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/buttons");
    }

    public WebElement getDoubleClickBtn() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickBtn() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClickMeBtn() {
        return driver.findElement(By.xpath("//button[text()='Click Me']"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }
}
