package utils;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {
    private static ScreenRecorder screenRecorder;

    public static void startRecording(String testName) throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        File folder = new File("target/videos");
        if (!folder.exists()) folder.mkdirs();

        screenRecorder = new ScreenRecorder(
                gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null,
                folder
        );
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
        }
    }

    /** Повертає файл відео за назвою тесту */
    public static File getVideoFile(String testName) {
        File folder = new File("target/videos");
        for (File f : folder.listFiles()) {
            if (f.getName().contains(testName) && f.getName().endsWith(".avi")) {
                return f;
            }
        }
        return null;
    }
}
