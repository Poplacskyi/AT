package lab_13;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener {
    private static final Logger logger = Logger.getLogger(CustomListener.class);
    private VideoRecorder videoRecorder = new VideoRecorder(); //для відеозйомки

    // ----------------- ISuiteListener -----------------
    @Override
    public void onStart(ISuite suite) {
        logger.info("ISuiteListener onStart: Setting up environment for suite: " + suite.getName());
        // Наприклад, підключення до БД:
       2
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("ISuiteListener onFinish: Tearing down environment for suite: " + suite.getName());
        // Наприклад, відключення від БД:
        // DatabaseHelper.close();
    }

    // ----------------- IExecutionListener -----------------
    @Override
    public void onExecutionStart() {
        logger.info("IExecutionListener onExecutionStart: Test execution started.");
        // Ініціалізація ресурсів, якщо потрібно.
    }

    @Override
    public void onExecutionFinish() {
        logger.info("IExecutionListener onExecutionFinish: Test execution finished.");
        
    }

    // ----------------- ITestListener -----------------
    @Override
    public void onStart(ITestContext context) {
        logger.info("ITestListener onStart: Test context starting: " + context.getName());
        // Завантаження тестових даних (наприклад, з локальної бази даних) і старт браузера.
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("ITestListener onFinish: Test context finished: " + context.getName());
        // Закриття ресурсів, наприклад, закриття з'єднання з БД, завершення роботи браузера.
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("ITestListener onTestStart: Test method started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("ITestListener onTestSuccess: Test method succeeded: " + result.getMethod().getMethodName());
    
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("ITestListener onTestFailure: Test method failed: " + result.getMethod().getMethodName(), result.getThrowable());

        // Зробити скріншот:
        takeScreenshot(result);
        // Зберегти HTML код сторінки:
        saveHtmlSource(result);
        // Запустити відеозйомку (або зупинити запис і зберегти відео):
        videoRecorder.recordFailure(result);
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("ITestListener onTestSkipped: Test method skipped: " + result.getMethod().getMethodName() + " | Reason: " + result.getSkipCausedBy());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Не реалізовано
    }

    // ----------------- IInvokedMethodListener -----------------
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.info("IInvokedMethodListener beforeInvocation: " + method.getTestMethod().getMethodName());
       
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.info("IInvokedMethodListener afterInvocation: " + method.getTestMethod().getMethodName());
        // Логування завершення виклику тесту, можливе закриття браузера, якщо потрібно.
    }

    // ----------------- Helper Methods -----------------

    private void takeScreenshot(ITestResult result) {
        try {
            Object testClassInstance = result.getInstance();
            if (testClassInstance instanceof WebDriverProvider) {
                WebDriver driver = ((WebDriverProvider) testClassInstance).getDriver();
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String screenshotName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
                // Збережіть файл у потрібну директорію (реалізуйте власну логіку збереження)
                logger.info("Screenshot saved as: " + screenshotName);
            }
        } catch (Exception e) {
            logger.error("Exception during screenshot capture", e);
        }
    }

    private void saveHtmlSource(ITestResult result) {
        try {
            Object testClassInstance = result.getInstance();
            if (testClassInstance instanceof WebDriverProvider) {
                WebDriver driver = ((WebDriverProvider) testClassInstance).getDriver();
                String htmlSource = driver.getPageSource();
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = result.getMethod().getMethodName() + "_" + timestamp + ".html";
                // Збережіть htmlSource у файл (реалізуйте власну логіку запису)
                logger.info("HTML source saved as: " + fileName);
            }
        } catch (Exception e) {
            logger.error("Exception during saving HTML source", e);
        }
    }
}
