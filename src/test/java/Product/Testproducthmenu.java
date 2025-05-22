package Product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactoryfiles.product;
import pagefactoryfiles.productSelectpagefactory;
import pagefactoryfiles1.checkout;

public class Testproducthmenu {
    WebDriver driver;
    productSelectpagefactory fact;
    product prod;
    checkout check;


    @BeforeTest
    public void startup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @Test(priority = 1)
    public void openurl() {
        fact = new productSelectpagefactory(driver);
        fact.openurl();

    }

    @Test(priority = 2)
    public void productselect() throws InterruptedException {
        prod = new product(driver);
        fact.reopen();
        prod.addtocart();
        fact.reopen2();
        prod.addtocart();
        fact.reopen3();
        prod.addtocart();

    }

    @Test(priority = 3)
    public void cartdetails() throws InterruptedException {
        prod.verifycartsection();
        prod.gotocartpage();
        prod.cartcalculationcheck();


    }

    @Test(priority = 4)
    public void checkout() throws InterruptedException {
        check = new checkout(driver);
        check.checkoutclick();
        check.checkoutdetails();
        check.orderreceived();

    }

    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
