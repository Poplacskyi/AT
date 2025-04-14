package lab_13;

import org.testng.ITestResult;

public class VideoRecorder {
    public void recordFailure(ITestResult result) {
        // Реалізуйте інтеграцію з бібліотекою для відеозапису або напишіть власну логіку
        System.out.println("Video recording for failed test: " + result.getMethod().getMethodName());
    }
}
