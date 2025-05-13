package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    private final WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doubleClickButton() {
        WebElement btn = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver).doubleClick(btn).perform();
    }

    public void rightClickButton() {
        WebElement btn = driver.findElement(By.id("rightClickBtn"));
        new Actions(driver).contextClick(btn).perform();
    }

    public String getDoubleClickMessage() {
        return driver.findElement(By.id("doubleClickMessage")).getText();
    }

    public String getRightClickMessage() {
        return driver.findElement(By.id("rightClickMessage")).getText();
    }
}
