package pagefactoryfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class Approchpagefactory {

    WebDriver driver;
    String url = "https://updates.futuristicbug.com/bippi/wordpress/";
    // @FindBy(css = "#menu-header-menu > li.navitem.has-children > a")
    // WebElement mainmenu;


    public Approchpagefactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openurl() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void menuselect() throws InterruptedException {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                //try {
                WebElement mainmenu = driver.findElement(By.cssSelector("#menu-header-menu > li.navitem.has-children > addd")); // adjust if needed
                Actions act = new Actions(driver);

                act.moveToElement(mainmenu).pause(Duration.ofSeconds(1)).perform();

                // Hover over the i-th category
                String cate = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(" + i + ") > a";
                WebElement categories = driver.findElement(By.cssSelector(cate));
                act.moveToElement(categories).pause(Duration.ofSeconds(1)).perform();

                // Hover and click the j-th subcategory under the i-th category
                String subCategoryCss = "#menu-header-menu > li.navitem.has-children > ul > li:nth-child(" + i + ") > ul > li:nth-child(" + j + ") > a";
                List<WebElement> subCategoryList = driver.findElements(By.cssSelector(subCategoryCss));

                if (subCategoryList.isEmpty()) {
                    System.out.println("No subcategory at i=" + i + ", j=" + j);
                    continue;
                }
                WebElement subCategory = subCategoryList.get(0);
                act.moveToElement(subCategory).pause(Duration.ofSeconds(1)).click().perform();
                Thread.sleep(2000);

            } //catch (Exception e) {
            // System.out.println("Error at i=" + i + ", j=" + j + ": " + e.getMessage());
        }
    }
}



