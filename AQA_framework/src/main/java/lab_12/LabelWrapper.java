package lab_12;

import org.openqa.selenium.WebElement;

public class LabelWrapper {
    private final WebElement element;

    public LabelWrapper(WebElement element) {
        this.element = element;
    }

    // Отримання тексту з елемента з логуванням
    public String getText() {
        String text = element.getText();
        System.out.println("Label text: " + text);
        return text;
    }

    // Метод, який перевіряє, чи містить елемент очікуваний текст (повертає true, якщо так)
    public boolean waitForText(String expected) {
        String actual = element.getText();
        boolean result = actual.contains(expected);
        System.out.println("Waiting for text '" + expected + "' -> " + result);
        return result;
    }

    // Перевірка, що елемент відображається
    public boolean verifyLabelExists() {
        boolean result = element.isDisplayed();
        System.out.println("Label exists: " + result);
        return result;
    }
}
