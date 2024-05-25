package ui.helpers;

import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SaveScreenshots {
    @Attachment(value = "{name}", type = "image/png")
    private static byte[] savedScreenshot(String name, byte[] image) {
        return image;
    }
    public void addImgToAllure(String name, File file) {
        try {
            byte[] image = Files.readAllBytes(file.toPath());
            savedScreenshot(name, image);
        } catch (IOException e) {
            throw new RuntimeException("Can't read bytes");

        }
    }
}
