package pagefactoryfiles1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.*;

public class checkout {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@href='https://updates.futuristicbug.com/bippi/wordpress/checkout/']")
    WebElement checkoutbutton;
    @FindBy(css = " header > h1")
    WebElement scrollchecktitle;
    @FindBy(xpath = "//input[@type='email']")
    WebElement checkemail;
    @FindBy(css = "#contact > div.wc-block-components-checkbox.wc-block-checkout__create-account > label > span")
    WebElement createpassword;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(id = "shipping-first_name")
    WebElement firstname;
    @FindBy(id = "shipping-last_name")
    WebElement lastname;
    @FindBy(xpath = "//select[@id='shipping-country']")
    WebElement dropdown;
    @FindBy(id = "shipping-address_1")
    WebElement address;
    @FindBy(id = "shipping-city")
    WebElement city;
    @FindBy(xpath = "//select[@id='shipping-state']")
    WebElement dropdownstate;
    @FindBy(id = "shipping-postcode")
    WebElement pincode;
    @FindBy(css = " div.wc-block-checkout__actions_row > button > span > div")
    WebElement placeorder;
    @FindBy(css = " p.woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")
    WebElement orderplacesucessfullyalert;
    @FindBy(css="#post-301 > div > div > div > ul>li")
    List<WebElement> orderdetailsinfo;
    @FindBy(css = "#post-301 > header > h1")
    WebElement orderrecive;


    public checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void checkoutclick() {
        js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", checkoutbutton);

        //checkoutbutton.click();

    }

    public void checkoutdetails() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        int count=2;


        List<String[]> checkoutdetails = new ArrayList<>();

        checkoutdetails.add(new String[]{"ritam.das55@yopmail.com", "Sanyal88888@", "Ritam", "Das", "29/1 R.T nagore,road", "kolkata", "700056"});

        for (String[] checkout : checkoutdetails) {
            js.executeScript("arguments[0].scrollIntoView();", scrollchecktitle);
            Thread.sleep(2000);

            String checkoutemail = checkout[0];


            String checkoutpassword = checkout[1];
            String checkfirstname = checkout[2];
            String checklastname = checkout[3];
            String checkaddress = checkout[4];
            String checkcity = checkout[5];
            String checkpincode = checkout[6];


            checkemail.sendKeys(checkoutemail);
            Thread.sleep(2000);
            // js.executeScript("arguments[0].click();",createpassword);
            // createpassword.click();
            //wait.until(ExpectedConditions.visibilityOf(password));
            //password.sendKeys(checkoutpassword);
            firstname.sendKeys(checkfirstname);
            lastname.sendKeys(checklastname);
            Select drop = new Select(dropdown);
            drop.selectByValue("IN");
            address.sendKeys(checkaddress);
            js.executeScript("arguments[0].scrollIntoView();", city);
            city.sendKeys(checkcity);
            Select drop1 = new Select(dropdownstate);
            drop1.selectByValue("WB");
            wait.until(ExpectedConditions.visibilityOf(pincode));
            pincode.sendKeys(checkpincode);
            Thread.sleep(5000);

            //js.executeScript("arguments[0].click();", placeorder);
           // Thread.sleep(5000);
            //js.executeScript("arguments[0].click();", placeorder);

            for(int i=0;i<count;i++)
            {
                Thread.sleep(5000);
                js.executeScript("arguments[0].click();", placeorder);

            }
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(300));
            wait1.until(ExpectedConditions.urlContains("https://updates.futuristicbug.com/bippi/wordpress/checkout/order-received/"));


        }


    }

    public void orderreceived() throws InterruptedException {

        js.executeScript("arguments[0].scrollIntoView();", orderrecive);
        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        wait.until(ExpectedConditions.visibilityOf(orderplacesucessfullyalert));
        String orderrecalert = orderplacesucessfullyalert.getText().trim();
        if (orderrecalert.contains("Thank you. Your order has been received.")) {
            System.out.println("Order has been received ");
        } else {
            System.out.println("order not received");
        }
        Thread.sleep(2000);
        for(WebElement order:orderdetailsinfo)
        {
            String datainfo=order.getText().trim();
            Thread.sleep(500);
            System.out.println(datainfo);
        }



    }


}
