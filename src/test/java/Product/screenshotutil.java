package Product;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenshotutil {


    public static void screenshot(WebDriver driver, String testname) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshot/" + testname + ".png"));
            System.out.println("Screenshot saved for failed test: " + testname);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
