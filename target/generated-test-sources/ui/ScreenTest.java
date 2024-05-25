package ui;

import com.codeborne.selenide.Selenide;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import ui.helpers.SaveScreenshots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import ui.settings.SetP;

import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenTest extends SetP {
    SaveScreenshots saveScreenshots = new SaveScreenshots();
    @Test
    public void testScreenLaptop(TestInfo info) {
        //Configuration.browserSize = "390x844";
        Selenide.open("https://demoqa.com/automation-practice-form");
        assertScreen(info);
    }

    public void assertScreen(TestInfo info) {
        String expectedFileName = info.getTestMethod().get().getName() + ".png";
        String expectedScreensDir = "src/test/resources/screens/";

        File actualScreenshot = Selenide.screenshot(OutputType.FILE);
        File expectedScreenshot = new File(expectedScreensDir + expectedFileName);

        if (!expectedScreenshot.exists()) {
           saveScreenshots.addImgToAllure("actualScreen", actualScreenshot);
            throw new IllegalArgumentException("Cant assert image");

        }
        BufferedImage expextedImage =
                ImageComparisonUtil.readImageFromResources(expectedScreensDir + expectedFileName);
        BufferedImage actualImage =
                ImageComparisonUtil.readImageFromResources(actualScreenshot.toPath().toString());
        File resultDestination = new File("build/diffs/diff_" + expectedFileName);

        ImageComparison imageComparison = new ImageComparison(expextedImage, actualImage, resultDestination);
        ImageComparisonResult result = imageComparison.compareImages();

        if(!result.getImageComparisonState().equals(ImageComparisonState.MATCH)){
            saveScreenshots.addImgToAllure("actual", actualScreenshot);
            saveScreenshots.addImgToAllure("expected", expectedScreenshot);
            saveScreenshots.addImgToAllure("diff", resultDestination);
        }
        Assertions.assertEquals(ImageComparisonState.MATCH, result.getImageComparisonState());
    }

}
