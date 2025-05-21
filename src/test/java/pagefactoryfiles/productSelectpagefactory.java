package pagefactoryfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class productSelectpagefactory {
    WebDriver driver;
    String url = "https://updates.futuristicbug.com/bippi/wordpress/";
    Actions act;
    WebDriverWait wait;

    @FindBy(css = "#menu-header-menu > li.navitem.has-children > a")
    WebElement mainmenu;
    @FindBy(css = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(1) > a")
    WebElement categories1;
    @FindBy(css = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    WebElement subcategories1;
    @FindBy(css = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(1) > ul > li:nth-child(2) > a")
    WebElement subcategories2;

    @FindBy(css = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(2) > a")
    WebElement categories2;

    @FindBy(css = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(3) > a")
    WebElement categories3;


    //By mainmenuhead = By.cssSelector("#menu-header-menu > li.navitem.has-children > a");
    //By cate = By.cssSelector("ul.sub-menu>li>a");
    //By subs = By.cssSelector("ul.child-sub-menu>li>a");


    public productSelectpagefactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openurl() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void reopen() throws InterruptedException {

        List<WebElement> links = new ArrayList<>();
        links.add(subcategories1);
        links.add(subcategories2);

        for (WebElement ele : links) {
            act = new Actions(driver);
            act.moveToElement(mainmenu);
            act.pause(1000);
            act.moveToElement(categories1);
            act.click(ele).build().perform();
            act.pause(5000);
            //driver.navigate().back();
            //act.pause(5000);
        }


    }

    public void reopen2() throws InterruptedException {
        Actions act = new Actions(driver);

        for (int i = 1; i < 5; i++) {
            act.moveToElement(mainmenu)
                    .pause(Duration.ofSeconds(1))
                    .moveToElement(categories2)
                    .pause(Duration.ofSeconds(1));
            String subCategoryCss = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(2) > ul > li:nth-child(" + i + ") > a";

            WebElement subCategory = driver.findElement(By.cssSelector(subCategoryCss));

            // Click on sub-category
            act.moveToElement(subCategory).click().build().perform();

            // Pause to allow page to load or content to change
            Thread.sleep(5000);


        }

    }

    public void reopen3() throws InterruptedException {
        Actions act = new Actions(driver);
        for (int i = 1; i < 5; i++) {
            act.moveToElement(mainmenu)
                    .pause(Duration.ofSeconds(1))
                    .moveToElement(categories3)
                    .pause(Duration.ofSeconds(1));
            String subCategoryCss = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(3) > ul > li:nth-child(" + i + ") > a";
            WebElement subCategory = driver.findElement(By.cssSelector(subCategoryCss));
            act.moveToElement(subCategory).click().build().perform();
            Thread.sleep(5000);

        }


    }
}


