package Product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactoryfiles.productSelectpagefactory;

public class Testproducthmenu {
    WebDriver driver;
    productSelectpagefactory fact;



    @BeforeTest
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();



    }
    @Test(priority = 1)
    public void openurl()
    {
       fact=new productSelectpagefactory(driver) ;
       fact.openurl();

    }
    @Test(priority = 2)
    public void productselect() throws InterruptedException {
        fact.reopen();
        fact.reopen2();

    }

    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
