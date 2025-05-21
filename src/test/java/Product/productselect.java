package Product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactoryfiles.product;
import pagefactoryfiles1.checkout;

public class productselect {
    WebDriver driver = null;
    product pro;
    ChromeOptions options;
    checkout check;

    @BeforeTest
    public void browseropen() {
        WebDriverManager.chromedriver().setup();
        options=new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        String projecturl = System.getProperty("user.dir");
        System.out.println(projecturl);
        pro = new product(driver);


    }

    @Test(priority = 1)
    public void openurl() {

        pro.openurl();
    }

    @Test(priority = 2)
    public void productselect() throws InterruptedException {
        pro.productselect();

    }

    @Test(priority = 3)
    public void addtocart() throws InterruptedException {
        pro.productquantityincrease();
        pro.addtocart();

    }

    @Test(priority = 4)
    public void verifycart() {
        pro.verifycartsection();

    }

    @Test(priority = 5)
    public void addanotherproduct() throws InterruptedException {
        pro.productselect1();
    }

    @Test(priority = 6)
    public void anotherproductaddtocart() throws InterruptedException {
        pro.productquantityincrease();
        pro.addtocart();
    }

    @Test(priority = 7)
    public void anotherproductaddtocartverify() throws InterruptedException {
        pro.verifycartsection1();
    }

    @Test(priority = 8)
    public void cartdetails() throws InterruptedException {
        pro.gotocartpage();
    }

    @Test(priority = 9)
    public void cartdetailsvalcheck() throws InterruptedException {
        pro.cartdetailsvalidationcheck();
        pro.cartcalculationcheck();
    }
    @Test(priority = 10 )
    public void checkoutclick() throws InterruptedException {
        check=new checkout(driver);
        check.checkoutclick();
        check.checkoutdetails();

    }
    @Test(priority = 11)
    public void orderrecieve() throws InterruptedException {
        check.orderreceived();
    }


    @AfterTest
    public void quit() throws InterruptedException {
        pro.quit();
    }

}
