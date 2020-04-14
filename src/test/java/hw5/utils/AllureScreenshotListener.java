package hw5.utils;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class AllureScreenshotListener extends TestListenerAdapter {


    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    private OutputType<byte[]> takeScreenshot() {
        //byte[] array = {1};
        try {
            return (OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }

        return OutputType.BYTES;
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takeScreenshot();
    }
}
