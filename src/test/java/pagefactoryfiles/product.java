package pagefactoryfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class product {
    WebDriver driver = null;
    String url = "https://updates.futuristicbug.com/bippi/wordpress/";
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;

    // @FindBy(xpath = "//ul[@id='menu-header-menu']/li[3]//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product-category/baby-pant-diapers/']")
    // WebElement mainproductmenu;
    // @FindBy(xpath = "//ul[@id='menu-header-menu']/li[3]//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product/bippi-premium-pants/']")
    // WebElement subproduct;
    @FindBy(xpath = "//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product/bippi-night-pants/']")
    WebElement subcategories;

    @FindBy(xpath = "//ul[@id='menu-header-menu']/li[3]//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product/']")
    WebElement headerroductmenuproduct;

    @FindBy(xpath = "//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product-category/baby-pant-diapers/']")
    WebElement categories;
    @FindBy(xpath = "//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product-category/baby-tape-diapers/']")
    WebElement categories1;
    @FindBy(xpath = "//a[@href='https://updates.futuristicbug.com/bippi/wordpress/product/bippi-premium-tape-nb/']")
    WebElement subcategories1;

    @FindBy(id = "custom-add-to-cart")
    WebElement addtocartclick;
    @FindBy(id = "cart-count")
    WebElement Cartcount;
    @FindBy(css = "div.cart_icon.fr_dext>a")
    WebElement gotocartpage;
    @FindBy(xpath = "*//article[@id='post-300']/header/h1[contains(text(),'Cart')]")
    WebElement cartdetailspage;

    @FindBy(css = "a.wc-block-components-product-name")
    List<WebElement> actualproducts;
    @FindBy(css = " div.wc-block-cart-item__prices>span>span")
    List<WebElement> unitprice;
    @FindBy(css = "  div.wc-block-cart-item__quantity > div > input")
   List< WebElement> Quantity;
    @FindBy(css = "  div.wc-block-cart-item__total-price-and-sale-badge-wrapper > span> span")
    List<WebElement> subtotal;
    @FindBy(xpath = "//input[@id='product-qty']")
    WebElement incrsequatity;

    public product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openurl() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void productselect() throws InterruptedException {


        act = new Actions(driver);
        act.moveToElement(headerroductmenuproduct);
        act.moveToElement(categories);
        act.pause(1000);
        act.moveToElement(subcategories);
        act.click().build().perform();
        Thread.sleep(2000);
        //driver.navigate().back();


    }

    public void productselect1() throws InterruptedException {


        act = new Actions(driver);
        act.moveToElement(headerroductmenuproduct);
        act.moveToElement(categories1);
        act.pause(1000);
        act.moveToElement(subcategories1);
        act.click().build().perform();
        Thread.sleep(2000);
        //driver.navigate().back();


    }


    public void addtocart() throws InterruptedException {
        Thread.sleep(1000);
        js = (JavascriptExecutor) driver;


        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addtocartclick));
        //js.executeScript("arguments[0].scrollIntoView(true);",addToCartBtn );
        js.executeScript("arguments[0].click();", addToCartBtn);

        // addToCartBtn.click();
        //addtocart.click();

        Thread.sleep(3000);

    }

    public void verifycartsection() {
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement cartcountnew = wait.until(ExpectedConditions.visibilityOf(Cartcount));

        String cartcounttext = cartcountnew.getText();

        if (Integer.parseInt(cartcounttext) > 0) {
            System.out.println("Product successfully added to  cart  :" + cartcounttext + " product");
        } else {
            System.out.println("Product not added to  cart");
        }


    }

    public void verifycartsection1() {
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement cartcountnew = wait.until(ExpectedConditions.visibilityOf(Cartcount));

        String cartcounttext = cartcountnew.getText();

        if (Integer.parseInt(cartcounttext) > 1) {
            System.out.println("Product successfully added to  cart  :" + cartcounttext + " product");
        } else {
            System.out.println("Product not added to  cart");
        }


    }

    public void gotocartpage() {
        js.executeScript("arguments[0].scrollIntoView(true);", gotocartpage);
        js.executeScript("arguments[0].click();", gotocartpage);


    }

    public void cartdetailsvalidationcheck() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", cartdetailspage);
        js.executeScript("arguments[0].click();", cartdetailspage);

        List<String> expectedproduct = Arrays.asList("Bippi Night Pants", "Bippi Premium Tape NB");
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement actualproduct : actualproducts) {
            Thread.sleep(1000);
            String actual = actualproduct.getText().trim();
            System.out.println("Actual products are :" + actual);
            actualProductNames.add(actual);
        }
        for (String expected : expectedproduct) {
            Assert.assertTrue(actualProductNames.contains(expected), "Missing product in cart: " + expected);
        }


    }

    public void cartcalculationcheck() {

        double totalCartPrice = 0;

        for (int i = 0; i < unitprice.size(); i++) {
            String unitmainprice = unitprice.get(i).getText().trim();

            double unitPrice = Double.parseDouble(unitmainprice.replace("$", ""));


            String quantityText = Quantity.get(i).getAttribute("value");
            int quantity = Integer.parseInt(quantityText);
            System.out.println("checking quantity"+quantity);
            double ActualproductTotal = unitPrice * quantity;

            System.out.println("Actual test"+ActualproductTotal);

            String subtotalprice=subtotal.get(i).getText().trim();

            double expectedtotalprice=Double.parseDouble(subtotalprice.replace("$",""));

            System.out.println("Expected test"+expectedtotalprice);

            Assert.assertEquals(ActualproductTotal,expectedtotalprice,0.01,"Mismatch in subtotal for product"+(i + 1));

            System.out.println("Product " + (i + 1) + " → Unit Price: " + unitPrice + ", Quantity: " + quantity + ", Subtotal: " + ActualproductTotal);

            // Add to total cart price
            totalCartPrice += ActualproductTotal;


        }
        System.out.println("🛒 Total Cart Price (All Products): $" + totalCartPrice);


    }

    public void productquantityincrease()
    {
        incrsequatity.clear();
        incrsequatity.sendKeys("2");

    }


}
