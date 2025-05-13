package listeners;

import io.qameta.allure.Attachment;
import org.testng.*;
import org.openqa.selenium.*;
import driver.DriverFactory;
import utils.VideoRecorder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AllureListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        try {
            VideoRecorder.startRecording(result.getName());
        } catch (Exception ignored) { }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        attachScreenshot(driver);
        attachPageSource(driver);
        stopAndAttachVideo(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        stopAndAttachVideo(result);
    }

    // решта методів з порожньою реалізацією
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

    private void stopAndAttachVideo(ITestResult result) {
        try {
            VideoRecorder.stopRecording();
            File video = VideoRecorder.getVideoFile(result.getName());
            if (video != null) {
                attachVideo(Files.readAllBytes(video.toPath()));
            }
        } catch (Exception ignored) { }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html")
    private String attachPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    @Attachment(value = "Test video", type = "video/avi")
    private byte[] attachVideo(byte[] data) {
        return data;
    }
}
