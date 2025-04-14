package lab_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// ... інші імпорти

public class AdBlockTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // 1) Варіант: запуск із вашим профілем Chrome:
        options.addArguments("user-data-dir=C:\\Users\\mypcl\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

        // 2) Варіант: підвантажити CRX‑файл:
        // File adBlockExtension = new File("C:\\path\\to\\adblock_extension.crx");
        // options.addExtensions(adBlockExtension);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
