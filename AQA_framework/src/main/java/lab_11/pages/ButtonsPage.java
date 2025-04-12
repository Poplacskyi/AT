package lab_11.pages;

;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class ButtonsPage {

    private WebDriver driver;

    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By dynamicClickMsg = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doubleClickButton() {
        WebElement btn = driver.findElement(doubleClickBtn);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.doubleClick(btn).perform();
    }

    public void rightClickButton() {
        WebElement btn = driver.findElement(rightClickBtn);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.contextClick(btn).perform();
    }

    public void dynamicClickButton() {
        WebElement btn = driver.findElement(dynamicClickBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }


    public String getDoubleClickMessage() {
        return driver.findElement(doubleClickMsg).getText();
    }

    public String getRightClickMessage() {
        return driver.findElement(rightClickMsg).getText();
    }

    public String getDynamicClickMessage() {
        return driver.findElement(dynamicClickMsg).getText();
    }
}
