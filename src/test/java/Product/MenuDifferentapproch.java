package Product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagefactoryfiles.Approchpagefactory;

@Listeners(TestListener.class)
public class MenuDifferentapproch {
    WebDriver driver;
    Approchpagefactory act;


    @BeforeTest
    public void startup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    public WebDriver getDriver() {
        return driver;
    }

    @Test(priority = 1)
    public void browseropen() {
        act = new Approchpagefactory(driver);
        act.openurl();


    }

    @Test(priority = 2)
    public void menu() throws InterruptedException {
        act.menuselect();

    }

    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
