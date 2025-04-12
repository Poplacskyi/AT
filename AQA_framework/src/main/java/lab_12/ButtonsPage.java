package lab_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {
    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='app']//h1") // або будь-який label
    private WebElement labelElement;

    public LabelWrapper getLabel() {
        return new LabelWrapper(labelElement);
    }
}
