package lab_12;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ButtonsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Локатори для кнопок та повідомлень
    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By dynamicClickMsg = By.id("dynamicClickMessage");

    // Використовуємо XPath локатор, який шукає елемент із класами, що містять 'main-header' або 'playgound-header'
    private By headerLocator = By.xpath("//*[contains(@class, 'main-header') or contains(@class, 'playgound-header')]");

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // Використовуємо трохи більший час очікування – 15 секунд
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Метод повертає обгортку (wrapper) для заголовка сторінки
    public LabelWrapper getLabelWrapper() {
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return new LabelWrapper(headerElement);
    }

    public void doubleClickButton() {
        WebElement btn = driver.findElement(doubleClickBtn);
        new Actions(driver).doubleClick(btn).perform();
    }

    public void rightClickButton() {
        WebElement btn = driver.findElement(rightClickBtn);
        new Actions(driver).contextClick(btn).perform();
    }

    public void dynamicClickButton() {
        WebElement btn = driver.findElement(dynamicClickBtn);
        // Прокрутка до елемента (якщо потрібно)
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
