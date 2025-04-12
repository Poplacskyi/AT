package lab_12;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;


public class ButtonsPage {

    private WebDriver driver;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement dynamicClickBtn;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMsg;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMsg;

    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMsg;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLabel() {
        return driver.findElement(By.xpath("//div[@class='main-header']"));
    }

    public void doubleClickButton() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
    }

    public void rightClickButton() {
        new Actions(driver).contextClick(rightClickBtn).perform();
    }

    public void dynamicClickButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicClickBtn);
        dynamicClickBtn.click();
    }

    public String getDoubleClickMessage() {
        return doubleClickMsg.getText();
    }

    public String getRightClickMessage() {
        return rightClickMsg.getText();
    }

    public String getDynamicClickMessage() {
        return dynamicClickMsg.getText();
    }
}
