package Product;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        WebDriver driver = ((MenuDifferentapproch) testInstance).getDriver();
        screenshotutil.screenshot(driver, result.getName());
    }
}
