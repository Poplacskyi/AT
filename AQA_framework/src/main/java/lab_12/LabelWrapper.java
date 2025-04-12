package lab_12;

import org.openqa.selenium.WebElement;

public class LabelWrapper {
    private final WebElement element;

    public LabelWrapper(WebElement element) {
        this.element = element;
    }

    public String getText() {
        String text = element.getText();
        System.out.println("Label text: " + text);
        return text;
    }

    public boolean waitForText(String expected) {
        String actual = element.getText();
        boolean result = actual.equals(expected);
        System.out.println("Waiting for text '" + expected + "' -> " + result);
        return result;
    }

    public boolean verifyLabelExists() {
        boolean result = element.isDisplayed();
        System.out.println("Label exists: " + result);
        return result;
    }
}
